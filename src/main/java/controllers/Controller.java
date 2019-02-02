package controllers;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    /*public void showTables (ActionEvent actionEvent){
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/showTables.fxml"));
            stage.setTitle("Редактирование данных");
            stage.setMinWidth(600);
            stage.setMinHeight(500);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void exitApp(javafx.event.ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            stage.close();
        }catch (Exception e){
            System.out.println("Все плохо" + e.getMessage());
        }

    }*/

    public void showTables(javafx.event.ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("showTables.fxml"));
            stage.setTitle("Редактирование данных");
            stage.setMinWidth(750);
            stage.setMinHeight(500);
            stage.getIcons().add(new Image("logo.png"));
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showReport(javafx.event.ActionEvent actionEvent) {
        try{
            Stage stage = new Stage();
            Parent panel = FXMLLoader.load(getClass().getClassLoader().getResource("reports.fxml"));
            stage.setTitle("Отчеты");
            stage.setResizable(false);
            stage.getIcons().add(new Image("logo.png"));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(panel));
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }catch (Exception e){
            System.err.println("Все плохо");
        }
    }

    public void showQuery(javafx.event.ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            Parent panel = FXMLLoader.load(getClass().getClassLoader().getResource("complexQuery.fxml"));
            stage.setTitle("Запросы");
            stage.setMinWidth(920);
            stage.setMinHeight(430);
            stage.setResizable(false);
            stage.getIcons().add(new Image("logo.png"));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(panel, 920, 430));
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();
        } catch (Exception e) {
            System.err.println("Все плохо");
        }
    }

}
