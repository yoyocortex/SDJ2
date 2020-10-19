package server.dataaccess;

import sharedClasses.transferObject.User;

import java.util.List;

public interface UserHome
{
  String validateUser(User user);
  User findUser(String username);
  String registerUser(User user);
  List<User> getAllOnlineUsers();
  void removeOnlineUser(User user);
}
