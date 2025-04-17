package ecommerce.application.models;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Order implements Serializable {
    private String id_Order;
    private Address deliveryAddress;
    private LocalDateTime orderDate;
    private ShoppingCart shoppingCart;
    private double totalSpent;

    public Order(ShoppingCart shoppingCart, Address deliveryAddress) {
        this.id_Order = new String("order." + IdGenerator.radomIdGenerator());
        this.deliveryAddress = deliveryAddress;
        this.orderDate = LocalDateTime.now();
        this.shoppingCart = shoppingCart;
        this.totalSpent = shoppingCart.getTotalPrice();
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
