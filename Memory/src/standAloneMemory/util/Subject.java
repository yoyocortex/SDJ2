package standAloneMemory.util;

import java.beans.PropertyChangeListener;

public interface Subject
{
  public void addListener(String name, PropertyChangeListener listener);
  public void removeListener(String name, PropertyChangeListener listener);
}