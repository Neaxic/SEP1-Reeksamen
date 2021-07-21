package Core;

import Model.*;
import Util.FileHandler;
import View.browseItems.BrowseViewController;
import View.login.loginViewController;

import View.registerNewItem.RegisterController;
import View.registerNewRenter.registerNewRenterViewController;

import View.renterList.renterListController;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class ViewHandler {

  private Scene browserScene,registerScene,registerNewRenterScene, loginScene, renterListScene;
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

    public void openRenterList() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/renterList/renterList.fxml"));
            Parent root = loader.load();

            renterListController ctrl = loader.getController();
            ctrl.init(viewModelFactory.getRenterListViewModel(),this);

            stage.setTitle("renterList");
            renterListScene = new Scene(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(renterListScene);
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

}

