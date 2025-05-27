package ecommerce.application.models.product;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class ShoppingCart implements Serializable {
    private double value;
    private List<SoldProduct> cart;

    public ShoppingCart() {
        value = 0;
        cart = new LinkedList<>();
    }

    public ShoppingCart(Product product, int amount) {
        value = product.getPrice();

        cart = new LinkedList<>();
        cart.add(new SoldProduct(product.getInfo(), amount));
    }

    public void addProduct(SoldProduct product) {
        value += (product.info().getPrice() * product.amount());
        cart.add(product);
    }

    @Override
    public String toString() {
        StringBuilder cartInfo = new StringBuilder();
        for (var product : cart) {
            cartInfo.append(product);
        }

        return cartInfo.toString();
    }

    public boolean isEmpty() {
        return cart.isEmpty();
    }

    public double getValue() {
        return value;
    }
}
