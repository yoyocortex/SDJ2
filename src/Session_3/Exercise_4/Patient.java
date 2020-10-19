package Session_3.Exercise_4;

public class Patient implements Listener
{
  private int ticketNum;
  private WaitingRoom waitingRoom;

  public Patient(int ticketNum, WaitingRoom waitingRoom)
  {
    this.ticketNum = ticketNum;
    this.waitingRoom = waitingRoom;
  }

  @Override public void update(int arg)
  {
    if(ticketNum == arg)
    {
      System.out.println("Patient goes to the doctor!");
      //waitingRoom.removeListener();
    }
    else if(ticketNum > arg)
      System.out.println("Patient checks the new number and goes back to playing on his phone!");
  }
}
