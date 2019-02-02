package controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;

import Customers.addCustomerContr;
import Customers.CustomerEnt;
import Customers.DeleteCustomer;
import Customers.GetCustomer;
import Delivery.addDeliveryContr;
import Delivery.DeliveryEnt;
import Delivery.GetDelivery;
import Delivery.DeleteDelivery;
import Manufacturers.ManufacturerEnt;
import Manufacturers.addManufacContr;
import Manufacturers.GetManufacturer;
import Manufacturers.DeleteManufacturer;
import printing.Manufacturer;

public class ShowTablesController {
    //public TableColumn id_customerO;
    //private CustomerEnt customerEnt = new CustomerEnt();
    private GetCustomer customerEnt = new GetCustomer();
    private GetDelivery deliveryEnt = new GetDelivery();
    private GetManufacturer manufacturerEnt = new GetManufacturer();

    @FXML
    public TableView<CustomerEnt> customerTable;
    @FXML
    public TableColumn<CustomerEnt, String> id_customerG;
    @FXML
    public TableColumn<CustomerEnt, String> name_customer;
    @FXML
    public TableColumn<CustomerEnt, String> sname_customer;
    @FXML
    public TableColumn<CustomerEnt, String> firm;

    @FXML
    public TableView<DeliveryEnt> deliveryTable;
    @FXML
    public TableColumn<DeliveryEnt, String> id_delivery;
    @FXML
    public TableColumn<DeliveryEnt, String> name;
    @FXML
    public TableColumn<DeliveryEnt, String> cost;

    @FXML
    public TableView<ManufacturerEnt> manufacTable;
    @FXML
    public TableColumn<ManufacturerEnt, String> id_manufac;
    @FXML
    public TableColumn<ManufacturerEnt, String> name_manufac;
    @FXML
    public TableColumn<ManufacturerEnt, String> address;
    @FXML
    public TableColumn<ManufacturerEnt, String> contacts;

    public void initialize(){
        id_customerG.setCellValueFactory(new PropertyValueFactory<CustomerEnt, String>("id_customer"));
        name_customer.setCellValueFactory(new PropertyValueFactory<CustomerEnt, String>("name_customer"));
        sname_customer.setCellValueFactory(new PropertyValueFactory<CustomerEnt, String>("sname_customer"));
        firm.setCellValueFactory(new PropertyValueFactory<CustomerEnt, String>("firm"));

        id_delivery.setCellValueFactory(new PropertyValueFactory<DeliveryEnt, String>("id_delivery"));
        name.setCellValueFactory(new PropertyValueFactory<DeliveryEnt, String>("name_delivery"));
        cost.setCellValueFactory(new PropertyValueFactory<DeliveryEnt, String>("cost_delivery"));

        id_manufac.setCellValueFactory(new PropertyValueFactory<ManufacturerEnt, String>("id_manufacturer"));
        name_manufac.setCellValueFactory(new PropertyValueFactory<ManufacturerEnt, String>("name_manufacturer"));
        address.setCellValueFactory(new PropertyValueFactory<ManufacturerEnt, String>("address"));
        contacts.setCellValueFactory(new PropertyValueFactory<ManufacturerEnt, String>("contacts"));

        try {
            customerTable.setItems(customerEnt.findCustomer());
            deliveryTable.setItems(deliveryEnt.findDelivery());
            manufacTable.setItems(manufacturerEnt.findManufacturer());
        }catch (Exception e){
            System.err.println("Все плохо" + e.getMessage());
        }

    }

    public void addCustomerButt(ActionEvent actionEvent) {

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("addCustomer.fxml"));
            stage.setTitle("Добавить заказчика");
            stage.setMinWidth(100);
            stage.setMinHeight(200);
            stage.getIcons().add(new Image("logo.png"));
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void addDeliveryButt(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("addDelivery.fxml"));
            stage.setTitle("Добавить доставку");
            stage.setMinWidth(100);
            stage.setMinHeight(200);
            stage.getIcons().add(new Image("logo.png"));
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void addProductButt(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("addProduct.fxml"));
            stage.setTitle("Добавить товар");
            stage.setMinWidth(100);
            stage.setMinHeight(200);
            stage.setResizable(false);
            stage.getIcons().add(new Image("logo.png"));
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void addOrderButt(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("addOrder.fxml"));
            stage.setTitle("Добавить заказ");
            stage.setMinWidth(100);
            stage.setMinHeight(200);
            stage.getIcons().add(new Image("logo.png"));
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void addOrdProdButt(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("addOrdProd.fxml"));
            stage.setTitle("Добавить заказанный товар");
            stage.setMinWidth(100);
            stage.setMinHeight(200);
            stage.getIcons().add(new Image("logo.png"));
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void addManufacButt(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("addManufac.fxml"));
            stage.setTitle("Добавить производителя");
            stage.setMinWidth(100);
            stage.setMinHeight(200);
            stage.getIcons().add(new Image("logo.png"));
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void deleteCustomerButt(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();

            FXMLLoader ldr = new FXMLLoader (getClass().getClassLoader().getResource("deleteCustomer.fxml"));
            Parent panel = ldr.load();
            DeleteCustomer editController = ldr.getController();
            CustomerEnt customer = customerTable.getSelectionModel().getSelectedItem();
            editController.deCustomer(customer);

            stage.setTitle("Подтверждение");
            stage.setMinWidth(350);
            stage.setMinHeight(150);
            stage.getIcons().add(new Image("logo.png"));
            stage.setResizable(false);
            stage.setScene(new Scene(panel));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void updateCustomerButt(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();

            FXMLLoader ldr = new FXMLLoader (getClass().getClassLoader().getResource("addCustomer.fxml"));
            Parent panel = ldr.load();
            addCustomerContr editController = ldr.getController();
            CustomerEnt customer = customerTable.getSelectionModel().getSelectedItem();
            editController.setCustomer(customer);


            stage.setTitle("Изменить данные о заказчике");
            stage.setMinWidth(100);
            stage.setMinHeight(200);
            stage.getIcons().add(new Image("logo.png"));
            stage.setResizable(false);
            stage.setScene(new Scene(panel));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void updateDeliveryButt(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();

        FXMLLoader ldr = new FXMLLoader (getClass().getClassLoader().getResource("addDelivery.fxml"));
        Parent panel = ldr.load();
        addDeliveryContr editController = ldr.getController();
        DeliveryEnt delivery = deliveryTable.getSelectionModel().getSelectedItem();
        editController.setDelivery(delivery);


        stage.setTitle("Изменить данные о заказчике");
        stage.setMinWidth(100);
        stage.setMinHeight(200);
        stage.getIcons().add(new Image("logo.png"));
        stage.setResizable(false);
        stage.setScene(new Scene(panel));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
        stage.show();
    }

    public void deleteDeliveryButt(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();

        FXMLLoader ldr = new FXMLLoader (getClass().getClassLoader().getResource("deleteDelivery.fxml"));
        Parent panel = ldr.load();
        DeleteDelivery editController = ldr.getController();
        DeliveryEnt delivery = deliveryTable.getSelectionModel().getSelectedItem();
        editController.deDelivery(delivery);


        stage.setTitle("Подтверждение");
        stage.setMinWidth(350);
        stage.setMinHeight(150);
        stage.setResizable(false);
        stage.getIcons().add(new Image("logo.png"));
        stage.setScene(new Scene(panel));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
        stage.show();
    }



}
