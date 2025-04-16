package ecommerce.application.models;

import ecommerce.application.views.Menu;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class ShoppingCart implements Serializable {
    private double totalPrice;
    private List<SoldProduct> cart;

    public ShoppingCart() {
        totalPrice = 0;
        cart = new LinkedList<SoldProduct>();
    }

    public void addProduct(SoldProduct product) {
        totalPrice += product.getPrice();
        cart.add(product);
    }

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

    public double getTotalPrice() {
        return totalPrice;
    }
}
