import javafx.application.Application;
import javafx.stage.Stage;
import springs.network.compilation.MyCompiler;
import springs.network.lambda.LambdaFunctions;
import springs.network.nodes.Nodes;
import springs.network.view.ViewTester;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{

        ViewTester.doPeopleStuff(stage);

        Stage stage2 = new Stage();
        ViewTester.doWebBrowserStuff(stage2);

        LambdaFunctions.test1();
        MyCompiler.test1();
        Nodes.test1();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
