package ecommerce.application.models;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Order implements Serializable {
    private String id_Order;
    private Address deliveryAddress;
    private LocalDateTime orderDate;
    private ShoppingCart shoppingCart;
    private double totalSpent;

    public Order(ShoppingCart shoppingCart) {
        this.id_Order = new String("order." + IdGenerator.radomIdGenerator());
        this.deliveryAddress = null;
        this.orderDate = LocalDateTime.now();
        this.shoppingCart = shoppingCart;
        this.totalSpent = shoppingCart.getTotalPrice();
    }

    public Order(ShoppingCart shoppingCart, Address address) {
        this.id_Order = new String("order." + IdGenerator.radomIdGenerator());
        this.deliveryAddress = address;
        this.orderDate = LocalDateTime.now();
        this.shoppingCart = shoppingCart;
        this.totalSpent = shoppingCart.getTotalPrice();
    }

    public void addProduct(Product product, int amount) {
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
        }
        shoppingCart.addProduct(new SoldProduct(product.getInfo(), amount));
    }

    public String toString() {
        String orderInfo;
        orderInfo  = "    Order id: " + id_Order + "\n";
        orderInfo += "    Total spent: " + totalSpent + "\n";
        orderInfo += "    Date: " + orderDate + "\n";
        orderInfo += "\n";
        orderInfo += shoppingCart.toString();
        return orderInfo;
    }

    public boolean isMoreExpensive(Order order) {
        if (order == null)
            return true;
        return this.totalSpent >= order.totalSpent;
    }
}
