package springs.network.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import java.io.IOException;

public class Widget {

    protected Pane Content;

    public Widget() {}

    protected void loadContent(String sourceFile) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(sourceFile));
        loader.setController(this);
        Content = loader.load();
    }

    public void addToParent(Pane parent) {
        parent.getChildren().add(Content);
    }

    public Pane getContent() {
        return Content;
    }

}
