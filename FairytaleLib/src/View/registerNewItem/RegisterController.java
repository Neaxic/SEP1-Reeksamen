package View.registerNewItem;

import Core.ViewHandler;
import javafx.event.ActionEvent;

public class RegisterController {

    private ViewHandler viewHandler;
    private RegisterViewmodel registerViewmodel;


    public void init(RegisterViewmodel registerViewmodel,ViewHandler viewHandler) {
        this.registerViewmodel = registerViewmodel;
        this.viewHandler = viewHandler;
    }


    public void Back(ActionEvent actionEvent) {
        viewHandler.openBrowseItem();
    }
}
