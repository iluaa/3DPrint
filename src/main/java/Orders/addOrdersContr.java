package Orders;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class addOrdersContr {
    public void actionCloseO(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
