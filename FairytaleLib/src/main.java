import Core.ModelFactory;
import Core.ViewHandler;
import Core.ViewModelFactory;
import Model.*;
import Util.FileHandler;
import javafx.stage.Stage;
import javafx.application.Application;

import java.io.IOException;
import java.util.ArrayList;

public class main extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        ArrayList Database = FileHandler.loadEverything();
        ArrayList Produkter = new ArrayList();
        ArrayList Renters = new ArrayList();

        //Diskutabele lister
        ArrayList rentedProducts = new ArrayList();
        ArrayList reservedProducts = new ArrayList();

        for(Object i : Database){
            for(Object j : (ArrayList) i){
                if(j instanceof product){
                    Produkter.add(j);
                } else if(j instanceof RentedList){
                    if(((RentedList) j).getLåneDato() != null){
                        rentedProducts.add(j);
                    } else {
                        reservedProducts.add(j);
                    }
                } else if(j instanceof renter){
                    Renters.add(j);
                } else {
                    System.out.println("Invalid objekt");
                }
            }
        }

        ClientModel.setAllProducts(Produkter);
        ClientModel.setAllClients(Renters);
        ClientModel.setRentedLists(rentedProducts);
        ClientModel.setReservedList(reservedProducts);

        ModelFactory modelFactory = new ModelFactory();
        ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);

        ViewHandler view = new ViewHandler(viewModelFactory, stage);
        view.start();

        stage.setResizable(false);

        stage.setOnCloseRequest(e -> {
            System.out.println("GEMMER ELEMENTER I SYSTEMET");
            try {
                FileHandler.saveEverything(ClientModel.allProducts, ClientModel.reservedList, ClientModel.rentedLists, ClientModel.allClients);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            System.exit(0);
        });
    }
}
