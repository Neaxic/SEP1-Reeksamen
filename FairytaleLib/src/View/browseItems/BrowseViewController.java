package View.browseItems;

import Core.ViewHandler;
import Model.product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.Instant;
import java.util.Date;


public class BrowseViewController {
    public TableColumn AuthorCoulmn;
    public TableColumn ISBNCoulmn;
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

    public void init(BrowseViewModel viewmodel, ViewHandler viewHandler)
    {
        this.viewHandler = viewHandler;
        this.viewmodel = viewmodel;
        viewmodel.loadProducts();
        avaliableTypeCollum.setCellValueFactory(new PropertyValueFactory<product, String>("productKind"));
        avaliableTitelCollum.setCellValueFactory(new PropertyValueFactory<product, String>("title"));

        AuthorCoulmn.setCellValueFactory(new PropertyValueFactory<product, String>("author"));
        ISBNCoulmn.setCellValueFactory(new PropertyValueFactory<product, String>("isbn"));
        releaseDate.setCellValueFactory(new PropertyValueFactory<product, String>("ReleaseDate"));

    /*    typeCollum.setCellValueFactory(new PropertyValueFactory<product, String>("title"));
        rentedTitelCollum.setCellValueFactory(new PropertyValueFactory<product, String>("title"));
        rentedStatusCollum.setCellValueFactory(new PropertyValueFactory<product, String>("title"));
        renterCollum.setCellValueFactory(new PropertyValueFactory<product, String>("title"));
        emailCollum.setCellValueFactory(new PropertyValueFactory<product, String>("title"));
        returnDateCollum.setCellValueFactory(new PropertyValueFactory<product, String>("title"));
        deadline.setCellValueFactory(new PropertyValueFactory<product, String>("title"));

        tupeCollum.setCellValueFactory(new PropertyValueFactory<product, String>("title"));*/

        availableMaterialView.setItems(viewmodel.getProductObservableList());
        rentetMaterialView.setItems(viewmodel.getProductObservableList());
        reservedMaterialView.setItems(viewmodel.getProductObservableList());

    }


    public void removeAvaliable(){
        //take from all lists - rerun populate
    }

    public void removeRented(){

    }

    public void removeReserved(){

    }

    public void OpenRegisterItems(ActionEvent actionEvent) {
        viewHandler.openRegisterNewItems();

    }
}
