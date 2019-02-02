package ComplexQuery;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.sql.*;
import java.util.LinkedList;

public class TableQuery {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1111";
    private static final String URL = "jdbc:mysql://localhost:3300/printing?useSSL=false";
    @FXML
    public TableView<ObservableList<String>> complexTabel;
    private String queryStr;
    private ObservableList<String> fieldsInQuery;




    //создание запроса
    public void setQuery(ObservableList<String> complexQueryTabs, ObservableList<String> complexQueryFils, ObservableList<String> condition){
        fieldsInQuery = complexQueryFils;
        queryStr = "select ";
        for (String fld: complexQueryFils) {
            queryStr += fld + ", ";
        }

        queryStr = queryStr.substring(0, queryStr.length()-2) + " from ";
        for (String table: complexQueryTabs) {
            queryStr += table + ", ";
        }
        if (condition.size() == 0){
            queryStr = queryStr.substring(0, queryStr.length());
        }else {
            queryStr = queryStr.substring(0, queryStr.length()) + " where ";
            for (String cond : condition) {
                queryStr += cond + " and ";
            }
            queryStr = queryStr.substring(0, queryStr.length());
        }

        System.out.println(queryStr);
    }
    //выполнение запроса, вывод данных
    public ObservableList<String> findRes() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryStr);
            ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
            while(resultSet.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=resultSet.getMetaData().getColumnCount(); i++){
                    row.add(resultSet.getString(i));
                }
                System.out.println("Row [1] added "+row );
                data.add(row);
            }
            mkColumns(complexTabel, resultSet.getMetaData());
            complexTabel.setItems(data);
            resultSet.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return list;
    }
    //создание столбцов, заполнение их данными
    private void mkColumns(TableView complexTabel, ResultSetMetaData metaData) {
        complexTabel.getColumns().clear();
        LinkedList<String> columns = new LinkedList<>(fieldsInQuery);
        int i = 0;
        for (String col : columns) {
            TableColumn tableColumn = new TableColumn();
            tableColumn.setText(col);
            final int finalI = i;
            tableColumn.setCellValueFactory(
                    new Callback<TableColumn.CellDataFeatures<ObservableList,String>,
                            ObservableValue<String>>() {
                        public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList,
                                String> param) {
                            return new SimpleStringProperty(param.getValue().get(finalI).toString());
                        }
                    });
            complexTabel.getColumns().add(tableColumn);
            i += 1;
        }
        complexTabel.setEditable(true);
    }
}
