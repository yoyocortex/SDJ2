package client.views.startmenu;

import client.core.ViewHandler;
import client.model.Memory;
import javafx.application.Platform;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import sharedClasses.transferObject.EventType;
import sharedClasses.transferObject.User;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

public class StartMenuViewModel
{
  private Memory model;
  private SimpleStringProperty warningMessage, loggedInUser, enemyUser;
  private List<User> onlineUsers;
  private ListProperty<String> listProperty;
  private User enemyUserUser = null;
  private ViewHandler viewHandler;

  public StartMenuViewModel(Memory model, ViewHandler viewHandler)
  {
    this.model = model;
    this.viewHandler = viewHandler;

    onlineUsers = new ArrayList<>();
    warningMessage = new SimpleStringProperty();
    loggedInUser = new SimpleStringProperty();
    listProperty = new SimpleListProperty<>();
    enemyUser = new SimpleStringProperty(null);

    this.model.addListener(EventType.USERSLIST_RESULT.toString(), this::onUserList);
    this.model.addListener("LoggedInUser", this::displayLoggedInUser);
    this.model.addListener(EventType.DUEL_RESULT.toString(), this::openPopup);
    this.model.addListener(EventType.OPEN_GAME_VIEW_RESULT.toString(), this::openGameView);
  }

  private void openGameView(PropertyChangeEvent event)
  {
    User user = (User) event.getNewValue();
    System.out.println("User name of this window or whatever> " + user.getUsername());
    Platform.runLater(() -> viewHandler.openGameView(user));
  }

  private void openPopup(PropertyChangeEvent event)
  {
    enemyUserUser = (User) event.getNewValue();
    enemyUser.set(enemyUserUser.getUsername());
    //System.out.println("StartMenuViewModel, User im supposed to play against> " + enemyUser.get());
    Platform.runLater(() -> viewHandler.openPopupRequestView(enemyUser.get(), loggedInUser.get()));
  }

  private void displayLoggedInUser(PropertyChangeEvent event)
  {
    User loggedInUser = (User) event.getNewValue();
    this.loggedInUser.set("You are logged in with; " + loggedInUser.getUsername());
  }

  private void onUserList(PropertyChangeEvent event)
  {
    onlineUsers = (List<User>) event.getNewValue();
    //System.out.println(onlineUsers);
    List<String> userUsernames = new ArrayList<>();
    for (User u : onlineUsers) {
      userUsernames.add(u.getUsername());
    }
    Platform.runLater(() -> listProperty.set(FXCollections.observableArrayList(userUsernames)));
    //listProperty.set(FXCollections.observableArrayList(userUsernames));
  }

  public ListProperty<String> listPropertyProperty()
  {
    return listProperty;
  }

  public SimpleStringProperty loggedInUserProperty()
  {
    return loggedInUser;
  }

  public void populateList()
  {
    model.getOnlinePlayers();
  }

  public SimpleStringProperty warningMessageProperty()
  {
    return warningMessage;
  }

  public void requestDuel(String selectedItem)
  {
    //System.out.println("StartMenuViewModel, requestDuel");
    model.requestDuel(selectedItem);
  }

  public SimpleStringProperty enemyUserProperty()
  {
    return enemyUser;
  }
}
