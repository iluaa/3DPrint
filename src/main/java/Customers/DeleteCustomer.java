package Customers;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class DeleteCustomer {
    private CustomerEnt customer = new CustomerEnt();

    public void yesDelete(ActionEvent actionEvent) {
        GetCustomer g = new GetCustomer();
        try {
            g.deleteDB(customer);
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
    public void deCustomer (CustomerEnt customer){

        if(customer.getID_customer()!=0){
            this.customer = customer;
        }
    }
}
