package Customers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class addCustomerContr {
    private CustomerEnt customer = new CustomerEnt();

    @FXML
    public TextField txtNameCustomer;
    @FXML
    public TextField txtSnameCustomer;
    @FXML
    public TextField txtFirm;


    public void actionCloseC(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void actionCloseOP(ActionEvent actionEvent) {
    }

    public void actionOKC(ActionEvent actionEvent) {
        if(txtNameCustomer.getText()==null || (txtNameCustomer.getText().trim()).length()==0 &&
                txtSnameCustomer.getText()==null || (txtSnameCustomer.getText().trim()).length()==0 ){
            return;
        }
        customer.setName_customer(txtNameCustomer.getText());
        customer.setSname_customer(txtSnameCustomer.getText());
        customer.setFirm(txtFirm.getText());
        actionCloseC(actionEvent);
        GetCustomer c = new GetCustomer();
        try {
            //System.out.println(klass.getId_klass());
            if (customer.getID_customer() == 0) {
                c.insertDB(customer);
            } else {
                c.UpdateDB(customer);
            }

        } catch (Exception e) {
            System.out.println("Плохо все:" + e.getMessage());
        }
    }
    public void setCustomer (CustomerEnt customer){
        this.customer = customer;
        txtNameCustomer.setText(customer.getName_customer());
        txtSnameCustomer.setText(""+customer.getSname_customer());
        txtFirm.setText(""+customer.getFirm());
    }
}
