package Session_6_Sockets.Exercises.exercise_12;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerStringOrPrime
{
  public static void main(String[] args)
      throws IOException, ClassNotFoundException
  {
    ServerSocket serverSocket = new ServerSocket(1000);
    System.out.println("Server started.");

    Socket socket = serverSocket.accept();
    System.out.println("Client connected.");

    ObjectInputStream inputFromClient = new ObjectInputStream(socket.getInputStream());
    ObjectOutputStream outputFromServer = new ObjectOutputStream(socket.getOutputStream());

    outputFromServer.writeUnshared("Write a number to check if its prime or write a string to reverse it.");
    while(true) {
      int switchStringOrInt = (Integer) inputFromClient.readObject();
      outputFromServer.writeUnshared("Recived no. " + switchStringOrInt);

      if(switchStringOrInt == 1) {
        String reverse = "";
        String clientString = (String) inputFromClient.readObject();
        int length = clientString.length();
        for (int i = length - 1 ; i >= 0 ; i--)
          reverse = reverse + clientString.charAt(i);
        outputFromServer.writeUnshared("Reversed string; " + reverse);
      }

      if(switchStringOrInt == 2) {
        int clientInt = (Integer) inputFromClient.readObject();
        boolean isItPrime = checkForPrime(clientInt);
        if (isItPrime) {
          outputFromServer.writeUnshared(clientInt +" is a prime number.");
        }
        else {
          outputFromServer.writeUnshared(clientInt +" is not a prime number.");
        }
      }
      else if(switchStringOrInt != 1 && switchStringOrInt != 2)
        break;
        //socket.close();
    }
    socket.close();
  }

  static boolean checkForPrime(int inputNumber)
  {
    boolean isItPrime = true;
    if(inputNumber <= 1) {
      isItPrime = false;
      return isItPrime;
    }
    else {
      for (int i = 2; i<= inputNumber/2; i++) {
        if ((inputNumber % i) == 0) {
          isItPrime = false;
          break;
        }
      }
      return isItPrime;
    }
  }
}
