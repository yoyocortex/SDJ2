package client.views.chat;

import client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import shared.util.Message;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatController {

  @FXML
  private ListView<String> onlineListView;

  @FXML
  private ListView<Message> chatListView;

  @FXML
  private TextField messageField;

  @FXML
  private Label loggedInAsLabel;

  @FXML
  private Label errorLabel;

  @FXML
  void onSendButton(ActionEvent event) {
    if(onlineListView.getSelectionModel().getSelectedItem() != null && !messageField.getText().isEmpty()
        && !("Logged in as; " + onlineListView.getSelectionModel().getSelectedItem()).equals(loggedInAsLabel.getText()))
    {
      errorLabel.setText("");

      Date dNow = new Date( );
      SimpleDateFormat ft = new SimpleDateFormat ("HH:mm dd.MM.yyyy");

      Message message = new Message(thisUser, onlineListView.getSelectionModel().getSelectedItem(), messageField.getText(), ft.format(dNow));

      chatViewModel.sendMessage(message);
      messageField.clear();
    }
    else
    {
      errorLabel.setText("Please select a user (not yourself) and type a message.");
    }
  }

  private ChatViewModel chatViewModel;
  private ViewHandler viewHandler;
  private String thisUser;

  public void init(ChatViewModel chatViewModel, ViewHandler viewHandler)
  {
    this.viewHandler = viewHandler;
    this.chatViewModel = chatViewModel;

    chatViewModel.onlineUsersRequest();

    onlineListView.itemsProperty().bind(this.chatViewModel.onlineUsersProperty());
    loggedInAsLabel.textProperty().bind(this.chatViewModel.thisUserStringPropertyProperty());
    chatListView.itemsProperty().bind(this.chatViewModel.messageBackProperty());
    this.chatViewModel.messageBackProperty().addListener((observableValue, oldValue, newValue) -> onChatListView());
    errorLabel.setText("");

    chatListView.setCellFactory(param -> {
      ListCell<Message> cell = new ListCell<>(){
        Label lblUserLeft = new Label();
        Label lblTextLeft = new Label();
        HBox hBoxLeft = new HBox(lblUserLeft, lblTextLeft);

        Label lblUserRight = new Label();
        Label lblTextRight = new Label();
        HBox hBoxRight = new HBox(lblTextRight, lblUserRight);

        {
          hBoxLeft.setAlignment(Pos.CENTER_LEFT);
          hBoxLeft.setSpacing(5);
          hBoxRight.setAlignment(Pos.CENTER_RIGHT);
          hBoxRight.setSpacing(5);
        }
        @Override
        protected void updateItem(Message item, boolean empty) {
          super.updateItem(item, empty);

          if(empty)
          {
            setText(null);
            setGraphic(null);
          }
          else{
            if(item.getFromUser().equals(thisUser))
            {
              lblUserLeft.setText(thisUser + " :");
              lblTextLeft.setText(item.getText() + " - " + item.getDate_time());
              setGraphic(hBoxLeft);
            }
            else if(!item.getFromUser().equals(thisUser)) {
              lblUserRight.setText(": " + item.getFromUser());
              lblTextRight.setText(item.getDate_time() + " - " + item.getText());
              setGraphic(hBoxRight);
            }
          }
        }
      };
      return cell;
    });
  }

  private void onChatListView()
  {
    thisUser = chatViewModel.getThisUser().getUsername();
  }
}


