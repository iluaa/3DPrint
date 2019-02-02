package Manufacturers;


import code.DBPrinting;
import code.Ent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import printing.Manufacturer;

import java.sql.*;

public class GetManufacturer implements DBPrinting {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1111";
    private static final String URL = "jdbc:mysql://localhost:3300/mysql?useSSL=false";
    private Connection connection = null;
    private static final String SELECT = "SELECT * from printing.manufacturer";
    private static final String INSERT = "insert into printing.manufacturer (name_manufacturer, address, contacts) values (?,?,?)";;
    private static final String DELETE = "delete from printing.manufacturer where id_manufacturer=?";
    private static final String UPDATE = "update printing.manufacturer set name_manufacturer=?, address=?, contacts=?, where id_manufacturer=?";

    @Override
    public void insertDB(Ent tbl) throws SQLException {
        ManufacturerEnt manufacturer = new ManufacturerEnt();
        if (tbl instanceof ManufacturerEnt){
            System.out.println("Запись добавлена!!!");
            manufacturer = (ManufacturerEnt) tbl;
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement prep = connection.prepareStatement(INSERT);
            prep.setString(1, manufacturer.getName_manufacturer());
            prep.setString(2, ""+manufacturer.getAddress());
            prep.setString(3, ""+manufacturer.getContacts());
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
        ManufacturerEnt manufacturer = new ManufacturerEnt();
        if (tbl instanceof ManufacturerEnt){
            System.out.println("Запись удалена!!!");
            manufacturer = (ManufacturerEnt) tbl;
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement prep = connection.prepareStatement(DELETE);
            prep.setInt(1, manufacturer.getId_manufacturer());
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
        ManufacturerEnt manufacturer = new ManufacturerEnt();
        if (tbl instanceof ManufacturerEnt){
            System.out.println("Запись изменена!!!");
            manufacturer = (ManufacturerEnt) tbl;
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement prep = connection.prepareStatement(UPDATE);
            prep.setString(1, manufacturer.getName_manufacturer());
            prep.setString(2, ""+manufacturer.getAddress());
            prep.setString(3, ""+manufacturer.getContacts());
            prep.setString(4, ""+manufacturer.getId_manufacturer());
            prep.executeUpdate();
        } catch (SQLException e) {
            System.err.println("message:" + e.getMessage());
        }finally {
            if (connection != null){
                connection.close();
            }
        }
    }
    public ObservableList<ManufacturerEnt> findManufacturer() throws SQLException {
        ObservableList<ManufacturerEnt> list = FXCollections.observableArrayList();
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement delivery = connection.prepareStatement(SELECT);
            ResultSet resultSet = delivery.executeQuery();
            while (resultSet.next()) {
                list.add(fillManufacturer(resultSet));
            }
            resultSet.close();
        } catch (Exception e) {
            System.err.println("Плохо все" + e.getMessage());
        }
        return list;
    }

    private ManufacturerEnt fillManufacturer(ResultSet rs) throws SQLException {
        ManufacturerEnt manufacturer = new ManufacturerEnt();
        manufacturer.setId_manufacturer(rs.getInt("id_manufacturer"));
        manufacturer.setName_manufacturer(rs.getString("name_manufacturer"));
        manufacturer.setAddress(rs.getString("address"));
        manufacturer.setContacts(rs.getString("contacts"));
        return manufacturer;
    }
}

