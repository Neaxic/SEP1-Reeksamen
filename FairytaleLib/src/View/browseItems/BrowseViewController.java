package View.browseItems;

import Core.ViewHandler;
import Model.RentedList;
import Model.product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class BrowseViewController {

    //clock
    @FXML public Label clock;

    //search
    @FXML public Button search;
    @FXML public TextField searchText;

    //errorLabel
    @FXML public Label error;

    //productList
    @FXML private TableView<product> availableMaterialView;
    @FXML private TableColumn avaliableTypeCollum;
    @FXML private TableColumn avaliableTitelCollum;
    @FXML public TableColumn AuthorCoulmn;
    @FXML public TableColumn ISBNCoulmn;
    @FXML private TableColumn releaseDate;

    //rentedList
    @FXML private TableView rentedMaterialView;
    @FXML private TableColumn typeCollum;
    @FXML private TableColumn rentedTitelCollum;
    @FXML private TableColumn rentedStatusCollum;
    @FXML private TableColumn renterCollum;
    @FXML private TableColumn emailCollum;
    @FXML private TableColumn returnDateCollum;
    @FXML private TableColumn deadline;

    //reservedList
    @FXML private TableView reservedMaterialView;
    @FXML private TableColumn ReserverType;
    @FXML private TableColumn ReserverTitle;
    @FXML private TableColumn ReserverStatus;
    @FXML private TableColumn ReserverName;
    @FXML private TableColumn ReserverMail;

    private ViewHandler viewHandler;
    private BrowseViewModel viewmodel;

    public void init(BrowseViewModel viewmodel, ViewHandler viewHandler)
    {
        this.viewHandler = viewHandler;
        this.viewmodel = viewmodel;

        populate();
        viewmodel.loadRentedList();
        viewmodel.loadReservedList();

        //productList
        availableMaterialView.setItems(viewmodel.getProductObservableList());
        avaliableTypeCollum.setCellValueFactory(new PropertyValueFactory<product, String>("productKind"));
        avaliableTitelCollum.setCellValueFactory(new PropertyValueFactory<product, String>("title"));
        AuthorCoulmn.setCellValueFactory(new PropertyValueFactory<product, String>("author"));
        ISBNCoulmn.setCellValueFactory(new PropertyValueFactory<product, String>("isbn"));
        releaseDate.setCellValueFactory(new PropertyValueFactory<product, String>("ReleaseDate"));

        availableMaterialView.setEditable(true);
        avaliableTypeCollum.setCellFactory(TextFieldTableCell.forTableColumn());
        avaliableTitelCollum.setCellFactory(TextFieldTableCell.forTableColumn());
        AuthorCoulmn.setCellFactory(TextFieldTableCell.forTableColumn());
        ISBNCoulmn.setCellFactory(TextFieldTableCell.forTableColumn());
        releaseDate.setCellFactory(TextFieldTableCell.forTableColumn());

        //rentedList
        rentedMaterialView.setItems(viewmodel.getRentedObservableList());
        typeCollum.setCellValueFactory(new PropertyValueFactory<>("productKind"));
        rentedTitelCollum.setCellValueFactory(new PropertyValueFactory<>("Title"));
        rentedStatusCollum.setCellValueFactory(new PropertyValueFactory<>("Status"));
        renterCollum.setCellValueFactory(new PropertyValueFactory<>("Name"));
        emailCollum.setCellValueFactory(new PropertyValueFactory<>("Email"));
        deadline.setCellValueFactory(new PropertyValueFactory<>("LåneDato"));
        returnDateCollum.setCellValueFactory(new PropertyValueFactory<>("returDato"));

        //Reserved
        reservedMaterialView.setItems(viewmodel.getReservedObservableList());
        ReserverType.setCellValueFactory(new PropertyValueFactory("productKind"));
        ReserverTitle.setCellValueFactory(new PropertyValueFactory("Title"));
        ReserverStatus.setCellValueFactory(new PropertyValueFactory("Status"));
        ReserverName.setCellValueFactory(new PropertyValueFactory("Name"));
        ReserverMail.setCellValueFactory(new PropertyValueFactory("Email"));

        //search
        searchText.textProperty().bindBidirectional(viewmodel.searchProperty());
        search.setDisable(true);

        //clock
        clock.textProperty().bind(viewmodel.clockProperty());
        viewmodel.startClock();

        //error
        error.textProperty().bind(viewmodel.errorProperty());

    }
    //lavede en populate for at adskille logik + et call fra viewhandler til at refresh items


    //henter vores products
    public void populate(){
        viewmodel.loadProducts();
    }


    //delete
    public void remove(ActionEvent actionEvent) {
        if (viewmodel.deleteProductValidation(availableMaterialView.getSelectionModel().getSelectedItem()))

        viewmodel.delete((product) availableMaterialView.getSelectionModel().getSelectedItem());
    }

    public void removeReserver(ActionEvent actionEvent) {
        if (viewmodel.deleteRentedValidation((RentedList) reservedMaterialView.getSelectionModel().getSelectedItem())){

            viewmodel.deleteReserver((RentedList) reservedMaterialView.getSelectionModel().getSelectedItem());

        }
    }

    public void removeRenter(ActionEvent actionEvent) {
        if (viewmodel.deleteRentedValidation((RentedList) rentedMaterialView.getSelectionModel().getSelectedItem())){

            viewmodel.deleteRenter((RentedList) rentedMaterialView.getSelectionModel().getSelectedItem());

        }

    }


    //search
    public void onKeyReleasedSearch(){
       search.setDisable(false);

    }
    public void search(ActionEvent actionEvent) {

        if (viewmodel.SearchValidation()) {
            viewmodel.Search();
            viewmodel.clearSearch();
        }

        else{
            viewHandler.openBrowseItem();
        }
    }


    //edit
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

    }

    //bruges til at skifte view
    public void OpenRegisterItems(ActionEvent actionEvent) {
        viewHandler.openRegisterNewItems();

    }

    public void OpenregisterNewRenter(ActionEvent actionEvent){
        viewHandler.openregisterNewRenter();
    }


    public void reserveButton(ActionEvent actionEvent)  {
        if ( viewmodel.getProductInformation(availableMaterialView.getSelectionModel().getSelectedItem())) {
            viewHandler.openReserveItem();
        }
    }

    public void udlånButton(ActionEvent actionEvent) {

        if (viewmodel.getProductInformation(availableMaterialView.getSelectionModel().getSelectedItem())) {
            viewmodel.delete(availableMaterialView.getSelectionModel().getSelectedItem());
            viewHandler.openRentItem();
        }

    }
}
