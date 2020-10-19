package Session_6_Sockets.Exercises.exercise_13;

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
    Socket socket = null;
    while (true) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Type which server you want to choose, no.1 for VAT and no.2 for String/Prime; ");
      int serverDecision = scanner.nextInt();

      if(serverDecision == 1) {
        socket = new Socket("localhost", 2915);
        System.out.println("Connected to server 2915.");

        ObjectOutputStream outputFromClient = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inputFromServer = new ObjectInputStream(socket.getInputStream());

        //while (true){
          String messgageFromServer = (String) inputFromServer.readObject();
          System.out.print(messgageFromServer);
          double amount = scanner.nextDouble();
          //if(amount < 0)
            //break;
          outputFromClient.writeObject(amount);
          System.out.println(inputFromServer.readObject());
        //}
        //socket.close();
      }

      if(serverDecision == 2) {
        socket = new Socket("localhost", 1000);
        System.out.println("Connected to server 1000");

        ObjectOutputStream outputFromClient = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inputFromServer = new ObjectInputStream(socket.getInputStream());

        System.out.println((String)inputFromServer.readObject());

        //while (true) {
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

          //else if(decision != 1 && decision != 2) break;
        //}
        //socket.close();
      }
      //else if(serverDecision != 1 && serverDecision != 2) break;
    }
    //socket.close();
  }
}
