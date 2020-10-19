package Session_5.Exercise_LoginSystem.core;

import Session_5.Exercise_LoginSystem.views.changePassword.ChangePasswordViewModel;
import Session_5.Exercise_LoginSystem.views.createUser.CreateUserViewModel;
import Session_5.Exercise_LoginSystem.views.loginView.LoginViewModel;

public class ViewModelFactory
{
  private LoginViewModel loginViewModel;
  private CreateUserViewModel createUserViewModel;
  private ChangePasswordViewModel changePasswordViewModel;
  private ModelFactory modelFactory;

  public ViewModelFactory(ModelFactory modelFactory) {
    this.modelFactory = modelFactory;
  }

  public LoginViewModel getLoginViewModel() {
    if(loginViewModel == null)
    {
      loginViewModel = new LoginViewModel(modelFactory.getLoginModel());
    }
    return loginViewModel;
  }

  public CreateUserViewModel getCreateUserViewModel() {
    if(createUserViewModel == null)
    {
      createUserViewModel = new CreateUserViewModel(modelFactory.getLoginModel());
    }
    return createUserViewModel;
  }

  public ChangePasswordViewModel getChangePasswordViewModel() {
    if(changePasswordViewModel == null)
    {
      changePasswordViewModel = new ChangePasswordViewModel(modelFactory.getLoginModel());
    }
    return changePasswordViewModel;
  }
}
