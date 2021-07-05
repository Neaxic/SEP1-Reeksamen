
package Core;

import View.browseItems.BrowseViewModel;

public class ViewModelFactory {

  private ModelFactory mf;
  private BrowseViewModel browseViewModel;

  public ViewModelFactory(ModelFactory mf) {
    this.mf = mf;
  }

  public BrowseViewModel getBrowseViewModel(){
    if (browseViewModel == null)
      browseViewModel = new BrowseViewModel(mf.getModel());
    return browseViewModel;

  }





}
