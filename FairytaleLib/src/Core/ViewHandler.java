package Core;

import View.browseItems.BrowseViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

  private Scene browserScene;
  private BrowseViewController browseViewController;
  private Stage stage;
  private ViewModelFactory viewModelFactory;


  private Stage primaryStage;
  private Scene currentScene;



  public ViewHandler(ViewModelFactory vmf) {
    this.viewModelFactory = vmf;

}

   public void start(){
    stage = new Stage();
    openBrowseItem();

   }


  public void openBrowseItem() {
    if(browserScene == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/browseItems/browser.fxml"));
        Parent root = loader.load();

        BrowseViewController ctrl = loader.getController();
        ctrl.init(viewModelFactory.getBrowseViewModel());

        stage.setTitle("browser");
        browserScene = new Scene(root);

      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    stage.setScene(browserScene);
    stage.show();
  }






















}
