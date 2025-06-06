package ecommerce.application.controllers;

import ecommerce.application.models.Program;
import ecommerce.application.models.account.Customer;
import ecommerce.application.models.product.Order;
import ecommerce.application.models.product.Product;
import ecommerce.application.models.product.ShoppingCart;
import ecommerce.application.views.MenuManager;
import ecommerce.application.views.SignInMenu;

public class OrderController {

    public static Long idCounter = 0L;
    private Order order = null;

    public OrderController() {}

    public void newOrder(Product product, int amount) {
        if (order == null) {
            order = new Order(new ShoppingCart());
        }

        order.addProduct(product, amount);
    }

    public boolean closeOrder() {
        var menu = (SignInMenu) MenuManager.instance().getMenu(SignInMenu.class);
        Customer account = (Customer) Program.Instance().getLoggedAccount();

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