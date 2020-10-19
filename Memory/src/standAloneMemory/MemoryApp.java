package standAloneMemory;

import javafx.application.Application;
import javafx.stage.Stage;
import standAloneMemory.core.ModelFacatory;
import standAloneMemory.core.ViewHandler;
import standAloneMemory.core.ViewModelFactory;
import standAloneMemory.model.MemoryDeck;
import standAloneMemory.model.MemoryRunnable;

public class MemoryApp extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ModelFacatory modelFacatory = new ModelFacatory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFacatory);
    ViewHandler viewHandler = new ViewHandler(viewModelFactory);
    viewHandler.start();

    MemoryDeck memoryDeck = new MemoryDeck(modelFacatory.getMemoryModel());
    /*MemoryRunnable memoryRunnable = new MemoryRunnable(memoryDeck);
    Thread thread = new Thread(memoryRunnable);
    thread.start();*/
  }
}
