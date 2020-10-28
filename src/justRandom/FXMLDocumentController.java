package justRandom;

import java.net.URL;
    import java.util.ResourceBundle;
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.fxml.Initializable;
    import javafx.geometry.Pos;
    import javafx.scene.control.Label;
    import javafx.scene.control.ListCell;
    import javafx.scene.control.ListView;
    import javafx.scene.control.TextField;
    import javafx.scene.layout.HBox;

public class FXMLDocumentController implements Initializable {

  @FXML private ListView<Message> lvChatWindow;
  @FXML private TextField tfUser1, tfUser2;

  ObservableList<Message> chatMessages = FXCollections.observableArrayList();//create observablelist for listview


  //Method use to handle button press that submits the 1st user's text to the listview.
  @FXML
  private void handleUser1SubmitMessage(ActionEvent event) {
    chatMessages.add(new Message(tfUser1.getText(), "User 1"));//get 1st user's text from his/her textfield and add message to observablelist
    tfUser1.setText("");//clear 1st user's textfield
  }

  //Method use to handle button press that submits the 2nd user's text to the listview.
  @FXML
  private void handleUser2SubmitMessage(ActionEvent event) {
    chatMessages.add(new Message(tfUser2.getText(), "User 2"));//get 2nd user's text from his/her textfield and add message to observablelist
    tfUser2.setText("");//clear 2nd user's textfield
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
    lvChatWindow.setItems(chatMessages);//attach the observablelist to the listview
    lvChatWindow.setCellFactory(param -> {
      ListCell<Message> cell = new ListCell<Message>(){
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
            System.out.println(item.getUser());
            if(item.getUser().equals("User 1"))
            {
              lblUserLeft.setText(item.getUser() + ":");
              lblTextLeft.setText(item.getText());
              setGraphic(hBoxLeft);
            }
            else{
              lblUserRight.setText(":" + item.getUser());
              lblTextRight.setText(item.getText());
              setGraphic(hBoxRight);
            }
          }
        }

      };

      return cell;
    });
  }
}