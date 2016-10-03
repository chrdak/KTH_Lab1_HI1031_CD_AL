package DB;

import DB.interfaces.Database;

import java.util.*;

/**
 * Created by Degern on 2016-09-26.
 */
public class DbList implements Database {
    private Map<Integer, String> products = new HashMap<>();
    private Map<String, String> user = new HashMap<>();

    public DbList() {
        products.put(1, "PASS");
        user.put("abv","123");
    }

    @Override
    public Map getAllProducts() {
        return Collections.unmodifiableMap(products);
    }

    @Override
    public Map getProductByCode(int code) {
        if (products.containsKey(code)) {
            return Collections.singletonMap(code, products.get(code));
        }
        return Collections.emptyMap();
    }

    @Override
    public boolean createUser(String username, String password) {
        if (user.containsKey(username)) {
            return false;
        }
        user.put(username, password);
        return true;
    }

    @Override
    public boolean exists(String username, String password) {
        return user.containsKey(username);
    }
}
