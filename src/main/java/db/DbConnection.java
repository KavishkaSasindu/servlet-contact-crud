package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {

    Connection conn;

    public Connection getConnection() throws SQLException{
        final String URL = "jdbc:mysql://localhost:3306/new_crud";
        final String USERNAME = "root";
        final String PASSWORD = "mysql";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
