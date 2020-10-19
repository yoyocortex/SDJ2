package Session_5.Exercise_LoginSystem.model;

import java.beans.PropertyChangeListener;

public interface LoginModel
{
  public void addListener(String name, PropertyChangeListener listener);
  public void removeListener(String name, PropertyChangeListener listener);
  public void validateLogin(String username, String password);
  public void createUser(String username, String password, String passwordAgain);
  public void changePassword(String username, String password, String newPassword, String newPasswordAgain);
}
