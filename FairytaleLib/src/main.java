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

        ArrayList test = FileHandler.loadProductList();
        ClientModel.setAllProducts(test);

        ArrayList test2 = FileHandler.loadRenter();
        ClientModel.setAllClients(test2);

        ArrayList test3 = FileHandler.loadRenterList();
        ClientModel.setSss(test3);


        ArrayList test4 = FileHandler.loadReservedList();
        ClientModel.setGgg(test4);




        ModelFactory modelFactory = new ModelFactory();
        ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);

        ViewHandler view = new ViewHandler(viewModelFactory, stage);
        view.start();

        stage.setOnCloseRequest(e -> {
            System.out.println("GEMMER ELEMENTER I SYSTEMET");
            try {
                FileHandler.saveProductList(ClientModel.allProducts);
                FileHandler.saveRenter(ClientModel.allClients);
                FileHandler.saveRentedList(ClientModel.sss);
                FileHandler.saveReservedList(ClientModel.ggg);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            System.exit(0);
        });
    }
}
