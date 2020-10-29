package client.views.chat;

import client.clientmodel.login_register.Login_Register;
import javafx.application.Platform;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.util.Message;
import shared.util.User;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

public class ChatViewModel
{
  private Login_Register loginRegisterModel;
  private ListProperty<String> onlineUsers;
  private StringProperty thisUserStringProperty;
  private User thisUser;
  private List<Message> messageLine;
  private ListProperty<Message> messageBack;

  public ChatViewModel(Login_Register loginRegisterModel)
  {
    this.loginRegisterModel = loginRegisterModel;

    thisUserStringProperty = new SimpleStringProperty();

    onlineUsers = new SimpleListProperty<>();
    messageBack = new SimpleListProperty<>();
    messageLine = new ArrayList<>();
    this.loginRegisterModel.addListener("OnlineUsers", this::updateOnlineUsers);
    this.loginRegisterModel.addListener("LoggedInAs", this::loggedInAs);
    this.loginRegisterModel.addListener("MessageBack", this::messageBack);
  }

  private void messageBack(PropertyChangeEvent event)
  {
    Message message = (Message) event.getNewValue();

    if(!message.getFromUser().equals("")
        && !message.getToUser().equals("")
        && !message.getText().equals("")
        && !message.getDate_time().equals(""))
    {

      messageLine.add(message);
      Platform.runLater(() -> messageBack.set(FXCollections.observableArrayList(messageLine)));
    }
    else
    {
      messageLine = new ArrayList<>();
      Platform.runLater(() -> messageBack.set(FXCollections.observableArrayList(messageLine)));
    }
  }

  private void loggedInAs(PropertyChangeEvent event)
  {
    thisUser = (User) event.getNewValue();
    Platform.runLater(() -> thisUserStringProperty.set("Logged in as; " + thisUser.getUsername()));
  }

  private void updateOnlineUsers(PropertyChangeEvent event)
  {
    List<User> onlineListDemo;
    List<String> onlineListOnlyNames = new ArrayList<>();
    onlineListDemo = (List<User>) event.getNewValue();

    for (User user : onlineListDemo)
    {
      onlineListOnlyNames.add(user.getUsername());
    }

    Platform.runLater(() -> onlineUsers.set(FXCollections.observableArrayList(onlineListOnlyNames)));
  }

  public ObservableList<String> getOnlineUsers()
  {
    return onlineUsers.get();
  }

  public ListProperty<String> onlineUsersProperty()
  {
    return onlineUsers;
  }

  public StringProperty thisUserStringPropertyProperty()
  {
    return thisUserStringProperty;
  }

  public ObservableList<Message> getMessageBack()
  {
    return messageBack.get();
  }

  public ListProperty<Message> messageBackProperty()
  {
    return messageBack;
  }

  public void onlineUsersRequest()
  {
    loginRegisterModel.onlineUsersRequest();
  }

  public User getThisUser()
  {
    return thisUser;
  }

  public void sendMessage(Message message)
  {
    message.setFromUser(thisUser.getUsername());
    loginRegisterModel.sendMessage(message);
  }
}
