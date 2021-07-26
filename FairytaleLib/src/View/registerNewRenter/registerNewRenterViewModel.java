package View.registerNewRenter;

import Model.Client;
import Model.product;
import Model.renter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class registerNewRenterViewModel
{
  private Client client;
  private StringProperty Name;
  private StringProperty eMail;
  private StringProperty status;
  private ObservableList<renter> renterObservableList;
  private StringProperty error;


  public registerNewRenterViewModel(Client client) {
    this.client = client;
    Name = new SimpleStringProperty();
    eMail = new SimpleStringProperty();
    status = new SimpleStringProperty();
    error = new SimpleStringProperty();
  }

  public void loadRenterStatus() {
    System.out.println("load status");
    ArrayList allRenterFromClient = client.getAllRenterType();
    renterObservableList = FXCollections.observableArrayList(allRenterFromClient);

  }

  public void submitRenter(){

    client.createRenter(Name.getValue(),eMail.getValue(),status.getValue());
    clearFields();

  }

  //clearfields
  public void clearFields() {
    Name.setValue("");
    eMail.setValue("");
    status.setValue("");

  }

  public void clearErrorLabel(){
    error.setValue("");
  }


  //checker om inputs er null
  public boolean validInputs() {

    if(Name.getValue() == null ||Name.getValue().equals("") ||eMail.getValue() == null|| eMail.getValue().equals("")|| status.getValue() == null || status.getValue().equals("") || renterObservableList.isEmpty() ){
      error.set("fields cannot be null");
      return false;
    }

    else {
      error.set("Renter has been Added");
      return true;
    }

  }

  public String getName() {
    return Name.get();
  }

  public StringProperty nameProperty() {
    return Name;
  }

  public String geteMail() {
    return eMail.get();
  }

  public StringProperty eMailProperty() {
    return eMail;
  }

  public StringProperty statusProperty() {
    return status;
  }

  public ObservableList<renter> getRenterObservableList() {
    return renterObservableList;
  }

  public String getError() {
    return error.get();
  }

  public StringProperty errorProperty() {
    return error;
  }
}
