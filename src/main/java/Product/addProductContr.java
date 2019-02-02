package Product;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class addProductContr {
    public void actionCloseP(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
