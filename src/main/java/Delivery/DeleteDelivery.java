package Delivery;

;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class DeleteDelivery {
    private DeliveryEnt delivery = new DeliveryEnt();

    public void yesDelete(ActionEvent actionEvent) {
        GetDelivery g = new GetDelivery();
        try {
            g.deleteDB(delivery);
        } catch (Exception e) {
            System.out.println("Плохо все:" + e.getMessage());
        }
        noDelete(actionEvent);
    }

    public void noDelete(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            stage.close();
        }catch (Exception e){
            System.err.println("Плохо все:"+e.getMessage());
        }
    }
    public void deDelivery (DeliveryEnt delivery){

        if(delivery.getId_delivery()!=0){
            this.delivery = delivery;
        }
    }
}
