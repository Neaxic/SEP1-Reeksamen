package View.opretLogin;

import Core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class opretLoginViewController {

    public TextField CreateUser;
    public PasswordField CreatePassword;
    public Label Error;
    private ViewHandler viewHandler;
    private opretLoginViewModel opretLoginViewModel;

    public void init(opretLoginViewModel opretLoginViewModel, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.opretLoginViewModel = opretLoginViewModel;
    }

    public void onCreateLogin(ActionEvent actionEvent) {
        viewHandler.openLogin();
    }

    public void onCancel(ActionEvent actionEvent) {
        viewHandler.openLogin();
    }
}
