
import Core.ModelFactory;
import Core.ViewHandler;
import Core.ViewModelFactory;
import Model.Client;
import Model.ClientModel;
import Model.product;
import Model.productList;
import Util.FileHandler;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.ArrayList;

public class main extends Application{
    @Override public void start(Stage stage) throws Exception
    {
        productList test = new productList();
        test.addProduct("2", "test", "idk", "24", "13-02-2000");

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                System.out.println("test");
                try {
                    FileHandler.saveProductList(test);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
        });

        ModelFactory modelFactory = new ModelFactory();
        ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);

        ViewHandler view = new ViewHandler(viewModelFactory);
        view.start();
    }
}
