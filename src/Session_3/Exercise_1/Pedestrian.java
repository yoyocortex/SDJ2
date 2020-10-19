package Session_3.Exercise_1;

import java.beans.PropertyChangeEvent;

public class Pedestrian
{
  public Pedestrian(PropertyChangeSubject subject)
  {
    subject.addPropertyChangeListener("GREEN", this::reactToGreen);
    subject.addPropertyChangeListener("YELLOW", this::reactToYellow);
    subject.addPropertyChangeListener("RED", this::reactToRed);
  }

  public void reactToRed(PropertyChangeEvent event)
  {
    System.out.println("Pedestrian is walking.");
  }

  public void reactToYellow(PropertyChangeEvent event)
  {
    if(event.getOldValue().equals("GREEN"))
    {
      System.out.println("Pedestrian runs across.");
    } else
      System.out.println("Pedestrian waits.");
  }

  public void reactToGreen(PropertyChangeEvent event)
  {
    if(event.getOldValue().equals("YELLOW"))
    {
      System.out.println("Pedestrian waits.");
    }
  }
}
