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

    public void viewShoppingCart() {
        for (var product : cart) {
            Menu.display(product);
        }
    }

    public boolean isEmpty() {
        return cart.isEmpty();
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
