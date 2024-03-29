package View.registerNewItem;

import Model.Client;
import Model.product;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class RegisterViewmodel {

    private Client client;
    private StringProperty title;
    private StringProperty author;
    private StringProperty isbn;
    private StringProperty type;
    private Property releaseDate;
    private ObservableList<product> productObservableList;
    private StringProperty error;


    public RegisterViewmodel(Client client) {
        this.client = client;
        title = new SimpleStringProperty();
        author = new SimpleStringProperty();
        isbn = new SimpleStringProperty();
        releaseDate = new SimpleObjectProperty();
        type = new SimpleStringProperty();
        error = new SimpleStringProperty();
    }

    public void loadProductsType() {
        System.out.println("load type");
        ArrayList allProductsFromClient = client.getAllProductsType();
        productObservableList = FXCollections.observableArrayList(allProductsFromClient);
    }

    public void submit(){
            client.createProduct(title.getValue(), author.getValue(), isbn.getValue(), type.getValue(), releaseDate.getValue().toString());
            clearFields();
    }


    //checker om fields er mindre end 35 characters eller null
    public boolean validInputs() {

        if(title.getValue() == null || author.getValue() == null || type.getValue() == null || releaseDate.getValue().toString() == null ){
            error.set("fields cannot be null");
            return false;
        }

        if(title.getValue().length() > 35) {
            error.set("title must contain less than 35 characters");
            return false;
        }
        if(author.getValue().length() > 35) {
            error.set("author must contain less than 35 characters");
            return false;
        }
        if(type.getValue().length() > 35) {
            error.set("type must contain less than 35 characters");
            return false;
        }
        else {
            error.set("Item has been Added");
            return true;
        }

    }


    public void clearErrorLabel(){
        error.setValue("");
    }


    public void clearFields(){
        title.setValue(null);
        author.setValue(null);
        isbn.setValue(null);
        type.setValue(null);
        releaseDate.setValue(null);
    }

    public StringProperty typeProperty() {
        return type;
    }

    public ObservableList<product> getProductObservableList() {
        return productObservableList;
    }

    public StringProperty titleProperty() {
        return title;
    }

    public StringProperty authorProperty() {
        return author;
    }

    public StringProperty isbnProperty() {
        return isbn;
    }

    public Property releaseDateProperty() {
        return releaseDate;
    }

    public StringProperty errorProperty() {
        return error;
    }
}
