package Core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ViewHandler {


    private Parent root;

  public void start() {
    stage = new Stage();
    openToDashView();
  }


    public Parent getRoot() {
      return root;
    }


}