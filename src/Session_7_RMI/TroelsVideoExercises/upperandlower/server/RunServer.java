package Session_7_RMI.TroelsVideoExercises.upperandlower.server;

import Session_7_RMI.TroelsVideoExercises.upperandlower.shared.Server;
import Session_7_RMI.TroelsVideoExercises.upperandlower.shared.UppercaseServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer
{
  public static void main(String[] args)
      throws RemoteException, AlreadyBoundException
  {
    Server server = new ServerImpl();
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("Server", server);
    System.out.println("Server started...");
  }
}
