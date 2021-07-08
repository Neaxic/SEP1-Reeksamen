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


  public registerNewRenterViewModel(Client client) {
    this.client = client;
    firstName = new SimpleStringProperty();
    lastName = new SimpleStringProperty();
    eMail = new SimpleStringProperty();
    renterID = new SimpleStringProperty();
    status = new SimpleStringProperty();
  }




  public void loadRenterStatus() {
    System.out.println("load status");
    ArrayList allProductsFromClient = client.getAllProductsType();
    productObservableList = FXCollections.observableArrayList(allProductsFromClient);


  }

  public void submit(){
    this.status.getValue().equals(status);
    client.createProduct(firstName.getValue(), lastName.getValue(), eMail.getValue(), status
            .getValue(),
        renterID.getValue());
  }



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

  public void loadProductsType()
  {
  }
}
