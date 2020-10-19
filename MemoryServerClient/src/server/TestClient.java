package server;

import sharedClasses.transferObject.EventType;
import sharedClasses.transferObject.Request;
import sharedClasses.transferObject.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TestClient
{
  public static void main(String[] args)
      throws IOException, ClassNotFoundException
  {
    Socket socket = new Socket("localhost", 2910);
    User u1 = new User("Karl", "");
    User u2 = new User("Karlo", "Karlo112");
    User u3 = new User("Karlo", "Karlo123");

    ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

    objectOutputStream.writeObject(new Request(EventType.LOGIN_REQUEST, u1));
    Request request = (Request) objectInputStream.readObject();
    System.out.println(request.arg);

    objectOutputStream.writeObject(new Request(EventType.LOGIN_REQUEST, u2));
    Request request1 = (Request) objectInputStream.readObject();
    System.out.println(request1.arg);

    objectOutputStream.writeObject(new Request(EventType.LOGIN_REQUEST, u3));
    Request request2 = (Request) objectInputStream.readObject();
    System.out.println(request2.arg);
  }
}
