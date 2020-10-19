package Session_3.Exercise_1;

import java.beans.PropertyChangeEvent;

public class  Car {
		
        public Car(PropertyChangeSubject subject) {
          subject.addPropertyChangeListener("GREEN", this::reactToGreen);
          subject.addPropertyChangeListener("YELLOW", this::reactToYellow);
          subject.addPropertyChangeListener("RED", this::reactToRed);
        }

        public void reactToRed(PropertyChangeEvent event)
        {
          System.out.println("Car has stopped.");
        }
        public void reactToYellow(PropertyChangeEvent event)
        {
          if("RED".equals(event.getOldValue()))
          {
            System.out.println("Car turns the engine on.");
          } else
            System.out.println("Car slows down.");
        }
        public void reactToGreen(PropertyChangeEvent event)
        {
          System.out.println("Car drives.");
        }
}


