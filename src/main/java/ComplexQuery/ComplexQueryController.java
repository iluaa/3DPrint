package ComplexQuery;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.LinkedList;

public class ComplexQueryController {
    @FXML
    public ListView<String> complexQueryTabInit;
    @FXML
    public ListView<String> complexQueryTabRes;
    @FXML
    public ListView<String> complexQueryFilInit;
    @FXML
    public ListView<String> complexQueryFilRes;
    @FXML
    public ListView<String> connectCond;

    public void initialize(){
        try {
            LinkedList<String> tables =  ComplexQuery.getTables();
            ObservableList<String> oltab = FXCollections.observableArrayList();
            oltab.addAll(tables);
            complexQueryTabInit.setItems(oltab);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void GetTable4List(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
            String tab = complexQueryTabInit.getSelectionModel().getSelectedItem();

            complexQueryTabRes.getItems().add(tab);
            complexQueryTabInit.getItems().remove(tab);
        }
    }


    public void GetFields4List(MouseEvent mouseEvent) throws SQLException {

        String tab = complexQueryTabRes.getSelectionModel().getSelectedItem();

        if (mouseEvent.getClickCount() == 1) {
            //список полей
            LinkedList<String> fieldList;
            try {
                fieldList = ComplexQuery.getColumns(tab);
                ObservableList<String> olfld = FXCollections.observableArrayList();
                olfld.addAll(fieldList);
                complexQueryFilInit.setItems(olfld);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else if (mouseEvent.getClickCount() == 2 ){

            complexQueryTabInit.getItems().add(tab);
            complexQueryTabRes.getItems().remove(tab);
        }
    }

    public void SelectFieldList(MouseEvent mouseEvent) {
        if(mouseEvent.getClickCount() == 2){
            String field = complexQueryFilInit.getSelectionModel().getSelectedItem();
            complexQueryFilRes.getItems().add(field);
            complexQueryFilInit.getItems().remove(field);
        }
    }

    public void RemoveFieldList(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2 ){
            String field = complexQueryFilRes.getSelectionModel().getSelectedItem();
            complexQueryFilInit.getItems().add(field);
            complexQueryFilRes.getItems().remove(field);
        }
    }

    public void ComplexQueryTables(ActionEvent actionEvent) {
        try{
            FXMLLoader ldr = new FXMLLoader(getClass().getClassLoader().getResource("tableQuery.fxml"));
            Parent panel = ldr.load();
            TableQuery tableQuery = ldr.getController();

            tableQuery.setQuery(complexQueryTabRes.getItems(), complexQueryFilRes.getItems(), connectCond.getItems());

            Stage stage = new Stage();
            stage.setTitle("Запросы");
            stage.setMinWidth(600);
            stage.setMinHeight(400);
            //stage.getIcons().add(new Image("school.png"));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(panel,500,400));
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }catch (Exception e){
            System.err.println(e.getMessage() + "Все плохо");
        }
    }

    public void Сondition(ActionEvent actionEvent) {
        try{
            FXMLLoader ldr = new FXMLLoader(getClass().getClassLoader().getResource("condition.fxml"));
            Parent panel = ldr.load();
            Condition condController = ldr.getController();
            condController.setLeftCond(complexQueryFilRes.getItems());
            condController.setRightCond(complexQueryFilRes.getItems());
            condController.setPrnt(this);

            Stage stage = new Stage();
            stage.setTitle("Условие соединения");
            stage.setMinWidth(600);
            stage.setMinHeight(317);
            //stage.getIcons().add(new Image("school.png"));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(panel,500,317));
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }catch (Exception e){
            System.err.println("Все плохо");
        }
    }

    public void addConnectCond(String Itm) {
        connectCond.getItems().add(Itm);
    }

    public void DeleteCondition(MouseEvent mouseEvent) {
        String cond = connectCond.getSelectionModel().getSelectedItem();
        if (mouseEvent.getClickCount() == 2 ){
            connectCond.getItems().remove(cond);
        }

    }
}
