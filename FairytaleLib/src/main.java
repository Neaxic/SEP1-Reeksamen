import Core.ModelFactory;
import Core.ViewHandler;
import Core.ViewModelFactory;
import Model.Client;
import Model.ClientModel;
import javafx.stage.Stage;
import javafx.application.Application;

public class main extends Application{
    @Override public void start(Stage stage) throws Exception
    {
        stage.setOnCloseRequest(e -> System.exit(0));

        ModelFactory modelFactory = new ModelFactory();
        ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);

        ViewHandler view = new ViewHandler(stage, viewModelFactory);
        //view.start(primaryStage);

    }
}
