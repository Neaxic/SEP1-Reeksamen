package View.browseItems;

import Core.ViewHandler;
import Model.product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;


public class BrowseViewController {
    public TableColumn AuthorCoulmn;
    public TableColumn ISBNCoulmn;
    public TextField searchText;
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

        populate();
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


        availableMaterialView.setEditable(true);
        avaliableTypeCollum.setCellFactory(TextFieldTableCell.forTableColumn());
        avaliableTitelCollum.setCellFactory(TextFieldTableCell.forTableColumn());
        AuthorCoulmn.setCellFactory(TextFieldTableCell.forTableColumn());
        ISBNCoulmn.setCellFactory(TextFieldTableCell.forTableColumn());
        releaseDate.setCellFactory(TextFieldTableCell.forTableColumn());

        searchText.textProperty().bindBidirectional(viewmodel.searchProperty());
    }

    //lavede en populate for at adskille logik + et call fra viewhandler til at refresh items
    public void populate(){
        viewmodel.loadProducts();
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

    public void OpenregisterNewRenter(ActionEvent actionEvent){
        viewHandler.openregisterNewRenter();
    }

    public void remove(ActionEvent actionEvent) {

        viewmodel.delete((product) availableMaterialView.getSelectionModel().getSelectedItem());


    }

    public void search(ActionEvent actionEvent) {


        if (availableMaterialView.getItems().isEmpty()){

            viewHandler.openBrowseItem();
        }

        viewmodel.Search();
        viewmodel.clearSearch();

    }


    public void changeProductKindCellEdit(TableColumn.CellEditEvent editEvent){

        product product = (Model.product) availableMaterialView.getSelectionModel().getSelectedItem();
        product.setProductKind(editEvent.getNewValue().toString());
    }


    public void changeTitleCellEdit(TableColumn.CellEditEvent editEvent){

        product product = (Model.product) availableMaterialView.getSelectionModel().getSelectedItem();
        product.setTitle(editEvent.getNewValue().toString());
    }




    public void changeAuthorCellEdit(TableColumn.CellEditEvent editEvent){

        product product = (Model.product) availableMaterialView.getSelectionModel().getSelectedItem();
        product.setAuthor(editEvent.getNewValue().toString());
    }


    public void changeIsbnCellEdit(TableColumn.CellEditEvent editEvent){

        product product = (Model.product) availableMaterialView.getSelectionModel().getSelectedItem();
        product.setIsbn(editEvent.getNewValue().toString());
    }



    public void changeReleaseDateCellEdit(TableColumn.CellEditEvent editEvent){

        product product = (Model.product) availableMaterialView.getSelectionModel().getSelectedItem();
        product.setReleaseDate(editEvent.getNewValue().toString());
    }
}
