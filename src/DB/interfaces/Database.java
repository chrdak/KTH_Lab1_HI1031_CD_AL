package DB.interfaces;

import BO.Product;

import java.sql.Connection;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Degern on 2016-09-26.
 */
public interface Database {

    public Map getAllProducts();

    public Map getProductByCode(int code);

    public boolean createUser(String username, String password);

    public boolean exists(String username, String password);

}
