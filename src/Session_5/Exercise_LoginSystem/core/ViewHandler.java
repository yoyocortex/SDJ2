package Session_5.Exercise_LoginSystem.core;

import Session_5.Exercise_LoginSystem.views.changePassword.ChangePasswordController;
import Session_5.Exercise_LoginSystem.views.createUser.CreateUserController;
import Session_5.Exercise_LoginSystem.views.loginResult.LoginResultController;
import Session_5.Exercise_LoginSystem.views.loginView.LoginController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Stage stage;
  private Scene loginScene, successfulLoginScene, createUserScene, changePasswordScene;
  private ViewModelFactory viewModelFactory;
  private ViewHandler viewHandler = this;


  public ViewHandler(ViewModelFactory viewModelFactory) {
    this.viewModelFactory = viewModelFactory;
  }

  public void start()
  {
    stage = new Stage();
    openLoginView();
  }

  public void openLoginView() {
    if(loginScene == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/loginView/Login.fxml"));
        Parent root = loader.load();

        LoginController ctrl = loader.getController();
        ctrl.init(viewHandler, viewModelFactory);

        stage.setTitle("Login");
        loginScene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      stage.setScene(loginScene);
      stage.show();
      createUserScene = null;
      changePasswordScene = null;
    }
  }

  public void openSuccessfulLoginView() {
    if(successfulLoginScene == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/loginResult/LoginResult.fxml"));
        Parent root = loader.load();

        LoginResultController ctrl = loader.getController();
        ctrl.init(viewHandler, viewModelFactory);

        stage.setTitle("Login Successful");
        successfulLoginScene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      stage.setScene(successfulLoginScene);
      stage.show();
    }
  }

  public void openCreateUserView() {
    if(createUserScene == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/createUser/CreateUser.fxml"));
        Parent root = loader.load();

        CreateUserController ctrl = loader.getController();
        ctrl.init(viewHandler, viewModelFactory);

        stage.setTitle("Create User");
        createUserScene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      stage.setScene(createUserScene);
      stage.show();
      loginScene = null;
      changePasswordScene = null;
    }
  }

  public void openChangePasswordView() {
    if(changePasswordScene == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/changePassword/ChangePassword.fxml"));
        Parent root = loader.load();

        ChangePasswordController ctrl = loader.getController();
        ctrl.init(viewHandler, viewModelFactory);

        stage.setTitle("Change Password");
        changePasswordScene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      stage.setScene(changePasswordScene);
      stage.show();
      loginScene = null;
      createUserScene = null;
    }
  }
}
