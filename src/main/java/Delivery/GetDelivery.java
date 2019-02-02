package Delivery;

import Delivery.DeliveryEnt;
import code.DBPrinting;
import code.Ent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class GetDelivery implements DBPrinting  {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1111";
    private static final String URL = "jdbc:mysql://localhost:3300/mysql?useSSL=false";
    private Connection connection = null;
    private static final String SELECT = "SELECT * from printing.delivery";
    private static final String INSERT = "insert into printing.delivery (name_delivery, cost_delivery) values (?,?)";;
    private static final String DELETE = "delete from printing.delivery where id_delivery=?";
    private static final String UPDATE = "update printing.delivery set name_delivery=?, cost_delivery=? where id_delivery=?";

    @Override
    public void insertDB(Ent tbl) throws SQLException {
        DeliveryEnt delivery = new DeliveryEnt();
        if (tbl instanceof DeliveryEnt){
            System.out.println("Запись добавлена!!!");
            delivery = (DeliveryEnt) tbl;
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement prep = connection.prepareStatement(INSERT);
            prep.setString(1, delivery.getName_delivery());
            prep.setString(2, ""+delivery.getCost_delivery());
            prep.executeUpdate();
        } catch (SQLException e) {
            System.err.println("message:" + e.getMessage());
        }finally {
            if (connection != null){
                connection.close();
            }
        }
    }

    @Override
    public void deleteDB(Ent tbl) throws SQLException {
        DeliveryEnt delivery = new DeliveryEnt();
        if (tbl instanceof DeliveryEnt){
            System.out.println("Запись удалена!!!");
            delivery = (DeliveryEnt) tbl;
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement prep = connection.prepareStatement(DELETE);
            prep.setInt(1, delivery.getId_delivery());
            prep.executeUpdate();
        } catch (SQLException e) {
            System.err.println("message:" + e.getMessage());
        }finally {
            if (connection != null){
                connection.close();
            }
        }
    }

    @Override
    public void UpdateDB(Ent tbl) throws SQLException {
        DeliveryEnt delivery = new DeliveryEnt();
        if (tbl instanceof DeliveryEnt){
            System.out.println("Запись изменена!!!");
            delivery = (DeliveryEnt) tbl;
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement prep = connection.prepareStatement(UPDATE);
            prep.setString(1, delivery.getName_delivery());
            prep.setString(2, ""+delivery.getCost_delivery());
            prep.setInt(3, delivery.getId_delivery());
            prep.executeUpdate();
        } catch (SQLException e) {
            System.err.println("message:" + e.getMessage());
        }finally {
            if (connection != null){
                connection.close();
            }
        }
    }
    public ObservableList<DeliveryEnt> findDelivery() throws SQLException {
        ObservableList<DeliveryEnt> list = FXCollections.observableArrayList();
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement delivery = connection.prepareStatement(SELECT);
            ResultSet resultSet = delivery.executeQuery();
            while (resultSet.next()) {
                list.add(fillDelivery(resultSet));
            }
            resultSet.close();
        } catch (Exception e) {
            System.err.println("Плохо все" + e.getMessage());
        }
        return list;
    }

    private DeliveryEnt fillDelivery(ResultSet rs) throws SQLException {
        DeliveryEnt delivery = new DeliveryEnt();
        delivery.setId_delivery(rs.getInt("id_delivery"));
        delivery.setName_delivery(rs.getString("name_delivery"));
        delivery.setCost_delivery(rs.getString("cost_delivery"));
        return delivery;
    }
}
