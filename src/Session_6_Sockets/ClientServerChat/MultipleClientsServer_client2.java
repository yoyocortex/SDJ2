package Session_6_Sockets.ClientServerChat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MultipleClientsServer_client2
{
  public static void main( String[] args ) throws IOException
  {
    new MultipleClientsServer_client2().run();
  }

  private void run() throws IOException
  {
    Socket socket = new Socket("localhost", 1000);
    //System.out.println(socket.getLocalPort());
    BufferedReader inputFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    OutputStreamWriter outputFromClient = new OutputStreamWriter(socket.getOutputStream());
    Scanner scanner = new Scanner(System.in);
    while (true)
    {
      System.out.print("Write smth; ");
      outputFromClient.write(scanner.nextLine() + "\n");
      outputFromClient.flush();
      System.out.println(inputFromServer.readLine());
    }
  }
}
