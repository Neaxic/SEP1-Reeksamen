package View.rentItem;

import Core.ViewHandler;
import Model.Renters;
import Model.renter;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.text.ParseException;

public class rentItemController {

    public TableView<Renters> Lånere;
    public TableColumn Name;
    public TableColumn Email;
    public TableColumn Status;
    public Label error;

    private ViewHandler viewHandler;
    private rentItemViewModel rentItemViewModel;

    public void init(rentItemViewModel rentItemViewModel, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.rentItemViewModel = rentItemViewModel;

        rentItemViewModel.loadRenter();
        Lånere.setItems(rentItemViewModel.getLånerObservableList());
        Name.setCellValueFactory(new PropertyValueFactory<renter, String>("Name"));
        Email.setCellValueFactory(new PropertyValueFactory<renter, String>("Email"));
        Status.setCellValueFactory(new PropertyValueFactory<renter, String>("Status"));

        //error
        error.textProperty().bind(rentItemViewModel.errorProperty());

    }

    public void next(ActionEvent actionEvent) throws ParseException {

        if ( rentItemViewModel.getRenterInformation(Lånere.getSelectionModel().getSelectedItem())) {
            rentItemViewModel.CreateUdlåntGenstand();
            viewHandler.openBrowseItem();
        }

    }
}


