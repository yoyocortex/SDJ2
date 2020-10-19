package Session_4.Exercise_2_UppercaseTwoViews.log;

import Session_4.Exercise_2_UppercaseTwoViews.model.TextConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LogViewModel
{
  private TextConverter textConverter;
  private ObservableList<String> logs;

  public LogViewModel(TextConverter textConverter) {
    this.textConverter = textConverter;
    logs = FXCollections.observableArrayList(textConverter.getLog());
  }

  public ObservableList<String> getLogs() {
    return logs;
  }
}
