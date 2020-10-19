package Session_4.Exercise_2_UppercaseTwoViews.log;

import Session_4.Exercise_2_UppercaseTwoViews.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class LogViewController {

  @FXML
  private ListView<String> listView;

  @FXML
  private Button backButton;

  private LogViewModel logViewModel;
  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler, LogViewModel logViewModel) {
    this.logViewModel = logViewModel;
    this.viewHandler = viewHandler;
    listView.setItems(this.logViewModel.getLogs());
  }

  @FXML
  void onBackButton(ActionEvent event) {
    viewHandler.openToUppercase();
  }
}
