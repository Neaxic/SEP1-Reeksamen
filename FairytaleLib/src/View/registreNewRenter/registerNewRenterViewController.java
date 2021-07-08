package View.registreNewRenter;

import Core.ViewHandler;
import View.registerNewItem.RegisterViewmodel;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class registerNewRenterViewController
{

  private ViewHandler viewHandler;
  private registerNewRenterViewModel registerViewmodel;

  @FXML private TextField firstName;
  @FXML private TextField lastName;
  @FXML private TextField eMail;
  @FXML private TextField renterID;
  @FXML private ChoiceBox status;


  public void init(registerNewRenterViewModel registerViewmodel,ViewHandler viewHandler) {
    this.registerViewmodel = registerViewmodel;
    this.viewHandler = viewHandler;
    registerViewmodel.loadProductsType();
    status.setItems(registerViewmodel.getProductObservableList());
    firstName.textProperty().bindBidirectional(registerViewmodel.firstNameProperty());
    lastName.textProperty().bindBidirectional(registerViewmodel.lastNameProperty());
    eMail.textProperty().bindBidirectional(registerViewmodel.eMailProperty());
    renterID.textProperty().bindBidirectional(registerViewmodel.renterIDProperty());
    status.valueProperty().bindBidirectional(registerViewmodel.statusProperty());




  }


  public void Back() {
    viewHandler.openBrowseItem();
  }




}
