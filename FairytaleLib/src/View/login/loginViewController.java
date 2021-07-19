package View.login;

import Core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class loginViewController {


    @FXML public Label error;
    @FXML public PasswordField kode;
    @FXML public TextField navn;
     private ViewHandler viewHandler;
     private LoginViewModel loginViewModel;

    public void init(LoginViewModel loginViewModel, ViewHandler viewHandler) {
        this.loginViewModel = loginViewModel;
        this.viewHandler = viewHandler;
        navn.textProperty().bindBidirectional(loginViewModel.navnProperty());
        kode.textProperty().bindBidirectional(loginViewModel.kodeProperty());
        error.textProperty().bindBidirectional(loginViewModel.errorProperty());

    }




    public void onLogButton(ActionEvent actionEvent) {
        if (  loginViewModel.login()){

            viewHandler.openBrowseItem();
        }


    }


}
