package View.renterList;

import Model.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class RenterListViewModel {

    private Client client;
    private ObservableList lånerObservableList;


    public RenterListViewModel(Client client) {
        this.client = client;
    }

    public void loadRenter() {

        ArrayList renterList = client.getAllClients();

        lånerObservableList = FXCollections.observableArrayList(renterList);

    }

    public ObservableList getLånerObservableList() {
        return lånerObservableList;
    }




}
