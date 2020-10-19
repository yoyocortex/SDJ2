package client.core;

import client.views.game.GameController;
import client.views.login.LoginController;
import client.views.popupRequest.PopupRequestController;
import client.views.register.RegisterController;
import client.views.startmenu.StartMenuController;
import com.sun.javafx.stage.EmbeddedWindow;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sharedClasses.transferObject.User;

import java.io.IOException;

public class ViewHandler
{
  private Stage mainStage;
  private ViewModelFactory viewModelFactory;
  private ViewHandler viewHandler = this;
  private Stage popup = new Stage();

  public ViewHandler(ViewModelFactory viewModelFactory) {
    mainStage = new Stage();
    this.viewModelFactory = viewModelFactory;
    this.viewModelFactory.setViewHandler(this);
  }

  public void start() {
    openLoginView();
    mainStage.show();
  }

  public void openLoginView() {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../views/login/Login.fxml"));
    try
    {
      Parent root = loader.load();
      LoginController controller = loader.getController();
      controller.init(viewModelFactory.getLoginViewModel(), viewHandler);
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
      controller.init(viewModelFactory.getRegisterViewModel(), viewHandler);
      mainStage.setTitle("Register");
      Scene loginScene = new Scene(root);
      mainStage.setScene(loginScene);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public void openStartMenuView() {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../views/startmenu/StartMenu.fxml"));
    try
    {
      Parent root = loader.load();
      StartMenuController controller = loader.getController();
      controller.init(viewModelFactory.getStartMenuViewModel(), viewHandler);
      mainStage.setTitle("StartMenu");
      Scene loginScene = new Scene(root);
      mainStage.setScene(loginScene);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public void openPopupRequestView(String enemyUser, String host) {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../views/popupRequest/PopupRequest.fxml"));
    try
    {
      Parent root = loader.load();
      PopupRequestController controller = loader.getController();
      controller.init(viewModelFactory.getPopupRequestViewModel(), viewHandler, enemyUser, host);
      popup.setTitle("Popup Request");
      Scene loginScene = new Scene(root);
      popup.setScene(loginScene);
      popup.show();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public void openGameView(User user)
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../views/game/Game.fxml"));
    try
    {
      Parent root = loader.load();
      GameController controller = loader.getController();
      controller.init(viewModelFactory.getGameViewModel(), user);
      mainStage.setTitle("Memory Game");
      Scene loginScene = new Scene(root);
      mainStage.setScene(loginScene);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
