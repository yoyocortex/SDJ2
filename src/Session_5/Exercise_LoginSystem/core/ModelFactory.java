package Session_5.Exercise_LoginSystem.core;

import Session_5.Exercise_LoginSystem.model.LoginModel;
import Session_5.Exercise_LoginSystem.model.LoginModelInMemory;

public class ModelFactory
{
  private LoginModel loginModel;

  public LoginModel getLoginModel() {
    if(loginModel == null) {
      loginModel = new LoginModelInMemory();
    }
    return loginModel;
  }
}
