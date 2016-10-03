package DB.mysql;

import DB.interfaces.Database;

import java.util.Map;

/**
 * Created by Degern on 2016-09-26.
 */
public class DbFacadeMysql implements Database {


    @Override
    public Map getAllProducts() {
        return ProductDbMysql.getAllProducts();
    }

    @Override
    public Map getProductByCode(int code) {
        return ProductDbMysql.getProductByCode(code);
    }

    @Override
    public boolean createUser(String username, String password) {
        return UserDbMysql.createUser(username, password);
    }

    @Override
    public boolean exists(String username, String password) {
        return UserDbMysql.exists(username, password);
    }
}
