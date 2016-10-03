package DB.mysql;

import java.util.*;
import java.sql.*;

/**
 * Created by Degern on 2016-09-22.
 */
public class ProductDbMysql {

    private ProductDbMysql() {}

    public static Map getAllProducts() {
        Map products = new HashMap();
        try (Connection connection = ConnectionManagerMysql.getConnection();
             Statement st = connection.createStatement()) {

            try (ResultSet rs = st.executeQuery("SELECT * FROM PRODUCT")) {
                while (rs.next()) {
                    products.put(rs.getInt("productCode"), rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.unmodifiableMap(products);
    }

    public static Map getProductByCode(int code) {
        Map products = new HashMap();
        try (Connection connection = ConnectionManagerMysql.getConnection();
             Statement st = connection.createStatement()) {

            try (ResultSet rs = st.executeQuery("SELECT * FROM PRODUCT p where p.productCode = '" + code + "'")) {
                if (rs.next()) {
                    products.put(rs.getInt("productCode"), rs.getString("name"));
                    return Collections.unmodifiableMap(products);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyMap();
    }
}
