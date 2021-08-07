package Viewmodel;

import Core.ModelFactory;
import Model.Client;
import Model.ClientModel;
import Model.product;
import View.browseItems.BrowseViewModel;
import View.registerNewItem.RegisterViewmodel;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BrowseViewModelTest {


    private StringProperty error;
    private ModelFactory modelFactory;
    private BrowseViewModel browseViewModel;


    @BeforeEach
    public void setUp(){
        Client client = new ClientModel();
        browseViewModel = new BrowseViewModel(client);
        error = new SimpleStringProperty();
        error.bind(browseViewModel.errorProperty());

    }


    @Test
    public void testIfNoItemIsSelected(){
        product p = null;
        browseViewModel.getProductInformation(p);

        assertEquals("Vælg venligst et produkt for at fortsætte",error.getValue());


    }


    @Test
    public void testIfItemIsSelected(){
        product p = new product("test","test","test","test","test");
        browseViewModel.getProductInformation(p);

        assertEquals("",error.getValue());


    }













}