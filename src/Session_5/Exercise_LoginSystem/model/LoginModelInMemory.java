package Session_5.Exercise_LoginSystem.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LoginModelInMemory implements LoginModel
{
  private PropertyChangeSupport support = new PropertyChangeSupport(this);
  private List<User> users = new LinkedList<>();

  public LoginModelInMemory() {
    populateModelWithDummyusers();
  }

  public void populateModelWithDummyusers() {
    User[] u = {
        new User("Troels", "Troels1"),
        new User("Steffen", "Steffen1"),
        new User("Michael", "Michael1"),
        new User("Kasper", "Kasper1"),
        new User("Jakob", "Jakob1"),
    };
    Collections.addAll(users, u);
  }

  public void clearUsers() {
    users.clear();
  }

  @Override public void addListener(String name, PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(name, listener);
  }

  @Override public void removeListener(String name, PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(name, listener);
  }

  @Override public void validateLogin(String username, String password)
  {
    String result = checkLoginCredentials(username, password);
    support.firePropertyChange("LoginResult", "", result);
  }

  private String checkLoginCredentials(String username, String password) {
    User user = findUser(username);
    if(user == null) {
      return "User not found";
    }
    if(!user.getPassword().equals(password)) {
      return "Incorrect password";
    }
    return "OK";
  }

  private User findUser(String username) {
    User user = null;
    for (User u : users) {
      if(u.getUsername().equals(username)) {
        user = u;
        break;
      }
    }
    return user;
  }

  @Override public void createUser(String username, String password, String passwordAgain)
  {
    String result = attemptCreateUser(username, password, passwordAgain);
    if("OK".equals(result)) {
      users.add(new User(username, password));
    }
    support.firePropertyChange("CreateUserResult", "", result);
  }

  private String attemptCreateUser(String username, String pw, String pwAgain) {
    if(username == null) {
      return "Username cannot be empty";
    }
    if(username.contains("#")) {
      return "Username cannot contain #";
    }
    if(username.length() < 4) {
      return "Username must contain more than 3 characters";
    }
    if(username.length() > 14) {
      return "Username must contain less than 15 characters";
    }
    if(findUser(username) != null) {
      return "Username already exists";
    }

    // checking the passwords
    return validatePasswords(pw, pwAgain); // returning result of checking passwords
  }

  private String validatePasswords(String pw, String pwAgain) {
    // I'm using an approach here called "guard clause", or "if guards"
    // Some people dislike it because there are many returns, i.e. exits out of the method, and they feel it
    // can cause confusion.
    // In lower level languages such as C++, it can cause problems, if you are not careful.
    // In java there are no problems with this, because we have a garbage collector.
    // It's a matter of preference.
    // Some people prefer to have a bunch of if-elseif-elseif-elseif, and only one return statement at the very end
    // The point is I'm checking and validating a bunch of stuff before at the end, allowing to do what was
    // intended. In this case just returning "OK", but it could also be putting things in the database, or deleting
    // data or starting a new Thread or whatever.

    if(pw == null) {
      return "Password cannot be empty";
    }
    if(pw.length() < 8) {
      return "Password length must be 8 or more";
    }
    if(pw.length() > 14) {
      return "Password length must be 14 or less";
    }
    if(!pw.equals(pwAgain)) {
      return "Passwords do not match";
    }

    // verifying that the password contains at least one upper case character
    if(pw.equals(pw.toLowerCase())) {
      return "Password must contain at least one upper case letter";
    }

    // checking if there is a lower case letter in pw
    if (!pwContainsLowerCase(pw)){
      return "Password must contain at least one lower case letter";
    }

    // password may not contain "#"
    if(pw.contains("#")) {
      return "Password cannot contain #";
    }

    // using regular expression to check that the password contains a number
    if(!pw.matches(".*\\d.*")) {
      return "Password must contain at least one number";
    }

    // if I reach this point, everything is okay.
    return "OK";
  }

  private boolean pwContainsLowerCase(String pw) {
    boolean foundLowerCase = false;
    for (int i = 0; i < pw.length(); i++) { // looping through all characters in the pw
      char c = pw.charAt(i);
      if(Character.isLowerCase(c)) { // checking if the character is lower case
        foundLowerCase = true;
        break;
      }
    }
    return foundLowerCase;
  }

  @Override public void changePassword(String username, String pw, String newPw, String newPwAgain) {
    String result = checkUpdateNewPW(username, pw, newPw, newPwAgain);

    if("OK".equals(result)) {
      // updating the password
      User user = findUser(username);
      user.password = newPw;
    }

    support.firePropertyChange("ChangePasswordResult", "", result);
  }

  private String checkUpdateNewPW(String username, String pw, String newPw, String newPwAgain) {

    // check that username and pw is correct;
    if(!"OK".equals(checkLoginCredentials(username, pw))) {
      return "Incorrect login credentials";
    }

    // check that passwords are valid and matches
    return validatePasswords(newPw, newPwAgain);
  }
}
