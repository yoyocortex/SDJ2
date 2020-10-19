package view.secondView;

import client.core.ViewHandler;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class SecondViewController
{
  @FXML
  private LineChart<CategoryAxis, NumberAxis> pastDataLineChart;

  @FXML
  private CategoryAxis xAxis;

  @FXML
  private NumberAxis yAxis;

  @FXML
  private Label pastDataLabel;

  private ViewHandler viewHandler;
  private SecondViewViewModel secondViewViewModel;
  private StringProperty chartDate, chartNearTemp, chartFarTemp;
  private XYChart.Series dataSeries1 = new XYChart.Series();
  private XYChart.Series dataSeries2 = new XYChart.Series();

  public void init(ViewHandler viewHandler, SecondViewViewModel secondViewViewModel) {
    this.viewHandler = viewHandler;
    this.secondViewViewModel = secondViewViewModel;
    chartDate = new SimpleStringProperty();
    chartNearTemp = new SimpleStringProperty();
    chartFarTemp = new SimpleStringProperty();
    loadData();
    pastDataLabel.textProperty().bind(this.secondViewViewModel.temperatureNearProperty());
    pastDataLabel.textProperty().addListener(this::loadData2);
    pastDataLabel.setVisible(false);
  }

  private void loadData2(Observable observable)
  {
    int i = 0;
    for (; i < secondViewViewModel.getNearHeaterList().size(); i++) {
      dataSeries1.getData().add(new XYChart.Data(secondViewViewModel.getNearHeaterList().get(i).getLocalDateTimeString()
          , secondViewViewModel.getNearHeaterList().get(i).getTemperature()));
      dataSeries2.getData().add(new XYChart.Data(secondViewViewModel.getNearHeaterList().get(i).getLocalDateTimeString()
          , secondViewViewModel.getFarHeaterList().get(i).getTemperature()));
    }
  }

  public void loadData() {
    xAxis.setLabel("Time");
    yAxis.setLabel("Temperature"); yAxis.setUpperBound(30);

    dataSeries1.setName("Near Heater Temp");
    dataSeries2.setName("Far Heater Temp");

    pastDataLineChart.getData().add(dataSeries1);
    pastDataLineChart.getData().add(dataSeries2);
  }

  @FXML
  void onBackButton(ActionEvent event) {
    viewHandler.openTemperatureView();
  }
}
