package View.registerNewItem;

import Core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class RegisterController {

    private ViewHandler viewHandler;
    private RegisterViewmodel registerViewmodel;

    @FXML private TextField titleInput;
    @FXML private TextField authorInput;
    @FXML private TextField isbnInput;
    @FXML private ChoiceBox typeInput;


    public void init(RegisterViewmodel registerViewmodel,ViewHandler viewHandler) {
        this.registerViewmodel = registerViewmodel;
        this.viewHandler = viewHandler;

        typeInput.getItems().add("Dvd");
    }

    public void submit(){
        registerViewmodel.submit(titleInput.getText(), authorInput.getText(), isbnInput.getText(), typeInput.getValue().toString());
        Back();
    }

    public void Back() {
        viewHandler.openBrowseItem();
    }
}
