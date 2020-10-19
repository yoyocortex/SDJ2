package Session_4.Exercise_2_UppercaseTwoViews.view_uppercase;

import Session_4.Exercise_2_UppercaseTwoViews.core.ViewHandler;
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

  @FXML
  private Button showLogButton;

  private UppercaseViewModel uppercaseViewModel;
  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler, UppercaseViewModel uppercaseViewModel) {
    this.viewHandler = viewHandler;
    this.uppercaseViewModel = uppercaseViewModel;
    errorLable.textProperty().bind(this.uppercaseViewModel.errorProperty());
    requestField.textProperty().bindBidirectional(this.uppercaseViewModel.requestProperty());
    replyField.textProperty().bind(this.uppercaseViewModel.replyProperty());
  }

  @FXML
  private void onSubmitButton(ActionEvent event) {
    uppercaseViewModel.convert();
  }

  @FXML
  private void onShowLogButton(ActionEvent event) {
    requestField.clear();
    replyField.clear();
    viewHandler.openLogView();
  }
}