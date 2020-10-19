package Session_3.Exercise_4_Solutions;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WaitingRoom implements PropertyChangeSubject, Runnable{

    private PropertyChangeSupport support;

    public WaitingRoom() {
        support = new PropertyChangeSupport(this);
    }

    @Override
    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        support.addPropertyChangeListener(name, listener);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
        support.removePropertyChangeListener(name, listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }


    @Override
    public void run() {
        int ticketNumber = 0;
        while(true) {
            try {
                Thread.sleep(100);
                System.out.println("Diing!");
                support.firePropertyChange("NextTicket", -1, ticketNumber);
                ticketNumber++;
            } catch (InterruptedException e) {}
        }
    }
}
