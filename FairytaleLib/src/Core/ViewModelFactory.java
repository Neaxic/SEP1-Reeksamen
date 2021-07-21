
package Core;

import View.browseItems.BrowseViewModel;
import View.login.LoginViewModel;

import View.registerNewItem.RegisterViewmodel;
import View.registerNewRenter.registerNewRenterViewModel;
import View.renterList.RenterListViewModel;

public class ViewModelFactory {

  private ModelFactory mf;
  private BrowseViewModel browseViewModel;
  private RegisterViewmodel registerViewmodel;
  private registerNewRenterViewModel registerNewRenterViewModel;
  private LoginViewModel loginViewModel;
  private RenterListViewModel renterListViewModel;


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
  public LoginViewModel getLoginViewModel(){
    if (loginViewModel == null)
      loginViewModel = new LoginViewModel(mf.getModel());
    return loginViewModel;

  }

  public RenterListViewModel getRenterListViewModel(){
    if (renterListViewModel == null)
      renterListViewModel = new RenterListViewModel(mf.getModel());
    return renterListViewModel;

  }


}
