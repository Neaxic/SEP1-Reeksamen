package Core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

  private ViewModelFactory viewModelFactory;
  private Stage mainStage;

  public ViewHandler(Stage stage, ViewModelFactory vmf) {
    mainStage = stage;
    viewModelFactory = vmf;
  }

  public void start() {
    openShowAllView();
  }

  private Scene addScene;


  public void openAdd() {
    try {
      if (addScene == null) {
        addScene = getScene("../view/add/Add.fxml");
      }
      changeScene("Add task", addScene);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void openShowAllView() {
    try {
      if(viewAllScene == null)
        viewAllScene = getScene("../view/all/TaskList.fxml");
      changeScene("View tasks", viewAllScene);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }



  private void changeScene(String s, Scene addScene) {
    mainStage.setTitle(s);
    mainStage.setScene(addScene);
    mainStage.show();
  }

  private Scene getScene(String path) {
    try {
      FXMLLoader loader = new FXMLLoader();

      loader.setLocation(getClass().getResource(path));
      Parent root = loader.load();

      ViewController view = loader.getController();
      view.init(this, viewModelFactory);

      return new Scene(root);
    } catch (IOException e) {
      e.printStackTrace();
    }
    throw new RuntimeException("Failed to create scene");
  }

}