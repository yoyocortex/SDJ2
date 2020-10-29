package client.clientmodel.login_register;

import shared.util.Message;
import shared.util.Subject;

public interface Login_Register extends Subject
{
  void loginRequest(String username, String password);
  void registerRequest(String username, String password, String repeatPassword);
  void onlineUsersRequest();
  void sendMessage(Message message);
}
