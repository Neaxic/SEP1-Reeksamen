package View.registerNewRenter;

import Core.ViewHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class registerNewRenterViewController
{

  public Label error;
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

    error.textProperty().bind(registerViewmodel.errorProperty());




  }


  public void Back() {
    viewHandler.openBrowseItem();
  }




}
