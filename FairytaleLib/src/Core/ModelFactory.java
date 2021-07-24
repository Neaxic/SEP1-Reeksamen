package Core;

import Model.Client;
import Model.ClientModel;

public class ModelFactory {

  private Client model;

  public Client getModel() {
    if(model == null)
      model = new ClientModel();
    return model;
  }
}
