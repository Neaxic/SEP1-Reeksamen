package Core;

import Model.*;
import Util.FileHandler;
import View.browseItems.BrowseViewController;
import View.login.loginViewController;

import View.registerNewItem.RegisterController;
import View.registerNewRenter.registerNewRenterViewController;

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

    public void openListOfUsers(ClientModel clientModel, product product) throws IOException, ClassNotFoundException {
        ArrayList test = FileHandler.loadProductList();

        //get Slected product
        System.out.println(product.getTitle());


        //Window setup
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(stage);
        VBox dialogVbox = new VBox(20);

        //FXML
        Text tekst = new Text("This is a Dialog");
        dialogVbox.getChildren().add(tekst);
        //ListView listOfUsers = new ListView();
       // TableView<renter> listOfUsers = new TableView();
        TableView table = new TableView();

        //TableColumn name = new TableColumn("Name");
        //TableColumn job = new TableColumn("Work");
       // TableColumn email = new TableColumn("Email");

        TableColumn<renter, String> column1 = new TableColumn<>("Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<renter, String> column2 = new TableColumn<>("Job");
        column2.setCellValueFactory(new PropertyValueFactory<>("jobPostion"));

        TableColumn<renter, String> column3 = new TableColumn<>("Email");
        column3.setCellValueFactory(new PropertyValueFactory<>("email"));

        table.getColumns().addAll(column1, column2, column3);

        for (int i = 0; i < clientModel.getAllClients().size(); i++) {
            //RenterName.getColumns().add(clientModel.getAllClients().get(i).getName());
           // RenterType.getColumns().add(clientModel.getAllClients().get(i).getJobPostion());
           // RenterEmail.getColumns().add(clientModel.getAllClients().get(i).getEmail());

            //table.getItems().add(clientModel.getAllClients().get(i).getName());

            table.getItems().add(clientModel.getAllClients().get(i));
        }





        Button submitButton = new Button("Submit");
        submitButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                //java.time.LocalDate.now().toString()
                //System.out.println(listOfUsers.getSelectionModel().getSelectedItem());

                for (renter allClient : clientModel.getAllClients()) {

                    String formatCode = "dd-MM-yyyy 'at' HH:mm:ss z"; // Example
                    SimpleDateFormat formatter = new SimpleDateFormat(formatCode); // Time Formatter


                    Calendar c= Calendar.getInstance();
                    Calendar yearBefore = Calendar.getInstance();
                    yearBefore.add(Calendar.YEAR,-1);
                    System.out.println("BLADDER: " +c.getTime());
                    System.out.println("BLADDER: " +yearBefore.getTime());



                    System.out.println("adwad: "+yearBefore.getTime());
                    System.out.println("adwad: "+c.getTime());

                    if (product.getProductKind() == "artikel") {
                        System.out.println("Artikel");
                        c.add(Calendar.DATE, 14);
                        Date d=c.getTime();
                        String time = formatter.format(d);
                        product.setRenter((renter) table.getSelectionModel().getSelectedItem(),time);
                    } else if (/*(Date) product.getReleaseDate()*/ true){

                        //Her skal fixes noget ^^ Productets date, er bare en string, så man kan ikke sammenligne de 2 dates
                        System.out.println("very old book");
                        if (allClient.getJobPostion().equals("student")){
                            c.add(Calendar.DATE, 30);
                            Date d=c.getTime();
                            String time = formatter.format(d);
                            product.setRenter((renter) table.getSelectionModel().getSelectedItem(),time);

                            openBrowseItem();
                            System.out.println("1" + allClient.getJobPostion().equals("student"));

                        } else if (allClient.getJobPostion().equals("lecture")){
                            System.out.println("2" + allClient.getJobPostion().equals("lecture"));

                            c.add(Calendar.DATE, 180);
                            Date d=c.getTime();
                            String time = formatter.format(d);
                            product.setRenter((renter) table.getSelectionModel().getSelectedItem(),time);

                            openBrowseItem();
                        }

                    } else {
                        System.out.println("Not very old book");
                    }




            }

            }

        });

        dialogVbox.getChildren().add(table);
        dialogVbox.getChildren().add(submitButton);

        //Margins
        VBox.setMargin(submitButton, new Insets(0, 16, 12, 16));
        VBox.setMargin(table, new Insets(0, 16, 12, 16));
        VBox.setMargin(tekst, new Insets(25, 16, 0, 16));

        //window execution
        Scene dialogScene = new Scene(dialogVbox, 500, 400);
        dialog.setScene(dialogScene);
        dialog.show();

    }


    public void reserve(ClientModel clientModel, product product) throws IOException, ClassNotFoundException {
        ArrayList test = FileHandler.loadProductList();

        //get Slected product
        System.out.println(product.getTitle());


        //Window setup
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(stage);
        VBox dialogVbox = new VBox(20);

        //FXML
        Text tekst = new Text("This is a Dialog");
        dialogVbox.getChildren().add(tekst);
        //ListView listOfUsers = new ListView();
        // TableView<renter> listOfUsers = new TableView();
        TableView table = new TableView();

        //TableColumn name = new TableColumn("Name");
        //TableColumn job = new TableColumn("Work");
        // TableColumn email = new TableColumn("Email");

        TableColumn<renter, String> column1 = new TableColumn<>("Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<renter, String> column2 = new TableColumn<>("Job");
        column2.setCellValueFactory(new PropertyValueFactory<>("jobPostion"));

        TableColumn<renter, String> column3 = new TableColumn<>("Email");
        column3.setCellValueFactory(new PropertyValueFactory<>("email"));

        table.getColumns().addAll(column1, column2, column3);

        for (int i = 0; i < clientModel.getAllClients().size(); i++) {
            //RenterName.getColumns().add(clientModel.getAllClients().get(i).getName());
            // RenterType.getColumns().add(clientModel.getAllClients().get(i).getJobPostion());
            // RenterEmail.getColumns().add(clientModel.getAllClients().get(i).getEmail());

            //table.getItems().add(clientModel.getAllClients().get(i).getName());

            table.getItems().add(clientModel.getAllClients().get(i));
        }





        Button submitButton = new Button("Submit");
        submitButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                //java.time.LocalDate.now().toString()
                //System.out.println(listOfUsers.getSelectionModel().getSelectedItem());
                        product.setReserver((renter) table.getSelectionModel().getSelectedItem());
                        openBrowseItem();
                }
        });

        dialogVbox.getChildren().add(table);
        dialogVbox.getChildren().add(submitButton);

        //Margins
        VBox.setMargin(submitButton, new Insets(0, 16, 12, 16));
        VBox.setMargin(table, new Insets(0, 16, 12, 16));
        VBox.setMargin(tekst, new Insets(25, 16, 0, 16));

        //window execution
        Scene dialogScene = new Scene(dialogVbox, 500, 400);
        dialog.setScene(dialogScene);
        dialog.show();

    }
}
