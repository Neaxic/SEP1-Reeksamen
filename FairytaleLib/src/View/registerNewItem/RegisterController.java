package View.registerNewItem;

import Core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class RegisterController {


    private ViewHandler viewHandler;
    private RegisterViewmodel registerViewmodel;

    @FXML private TextField titleInput;
    @FXML private TextField authorInput;
    @FXML private TextField isbnInput;
    @FXML private DatePicker ReleaseDate;
    @FXML private ChoiceBox typeInput;

    public void init(RegisterViewmodel registerViewmodel,ViewHandler viewHandler) {
        this.registerViewmodel = registerViewmodel;
        this.viewHandler = viewHandler;
        registerViewmodel.loadProductsType();
        typeInput.setItems(registerViewmodel.getProductObservableList());
        titleInput.textProperty().bindBidirectional(registerViewmodel.titleProperty());
        authorInput.textProperty().bindBidirectional(registerViewmodel.authorProperty());
        isbnInput.textProperty().bindBidirectional(registerViewmodel.isbnProperty());
        ReleaseDate.valueProperty().bindBidirectional(registerViewmodel.releaseDateProperty());
        typeInput.valueProperty().bindBidirectional(registerViewmodel.typeProperty());
    }

    public void submit(){
        registerViewmodel.submit();
        Back();
    }

    public void Back() {
        viewHandler.openBrowseItem();
    }
}
