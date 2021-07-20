package View.browseItems;

import Core.ViewHandler;
import Model.ClientModel;
import Model.product;
import Model.renter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;


public class BrowseViewController {

    public TableColumn AuthorCoulmn;
    public TableColumn ISBNCoulmn;
    public TextField searchText;
    public Label clock;
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
    @FXML private TableColumn ReserverType;
    @FXML private TableColumn ReserverTitle;
    @FXML private TableColumn ReserverStatus;
    @FXML private TableColumn ReserverName;
    @FXML private TableColumn ReserverMail;

    public void init(BrowseViewModel viewmodel, ViewHandler viewHandler)
    {
        this.viewHandler = viewHandler;
        this.viewmodel = viewmodel;

        populate();

        //Avaliable
        availableMaterialView.setItems(viewmodel.getProductObservableList());
        avaliableTypeCollum.setCellValueFactory(new PropertyValueFactory<product, String>("productKind"));
        avaliableTitelCollum.setCellValueFactory(new PropertyValueFactory<product, String>("title"));

        AuthorCoulmn.setCellValueFactory(new PropertyValueFactory<product, String>("author"));
        ISBNCoulmn.setCellValueFactory(new PropertyValueFactory<product, String>("isbn"));
        releaseDate.setCellValueFactory(new PropertyValueFactory<product, String>("ReleaseDate"));

        //Rented table
        rentetMaterialView.setItems(viewmodel.getRentedObservableList());

        typeCollum.setCellValueFactory(new PropertyValueFactory<product, String>("productKind"));
        rentedTitelCollum.setCellValueFactory(new PropertyValueFactory<product, String>("title"));

        rentedStatusCollum.setCellValueFactory(new PropertyValueFactory<product, String>("RenterJobPostion"));
        renterCollum.setCellValueFactory(new PropertyValueFactory<product, String>("RenterName"));
        emailCollum.setCellValueFactory(new PropertyValueFactory<product, String>("RenterEmail"));

        //SidsteFrist
        deadline.setCellValueFactory(new PropertyValueFactory<product, String>("title"));
        returnDateCollum.setCellValueFactory(new PropertyValueFactory<product, String>("RenterReturnDate"));

        //Reserved
        reservedMaterialView.setItems(viewmodel.getReservedObservableList());
        ReserverType.setCellValueFactory(new PropertyValueFactory<product, String>("productKind"));
        ReserverTitle.setCellValueFactory(new PropertyValueFactory<product, String>("title"));

        ReserverStatus.setCellValueFactory(new PropertyValueFactory<product, String>("ReserverJobPostion"));
        ReserverName.setCellValueFactory(new PropertyValueFactory<product, String>("ReserverName"));
        ReserverMail.setCellValueFactory(new PropertyValueFactory<product, String>("ReserverEmail"));


        availableMaterialView.setEditable(true);
        avaliableTypeCollum.setCellFactory(TextFieldTableCell.forTableColumn());
        avaliableTitelCollum.setCellFactory(TextFieldTableCell.forTableColumn());
        AuthorCoulmn.setCellFactory(TextFieldTableCell.forTableColumn());
        ISBNCoulmn.setCellFactory(TextFieldTableCell.forTableColumn());
        releaseDate.setCellFactory(TextFieldTableCell.forTableColumn());

        searchText.textProperty().bindBidirectional(viewmodel.searchProperty());
        clock.textProperty().bind(viewmodel.clockProperty());
        viewmodel.startClock();
    }

    //lavede en populate for at adskille logik + et call fra viewhandler til at refresh items
    public void populate(){
        viewmodel.loadProducts();
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

    //RESERVE TODO:MAYBE RENAME en msule forvirrende
    public void OpenListOfUser(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        product selectedProduct = (product) availableMaterialView.getSelectionModel().getSelectedItem();
        //Åbner i viewhandler eftersom vi laver et nyt vindue popup
        viewHandler.openListOfUsers((ClientModel) viewmodel.getClient(), selectedProduct);
    }

    public void removeReserver(ActionEvent actionEvent) {
        viewmodel.deleteReserver((product) reservedMaterialView.getSelectionModel().getSelectedItem());
    }

    public void removeRenter(ActionEvent actionEvent) {
        viewmodel.deleteRenter((product) rentetMaterialView.getSelectionModel().getSelectedItem());

    }

    public void reserveButton(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        product selectedProduct = (product) availableMaterialView.getSelectionModel().getSelectedItem();
        viewHandler.reserve((ClientModel) viewmodel.getClient(), selectedProduct);
    }
}
