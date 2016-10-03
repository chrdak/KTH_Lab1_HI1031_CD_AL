package BO;

import java.util.*;

/**
 * Created by Degern on 2016-09-22.
 */
public class Product {

    private final int productCode;
    private final String name;

    protected Product(int productCode, String name){
        this.productCode = Objects.requireNonNull(productCode);
        this.name = Objects.requireNonNull(name);
    }

    public int getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }

    public static List<Product> getAllProducts() {
        List<Product> products=  new ArrayList<>();
        Map<Integer,String> allProducts = DbAccess.create().getAllProducts();
        allProducts.entrySet().stream().forEach(e -> {
            Integer key = e.getKey();
            String name = e.getValue();
            products.add(new Product(key,name));
        });
        return Collections.unmodifiableList(products);
    }

    public static Optional<Product> getProductByCode(int code) {
        Map<Integer,String> allProducts = DbAccess.create().getProductByCode(code);
        if (!allProducts.isEmpty()) {
            return Optional.of(new Product(code, allProducts.get(code)));
        }
        return Optional.empty();
    }

}
