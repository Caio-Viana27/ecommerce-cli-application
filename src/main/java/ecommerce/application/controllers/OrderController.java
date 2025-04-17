package ecommerce.application.controllers;

import ecommerce.application.interfaces.IController;
import ecommerce.application.models.Order;
import ecommerce.application.models.ShoppingCart;

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

    public void newOrder() {
        //order = new Order(new ShoppingCart(), );
    }

    public void closeOrder() {

    }

    public Order getCurrentOrder() {
        return order;
    }
}