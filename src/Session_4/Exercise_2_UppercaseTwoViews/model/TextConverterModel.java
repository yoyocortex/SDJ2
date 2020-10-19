package Session_4.Exercise_2_UppercaseTwoViews.model;

import java.util.ArrayList;
import java.util.List;

public class TextConverterModel implements TextConverter
{
  private ArrayList<String> list = new ArrayList<>();

  @Override public String toUppercase(String text) {
    String result = text.toUpperCase();
    addLog(text);
    return result;
  }

  @Override public void addLog(String log) {
    list.add(log);
  }

  @Override public List<String> getLog()
  {
    return list;
  }

  public int getLogSize() {
    return list.size();
  }
}