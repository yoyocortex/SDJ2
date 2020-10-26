package Session_7_RMI.TroelsVideoExercises.uppercasebroadcast.client;

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
        String result = client.toUppercase(nextLine);
        System.out.println("Result> " + result);
      }
      catch (Exception e)
      {
        System.out.println("Error> " + e.getMessage());
      }
    }
  }
}
