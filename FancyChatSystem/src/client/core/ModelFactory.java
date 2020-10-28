package client.core;

import client.clientmodel.login_register.Login_Register;
import client.clientmodel.login_register.Login_RegisterManager;

public class ModelFactory
{
  private Login_Register loginRegister;
  private ClientFactory clientFactory;

  public ModelFactory(ClientFactory clientFactory)
  {
    this.clientFactory = clientFactory;
  }

  public Login_Register getLoginRegisterModel() {
    if(loginRegister == null)
    {
      loginRegister = new Login_RegisterManager(clientFactory.getClient());
    }
    return loginRegister;
  }
}
