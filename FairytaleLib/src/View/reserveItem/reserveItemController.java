package View.reserveItem;

import Core.ViewHandler;
import Model.Renters;
import Model.renter;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class reserveItemController {

    public TableView<Renters> Lånere;
    public TableColumn Name;
    public TableColumn Email;
    public TableColumn Status;

    public Label error;

    private ViewHandler viewHandler;
    private reserveItemViewModel reserveItemViewModel;

    public void init(reserveItemViewModel reserveItemViewModel, ViewHandler viewHandler) {
        this.reserveItemViewModel = reserveItemViewModel;
        this.viewHandler = viewHandler;

        reserveItemViewModel.loadRenter();
        Lånere.setItems(reserveItemViewModel.getLånerObservableList());
        Name.setCellValueFactory(new PropertyValueFactory<renter, String>("Name"));
        Email.setCellValueFactory(new PropertyValueFactory<renter, String>("Email"));
        Status.setCellValueFactory(new PropertyValueFactory<renter, String>("Status"));

        //error
        error.textProperty().bind(reserveItemViewModel.errorProperty());

    }

    public void next(ActionEvent actionEvent) {

        if ( reserveItemViewModel.getRenterInformation(Lånere.getSelectionModel().getSelectedItem())) {
            reserveItemViewModel.CreateUdlåntGenstand();
            viewHandler.openBrowseItem();
        }

    }

}
