package Session_3.Exercise_4_Solutions;

public class StartWaitingRoom {

    public static void main(String[] args) throws InterruptedException {
        WaitingRoom wr = new WaitingRoom();
        new Thread(wr).start();
        for (int i = 0; i < 20; i++) {
            Patient p = new Patient(i);
            System.out.println("Patient " + i + " enters waiting room");
            wr.addPropertyChangeListener(p);
            Thread.sleep(75);
        }
    }
}
