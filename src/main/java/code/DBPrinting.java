package code;

import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public interface DBPrinting {

    //Connection getConnection() throws SQLException;

    //public void selectDB() throws SQLException;

    void insertDB(Ent tbl) throws SQLException;

    void deleteDB(Ent tbl) throws SQLException;

    void UpdateDB(Ent tbl) throws SQLException;

   // ArrayList<PrepodEnt> findPrepod() throws SQLException;
}
