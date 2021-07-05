package Core;

import Model.ClientModel;

public class ModelFactory {

  private ClientModel model;

  public ClientModel getModel() {
    if(model == null)
      model = new ClientModel();
    return model;
  }
}
