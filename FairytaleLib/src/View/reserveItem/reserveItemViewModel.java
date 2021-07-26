package View.reserveItem;

import Model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Date;

public class reserveItemViewModel {

    private Client client;
    private ObservableList lånerObservableList;
    private StringProperty error;

    public reserveItemViewModel(Client client) {
        this.client = client;
        error = new SimpleStringProperty();
    }


    public void loadRenter() {

        ArrayList renterList = client.getAllClients();
        lånerObservableList = FXCollections.observableArrayList(renterList);

    }

    public ObservableList getLånerObservableList() {
        return lånerObservableList;
    }


    public boolean getRenterInformation(Renters renters) {
        if (renters != null) {
            SaveInfo.getInstance().setRenters(renters);
            System.out.println("Save RenterInformation  = " + SaveInfo.getInstance());
            return true;
        }else {
            error.setValue("Please choose a renter for continue");
            return false;
        }
    }

    public void CreateUdlåntGenstand() {

        product pt = SaveInfo.getInstance().getProduct();
        System.out.println("Gets SavedInfo from product= " + SaveInfo.getInstance().getProduct());

        Renters rt = SaveInfo.getInstance().getRenters();
        System.out.println("Gets SavedInfo from renter = " + SaveInfo.getInstance().getRenters());

        RentedList rentedList = new RentedList(pt,rt);

        client.createReservedItem(rentedList);
    }

    public String getError() {
        return error.get();
    }

    public StringProperty errorProperty() {
        return error;
    }
}
