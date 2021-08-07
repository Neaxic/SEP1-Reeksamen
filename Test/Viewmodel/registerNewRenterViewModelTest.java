package Viewmodel;

import Core.ModelFactory;
import Model.Client;
import Model.ClientModel;
import View.registerNewItem.RegisterViewmodel;
import View.registerNewRenter.registerNewRenterViewModel;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class registerNewRenterViewModelTest {

    private StringProperty Name;
    private StringProperty eMail;
    private StringProperty status;
    private StringProperty error;
    private ModelFactory modelFactory;
    private registerNewRenterViewModel registerNewRenterViewModel;


    @BeforeEach
    public void setUp(){
        Client client = new ClientModel();
        registerNewRenterViewModel = new registerNewRenterViewModel(client);
        Name = new SimpleStringProperty();
        eMail = new SimpleStringProperty();
        status = new SimpleStringProperty();
        error = new SimpleStringProperty();
        Name.bindBidirectional(registerNewRenterViewModel.nameProperty());
        eMail.bindBidirectional(registerNewRenterViewModel.eMailProperty());
        status.bindBidirectional(registerNewRenterViewModel.statusProperty());
        error.bind(registerNewRenterViewModel.errorProperty());
        registerNewRenterViewModel.loadRenterStatus();

    }



    @Test
    public void testWhatHappensIfValueISEmpty(){

        Name.setValue("");
        eMail.setValue("");
        status.setValue("");

        registerNewRenterViewModel.validInputs();

        assertEquals("fields cannot be null",error.getValue());

    }



    @Test
    public void testWhatHappensIfOneValueISEmpty(){

        Name.setValue("Test");
        eMail.setValue("Test@gmail.com");
        status.setValue("");

        registerNewRenterViewModel.validInputs();

        assertEquals("fields cannot be null",error.getValue());

    }


    @Test
    public void testWhatHappensIfValueIsCorrect(){

        Name.setValue("Test");
        eMail.setValue("Test@gmail.com");
        status.setValue("student");

        registerNewRenterViewModel.validInputs();

        assertEquals("Renter has been Added",error.getValue());

    }




}