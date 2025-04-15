package ecommerce.application.models;

import java.io.Serializable;
import java.util.LinkedList;

public class ShoppingCart implements Serializable {

    private double totalPrice;
    private LinkedList<SoldProduct> cart;

    public ShoppingCart() {
        totalPrice = 0;
        cart = new LinkedList<SoldProduct>();
    }

    public void addProduct(SoldProduct boughtProduct) {
        totalPrice += boughtProduct.getPrice();
        cart.add(boughtProduct);
    }

    public void viewShoppingCart() {
        for (var product : cart) {
            product.display();
        }
    }

    public boolean isEmpty() {
        return cart.isEmpty();
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
