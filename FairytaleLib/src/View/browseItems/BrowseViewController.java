package View.browseItems;

import Core.ViewHandler;
import Model.product;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;

import java.util.ArrayList;


public class BrowseViewController {
    private ViewHandler viewHandler;
    private BrowseViewModel viewmodel;

    @FXML private TableView availableMaterialView;
    @FXML private TableColumn avaliableTypeCollum;
    @FXML private TableColumn avaliableTitelCollum;
    @FXML private TableColumn releaseDate;

    @FXML private TableView rentetMaterialView;
    @FXML private TableColumn typeCollum;
    @FXML private TableColumn rentedTitelCollum;
    @FXML private TableColumn rentedStatusCollum;
    @FXML private TableColumn renterCollum;
    @FXML private TableColumn emailCollum;
    @FXML private TableColumn returnDateCollum;
    @FXML private TableColumn deadline;

    @FXML private TableView reservedMaterialView;
    @FXML private TableColumn tupeCollum;

    public void init(BrowseViewModel viewmodel)
    {
        this.viewHandler = viewHandler;
        this.viewmodel = viewmodel;

        initializeTables();
    }
    ObservableList<product> avaliableList() {
        ObservableList<product> products = FXCollections.observableArrayList();
        products.add(new product("dvd", "nej", "karl", "31"));
        return products;
    }

    public void initializeTables(){
        avaliableTitelCollum.setCellValueFactory(new PropertyValueFactory<product, String>("title"));
        avaliableTypeCollum.setCellValueFactory(new PropertyValueFactory<product, String>("title"));
        releaseDate.setCellValueFactory(new PropertyValueFactory<product, String>("title"));

        typeCollum.setCellValueFactory(new PropertyValueFactory<product, String>("title"));
        rentedTitelCollum.setCellValueFactory(new PropertyValueFactory<product, String>("title"));
        rentedStatusCollum.setCellValueFactory(new PropertyValueFactory<product, String>("title"));
        renterCollum.setCellValueFactory(new PropertyValueFactory<product, String>("title"));
        emailCollum.setCellValueFactory(new PropertyValueFactory<product, String>("title"));
        returnDateCollum.setCellValueFactory(new PropertyValueFactory<product, String>("title"));
        deadline.setCellValueFactory(new PropertyValueFactory<product, String>("title"));

        tupeCollum.setCellValueFactory(new PropertyValueFactory<product, String>("title"));

        availableMaterialView.setItems(avaliableList());
        rentetMaterialView.setItems(avaliableList());
        reservedMaterialView.setItems(avaliableList());
        System.out.println(avaliableList().size());
    }

    public void populate(){
        product test = new product("dvd", "test", "bente", "2");
    };

    public void removeAvaliable(){
        //take from all lists - rerun populate
    }

    public void removeRented(){

    }

    public void removeReserved(){

    }




}
