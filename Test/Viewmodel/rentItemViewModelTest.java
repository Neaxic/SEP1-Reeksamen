package Viewmodel;

import Core.ModelFactory;
import Model.Client;
import Model.ClientModel;
import Model.Renters;
import View.browseItems.BrowseViewModel;
import View.rentItem.rentItemViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class rentItemViewModelTest {


    private StringProperty error;
    private ModelFactory modelFactory;
    private rentItemViewModel rentItemViewModel;


    @BeforeEach
    public void setUp(){
        Client client = new ClientModel();
        rentItemViewModel = new rentItemViewModel(client);
        error = new SimpleStringProperty();
        error.bind(rentItemViewModel.errorProperty());

    }


    @Test
    public void testIfTheIsNoBorrower(){
        Renters renters = null;
        rentItemViewModel.getRenterInformation(renters);

        assertEquals("Please choose a renter for continue",error.getValue());



    }



    @Test
    public void testIfTheIsBorrower(){

        Renters renters = new Renters("test","test","test");
        rentItemViewModel.getRenterInformation(renters);

        assertEquals(null,error.getValue());


    }

}