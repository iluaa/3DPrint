package Delivery;

import Delivery.DeliveryEnt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import printing.Delivery;

public class addDeliveryContr {

    private DeliveryEnt delivery = new DeliveryEnt();

    @FXML
    public TextField txtNameDelivery;
    @FXML
    public TextField txtCostDelivery;

    public void actionCloseD(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }


    public void actionOKD(ActionEvent actionEvent) {
        if(txtNameDelivery.getText()==null || (txtNameDelivery.getText().trim()).length()==0 &&
                txtCostDelivery.getText()==null || (txtCostDelivery.getText().trim()).length()==0 ){
            return;
        }
        delivery.setName_delivery(txtNameDelivery.getText());
        delivery.setCost_delivery(txtCostDelivery.getText());
        actionCloseD(actionEvent);
        GetDelivery c = new GetDelivery();
        try {
            if (delivery.getId_delivery() == 0) {
                c.insertDB(delivery);
            } else {
                c.UpdateDB(delivery);
            }

        } catch (Exception e) {
            System.out.println("Плохо все:" + e.getMessage());
        }
    }
    public void setDelivery (DeliveryEnt delivery){
        this.delivery = delivery;
        txtNameDelivery.setText(delivery.getName_delivery());
        txtCostDelivery.setText(""+delivery.getCost_delivery());
    }


}
