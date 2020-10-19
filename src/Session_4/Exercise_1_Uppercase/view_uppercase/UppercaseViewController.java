package Session_4.Exercise_1_Uppercase.view_uppercase;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class UppercaseViewController {

  @FXML
  private AnchorPane anchorPane;

  @FXML
  private Button submitButton;

  @FXML
  private TextField requestField;

  @FXML
  private TextField replyField;

  @FXML
  private Label errorLable;

  private UppercaseViewModel uppercaseViewModel;

  public void init(UppercaseViewModel uppercaseViewModel) {
    this.uppercaseViewModel = uppercaseViewModel;
    errorLable.textProperty().bind(this.uppercaseViewModel.errorProperty());
    requestField.textProperty().bindBidirectional(this.uppercaseViewModel.requestProperty());
    replyField.textProperty().bind(this.uppercaseViewModel.replyProperty());
  }

  @FXML
  private void onSubmitButton(ActionEvent event) {
    uppercaseViewModel.convert();
  }
}