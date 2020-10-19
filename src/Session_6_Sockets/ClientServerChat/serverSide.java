package Session_6_Sockets.ClientServerChat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class serverSide
{
  public static void main(String[] args)
  {
    System.out.println("Server is starting...");
    Scanner keyboard = new Scanner(System.in);
    try{
      ServerSocket serverSocket = new ServerSocket(2930);
      System.out.println( "Server listening on " + InetAddress.getLocalHost().getHostAddress() );
      while(true){
        Socket socket = serverSocket.accept();
        System.out.println("Client has been connected");
        ObjectInputStream inFromClient = new ObjectInputStream((socket.getInputStream()));
        String clientMsg = (String) inFromClient.readObject();
        //System.out.println("Number received: " + number);
        System.out.println(clientMsg);
        //double result = number * 0.25;
        String result = keyboard.nextLine();
        ObjectOutputStream outToClient = new ObjectOutputStream((socket.getOutputStream())); //used to send objects to the client
        outToClient.writeObject(result);
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }
}