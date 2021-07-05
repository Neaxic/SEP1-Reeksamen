import Core.ModelFactory;
import javafx.stage.Stage;
import javafx.application.Application;

public class main extends Application{
    @Override public void start(Stage stage) throws Exception
    {
        stage.setOnCloseRequest(e -> System.exit(0));

    }
}
