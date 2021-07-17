package View.registerNewRenter;

import Core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class registerNewRenterViewController
{

  public Label error;
  private ViewHandler viewHandler;
  private registerNewRenterViewModel registerNewRenterViewModel;

  @FXML private TextField firstName;
  @FXML private TextField eMail;
  @FXML private ChoiceBox status;


  public void init(registerNewRenterViewModel registerNewRenterViewModel,ViewHandler viewHandler) {
    this.registerNewRenterViewModel = registerNewRenterViewModel;
    this.viewHandler = viewHandler;

    registerNewRenterViewModel.loadRenterStatus();
    status.setItems(registerNewRenterViewModel.getRenterObservableList());
    firstName.textProperty().bindBidirectional(registerNewRenterViewModel.nameProperty());
    eMail.textProperty().bindBidirectional(registerNewRenterViewModel.eMailProperty());
    error.textProperty().bind(registerNewRenterViewModel.errorProperty());
    status.valueProperty().bindBidirectional(registerNewRenterViewModel.statusProperty());
  }


  public void Back() {
    viewHandler.openBrowseItem();
  }


  public void Submit(ActionEvent actionEvent) {
    registerNewRenterViewModel.submitRenter();
  }
}
