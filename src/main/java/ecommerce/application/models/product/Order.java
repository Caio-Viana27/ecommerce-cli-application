package ecommerce.application.models.product;

import ecommerce.application.controllers.OrderController;
import ecommerce.application.models.Address;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order implements Serializable {

    private final Long id_Order;
    private Address deliveryAddress;
    private final LocalDateTime orderDate;
    private ShoppingCart shoppingCart;
    private BigDecimal value = BigDecimal.ZERO;

    public Order(ShoppingCart shoppingCart) {
        this.id_Order = OrderController.idCounter++;
        this.deliveryAddress = null;
        this.orderDate = LocalDateTime.now();
        this.shoppingCart = shoppingCart;
        this.value = this.value.add(shoppingCart.getValue());
    }

    public Order(ShoppingCart shoppingCart, Address address) {
        this.id_Order = OrderController.idCounter++;
        this.deliveryAddress = address;
        this.orderDate = LocalDateTime.now();
        this.shoppingCart = shoppingCart;
        this.value = this.value.add(shoppingCart.getValue());
    }

    public void addProduct(Product product, int amount) {
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
        }

        shoppingCart.addProduct(new SoldProduct(product.getInfo(), amount));
        product.setNewInventory(amount);
        value = shoppingCart.getValue();
    }

    public String toString() {
        String orderInfo;
        orderInfo  = "    Order id: " + id_Order + "\n";
        orderInfo += "    Total spent: " + value + "\n";
        orderInfo += "    Date: " + orderDate + "\n";
        orderInfo += "\n";
        orderInfo += shoppingCart.toString();
        return orderInfo;
    }

    public boolean isEmpty() {
        return shoppingCart.isEmpty();
    }

    public boolean isMoreExpensive(Order order) {
        if (order == null)
            return true;

        return this.value.compareTo(order.value) >= 0;
    }
}
