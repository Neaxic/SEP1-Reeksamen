package View.registerNewItem;

import Core.ViewHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;

public class RegisterController {


    private ViewHandler viewHandler;
    private RegisterViewmodel registerViewmodel;

    //product
    @FXML private TextField titleInput;
    @FXML private TextField authorInput;
    @FXML private TextField isbnInput;
    @FXML private ChoiceBox typeInput;
    @FXML private DatePicker ReleaseDate;

    //errorLabel
    @FXML private Label error;


    public void init(RegisterViewmodel registerViewmodel,ViewHandler viewHandler) {
        this.registerViewmodel = registerViewmodel;
        this.viewHandler = viewHandler;

        registerViewmodel.loadProductsType();

        //product
        typeInput.setItems(registerViewmodel.getProductObservableList());
        titleInput.textProperty().bindBidirectional(registerViewmodel.titleProperty());
        authorInput.textProperty().bindBidirectional(registerViewmodel.authorProperty());
        isbnInput.textProperty().bindBidirectional(registerViewmodel.isbnProperty());
        ReleaseDate.valueProperty().bindBidirectional(registerViewmodel.releaseDateProperty());
        typeInput.valueProperty().bindBidirectional(registerViewmodel.typeProperty());

        //errorLabel
        error.textProperty().bind(registerViewmodel.errorProperty());

    }

    //Skifte view knapper
    public void submit(){
        if (registerViewmodel.validInputs()) {
            registerViewmodel.submit();
        }

    }

    public void Back() {
        viewHandler.openBrowseItem();
        registerViewmodel.clearErrorLabel();
    }
}
