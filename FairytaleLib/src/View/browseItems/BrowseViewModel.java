package View.browseItems;

import Model.Client;
import javafx.beans.property.ListProperty;

import java.util.ArrayList;

public class BrowseViewModel {


private Client client;

    private ArrayList<String> allItemList;

    public BrowseViewModel(Client client) {
        this.client = client;
        allItemList = new ArrayList<>();
    }

    public void populate(){
        this.allItemList.add("ITEM");

    }

    public void getAvaliable(){

    }
}
