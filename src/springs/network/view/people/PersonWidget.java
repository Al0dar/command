package springs.network.view.people;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import springs.network.view.Widget;

public class PersonWidget extends Widget {

    public TextField FirstName = null;
    public TextField LastName = null;

    public PersonWidget() throws Exception {
        loadContent("PersonWidget.fxml");
    }

    @FXML private void buttonClicked(Event e){
        FirstName.setText("Someone clicked my button! :)");
    }

}
