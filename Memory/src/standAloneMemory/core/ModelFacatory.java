package standAloneMemory.core;

import standAloneMemory.model.Memory;
import standAloneMemory.model.MemoryManager;

public class ModelFacatory
{
  private Memory memoryModel;

  public ModelFacatory() {}

  public Memory getMemoryModel() {
    if(memoryModel == null) {
      memoryModel = new MemoryManager();
    }
    return memoryModel;
  }
}
