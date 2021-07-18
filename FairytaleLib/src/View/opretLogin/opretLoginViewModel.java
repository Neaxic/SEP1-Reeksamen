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
            attemptCreateUser();
            validatePasswords();
            clearFields();

            return true;
        }
        else{

            return false;
        }

    }

    public boolean attemptCreateUser() {

        if(CreateUser.getValue() == null) {
            Error.set("Username cannot be empty");
            return false;

        }
        if(CreateUser.getValue().contains("#")) {
            Error.set("Username cannot contain #");
            return false;
        }
        if(CreateUser.getValue().length() < 4) {
            Error.set("Username must contain more than 3 characters");
            return false;
        }
        if(CreateUser.getValue().length() > 14) {
            Error.set("Username must contain less than 15 characters");
            return false;
        } else {

            return true;
        }
    }

    public boolean validatePasswords() {

        if (CreatePassword.getValue() == null && CreateUser.getValue() == null) {
            Error.set("Password cannot be empty");
            return false;
        }
        if (CreatePassword.getValue().length() < 8) {
            Error.set("Password length must be 8 or more");
            return false;
        }
        if (CreatePassword.getValue().length() > 14) {
            Error.set("Password length must be 14 or less");
            return false;
        }

        if (CreatePassword.getValue().contains("#")) {
            Error.set("Password cannot contain #");
            return false;
        }

        if (!CreatePassword.getValue().matches(".*\\d.*")) {
            Error.set("Password must contain at least one number");
            return false;
        } else {

            return true;

        }


    }


    public void clearFields() {
        CreateUser.setValue(null);
        CreatePassword.setValue(null);
        Error.setValue(null);

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
