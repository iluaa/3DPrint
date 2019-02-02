package Customers;

import code.DBPrinting;
import code.Ent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class GetCustomer implements DBPrinting  {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1111";
    private static final String URL = "jdbc:mysql://localhost:3300/mysql?useSSL=false";
    private Connection connection = null;
    private static final String SELECT = "SELECT * from printing.customers";
    private static final String INSERT = "insert into printing.customers (name_customer, sname_customer, firm) values (?,?,?)";;
    private static final String DELETE = "delete from printing.customers where id_customer=?";
    private static final String UPDATE = "update printing.customers set name_customer=?, sname_customer=? where firm=?";

    @Override
    public void insertDB(Ent tbl) throws SQLException {
        CustomerEnt customer = new CustomerEnt();
        if (tbl instanceof CustomerEnt){
            System.out.println("Запись добавлена!!!");
            customer = (CustomerEnt) tbl;
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement prep = connection.prepareStatement(INSERT);
            prep.setString(1, customer.getName_customer());
            prep.setString(2, ""+customer.getSname_customer());
            prep.setString(3, ""+customer.getFirm());
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
        CustomerEnt customer = new CustomerEnt();
        if (tbl instanceof CustomerEnt){
            System.out.println("Запись удалена!!!");
            customer = (CustomerEnt) tbl;
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement prep = connection.prepareStatement(DELETE);
            prep.setInt(1, customer.getID_customer());
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
        CustomerEnt customer = new CustomerEnt();
        if (tbl instanceof CustomerEnt){
            System.out.println("Запись изменена!!!");
            customer = (CustomerEnt) tbl;
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement prep = connection.prepareStatement(UPDATE);
            prep.setString(1, customer.getName_customer());
            prep.setString(2, ""+customer.getSname_customer());
            prep.setString(3, ""+customer.getFirm());
            prep.executeUpdate();
        } catch (SQLException e) {
            System.err.println("message:" + e.getMessage());
        }finally {
            if (connection != null){
                connection.close();
            }
        }
    }
    public ObservableList<CustomerEnt> findCustomer() throws SQLException {
        ObservableList<CustomerEnt> list = FXCollections.observableArrayList();
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement customer = connection.prepareStatement(SELECT);
            ResultSet resultSet = customer.executeQuery();
            while (resultSet.next()) {
                list.add(fillCustomer(resultSet));
            }
            resultSet.close();
        } catch (Exception e) {
            System.err.println("Плохо все" + e.getMessage());
        }
        return list;
    }

    private CustomerEnt fillCustomer(ResultSet rs) throws SQLException {
        CustomerEnt customer = new CustomerEnt();
        customer.setID_customer(rs.getInt("id_customer"));
        customer.setName_customer(rs.getString("name_customer"));
        customer.setSname_customer(rs.getString("sname_customer"));
        customer.setFirm(rs.getString("firm"));
        return customer;
    }
}
