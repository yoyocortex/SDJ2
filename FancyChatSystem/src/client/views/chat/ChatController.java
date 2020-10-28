package client.views.chat;

import client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ChatController {

  @FXML
  private ListView<String> onlineListView;

  @FXML
  private TextField messageField;

  @FXML
  void onSendButton(ActionEvent event) {

  }

  private ChatViewModel chatViewModel;
  private ViewHandler viewHandler;

  public void init(ChatViewModel chatViewModel, ViewHandler viewHandler)
  {
    this.viewHandler = viewHandler;
    this.chatViewModel = chatViewModel;
  }


}
