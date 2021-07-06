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
        productObservableList = FXCollections.observableArrayList();
        productObservableList.add(new product("dvd", "nej", "karl", "31","2007-10-03"));
        productObservableList.add(new product("dvd", "nej", "karl", "31","2007-10-03"));
        productObservableList.add(new product("dvd", "nej", "karl", "31","2007-10-03"));
        productObservableList.add(new product("dvd", "nej", "karl", "31","2007-10-03"));
        productObservableList.add(new product("dvd", "nej", "karl", "31","2007-10-03"));
        productObservableList.add(new product("dvd", "nej", "karl", "31","2007-10-03"));

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
