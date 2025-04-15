package ecommerce.application.models;

import ecommerce.application.views.Menu;
import ecommerce.application.views.Message;

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

    public void menu(Program program) {
        program.storeMenu(this);
    }

    public void addToShoppingCart(Map<String, Product> products,
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
                Message.invalidOption("id");
        }

        if (!product.isAvailable()) {
            Message.productHasNoInventory();
            return;
        }

        int quantity = product.selectQuantity(scanner);
        product.setNewInventory(-quantity);

        shoppingCart.addProduct(new SoldProduct(product, quantity));
    }

    public void finishOrder(ShoppingCart shoppingCart) {
        orderHistory.add(new Order(shoppingCart));
    }

    public void display() {
        super.display();
        System.out.println("    Delivery address:");
        deliveryAddress.display();
        System.out.println("\n    Order history:\n");
        orderHistoryDisplay();
    }

    private void orderHistoryDisplay() {
        if (orderHistory.isEmpty()) {
            System.out.println("    No order history yet\n");
            return;
        }
        for (var order : orderHistory) {
            order.display();
        }
    }

    public boolean hasOrderHistory() {
        return !orderHistory.isEmpty();
    }

    public Order getMostExpensiveOrder() {
        if (!hasOrderHistory())
            return null;

        Order currentMoreExpensive = null;

        for (Order order : orderHistory) {
            if (currentMoreExpensive == null || !currentMoreExpensive.isMoreExpensive(order)) {
                currentMoreExpensive = order;
            }
        }
        return currentMoreExpensive;
    }
}
