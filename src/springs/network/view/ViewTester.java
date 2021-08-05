package springs.network.view;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import springs.network.view.people.PersonWidget;

import java.io.IOException;
import java.net.URL;

public class ViewTester {

    public static void doPeopleStuff(Stage stage) throws Exception {

        stage.setTitle("People Stuff");

        PersonWidget james = new PersonWidget();
        james.FirstName.setText("James!");
        james.LastName.setText("Bonas");

        PersonWidget hannah = new PersonWidget();
        hannah.FirstName.setText("Hannah");
        hannah.LastName.setText("Rhodes");

        VBox root = new VBox();
        james.addToParent(root);
        hannah.addToParent(root);

        Scene scene = new Scene(root,600, 400);
        stage.setScene(scene);
        stage.show();

    }

    public static void doWebBrowserStuff(Stage stage) {
        ViewTester x = new ViewTester();
        x.showWebBrowser(stage);
    }

    public void showWebBrowser(Stage stage) {
        stage.setTitle("JavaFX WebView Example");
        WebView webView = new WebView();
        URL url = this.getClass().getResource("HelloWorld.html");
        webView.getEngine().load(url.toString()); //"http://www.google.com");
        VBox vBox = new VBox(webView);
        Scene scene = new Scene(vBox, 960, 600);
        stage.setScene(scene);
        stage.show();
    }

}
