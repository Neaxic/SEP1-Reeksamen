package View.browseItems;

import Model.*;
import Util.FileHandler;
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
    private StringProperty error;

    private ObservableList lånerObservableList;

    private StringProperty search;
    private StringProperty clock;

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

        List<RentedList> rentedLists = client.getSss();
        renterObservableList = FXCollections.observableArrayList(rentedLists);
    }

    public void loadReservedList() {
        List<RentedList> reservedlist = client.getGgg();
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
       // product product1 = SaveInfo.getInstance().getProduct();
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
    }


    public void clearSearch(){
        search.setValue("");

    }

    public boolean deleteProductValidation(product product){
        if (product != null){
            return true;
        } else{

            error.setValue("Please choose a product to delete");
            return false;

        }


    }

    public boolean deleteRentedValidation(RentedList rentedList){
        if (rentedList != null){
            return true;
        } else{

            error.setValue("Please choose a rented item to delete");
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
            error.setValue("Please choose a product for continue");
            return false;
        }
    }

    public String getClock() {
        return clock.get();
    }

    public StringProperty clockProperty() {
        return clock;
    }

    public void setClock(String clock) {
        this.clock.set(clock);
    }

    public String getSearch() {
        return search.get();
    }

    public StringProperty searchProperty() {
        return search;
    }

    public void setSearch(String search) {
        this.search.set(search);
    }

    public Client getClient() {
        return client;
    }

    public String getError() {
        return error.get();
    }

    public StringProperty errorProperty() {
        return error;
    }

    public ObservableList getRenterObservableList() {
        return renterObservableList;
    }

    public ObservableList getReserverObservableList() {
        return reserverObservableList;
    }

    public ObservableList getLånerObservableList() {
        return lånerObservableList;
    }
}
