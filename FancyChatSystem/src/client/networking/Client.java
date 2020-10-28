package client.networking;

import shared.util.Subject;

public interface Client extends Subject
{
  void loginRequest(String username, String password);
  void registerRequest(String username, String password, String repeatPassword);
}
