package standAloneMemory.core;

import standAloneMemory.views.game.GameViewModel;
import standAloneMemory.views.startmenu.StartMenuViewModel;

public class ViewModelFactory
{
  private ModelFacatory modelFacatory;
  private StartMenuViewModel startMenuViewModel;
  private GameViewModel gameViewModel;

  public ViewModelFactory(ModelFacatory modelFacatory)
  {
    this.modelFacatory = modelFacatory;
  }

  public StartMenuViewModel getStartMenuViewModel() {
    if(startMenuViewModel == null)
    {
      startMenuViewModel = new StartMenuViewModel();
    }
    return startMenuViewModel;
  }

  public GameViewModel getGameViewModel()
  {
    if(gameViewModel == null)
    {
      gameViewModel = new GameViewModel(modelFacatory.getMemoryModel());
    }
    return gameViewModel;
  }
}
