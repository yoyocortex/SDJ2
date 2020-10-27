package client.views.popupRequest;

import client.clientmodel.Memory;

public class PopupRequestViewModel
{
  private Memory model;

  public PopupRequestViewModel(Memory model)
  {
    this.model = model;
  }

  public void openGameView(String enemy, String host)
  {
    model.openGameView(enemy, host);
  }
}
