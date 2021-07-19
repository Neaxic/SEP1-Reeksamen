package View.browseItems;

import Model.Client;
import Model.ClientModel;
import Model.product;
import Util.FileHandler;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BrowseViewModel {


private Client client;

    private ObservableList productObservableList;
    private ObservableList renterObservableList;
    private ObservableList reserverObservableList;


    private StringProperty search;
    private StringProperty clock;

    public BrowseViewModel(Client client) {
        this.client = client;
        search = new SimpleStringProperty();
        clock = new SimpleStringProperty();
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
        ArrayList rentedProducts = client.getAllRentedProducts();
        ArrayList productList = client.getAllAvaliableProducts();
        ArrayList reserverList = client.getAllReservedProducts();

        //List<product> productList = client.getAllProducts();
        productObservableList = FXCollections.observableArrayList(productList);
        renterObservableList = FXCollections.observableArrayList(rentedProducts);
        reserverObservableList = FXCollections.observableArrayList(reserverList);
    }

 // productKind,title,author,isbn




    public ObservableList<product> getProductObservableList() {
        return productObservableList;
    }

    public ObservableList<product> getRentedObservableList() {
        return renterObservableList;
    }

    public ObservableList<product> getReservedObservableList() {
        return reserverObservableList;
    }

    public void delete(product product){
        productObservableList.remove(client.deleteProduct(product));


    }


    public void deleteRenter(product product){
        renterObservableList.remove(client.deleteProduct(product));
        productObservableList.add(client.addProduct(product));

    }




    public void Search(){
        productObservableList.setAll(client.search(search.getValue()));
    }





    public void clearSearch(){
        search.setValue("");

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
}
