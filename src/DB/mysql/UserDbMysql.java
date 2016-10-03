package DB.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Degern on 2016-09-24.
 */
public class UserDbMysql {

    private UserDbMysql() {
    }

    public static boolean exists(String username, String password) {
        try (Connection connection = ConnectionManagerMysql.getConnection();
             Statement st = connection.createStatement()) {

            try (ResultSet rs = st.executeQuery("SELECT * FROM USER user where user.name = '" + username + "'"
                    + " AND user.password ='" + password + "'")) {
                if (rs.next()) {
                    return true;
                }
            }

            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean createUser(String username, String password) {

        if (exists(username, password)) {
            return false;
        }
        try (Connection connection = ConnectionManagerMysql.getConnection(); Statement st = connection.createStatement()) {
            st.execute("INSERT INTO USER(name,password) VALUES('" + username + "'"
                    + ",'" + password + "')");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
