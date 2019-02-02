package printing;

import java.sql.*;
import java.util.Scanner;

public class Customers extends Main {
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

   public void customersInsert () throws SQLException {
       Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
       Statement statement = connection.createStatement();
       Scanner sc = new Scanner(System.in);
       System.out.println("Введите имя нового заказчика:");
       String nameCust = sc.nextLine();
       System.out.println("Введите фамилию нового заказчика:");
       String sNameCust = sc.nextLine();
       System.out.println("Введите фирму нового заказчика:");
       String firm = sc.nextLine();
       sc.close();
       preparedStatement = connection.prepareStatement("insert into printing.customers (name_customer, sname_customer, firm) " +
               "values (?,?,?)");
       preparedStatement.setString(1,nameCust);
       preparedStatement.setString(2,sNameCust);
       preparedStatement.setString(3,firm);
       preparedStatement.executeUpdate();
       statement.close();
       connection.close();
   }

    public void customersDelete () throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID клиента, информацию о котором тебуется удалить:");
        String idCustomer = sc.nextLine();
        sc.close();
        preparedStatement = connection.prepareStatement("delete from printing.customers where id_customer=?");
        preparedStatement.setString(1,idCustomer);
        preparedStatement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void customersUpdate () throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название фирмы, у которой изменился представитель:");
        String firm = sc.nextLine();
        System.out.println("Введите обновлённую цену продукта:");
        String nameCust = sc.nextLine();
        System.out.println("Введите обновлённую цену продукта:");
        String sNameCust = sc.nextLine();
        sc.close();
        preparedStatement = connection.prepareStatement("update printing.customers set name_customer=?, sname_customer=?, where firm=?");
        preparedStatement.setString(1,nameCust);
        preparedStatement.setString(2,sNameCust);
        preparedStatement.setString(3,firm);
        preparedStatement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void productSelect () throws SQLException{
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();

        preparedStatement = connection
                .prepareStatement("SELECT * from printing.customers");
        resultSet = preparedStatement.executeQuery();
        writeResultSetCust(resultSet);
        statement.close();
        connection.close();
    }

    private void writeResultSetCust(ResultSet resultSet) throws SQLException {

        System.out.println("Имя: " + "Фамилия:  " + "Фирма: ");

        while (resultSet.next()) {

            String nameCust = resultSet.getString("name_customer");

            String sNameCust = resultSet.getString("sname_customer");

            String firm = resultSet.getString("firm");

            System.out.println(nameCust + "  " + sNameCust + "  " + firm);

        }

    }
}
