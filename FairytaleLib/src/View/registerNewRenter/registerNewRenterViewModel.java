package View.registerNewRenter;

import Model.Client;
import Model.product;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class registerNewRenterViewModel
{
  private Client client;
  private StringProperty firstName;
  private StringProperty lastName;
  private StringProperty eMail;
  private StringProperty renterID;
  private StringProperty status;
  private ObservableList<product> productObservableList;
  private StringProperty error;


  public registerNewRenterViewModel(Client client) {
    this.client = client;
    firstName = new SimpleStringProperty();
    lastName = new SimpleStringProperty();
    eMail = new SimpleStringProperty();
    renterID = new SimpleStringProperty();
    status = new SimpleStringProperty();
    error = new SimpleStringProperty();
  }

  public void loadRenterStatus() {
    System.out.println("load status");
    ArrayList allProductsFromClient = client.getAllProductsType();
    productObservableList = FXCollections.observableArrayList(allProductsFromClient);

  }

/*
  public void submit(){

    if (validInput() && validCharInputs())

    this.status.getValue().equals(status);

  }


  //checker om fields er null
  public boolean validInput(){
    if(firstName.getValue() == null || lastName.getValue() == null || eMail.getValue() == null || renterID.getValue() == null || status.getValue() == null){
      error.set("field cannot be null");
      return false;
    }
    return true;
  }


  //checker om fields er under 35 tegn
  public boolean validCharInputs() {
    if(firstName.getValue().length() > 35) {
      error.set("firstname must contain less than 35 characters");
      return false;
    }
    if(lastName.getValue().length() > 35) {
      error.set("lastName must contain less than 35 characters");
      return false;
    }
    if(eMail.getValue().length() > 35) {
      error.set("email must contain less than 35 characters");
      return false;
    }
    if(renterID.getValue().length() > 35) {
      error.set("email must contain less than 35 characters");
      return false;
    }
    if(status.getValue().length() > 35) {
      error.set("email must contain less than 35 characters");
      return false;
    }
    else {

      return true;
    }
  }

  //clearfields
  public void clearFields(){
    firstName.setValue(null);
    lastName.setValue(null);
    eMail.setValue(null);
    renterID.setValue(null);
    status.setValue(null);
  }

*/




  public String getStatus() {
    return status.get();
  }

  public StringProperty statusProperty() {
    return status;
  }

  public ObservableList<product> getProductObservableList() {
    return productObservableList;
  }

  public String getFirstName() {
    return firstName.get();
  }

  public StringProperty firstNameProperty() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName.set(firstName);
  }

  public String getLastName() {
    return lastName.get();
  }

  public StringProperty lastNameProperty() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName.set(lastName);
  }

  public String geteMail() {
    return eMail.get();
  }

  public StringProperty eMailProperty() {
    return eMail;
  }

  public void seteMail(String eMail) {
    this.eMail.set(eMail);
  }

  public String getRenterID() {
    return renterID.get();
  }

  public StringProperty renterIDProperty() {
    return renterID;
  }

  public void setRenterID(String renterID) {
    this.renterID.set(renterID);
  }

  public void loadProductsType() {}

  public StringProperty errorProperty() {
    return error;
  }
}
