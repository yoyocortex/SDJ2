package client.core;

import client.views.chat.ChatController;
import client.views.login.LoginController;
import client.views.register.RegisterController;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class ViewHandler
{
  private Stage mainStage;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    mainStage = new Stage();
    this.viewModelFactory = viewModelFactory;
  }

  public void start() {
    openLoginView();

    mainStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
      @Override
      public void handle(WindowEvent t) {
        Platform.exit();
        System.exit(0);
      }
    });

    mainStage.show();
  }

  public void openLoginView() {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../views/login/Login.fxml"));
    try
    {
      Parent root = loader.load();
      LoginController controller = loader.getController();
      controller.init(viewModelFactory.getLoginViewModel(), this);
      mainStage.setTitle("Log in");
      Scene loginScene = new Scene(root);
      mainStage.setScene(loginScene);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public void openRegisterView() {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../views/register/Register.fxml"));
    try
    {
      Parent root = loader.load();
      RegisterController controller = loader.getController();
      controller.init(viewModelFactory.getRegisterViewModel(), this);
      mainStage.setTitle("Register");
      Scene loginScene = new Scene(root);
      mainStage.setScene(loginScene);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public void openChatView() {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../views/chat/Chat.fxml"));
    try
    {
      Parent root = loader.load();
      ChatController controller = loader.getController();
      controller.init(viewModelFactory.getChatViewModel(), this);
      mainStage.setTitle("Chat");
      Scene loginScene = new Scene(root);
      mainStage.setScene(loginScene);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
