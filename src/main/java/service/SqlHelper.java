package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlHelper {
    private static String url="jdbc:mysql://localhost/webapp?serverTimezone=GMT%2B8";
    private static String driver="com.mysql.cj.jdbc.Driver";
    private static String username="webapp1901";
    private static String pwd="webapp1901";
    private static Connection connection;

    public static Connection getConn(){
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, pwd);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void connClose(){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
