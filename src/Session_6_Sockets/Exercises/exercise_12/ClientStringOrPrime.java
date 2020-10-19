package Session_6_Sockets.Exercises.exercise_12;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientStringOrPrime
{
  public static void main(String[] args)
      throws IOException, ClassNotFoundException
  {
    Socket socket = new Socket("localhost", 1000);
    System.out.println("Connected to server.");

    ObjectOutputStream outputFromClient = new ObjectOutputStream(socket.getOutputStream());
    ObjectInputStream inputFromServer = new ObjectInputStream(socket.getInputStream());

    System.out.println((String)inputFromServer.readObject());

    while (true)
    {
      Scanner scanner = new Scanner(System.in);
      System.out.print("If you want to type a string press number 1, else press number 2; ");

      int decision = scanner.nextInt();
      outputFromClient.writeObject(decision);
      System.out.println((String)inputFromServer.readObject());

      if(decision == 1) {
        String clientString = scanner.nextLine();
        clientString = scanner.nextLine();
        outputFromClient.writeObject(clientString);
        System.out.println((String)inputFromServer.readObject());
      }

      if(decision == 2) {
        int clientInt = scanner.nextInt();
        outputFromClient.writeObject(clientInt);
        System.out.println((String)inputFromServer.readObject());
      }

      else if(decision != 1 && decision != 2)
        break;
        //socket.close();
    }
    socket.close();
  }
}
