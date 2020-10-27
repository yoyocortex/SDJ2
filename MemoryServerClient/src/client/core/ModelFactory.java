package client.core;

import client.clientmodel.Memory;
import client.clientmodel.MemoryManager;

public class ModelFactory
{
  private Memory model;
  private ClientFactory clientFactory;

  public ModelFactory(ClientFactory clientFactory)
  {
    this.clientFactory = clientFactory;
  }

  public Memory getModel()
  {
    if(model == null)
    {
      model = new MemoryManager(clientFactory.getClient());
    }
    return model;
  }
}
