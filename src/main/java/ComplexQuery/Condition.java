package ComplexQuery;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Condition {
    public ListView<String> leftCond;
    public ListView<String> rightCond;
    public Label leftField;
    public Label rightField;

    public void setPrnt(Object prnt) {
        this.prnt = prnt;
    }

    private Object prnt;

    public void setLeftCond(ObservableList<String> lstFlds){
        leftCond.setItems(lstFlds);
    }
    public void setRightCond(ObservableList<String> lstFlds){
        rightCond.setItems(lstFlds);
    }

    public void addCondLeft(MouseEvent mouseEvent) {
        leftField.setText(leftCond.getSelectionModel().getSelectedItem());
    }

    public void addCondRight(MouseEvent mouseEvent) {
        rightField.setText(rightCond.getSelectionModel().getSelectedItem());
    }

    public void okCondition(ActionEvent actionEvent) {
        try {
            if ( prnt instanceof ComplexQueryController) {
                ((ComplexQueryController) prnt).addConnectCond(leftField.getText() + "=" + rightField.getText());
            }
            Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            stage.close();
        }catch (Exception e){
            System.err.println("Плохо все:"+e.getMessage());
        }
    }
}
