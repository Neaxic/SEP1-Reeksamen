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
        //Det er vigtigt vi starter fra mere specifikke og ned i test purpose da vi først laver en rented i get all rented

        ArrayList productList = client.getAllAvaliableProducts();
        ArrayList reserverList = client.getAllReservedProducts();

        //List<product> productList = client.getAllProducts();
        productObservableList = FXCollections.observableArrayList(productList);

        reserverObservableList = FXCollections.observableArrayList(reserverList);

    }

    public void loadRentedList() {

        List<RentedList> rentedLists = client.getSss();

        renterObservableList = FXCollections.observableArrayList(rentedLists);

    }

    public ObservableList<product> getProductObservableList() {
        return productObservableList;
    }

    public ObservableList<RentedList> getRentedObservableList() {
        return renterObservableList;
    }

    public ObservableList<product> getReservedObservableList() {
        return reserverObservableList;
    }

    public void delete(product product){
        if(product.isRented()){
            System.out.println("rented");
            renterObservableList.remove(client.deleteProduct(product));
        } else if(product.isReserved()){
            System.out.println("reserver");
            reserverObservableList.remove(client.deleteProduct(product));
        } else {
            System.out.println("avaliable");
            productObservableList.remove(client.deleteProduct(product));
        }
    }


    public void deleteRenter(product product){
        renterObservableList.remove(client.deleteProduct(product));
        productObservableList.add(client.addProduct(product));

    }

    public void deleteReserver(product product){
        reserverObservableList.remove(client.deleteProduct(product));
        productObservableList.add(client.addProduct(product));
    }

    public void Search(){
        productObservableList.setAll(client.search(search.getValue()));
    }





    public void clearSearch(){
        search.setValue("");

    }


    public boolean getProductInformation(product products) {
        if (products != null) {
            SaveInfo.getInstance().setProduct(products);
            System.out.println("Save ProductInformation  = " + SaveInfo.getInstance());
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
}
