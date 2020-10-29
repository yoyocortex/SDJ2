package server.servermodel.login_register;

import shared.networking.ClientCallBack;
import shared.util.Message;
import shared.util.User;

public interface Login_Register
{
  void loginRequest(String username, String password, ClientCallBack rmiClient);
  void registerRequest(String username, String password, String repeatPassword, ClientCallBack rmiClient);
  void removeClient(ClientCallBack client);
  void onlineUsersRequest();
  void sendMessage(Message message);//User thisUser, String selectedUserToSendMessageTo, String messageFieldText, String dateAndTime);
}
