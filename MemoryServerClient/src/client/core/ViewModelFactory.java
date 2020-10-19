package client.core;

import client.views.game.GameViewModel;
import client.views.login.LoginViewModel;
import client.views.popupRequest.PopupRequestViewModel;
import client.views.register.RegisterViewModel;
import client.views.startmenu.StartMenuViewModel;

public class ViewModelFactory
{
  private LoginViewModel loginViewModel;
  private RegisterViewModel registerViewModel;
  private StartMenuViewModel startMenuViewModel;
  private PopupRequestViewModel popupRequestViewModel;
  private GameViewModel gameViewModel;

  private ModelFactory modelFactory;
  private ViewHandler viewHandler;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
  }

  public LoginViewModel getLoginViewModel() {
    if(loginViewModel == null)
    {
      loginViewModel = new LoginViewModel(modelFactory.getModel());
    }
    return loginViewModel;
  }

  public RegisterViewModel getRegisterViewModel() {
    if(registerViewModel == null)
    {
      registerViewModel = new RegisterViewModel(modelFactory.getModel());
    }
    return registerViewModel;
  }

  public StartMenuViewModel getStartMenuViewModel() {
    if(startMenuViewModel == null)
    {
      startMenuViewModel = new StartMenuViewModel(modelFactory.getModel(), viewHandler);
    }
    return startMenuViewModel;
  }

  public PopupRequestViewModel getPopupRequestViewModel() {
    if(popupRequestViewModel == null)
    {
      popupRequestViewModel = new PopupRequestViewModel(modelFactory.getModel());
    }
    return popupRequestViewModel;
  }

  public GameViewModel getGameViewModel() {
    if(gameViewModel == null)
    {
      gameViewModel = new GameViewModel(modelFactory.getModel());
    }
    return gameViewModel;
  }

  public void setViewHandler(ViewHandler viewHandler) {
    this.viewHandler = viewHandler;
  }
}
