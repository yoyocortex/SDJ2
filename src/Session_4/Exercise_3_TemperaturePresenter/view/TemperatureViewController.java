package Session_4.Exercise_3_TemperaturePresenter.view;

import Session_4.Exercise_3_TemperaturePresenter.core.ViewHandler;
import Session_4.Exercise_3_TemperaturePresenter.mediator.TemperatureModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TemperatureViewController {

  @FXML
  private Label tempLable;

  @FXML
  private Button updateButton;

  private TemperatureViewModel temperatureViewModel;
  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler, TemperatureViewModel temperatureViewModel) {
    this.viewHandler = viewHandler;
    this.temperatureViewModel = temperatureViewModel;
    //tempLable.setText("Kurva");
    tempLable.textProperty().bind(this.temperatureViewModel.getLastTemp());
  }

  @FXML
  void showUpdatedInfo(ActionEvent event) {
    System.out.println(String.valueOf(temperatureViewModel.getLastTemp()));
    //tempLable.setText(String.valueOf(temperatureViewModel.getLastTemp()));
    temperatureViewModel.getLastTemp();
    //tempLable.textProperty().bind(this.temperatureViewModel.getLastTemp());
  }
}
