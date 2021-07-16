package View.opretLogin;

import Model.Client;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class opretLoginViewModel {

    private Client client;
    private StringProperty CreateUser;
    private StringProperty CreatePassword;
    private StringProperty Error;


    public opretLoginViewModel(Client client) {
        this.client = client;
        CreateUser = new SimpleStringProperty();
        CreatePassword = new SimpleStringProperty();
        Error = new SimpleStringProperty();

    }



    public boolean createUser(){

        if (client.createUser(CreateUser.getValue(),CreatePassword.getValue())){

            return true;
        }
        else{

            return false;
        }


    }



    public String getCreateUser() {
        return CreateUser.get();
    }

    public StringProperty createUserProperty() {
        return CreateUser;
    }

    public String getCreatePassword() {
        return CreatePassword.get();
    }

    public StringProperty createPasswordProperty() {
        return CreatePassword;
    }

    public String getError() {
        return Error.get();
    }

    public StringProperty errorProperty() {
        return Error;
    }
}
