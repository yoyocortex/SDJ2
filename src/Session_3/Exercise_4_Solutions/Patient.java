package Session_3.Exercise_4_Solutions;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Patient implements PropertyChangeListener {

    public int ticketNumber;

    public Patient(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Patient " + ticketNumber + " looks up");
        if(ticketNumber == (int) evt.getNewValue()) {
            System.out.println("Patient " + ticketNumber + " goes to the doctor's room");
            WaitingRoom source = (WaitingRoom) evt.getSource();
            source.removePropertyChangeListener(this);
        } else {
            System.out.println("Patient " + ticketNumber + " goes back to looking at phone");
        }
    }
}
