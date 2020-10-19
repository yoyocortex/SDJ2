package Session_6_Sockets.Exercises.exercise_11;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
  public static void main(String[] args)
      throws IOException, ClassNotFoundException
  {
    ServerSocket serverSocket = new ServerSocket(2915);
    System.out.println("Server started");
    Socket client = serverSocket.accept();
    System.out.println("Client connected");
    ObjectInputStream inFromClient = new ObjectInputStream(client.getInputStream());
    ObjectOutputStream outToClient = new ObjectOutputStream(client.getOutputStream());
    while (true)
    {
      outToClient.writeUnshared("Enter the amount: ");
      double amountFromClient =  (double) inFromClient.readObject();
      if(amountFromClient < 0)
        break;
      double vat = amountFromClient * 0.25;
      outToClient.writeObject("VAT is : " + vat);
    }
    client.close();
  }
}
