package View.renterList;

import Core.ViewHandler;
import Model.renter;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class renterListController {


    public TableView Lånere;
    public TableColumn Name;
    public TableColumn Email;
    public TableColumn Status;


    private ViewHandler viewHandler;
    private RenterListViewModel renterListViewModel;

    public void init(RenterListViewModel renterListViewModel, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.renterListViewModel = renterListViewModel;

        renterListViewModel.loadRenter();
        Lånere.setItems(renterListViewModel.getLånerObservableList());
        Name.setCellValueFactory(new PropertyValueFactory<renter, String>("Name"));
        Email.setCellValueFactory(new PropertyValueFactory<renter, String>("Email"));
        Status.setCellValueFactory(new PropertyValueFactory<renter, String>("Status"));

    }

    public void next(ActionEvent actionEvent) {
        viewHandler.openBrowseItem();
    }
}
