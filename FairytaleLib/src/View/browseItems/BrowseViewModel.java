package View.browseItems;

import Model.Client;
import Model.product;
import javafx.beans.property.ListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BrowseViewModel {


private Client client;

    private ObservableList<product> productObservableList;

    public BrowseViewModel(Client client) {
        this.client = client;
    }


    public void loadProducts() {
        System.out.println("load");
        ArrayList allProductsFromClient = client.getAllProducts();
        productObservableList = FXCollections.observableArrayList();
        for (Object i : allProductsFromClient) {
            productObservableList.add((product) i);
        }
    }

 // productKind,title,author,isbn






    public ObservableList<product> getProductObservableList() {
        return productObservableList;
    }

    public void populate(){


    }

    public void getAvaliable(){

    }






}
