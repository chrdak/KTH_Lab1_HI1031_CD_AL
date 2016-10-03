package UI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by Degern on 2016-09-24.
 */
public class Cart {

    private List<ProductVM> cart = new ArrayList<>();;

    public static Cart create() {
        return new Cart();
    }

    public List<ProductVM> getCartProducts() {
        System.out.println(cart.size());
        return Collections.unmodifiableList(cart);
    }

    public void addToCart(ProductVM productVM) {
        ProductVM p = Objects.requireNonNull(productVM);
        System.out.println(p.getName());
        cart.add(p);
        System.out.println(cart.size());
    }
}
