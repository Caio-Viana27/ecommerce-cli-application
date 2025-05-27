package ecommerce.application.controllers;

import ecommerce.application.interfaces.Controller;
import ecommerce.application.models.account.Customer;
import ecommerce.application.models.product.Order;
import ecommerce.application.models.product.Product;
import ecommerce.application.models.product.ShoppingCart;
import ecommerce.application.views.SignInMenu;

public class OrderController implements Controller {
    private static OrderController instance = null;
    private Order order = null;

    public OrderController() {
        if (instance != null)
            throw new RuntimeException();
        instance = this;
    }

    public static OrderController getInstance() {
        return instance;
    }

    public void newOrder(Product product, int amount) {
        if (order == null) {
            order = new Order(new ShoppingCart());
        }

        order.addProduct(product, amount);
    }

    public boolean closeOrder() {
        Customer account = (Customer) SignInMenu.getInstance().getLogedAccount();

        if (order == null)
            return false;
        if (order.isEmpty())
            return false;

        account.addOrder(order);
        order = null;

        return true;
    }

    public Order getCurrentOrder() {
        return order;
    }
}