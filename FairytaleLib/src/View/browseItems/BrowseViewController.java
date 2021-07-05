package View.browseItems;

import Core.ViewHandler;
import javafx.scene.layout.Region;

public class BrowseViewController {
    private ViewHandler viewHandler;
    private Region root;
    private BrowseViewModel viewmodel;

    public void init(ViewHandler viewHandler, BrowseViewModel viewmodel, Region root)
    {
        this.viewHandler = viewHandler;
        this.viewmodel = viewmodel;
        this.root = root;
    }

    public Region getRoot()
    {
        return root;
    }


}
