package View.registerNewItem;

import Model.Client;
import Model.product;
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
    private StringProperty releaseDate;
    private StringProperty type;
    private ObservableList<product> productObservableList;


    public RegisterViewmodel(Client client) {
        this.client = client;
        title = new SimpleStringProperty();
        author = new SimpleStringProperty();
        isbn = new SimpleStringProperty();
        releaseDate = new SimpleStringProperty();
        type = new SimpleStringProperty();
    }




    public void loadProductsType() {
        System.out.println("load type");
        ArrayList allProductsFromClient = client.getAllProductsType();
        productObservableList = FXCollections.observableArrayList(allProductsFromClient);


    }

    public void submit(){
        this.type.getValue().equals(type);
        client.createProduct(title.getValue(), author.getValue(), isbn.getValue(), type.getValue(),releaseDate.getValue());
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
        return releaseDate.get();
    }

    public StringProperty releaseDateProperty() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate.set(releaseDate);
    }
}
