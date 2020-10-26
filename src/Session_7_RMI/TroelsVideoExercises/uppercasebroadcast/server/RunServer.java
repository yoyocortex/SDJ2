package Session_7_RMI.TroelsVideoExercises.uppercasebroadcast.server;

import Session_7_RMI.TroelsVideoExercises.uppercasebroadcast.shared.UppercaseServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer
{
  public static void main(String[] args)
      throws RemoteException, AlreadyBoundException
  {
    UppercaseServer server = new ServerImpl();
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("Server", server);
    System.out.println("Server started...");
  }
}
