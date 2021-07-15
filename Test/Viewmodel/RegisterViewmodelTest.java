package Viewmodel;

import Core.ModelFactory;
import Model.Client;
import Model.ClientModel;
import Model.product;
import View.registerNewItem.RegisterViewmodel;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterViewmodelTest {

    private StringProperty title;
    private StringProperty author;
    private StringProperty isbn;
    private StringProperty type;
    private Property releaseDate;
    private ObservableList<product> productObservableList;
    private StringProperty error;
    private ModelFactory modelFactory;
    private RegisterViewmodel registerViewmodel;


    @BeforeEach
    public void setUp(){
        Client client = new ClientModel();
        registerViewmodel = new RegisterViewmodel(client);
        title = new SimpleStringProperty();
        author = new SimpleStringProperty();
        isbn = new SimpleStringProperty();
        releaseDate = new SimpleObjectProperty();
        type = new SimpleStringProperty();
        error = new SimpleStringProperty();
        title.bindBidirectional(registerViewmodel.titleProperty());
        author.bindBidirectional(registerViewmodel.authorProperty());
        isbn.bindBidirectional(registerViewmodel.isbnProperty());
        releaseDate.bindBidirectional(registerViewmodel.releaseDateProperty());
        type.bindBidirectional(registerViewmodel.typeProperty());
        error.bind(registerViewmodel.errorProperty());

    }

    @Test
    public void testWhatHappensIfValueISNull(){

        title.setValue("fdsgfsdgs");
        author.setValue("fdsfds");
        isbn.setValue("fdsfsd");
        releaseDate.setValue("fdsfsdf");
        type.setValue(null);
        registerViewmodel.validInputs();

        assertEquals("fields cannot be null",error.getValue());

    }


    @Test
    public void TestWhatHappensIfValueIsMoreThen35Characters(){

        title.setValue("Testdsadsadafdsafdsfsdfsdfsfsfsfsfsfsfdsfdsfdsfsdfdsfdsfdsfdsfdsfsd");
        author.setValue("TEst");
        isbn.setValue("test");
        releaseDate.setValue("Test");
        type.setValue("Test");
        registerViewmodel.validInputs();


        assertEquals("title must contain less than 35 characters",error.getValue());


    }



    @Test
    public void testIfYouCanAddAnElementSuccessfully(){
        title.setValue("Test");
        author.setValue("TEst");
        isbn.setValue("test");
        releaseDate.setValue("Test");
        type.setValue("Test");
        registerViewmodel.validInputs();

        assertEquals(null,error.getValue());

    }


//    //  1 before boundary
//    @Test
//    public void testCreateUserWithLessThen3characters(){
//
//        username.setValue("Usw");
//        password.setValue("password1");
//
//        createUserViewModel.validateSignUp();
//
//        assertEquals("Username must contain more than 3 characters",label.get());
//    }*/








}