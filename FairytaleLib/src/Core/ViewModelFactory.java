
package Core;

import View.browseItems.BrowseViewModel;
import View.registerNewItem.RegisterViewmodel;
import View.registreNewRenter.registerNewRenterViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ViewModelFactory {

  private ModelFactory mf;
  private BrowseViewModel browseViewModel;
  private RegisterViewmodel registerViewmodel;
  private registerNewRenterViewModel registerNewRenterViewModel;

  public ViewModelFactory(ModelFactory mf) {
    this.mf = mf;
  }

  public BrowseViewModel getBrowseViewModel(){
    if (browseViewModel == null)
      browseViewModel = new BrowseViewModel(mf.getModel());
    return browseViewModel;

  }


  public RegisterViewmodel getRegisterViewmodel(){
    if (registerViewmodel == null)
      registerViewmodel = new RegisterViewmodel(mf.getModel());
      return registerViewmodel;

  }


  public registerNewRenterViewModel getRegisterNewRenterViewModel(){
    if (registerNewRenterViewModel == null)
      registerNewRenterViewModel = new registerNewRenterViewModel(mf.getModel());
    return registerNewRenterViewModel;

  }



}
