package printing;

import java.sql.*;
import java.util.Scanner;

public class Manufacturer extends Main {
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void manufacturerInsert () throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название нового производителя:");
        String nameManufacturer = sc.nextLine();
        System.out.println("Введите адресс нового производителя:");
        String addrManufacturer = sc.nextLine();
        System.out.println("Введите контакты нового производителя:");
        String contManufacturer = sc.nextLine();
        sc.close();
        preparedStatement = connection.prepareStatement("insert into printing.manufacturer (name_manufacturer, address, contacts) values (?,?,?)");
        preparedStatement.setString(1,nameManufacturer);
        preparedStatement.setString(2,addrManufacturer);
        preparedStatement.setString(2,contManufacturer);
        preparedStatement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void manufacturerDelete () throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID производителя, информацию о котором тебуется удалить:");
        String idManufacturer = sc.nextLine();
        sc.close();
        preparedStatement = connection.prepareStatement("delete from printing.manufacturer where id_manufacturer=?");
        preparedStatement.setString(1,idManufacturer);
        preparedStatement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void manufacturerUpdate () throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID производителя, информацию о которой нужно обновить:");
        String idManufacturer = sc.nextLine();
        System.out.println("Введите новое название произвожителя:");
        String nameManufacturer = sc.nextLine();
        System.out.println("Введите новый адресс производителя:");
        String addrManufacturer = sc.nextLine();
        System.out.println("Введите новые контакты:");
        String contManufacturer = sc.nextLine();
        sc.close();
        preparedStatement = connection.prepareStatement("update printing.manufacturer set name_manufacturer=?, address=?, contacts=?, where id_manufacturer=?");
        preparedStatement.setString(1,nameManufacturer);
        preparedStatement.setString(2,addrManufacturer);
        preparedStatement.setString(3,contManufacturer);
        preparedStatement.setString(4,idManufacturer);
        preparedStatement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void manufacturerSelect () throws SQLException{
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();

        preparedStatement = connection
                .prepareStatement("SELECT * from printing.manufacturer");
        resultSet = preparedStatement.executeQuery();
        writeResultSetManufac(resultSet);
        statement.close();
        connection.close();
    }

    private void writeResultSetManufac(ResultSet resultSet) throws SQLException {

        System.out.println("Название производителя: " + "Аддрес  " + "Контакты ");

        while (resultSet.next()) {

            String nameManufac = resultSet.getString("name_manufacturer");

            String addrManufac = resultSet.getString("address");

            String contManufac = resultSet.getString("contacts");

            System.out.println(nameManufac + "  " + addrManufac + "  " + contManufac);

        }

    }
}
