package View.login;

import Core.ViewHandler;
import javafx.event.ActionEvent;

public class loginViewController {

    private ViewHandler viewHandler;
    private LoginViewModel loginViewModel;

    public void init(LoginViewModel loginViewModel, ViewHandler viewHandler) {
        this.loginViewModel = loginViewModel;
        this.viewHandler = viewHandler;

    }


    public void OnSignIn(ActionEvent actionEvent) {

    }

    public void onLogButton(ActionEvent actionEvent) {
        viewHandler.openBrowseItem();
    }


}
