package ComplexQuery;

import java.sql.*;
import java.util.LinkedList;

public class ComplexQuery {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1111";
    private static final String URL = "jdbc:mysql://localhost:3300/printing?useSSL=false";

    //таблицы
    public static LinkedList<String> getTables() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        LinkedList<String> tables = new LinkedList<String>();
        DatabaseMetaData md = connection.getMetaData();
        ResultSet resultSet = md.getTables(null, null, "%", null);
        while (resultSet.next()) {
            tables.add(resultSet.getString(3));
        }
        return tables;
    }
    //поля
    public static LinkedList<String> getColumns(String tableName) throws SQLException {
        LinkedList<String> columns = new LinkedList<String>();
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM "+ tableName);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

// Нумерация колонок начинается с 1
        for (int i = 1; i < columnCount + 1; i++ ) {
            columns.add(tableName + "." + rsmd.getColumnName(i));
        }
        return columns;
    }
}
