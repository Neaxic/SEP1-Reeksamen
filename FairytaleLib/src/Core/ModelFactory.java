package Core;

import Model.ClientModel;

public class ModelFactory {

  private Model model;

  public Model getModel() {
    if(model == null) model = new ClientModel();
    return model;
  }
}
