package View.registerNewRenter;

import Core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class registerNewRenterViewController
{

  private ViewHandler viewHandler;
  private registerNewRenterViewModel registerNewRenterViewModel;

  //renter
  @FXML private TextField firstName;
  @FXML private TextField eMail;
  @FXML private ChoiceBox status;
  @FXML private Label error;

  public void init(registerNewRenterViewModel registerNewRenterViewModel,ViewHandler viewHandler) {
    this.registerNewRenterViewModel = registerNewRenterViewModel;
    this.viewHandler = viewHandler;

    registerNewRenterViewModel.loadRenterStatus();

    //renter
    firstName.textProperty().bindBidirectional(registerNewRenterViewModel.nameProperty());
    eMail.textProperty().bindBidirectional(registerNewRenterViewModel.eMailProperty());
    status.setItems(registerNewRenterViewModel.getRenterObservableList());
    status.valueProperty().bindBidirectional(registerNewRenterViewModel.statusProperty());

    //error
    error.textProperty().bind(registerNewRenterViewModel.errorProperty());
  }

  public void Back() {

    viewHandler.openBrowseItem();
    registerNewRenterViewModel.clearErrorLabel();
  }

  public void Submit(ActionEvent actionEvent) {

    if (registerNewRenterViewModel.validInputs()) {

      registerNewRenterViewModel.submitRenter();
    }

  }

}
