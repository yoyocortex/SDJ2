package Session_3.Exercise_4;

public class Patient implements Listener
{
  private int ticketNum;

  public Patient(int ticketNum)
  {
    this.ticketNum = ticketNum;
  }

  @Override public void update(int arg)
  {
    if(ticketNum == arg)
    {
      System.out.println("Patient " + ticketNum + " goes to the doctor!");
    }
    else if(ticketNum > arg)
      System.out.println("Patient " + ticketNum + " checks the new number and goes back to playing on his phone!");
  }
}
