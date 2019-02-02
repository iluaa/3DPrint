package printing;

import java.sql.*;
import java.util.Scanner;

public class OrdProduct extends Main {
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void ordProdInsert () throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID заказа, в который добавляется продукт:");
        String idOrd = sc.nextLine();
        System.out.println("Введите ID продукта, добавленного в заказ:");
        String idProd = sc.nextLine();
        System.out.println("Введите количество добавляемого продукта:");
        String amount = sc.nextLine();
        System.out.println("Введите цену заказа:");
        String priceOrder = sc.nextLine();
        sc.close();

        preparedStatement = connection.prepareStatement("insert into printing.ord_product (id_product, id_order, amount, price_order) " +
                "values (?,?,?,?)");
        preparedStatement.setString(1, idProd);
        preparedStatement.setString(2, idOrd);
        preparedStatement.setString(3, amount);
        preparedStatement.setString(4, priceOrder);
        preparedStatement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void ordProdDelete () throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID заказа, который тебуется удалить:");
        String idOrder = sc.nextLine();
        sc.close();
        preparedStatement = connection.prepareStatement("delete from printing.ord_product where id_order=?");
        preparedStatement.setString(1,idOrder );
        preparedStatement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void ordProdUpdate () throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID продукта, количество которого требуется обновить:");
        String idProduct = sc.nextLine();
        System.out.println("Введите количество нового продукта:");
        String amount = sc.nextLine();
        System.out.println("Введите обновлённую цену заказа:");
        String priceOrder = sc.nextLine();
        sc.close();
        preparedStatement = connection.prepareStatement("update printing.ord_product set amount=?, price_order=? where id_product=?");
        preparedStatement.setString(1,amount);
        preparedStatement.setString(2,priceOrder);
        preparedStatement.setString(3,idProduct);
        preparedStatement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void ordProdSelect () throws SQLException{
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();

        preparedStatement = connection
                .prepareStatement("SELECT * from printing.ord_product");
        resultSet = preparedStatement.executeQuery();
        writeResultSetOrd(resultSet);
        statement.close();
        connection.close();
    }

    private void writeResultSetOrd(ResultSet resultSet) throws SQLException {

        System.out.println("ID продукта:  " + "Количество:     " + "Цена заказа:");

        while (resultSet.next()) {

            String idProduct = resultSet.getString("id_product");

            String amount = resultSet.getString("amount");

            String priceOrder = resultSet.getString("price_order");

            //System.out.println("Название: " + "Тип: " + "Цена: ");

            System.out.println(idProduct + "              " + amount + "       " + priceOrder);

        }

    }
}
