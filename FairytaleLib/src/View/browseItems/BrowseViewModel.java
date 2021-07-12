package View.browseItems;

import Model.Client;
import Model.ClientModel;
import Model.product;
import Model.renter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.List;

public class BrowseViewModel {


private Client client;

    private ObservableList productObservableList;
    private ObservableList renterObservableList;
    private StringProperty search;

    public BrowseViewModel(Client client) {
        this.client = client;
        search = new SimpleStringProperty();
    }


    public void loadProducts() {
        //Det er vigtigt vi starter fra mere specifikke og ned i test purpose da vi først laver en rented i get all rented
        ArrayList rentedProducts = client.getAllRentedProducts();
        ArrayList productList = client.getAllAvaliableProducts();

            productObservableList = FXCollections.observableArrayList(productList);

            renterObservableList = FXCollections.observableArrayList(rentedProducts);
    }

 // productKind,title,author,isbn






    public ObservableList<product> getProductObservableList() {
        return productObservableList;
    }

    public ObservableList<product> getRentedObservableList() {
        return renterObservableList;
    }

    public void delete(product product){
        productObservableList.remove(client.deleteProduct(product));


    }

    public void Search(){
        productObservableList.setAll(client.search(search.getValue()));
    }





    public void clearSearch(){
        search.setValue("");

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
}
