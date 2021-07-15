package View.login;

import Core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class loginViewController {

    public Label error;
    public PasswordField kode;
    public TextField navn;
    private ViewHandler viewHandler;
    private LoginViewModel loginViewModel;

    public void init(LoginViewModel loginViewModel, ViewHandler viewHandler) {
        this.loginViewModel = loginViewModel;
        this.viewHandler = viewHandler;

    }


    public void OnSignIn(ActionEvent actionEvent) {
        viewHandler.openOpretLogin();
    }

    public void onLogButton(ActionEvent actionEvent) {
        viewHandler.openBrowseItem();
    }


}
