import Core.ModelFactory;
import Core.ViewHandler;
import Core.ViewModelFactory;
import Model.Client;
import Model.ClientModel;
import Model.product;
import Model.productList;
import Util.FileHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.application.Application;

import java.io.IOException;
import java.util.ArrayList;

public class main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        productList test = new productList();
        test.addProduct("2", "test", "idk", "24", "13-02-2000");

        stage.setOnCloseRequest(e -> {
            System.out.println("test");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you really want to close this applicetion?", ButtonType.YES, ButtonType.NO);
            //FileHandler.saveProductList(test);
            System.exit(0);
        });

        ModelFactory modelFactory = new ModelFactory();
        ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);


        ViewHandler view = new ViewHandler(viewModelFactory);
        view.start();

    }
}
