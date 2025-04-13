import java.io.Serializable;
import java.time.LocalDateTime;
//import java.util.LinkedList;

public class Order implements Serializable {
    private String id_Order;
    private LocalDateTime orderDate;
    private ShoppingCart shoppingCart;
    private double totalSpent;

    public Order(ShoppingCart shoppingCart) {
        this.id_Order = new String("order." + IdGenerator.radomIdGenerator());
        this.orderDate = LocalDateTime.now();
        this.shoppingCart = shoppingCart;
        this.totalSpent = shoppingCart.getTotalPrice();
    }

    public void display() {
        System.out.println("    Order id: " + id_Order);
        System.out.println("    Total spent: " + totalSpent);
        System.out.println("    Date: " + orderDate + "\n");
        shoppingCart.viewShoppingCart();
    }

    public boolean isMoreExpensive(Order order) {
        if (order == null)
            return true;
        return this.totalSpent >= order.totalSpent;
    }
}
