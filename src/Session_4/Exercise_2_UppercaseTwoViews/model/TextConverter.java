package Session_4.Exercise_2_UppercaseTwoViews.model;

import java.util.List;

public interface TextConverter
{
  String toUppercase(String text);
  void addLog(String log);
  List<String> getLog();
}
