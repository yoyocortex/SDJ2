package Session_3.Exercise_1;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TrafficLight implements PropertyChangeSubject{

    private String[] lights = {"GREEN", "YELLOW", "RED", "YELLOW"};
    private int count = 2;
    private String currentLight;
    private PropertyChangeSupport support;

    public TrafficLight() {
        currentLight = lights[count];
        support = new PropertyChangeSupport(this);
    }

    public void start() throws InterruptedException {
        String previous = "";
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            count = (++count) % 4;
            previous = currentLight;
            currentLight = lights[count];
            System.out.println("\nLight is " + currentLight);
            //support.firePropertyChange("LightChanged", previous, currentLight);
            support.firePropertyChange(currentLight, previous, currentLight);
        }

    }

    @Override public void addPropertyChangeListener(String name, PropertyChangeListener listener)
    {
        if(name == null)
        {
            addPropertyChangeListener(listener);
        }
        else
            support.addPropertyChangeListener(name, listener);
    }

    @Override public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        support.addPropertyChangeListener(listener);
    }

    @Override public void removePropertyChangeListener(String name, PropertyChangeListener listener)
    {
        if(name == null) {
            removePropertyChangeListener(listener);
        } else
            support.removePropertyChangeListener(name, listener);
    }

    @Override public void removePropertyChangeListener(PropertyChangeListener listener)
    {
        support.removePropertyChangeListener(listener);
    }
}
