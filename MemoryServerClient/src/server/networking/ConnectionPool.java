package server.networking;

import sharedClasses.transferObject.Request;
import sharedClasses.transferObject.User;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool
{
  private List<ServerSocketHandler> conns = new ArrayList<>();

  public void addConnection(ServerSocketHandler ssh) {
    conns.add(ssh);
  }

  public void broadcast(Request obj) {
    for (ServerSocketHandler c : conns)
    {
      List<User> onlineUsers = (List<User>) obj.arg;
      c.sendUserList(obj);
    }
  }

  public List<ServerSocketHandler> getConns()
  {
    return conns;
  }

  public void removeConnection(ServerSocketHandler ssh)
  {
    conns.remove(ssh);
  }
}
