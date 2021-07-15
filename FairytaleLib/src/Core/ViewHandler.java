package Core;

import View.browseItems.BrowseViewController;
import View.login.loginViewController;
import View.opretLogin.opretLoginViewController;
import View.registerNewItem.RegisterController;
import View.registerNewRenter.registerNewRenterViewController;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

  private Scene browserScene,registerScene,registerNewRenterScene, loginScene, opretloginScene;
  private BrowseViewController browseViewController;
  private RegisterController registerController;
  private Stage stage;
  private ViewModelFactory viewModelFactory;


  public ViewHandler(ViewModelFactory vmf, Stage stage) {
    this.viewModelFactory = vmf;
    this.stage = stage;
}

   public void start(){
    //stage = new Stage();
   // openBrowseItem();
       openLogin();
   }


   public void openLogin() {

       try {
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("../view/login/login.fxml"));
           Parent root = loader.load();

           loginViewController ctrl = loader.getController();
           ctrl.init(viewModelFactory.getLoginViewModel(),this);

           stage.setTitle("login");
           loginScene = new Scene(root);

       } catch (IOException e) {
           e.printStackTrace();
       }
       stage.setScene(loginScene);
       stage.show();
   }


    public void openOpretLogin() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/opretLogin/opretLogin.fxml"));
            Parent root = loader.load();

            opretLoginViewController ctrl = loader.getController();
            ctrl.init(viewModelFactory.getOpretLoginViewModel(),this);

            stage.setTitle("opretLogin");
            opretloginScene = new Scene(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(opretloginScene);
        stage.show();
    }


  public void openBrowseItem() {

      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/browseItems/browser.fxml"));
        Parent root = loader.load();

        BrowseViewController ctrl = loader.getController();
        ctrl.init(viewModelFactory.getBrowseViewModel(),this);

        stage.setTitle("browser");
        browserScene = new Scene(root);

      } catch (IOException e) {
        e.printStackTrace();
      }

    stage.setScene(browserScene);
    stage.show();
  }

  public void openRegisterNewItems() {

      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/registerNewItem/registernewitem.fxml"));
        Parent root = loader.load();

        RegisterController ctrl = loader.getController();
        ctrl.init(viewModelFactory.getRegisterViewmodel(),this);

        stage.setTitle("RegisterItems");
        registerScene = new Scene(root);

      } catch (IOException e) {
        e.printStackTrace();
      }

    stage.setScene(registerScene);
    stage.show();
  }


  public void openregisterNewRenter() {

    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("../view/registerNewRenter/registerNewRenter.fxml"));
      Parent root = loader.load();

      registerNewRenterViewController ctrl = loader.getController();
      ctrl.init(viewModelFactory.getRegisterNewRenterViewModel(),this);

      stage.setTitle("registerNewRenter");
      registerNewRenterScene = new Scene(root);

    } catch (IOException e) {
      e.printStackTrace();
    }

    stage.setScene(registerNewRenterScene);
    stage.show();
  }

    public void openListOfUsers() {

        //Window setup
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(stage);
        VBox dialogVbox = new VBox(20);

        //FXML
        Text tekst = new Text("This is a Dialog");
        dialogVbox.getChildren().add(tekst);
        ListView listOfUsers = new ListView();
        listOfUsers.getItems().add("Tissemand");
        listOfUsers.getItems().add("Fissemand");
        dialogVbox.getChildren().add(listOfUsers);

        //Margins
        VBox.setMargin(listOfUsers, new Insets(0, 16, 12, 16));
        VBox.setMargin(tekst, new Insets(25, 16, 0, 16));

        //window execution
        Scene dialogScene = new Scene(dialogVbox, 500, 400);
        dialog.setScene(dialogScene);
        dialog.show();

    }


}
