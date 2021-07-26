package View.browseItems;

import Model.*;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

public class BrowseViewModel {

private Client client;

    private ObservableList productObservableList;
    private ObservableList renterObservableList;
    private ObservableList reserverObservableList;

    private StringProperty clock;
    private StringProperty search;
    private StringProperty error;

    public BrowseViewModel(Client client) {
        this.client = client;
        search = new SimpleStringProperty();
        clock = new SimpleStringProperty();
        error = new SimpleStringProperty();
        client.addListener("time",this::clock);
        client.addListener("product",this::product);
        client.addListener("renter",this::renter);
    }

    private void renter(PropertyChangeEvent propertyChangeEvent) {
       loadRentedList();
    }

    private void product(PropertyChangeEvent propertyChangeEvent) {
      loadProducts();

    }

    private void clock(PropertyChangeEvent propertyChangeEvent) {
        startClock();
    }


    public void startClock(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                clock.setValue(String.valueOf(client.clock()));
            }
        });
    }

    public void loadProducts() {
        ArrayList productList = client.getAllAvaliableProducts();
        productObservableList = FXCollections.observableArrayList(productList);

    }

    public void loadRentedList() {
        List<RentedList> rentedLists = client.getRentedList();
        renterObservableList = FXCollections.observableArrayList(rentedLists);
    }

    public void loadReservedList() {
        List<RentedList> reservedlist = client.getReservedList();
        reserverObservableList = FXCollections.observableArrayList(reservedlist);
    }

    public ObservableList<product> getProductObservableList() {
        return productObservableList;
    }

    public ObservableList<RentedList> getRentedObservableList() {
        return renterObservableList;
    }

    public ObservableList<RentedList> getReservedObservableList() {
        return reserverObservableList;
    }

    public void delete(product product){
        productObservableList.remove(client.deleteProduct(product));


    }

    public void deleteRenter(RentedList rentedList){
        RentedList deleteRenter = client.deleteRenter(rentedList);
        renterObservableList.remove(deleteRenter);
        productObservableList.add(client.addProduct(new product(deleteRenter.getProductKind(),deleteRenter.getTitle(),deleteRenter.getIsbn(), deleteRenter.getAuthor(), deleteRenter.getReleaseDate())));

    }

    public void deleteReserver(RentedList rentedList){
        reserverObservableList.remove(client.deleteReserved(rentedList));
    }

    public void Search(){
        productObservableList.setAll(client.search(search.getValue()));
        renterObservableList.setAll(client.searchRenters(search.getValue()));
        reserverObservableList.setAll(client.searchReserve(search.getValue()));
    }


    public void clearSearch(){
        search.setValue("");

    }

    public boolean SearchValidation(){
        Search();
        if (productObservableList.isEmpty() && renterObservableList.isEmpty() && reserverObservableList.isEmpty()){

            error.setValue("Kunne ikke finde noget tilsvarende");
            Search();
            return false;


        }
        else {
            error.setValue("");
            return true;
        }

    }

    public boolean deleteProductValidation(product product){
        if (product != null){
            return true;
        } else{

            error.setValue("Vælg venligst et produkt at fjerne");
            return false;

        }


    }

    public boolean deleteRentedValidation(RentedList rentedList){
        if (rentedList != null){
            return true;
        } else{

            error.setValue("Vælg venligst en lånt genstand at fjerne");
            return false;

        }


    }

    public boolean getProductInformation(product products) {
        if (products != null) {
            SaveInfo.getInstance().setProduct(products);
            System.out.println("Save ProductInformation  = " + SaveInfo.getInstance());
            error.setValue("");
            return true;
        }else {
            error.setValue("Vælg venligst et produkt for at fortsætte");
            return false;
        }
    }

    public StringProperty clockProperty() {
        return clock;
    }

    public StringProperty searchProperty() {
        return search;
    }

    public String getError() {
        return error.get();
    }

    public StringProperty errorProperty() {
        return error;
    }


}
