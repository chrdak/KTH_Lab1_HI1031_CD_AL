package BO;

import java.util.Objects;

/**
 * Created by Degern on 2016-09-24.
 */
public class User {

    private final String username;
    private final String password;

    protected User(String username, String password) {
        this.username = Objects.requireNonNull(username);
        this.password = Objects.requireNonNull(password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static boolean exists(String username, String password) {
        return DbAccess.create().exists(username,password);
    }

    public static boolean createUser(String username, String password) {
        return DbAccess.create().createUser(username, password);
    }
}
