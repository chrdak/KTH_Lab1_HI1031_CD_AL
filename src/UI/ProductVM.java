package UI;

import BO.Product;

import java.util.*;

/**
 * Created by Degern on 2016-09-22.
 */
public class ProductVM {
    private final String name;
    private final int code;
    private ProductVM(String name, int code) {
        this.name = Objects.requireNonNull(name);
        this.code =  Objects.requireNonNull(code);
    }

    public String getName() {
        return name;
    }

    public static List<ProductVM> getAllProducts() {
        List<ProductVM> productsVM = new ArrayList<>();
        List<Product> products = Product.getAllProducts();
        products.stream().forEach(e -> {
            productsVM.add(new ProductVM(e.getName(), e.getProductCode()));
        });
        return Collections.unmodifiableList(productsVM);
    }

    public static ProductVM getProductByCode(int code){
        Optional<Product> product = Product.getProductByCode(code);
        if (product.isPresent()) {
            return new ProductVM(product.get().getName(), code);
        }
        return new ProductVM("", 0);
    }

    public String toString() {
        return name;
    }

    public int getCode() {
        return code;
    }
}
