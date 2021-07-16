package View.opretLogin;

import Core.ViewHandler;
import Model.ClientModel;
import Util.FileHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class opretLoginViewController {


    @FXML public TextField CreateUser;
    @FXML public PasswordField CreatePassword;
    @FXML public Label Error;
    private ViewHandler viewHandler;
    private opretLoginViewModel opretLoginViewModel;

    public void init(opretLoginViewModel opretLoginViewModel, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.opretLoginViewModel = opretLoginViewModel;
        CreateUser.textProperty().bindBidirectional(opretLoginViewModel.createUserProperty());
        CreatePassword.textProperty().bindBidirectional(opretLoginViewModel.createPasswordProperty());
        Error.textProperty().bindBidirectional(opretLoginViewModel.errorProperty());

    }

    public void onCreateLogin(ActionEvent actionEvent) {
        if (opretLoginViewModel.createUser()){
            viewHandler.openLogin();

        }

    }

    public void onCancel(ActionEvent actionEvent) {
        viewHandler.openLogin();
    }
}
