package Session_6_Sockets.Exercises.exercise_13;

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

    ObjectInputStream inFromClient;
    ObjectOutputStream outToClient;

    //Socket client = serverSocket.accept();
    //System.out.println("Client connected");

    //outToClient.writeUnshared("");
    while (true)
    {
      Socket client = serverSocket.accept();
      System.out.println("Client connected");

      inFromClient = new ObjectInputStream(client.getInputStream());
      outToClient = new ObjectOutputStream(client.getOutputStream());

      outToClient.writeUnshared("Enter the amount: ");
      double amountFromClient = (double) inFromClient.readObject();
      //if(amountFromClient < 0);
        //break;
      double vat = amountFromClient * 0.25;
      outToClient.writeObject("VAT is : " + vat);
    }
    //client.close();
  }
}
