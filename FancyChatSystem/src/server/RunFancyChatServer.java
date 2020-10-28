package server;

import server.networking.RMIRMIServer;
import shared.networking.RMIServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunFancyChatServer
{
  public static void main(String[] args)
      throws RemoteException, AlreadyBoundException
  {
    RMIRMIServer RMIRMIServer = new RMIRMIServer();
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("Server", RMIRMIServer);
    System.out.println("Server started...");
  }
}
