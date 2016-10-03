package DB.mysql;

import java.sql.*;

/**
 * Created by Degern on 2016-09-24.
 */
public class ConnectionManagerMysql {

    private ConnectionManagerMysql (){}


    private static void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error did not find driver");
        }
    }

    public static Connection getConnection() throws SQLException {
        connect();
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/Lab1_HI1031_CD_AL",
                "root", "root");
    }
}
