
package Core;

import View.browseItems.BrowseViewModel;

public class ViewModelFactory {

   private BrowseViewModel ViewModelBrowse;
  //private TaskListViewModel taskListViewModel;
  //private NextTaskViewModel nextTaskViewModel;

  public ViewModelFactory(ModelFactory mf) {
    //        addViewModel = new AddViewModel(mf.getModel());
    //    taskListViewModel = new TaskListViewModel(mf.getModel());
    // nextTaskViewModel = new NextTaskViewModel(mf.getModel());
  }

  //   public AddViewModel getAddViewModel() {
  //    return addViewModel;
  // }

  public BrowseViewModel getViewModelBrowse() {
    return ViewModelBrowse;
  };
}
