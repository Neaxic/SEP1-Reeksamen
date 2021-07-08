package View.browseItems;

import Model.Client;
import Model.ClientModel;
import Model.product;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class BrowseViewModel {


private Client client;

    private ObservableList<product> productObservableList;
    private StringProperty search;

    public BrowseViewModel(Client client) {
        this.client = client;
        search = new SimpleStringProperty();
    }


    public void loadProducts() {
            List<product>productList = client.getAllProducts();
            productObservableList = FXCollections.observableArrayList(productList);
    }

 // productKind,title,author,isbn






    public ObservableList<product> getProductObservableList() {
        return productObservableList;
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
