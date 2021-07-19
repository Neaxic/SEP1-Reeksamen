package View.login;

import Model.Client;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewModel {

    private Client client;
    private StringProperty navn;
    private StringProperty kode;
    private StringProperty error;


    public LoginViewModel(Client client) {
        this.client = client;
        navn = new SimpleStringProperty();
        kode = new SimpleStringProperty();
        error =  new SimpleStringProperty();
    }


    public boolean login(){
        if (client.checkLogin(navn.getValue(),kode.getValue())){
            clearFields();
            return true;

        }
        if (navn.getValue() == null && kode.getValue() == null || navn.getValue().equals("") && kode.getValue().equals("")) {
            error.setValue("ERROR field is empty");
            return false;
        }
            error.setValue("ERROR, Either username or password is wrong");
        return false;

    }


    //clearfields
    public void clearFields() {
        navn.setValue("");
        kode.setValue("");
        error.setValue("");
    }


    public String getNavn() {
        return navn.get();
    }

    public StringProperty navnProperty() {
        return navn;
    }

    public String getKode() {
        return kode.get();
    }

    public StringProperty kodeProperty() {
        return kode;
    }

    public String getError() {
        return error.get();
    }

    public StringProperty errorProperty() {
        return error;
    }
}
