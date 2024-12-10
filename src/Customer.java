import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Map;

public class Customer extends Account {
    private Address deliveryAddress;
    private LinkedList<Order> orderHistory;

    public Customer(String name, String email, String password, Address deliveryAddress) {
        super(name, email, password, "customer");
        this.deliveryAddress = deliveryAddress;
        this.orderHistory = new LinkedList<Order>();
    }

    public void addProductToShoppingCart(HashMap<String, Product> products,
            ShoppingCart shoppingCart, Scanner scanner) {

        Product product;
        Menu.separator();
        System.out.println("List of products");
        System.out.println("To select a product type its id");

        for (Map.Entry<String, Product> entry : products.entrySet()) {
            entry.getValue().display();
        }
        while (true) {

            System.out.print("\nEnter id: ");
            String id = scanner.nextLine();

            product = products.get(id);

            if (product != null) {
                break;
            } else
                Menu.invalidWarning("id");
        }

        if (!product.isAvailable()) {
            System.out.println("Sorry, the selected product has no inventory");
            return;
        }

        int quantity = product.selectQuantity(scanner);
        product.setNewInventory(-quantity);

        shoppingCart.addBoughtProduct(new BoughtProduct(product, quantity));
    }

    public void finishOrder(ShoppingCart shoppingCart) {
        orderHistory.add(new Order(shoppingCart));
    }

    public void display() {
        super.display();
        System.out.println("Delivery address:");
        deliveryAddress.display();
        System.out.println("\nOrder history:\n");
        this.orderHistoryDisplay();
    }

    private void orderHistoryDisplay() {
        if (orderHistory.size() == 0) {
            System.out.println("No order history yet");
            return;
        }
        for (var order : orderHistory) {
            order.display();
        }
    }

    public boolean hasHistoryOrder() {
        return this.orderHistory.size() > 0;
    }

    public Order searchMoreExpensiveOrder(Order currentMoreExpensive) {
        for (Order order : orderHistory) {
            if (currentMoreExpensive == null || !currentMoreExpensive.isMoreExpensiveOrder(order)) {
                currentMoreExpensive = order;
            }
        }
        return currentMoreExpensive;
    }
}
