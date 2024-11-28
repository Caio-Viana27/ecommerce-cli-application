import java.util.LinkedList;

public class Customer extends Account {
    private Address deliveryAddress;
    private LinkedList<Order> orderHistory;

    public Customer(String name, String email, String password, Address deliveryAddress) {
        super(name, email, password, "customer");
        this.deliveryAddress = deliveryAddress;
        this.orderHistory = new LinkedList<Order>();
    }

    public void makeNewOrder() {

    }

    public void viewCurrentOrder() {

    }

    public void finishOrder() {

    }

    public void display() {
        super.display();
        System.out.println("Delivery address");
        deliveryAddress.display();
    }
}
