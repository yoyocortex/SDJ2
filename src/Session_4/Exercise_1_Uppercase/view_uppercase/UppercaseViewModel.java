package Session_4.Exercise_1_Uppercase.view_uppercase;

import Session_4.Exercise_1_Uppercase.model.TextConverter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.awt.*;

public class UppercaseViewModel
{
  private StringProperty requestField;
  private StringProperty replayField;
  private StringProperty errorLabel;
  private TextConverter textConverter;

  public UppercaseViewModel(TextConverter textConverter) {
    this.textConverter = textConverter;
    requestField = new SimpleStringProperty();
    replayField = new SimpleStringProperty();
    errorLabel = new SimpleStringProperty();
  }

  public void convert() {
    String input = requestField.get();
    //System.out.println("Hello from VM (ViewModel)");
    if(input == null || input.equals("")) {
      errorLabel.set("Error, text field can not be empty!");
    }
    else
    {
      //System.out.println(requestProperty());
      String result = textConverter.toUppercase(input);
      replayField.set(result);
    }
  }

  public StringProperty errorProperty() {
    return errorLabel;
  }

  public StringProperty requestProperty() {
    return requestField;
  }

  public StringProperty replyProperty() {
    return replayField;
  }
}
