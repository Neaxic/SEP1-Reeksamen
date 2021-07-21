package View.login;

import Core.ModelFactory;
import Model.Client;
import Model.ClientModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginViewModelTest {


    private StringProperty name;
    private StringProperty password;
    private StringProperty error;
    private LoginViewModel loginViewModel;


    @BeforeEach
    public void setUp(){
        Client client = new ClientModel();
        loginViewModel = new LoginViewModel(client);
        name = new SimpleStringProperty();
        password = new SimpleStringProperty();
        error = new SimpleStringProperty();
        name.bindBidirectional(loginViewModel.navnProperty());
        password.bindBidirectional(loginViewModel.kodeProperty());
        error.bind(loginViewModel.errorProperty());

    }

    @Test
    public void TestLoginWithNullValues(){

        name.setValue("");
        password.setValue("");

        loginViewModel.login();

        assertEquals("ERROR field is empty",error.getValue());



    }


    @Test
    public void TestLoginWithInvalidValues(){
        name.setValue("test");
        password.setValue("test");

        loginViewModel.login();

        assertEquals("ERROR, Either username or password is wrong",error.getValue());


    }




    @Test
    public void TestLoginWithvalidValues(){
        name.setValue("bob");
        password.setValue("123");

        loginViewModel.login();

        assertEquals("",error.getValue());


    }






}