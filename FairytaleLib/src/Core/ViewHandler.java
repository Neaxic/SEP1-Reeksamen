package Core;

import View.browseItems.BrowseViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

  private ViewModelFactory viewModelFactory;
  private Stage mainStage;


  private Stage primaryStage;
  private Scene currentScene;

  private BrowseViewController browseViewController;

  public ViewHandler(Stage stage, ViewModelFactory vmf) {
    mainStage = stage;
    primaryStage = stage;
    this.currentScene = new Scene(new Region());
    viewModelFactory = vmf;
    openView("browser");
  }
/*
  public void start() {
    openShowAllView();
  }

  private Scene addScene;

/*
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
/*
  public void openShowAllView() {
    try {
      if(viewAllScene == null)
        viewAllScene = getScene("../View/browseItems/browser.fxml");
      changeScene("View tasks", viewAllScene);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
*/


  private void changeScene(String s, Scene addScene) {
    mainStage.setTitle(s);
    mainStage.setScene(addScene);
    mainStage.show();
  }
/*
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
*/

  public void openView(String id)
  {
    Region root = null;
    switch (id)
    {
      case "browser":
        root = loadView("browser.fxml");
        break;
    }

    currentScene.setRoot(root);

    String title = "Test";
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  private Region loadView(String fxmlFile)
  {
    if (browseViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../View/browseItems/"+fxmlFile));
        Region root = loader.load();
        browseViewController = loader.getController();
        browseViewController.init(this, viewModelFactory.getViewModelBrowse() , root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      //browseViewController.reset();
      System.out.println("t");
    }
    return browseViewController.getRoot();
  }

}
