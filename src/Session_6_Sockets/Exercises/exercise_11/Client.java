package Session_6_Sockets.Exercises.exercise_11;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
  public static void main(String[] args)
      throws IOException, ClassNotFoundException
  {
    Socket socket = new Socket("localhost", 2915);
    ObjectOutputStream outFromServer = new ObjectOutputStream(socket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
    while (true)
    {
      String messgageFromServer = (String) inFromServer.readObject();
      System.out.println(messgageFromServer);
      Scanner scanner = new Scanner(System.in);
      double amount = scanner.nextDouble();
      outFromServer.writeObject(amount);
      if(amount < 0)
        break;
      System.out.println(inFromServer.readObject());
    }
    socket.close();
  }
}
