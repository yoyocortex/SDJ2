package Session_6_Sockets.ClientServerChat;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class MultipleClientServer
{
  public static void main(String[] args)
  {
    new MultipleClientServer().run();
  }

  public void run()
  {
    try
    {
      //Random random = new Random();
      //id = random.nextInt()
      List<Integer> portList = new ArrayList<>();
      ServerSocket socket = new ServerSocket(1000);
      System.out.println("Server IP; " + InetAddress.getLocalHost().getHostAddress());
      while(true) {
        Socket clientSocket = socket.accept();
        new Thread(new ServerThread(clientSocket, portList)).start();
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private class ServerThread implements Runnable {
    private Socket clientSocket;
    public ServerThread( Socket clientSocket, List list) {
      this.clientSocket = clientSocket;
      System.out.println("Client connected.");
      list.add(clientSocket.getPort());
      System.out.println(list);
      //System.out.println(Thread.currentThread());
    }
    public void run() {
      try
      {
        while(true)
        {
          //ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
          BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
          OutputStreamWriter outputFromServer = new OutputStreamWriter(clientSocket.getOutputStream());
          System.out.println(inputFromClient.readLine());
          //System.out.println(inputStream.readObject());
          Scanner scanner = new Scanner(System.in);
          outputFromServer.write("Recived." + scanner.nextLine() + "\n" );
          outputFromServer.flush();
        }
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
  }
}
