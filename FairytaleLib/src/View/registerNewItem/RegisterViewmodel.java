package View.registerNewItem;

import Model.Client;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RegisterViewmodel {
    private Client client;

    public void submit(String title, String author, String isbn, String type){
        client.createProduct(title, author, isbn, type);
    }

    public RegisterViewmodel(Client client) {
        this.client = client;
    }
}
