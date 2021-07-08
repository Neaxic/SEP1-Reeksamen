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


    public RegisterViewmodel(Client client) {
        this.client = client;
        title = new SimpleStringProperty();
        author = new SimpleStringProperty();
        isbn = new SimpleStringProperty();
        releaseDate = new SimpleObjectProperty();
        type = new SimpleStringProperty();
    }

    public void loadProductsType() {
        System.out.println("load type");
        ArrayList allProductsFromClient = client.getAllProductsType();
        productObservableList = FXCollections.observableArrayList(allProductsFromClient);
    }

    public void submit(){
        if(validInput()){
            this.type.getValue().equals(type);
            client.createProduct(title.getValue(), author.getValue(), isbn.getValue(), type.getValue(), releaseDate.getValue().toString());
            //clearFields();
        } else {
            //invalidInputPopup();
        }
    }

//TODO: bedre checks skal jeg nok lave
    public boolean validInput(){
        //Blank check
        if(title.getValue().isBlank()){
            return false;
        }

        return true;
    }

    //TODO: Tænker at give client et popup med hvad der mangler af inputs
    public void invalidInputPopup(){

    }

    public void clearFields(){
        title.setValue(null);
        author.setValue(null);
        isbn.setValue(null);
        type.setValue(null);
        releaseDate.setValue(null);
    }


    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public ObservableList<product> getProductObservableList() {
        return productObservableList;
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getAuthor() {
        return author.get();
    }

    public StringProperty authorProperty() {
        return author;
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public String getIsbn() {
        return isbn.get();
    }

    public StringProperty isbnProperty() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn.set(isbn);
    }

    public String getReleaseDate() {
        return releaseDate.getValue().toString();
    }

    public Property releaseDateProperty() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate.setValue(releaseDate);
    }
}
