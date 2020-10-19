package Session_3.Exercise_4;

public class Main
{
  public static void main(String[] args)
  {
    WaitingRoom waitingRoom = new WaitingRoom();
    Patient patient = new Patient(2, waitingRoom);
    Patient patient1 = new Patient(3, waitingRoom);
    Patient patient2 = new Patient(1, waitingRoom);
    Patient patient3 = new Patient(4, waitingRoom);
    Patient patient4 = new Patient(5, waitingRoom);
    Patient patient5 = new Patient(6, waitingRoom);
    waitingRoom.addListener(patient);
    waitingRoom.addListener(patient1);
    waitingRoom.addListener(patient2);
    waitingRoom.addListener(patient3);
    waitingRoom.addListener(patient4);
    waitingRoom.addListener(patient5);
    Thread thread = new Thread(waitingRoom);
    thread.start();
  }
}
