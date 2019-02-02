package printing;

import java.sql.*;
import java.util.Scanner;

public class Orders extends Main {
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void ordersInsert () throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID заказчика:");
        String customer = sc.nextLine();
        System.out.println("Введите дату заказа:");
        String date = sc.nextLine();
        System.out.println("Введите введите должность сотрудника:");
        String worker = sc.nextLine();
        System.out.println("Введите ID доставки:");
        String delivery = sc.nextLine();
        sc.close();

        preparedStatement = connection.prepareStatement("insert into printing.orders (customer, date_order, worker, delivery) " +
                "values (?,?,?,?)");
        preparedStatement.setString(1, customer);
        preparedStatement.setString(2, date);
        preparedStatement.setString(3, worker);
        preparedStatement.setString(4, delivery);
        preparedStatement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void ordersDelete () throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID заказа, который тебуется удалить:");
        String idOrder = sc.nextLine();
        sc.close();
        preparedStatement = connection.prepareStatement("delete from printing.orders where id_order=?");
        preparedStatement.setString(1,idOrder );
        preparedStatement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void ordersUpdate () throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID заказа, который тебуется обновить:");
        String idOrder = sc.nextLine();
        System.out.println("Введите должность нового работника:");
        String worker = sc.nextLine();
        System.out.println("Введите ID обновлённой доставки:");
        String delivery = sc.nextLine();
        sc.close();
        preparedStatement = connection.prepareStatement("update printing.orders set worker=?, delivery=? where id_order=?");
        preparedStatement.setString(1,worker);
        preparedStatement.setString(2,delivery);
        preparedStatement.setString(3,idOrder);
        preparedStatement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void ordersSelect () throws SQLException{
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();

        preparedStatement = connection
                .prepareStatement("SELECT * from printing.orders");
        resultSet = preparedStatement.executeQuery();
        writeResultSetOrd(resultSet);
        statement.close();
        connection.close();
    }

    private void writeResultSetOrd(ResultSet resultSet) throws SQLException {

        System.out.println("ID заказчика:  " + "Дата заказа:     " + "Должность работника:");

        while (resultSet.next()) {

            String customer = resultSet.getString("customer");

            String date = resultSet.getString("date_order");

            String worker = resultSet.getString("worker");

            //System.out.println("Название: " + "Тип: " + "Цена: ");

            System.out.println(customer + "              " + date + "       " + worker);

        }

    }

}
