package server.servermodel.login_register;

import shared.networking.ClientCallBack;

public interface Login_Register
{
  void loginRequest(String username, String password, ClientCallBack rmiClient);
  void registerRequest(String username, String password, String repeatPassword, ClientCallBack rmiClient);
  void removeClient(ClientCallBack client);
}
