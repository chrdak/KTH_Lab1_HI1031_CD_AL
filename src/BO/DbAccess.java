package BO;

import DB.interfaces.Database;
import DB.mysql.DbFacadeMysql;

import java.util.Map;

/**
 * Created by Degern on 2016-09-26.
 */
public class DbAccess {
    private final Database db = new DbFacadeMysql();
    private DbAccess (){}

    public static DbAccess create (){
        return new DbAccess();
    }

    public Map getAllProducts(){
        return db.getAllProducts();
    }

    public Map getProductByCode(int code){
        return db.getProductByCode(code);
    }

    public boolean exists(String name,String password){
        return db.exists(name, password);
    }

    public boolean createUser(String name,String password){
        return db.createUser(name, password);
    }


}
