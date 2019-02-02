package printing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Product extends Main {
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void productInsert () throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите тип продукта:");
        String typeProduct = sc.nextLine();
        System.out.println("Введите ID роизводителя:");
        String idManufac = sc.nextLine();
        System.out.println("Введите название продукта:");
        String nameProduct = sc.nextLine();
        System.out.println("Введите цену продукта:");
        String costProduct = sc.nextLine();
        sc.close();

        preparedStatement = connection.prepareStatement("insert into printing.product (type_product, manufacturer, name_product, cost_product) " +
            "values (?,?,?,?)");
        preparedStatement.setString(1, typeProduct);
        preparedStatement.setString(2, idManufac);
        preparedStatement.setString(3, nameProduct);
        preparedStatement.setString(4, costProduct);
        preparedStatement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void productDelete () throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID продукта, который тебуется удалить:");
        String idProduct = sc.nextLine();
        sc.close();
        preparedStatement = connection.prepareStatement("delete from printing.product where id_product=?");
        preparedStatement.setString(1,idProduct );
        preparedStatement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void productUpdate () throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID продукта, который тебуется обновить:");
        String idProduct = sc.nextLine();
        System.out.println("Введите обновлённую цену продукта:");
        String costProduct = sc.nextLine();
        sc.close();
        preparedStatement = connection.prepareStatement("update printing.product set cost_product=?, where id_product=?");
        preparedStatement.setString(1,costProduct);
        preparedStatement.setString(2,idProduct);
        preparedStatement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void productSelect () throws SQLException{
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();

        preparedStatement = connection
                .prepareStatement("SELECT * from printing.product");
        resultSet = preparedStatement.executeQuery();
        writeResultSetProd(resultSet);
        statement.close();
        connection.close();
    }

    private void writeResultSetProd(ResultSet resultSet) throws SQLException {

        System.out.println("Название: " + "Тип:     " + "Цена: ");

        while (resultSet.next()) {

            String namePr = resultSet.getString("name_product");

            String typePr = resultSet.getString("type_product");

            String costPr = resultSet.getString("cost_product");

            //System.out.println("Название: " + "Тип: " + "Цена: ");

            System.out.println(namePr + "  " + typePr + "  " + costPr);

        }

    }
}
