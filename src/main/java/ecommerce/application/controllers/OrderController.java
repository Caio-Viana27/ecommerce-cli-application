package ecommerce.application.controllers;

import ecommerce.application.interfaces.IController;
import ecommerce.application.models.Customer;
import ecommerce.application.models.Order;
import ecommerce.application.models.Product;
import ecommerce.application.models.ShoppingCart;
import ecommerce.application.views.CustomerMenu;
import ecommerce.application.views.Login;
import ecommerce.application.views.OrderMenu;

public class OrderController implements IController {
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
        OrderMenu.getInstance().draw();
    }

    public void closeOrder() {
        if (order == null) {
            OrderMenu.getInstance().draw();
        }

        Customer account = (Customer) Login.getInstance().getLogedAccount();
        account.addOrder(order);
        order = null;

        CustomerMenu.getInstance().draw();
    }

    public Order getCurrentOrder() {
        return order;
    }
}