package Session_7_RMI.TroelsVideoExercises.upperandlower.client;

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
      System.out.print("Request> ");
      String request = scanner.nextLine();

      System.out.print("Input> ");
      String nextLine = scanner.nextLine();

      if("exit".equalsIgnoreCase(nextLine)) break;

      String result = null;
      try
      {
        if(request.equalsIgnoreCase("tolowercase"))
          result = client.toLowercase(nextLine);
        else if(request.equalsIgnoreCase("touppercase"))
          result = client.toUppercase(nextLine);
        else
          result = "Did not understand request";

        System.out.println("Result> " + result);
      }
      catch (Exception e)
      {
        System.out.println("Error> " + e.getMessage());
      }
    }
  }
}
