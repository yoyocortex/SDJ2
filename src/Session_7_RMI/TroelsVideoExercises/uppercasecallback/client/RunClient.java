package Session_7_RMI.TroelsVideoExercises.uppercasecallback.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RunClient
{
  public static void main(String[] args) throws RemoteException, NotBoundException
  {
    RMIClient client = new RMIClient();
    client.startClient();

    Scanner scanner = new Scanner(System.in);

    while(true)
    {
      System.out.print("Input> ");
      String nextLine = scanner.nextLine();

      if("exit".equalsIgnoreCase(nextLine)) break;

      try
      {
        client.toUppercase(nextLine);
      }
      catch (Exception e)
      {
        System.out.println("Error> " + e.getMessage());
      }
    }
  }
}
