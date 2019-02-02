package printing;

import java.sql.*;
import java.util.Scanner;

public class Delivery extends Main {
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void deliveryInsert () throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название новой доставки:");
        String nameDelivery = sc.nextLine();
        System.out.println("Введите новой доставки:");
        String costDelivery = sc.nextLine();
        sc.close();
        preparedStatement = connection.prepareStatement("insert into printing.delivery (name_delivery, cost_delivery) " +
                "values (?,?)");
        preparedStatement.setString(1,nameDelivery);
        preparedStatement.setString(2,costDelivery);
        preparedStatement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void deliveryDelete () throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID доставки,которую тебуется удалить:");
        String idDelivery = sc.nextLine();
        sc.close();
        preparedStatement = connection.prepareStatement("delete from printing.delivery where id_delivery=?");
        preparedStatement.setString(1,idDelivery);
        preparedStatement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void deliveryUpdate () throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID доставки, информацию о которой нужно обновить:");
        String idDeliv = sc.nextLine();
        System.out.println("Введите новое название доставки:");
        String nameDeliv = sc.nextLine();
        System.out.println("Введите новую цену доставки:");
        String costDeliv = sc.nextLine();
        sc.close();
        preparedStatement = connection.prepareStatement("update printing.delivery set name_delivery=?, cost_delivery=?, where id_delivery=?");
        preparedStatement.setString(1,nameDeliv);
        preparedStatement.setString(2,costDeliv);
        preparedStatement.setString(3,idDeliv);
        preparedStatement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void deliverySelect () throws SQLException{
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();

        preparedStatement = connection
                .prepareStatement("SELECT * from printing.delivery");
        resultSet = preparedStatement.executeQuery();
        writeResultSetDeliv(resultSet);
        statement.close();
        connection.close();
    }

    private void writeResultSetDeliv(ResultSet resultSet) throws SQLException {

        System.out.println("Название доставки: " + "Цена  ");

        while (resultSet.next()) {

            String nameDeliv = resultSet.getString("name_delivery");

            String costDeliv = resultSet.getString("cost_delivery");

            System.out.println(nameDeliv + "  " + costDeliv);

        }

    }
}
