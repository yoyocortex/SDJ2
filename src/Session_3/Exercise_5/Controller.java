package Session_3.Exercise_5;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.FileNotFoundException;

public class Controller implements Listener
{
  @FXML
  private PieChart pieChart;

  @FXML
  private Button updateBtn;

  @FXML
  private AnchorPane anchorPane;

  public void initialize(Subject dataModel)
  {
    ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
    list.add(new PieChart.Data("Bla", 3));
    list.add(new PieChart.Data("Bla2", 5));
    pieChart.setData(list);
    dataModel.addListener(this);
  }

  public void handleClickMe(ActionEvent e) throws FileNotFoundException
  {
    if(e.getSource() == updateBtn)
    {
      //update();
    }
  }

  @Override public void update(int red, int green, int yellow)
  {
    Platform.runLater(() -> {
      ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
      list.add(new PieChart.Data("Red", red));
      list.add(new PieChart.Data("Green", green));
      list.add(new PieChart.Data("Yellow", yellow));
      pieChart.setData(list);
    });
  }
}
