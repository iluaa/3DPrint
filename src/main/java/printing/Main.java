package printing;


import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Main {
    static final String USERNAME = "root";
    static final String PASSWORD = "1111";
    static final String URL = "jdbc:mysql://localhost:3300/mysql?useSSL=false";



    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException ex){
            System.out.println("Ошибка регистрации драйвкра!");
            return;
        }

        /*Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();

            statement.execute("insert into printing.product (type_product, manufacturer, name_product, cost_product) " +
                    "values (\"Принтер\",1,\"Designer X Pro\", 250000)");

            statement.executeUpdate("update printing.product set cost_product=1500 where id_product=4");

            ResultSet resSet = statement.executeQuery("select * from printing.customers");

            statement.executeUpdate("delete from printing.product where id_product=10");

        Product prodQuery = new Product();
        //prodQuery.productInsert();
        //prodQuery.productDelete();
        //prodQuery.productSelect();
        Customers custQuery = new Customers();
        //custQuery.productSelect();
        Orders orderQuery = new Orders();
        orderQuery.ordersSelect();*/

    }
}
