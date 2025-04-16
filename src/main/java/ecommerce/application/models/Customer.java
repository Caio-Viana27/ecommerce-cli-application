package ecommerce.application.models;

import ecommerce.application.views.Menu;
import ecommerce.application.views.Message;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Map;

public class Customer extends Account {
    private Address deliveryAddress;
    private List<Order> orderHistory;

    public Customer(String name, String email, String password, Address deliveryAddress) {
        super(name, email, password, "customer");
        this.deliveryAddress = deliveryAddress;
        this.orderHistory = new LinkedList<Order>();
    }

    @Override
    public void menu(Program program) {
        if (program == null) {
            throw new NullPointerException();
        }

        program.storeMenu(this);
    }

    public void addToShoppingCart(Map<String, Product> products,
            ShoppingCart shoppingCart, Scanner scanner) {

        Menu.separator();
        System.out.println("List of products");
        System.out.println("To select a product type its id");

        for (Product product : products.values()) {
            Menu.display(product);
        }

        Product selectedProduct;
        while (true) {

            System.out.print("\nEnter id: ");
            String id = scanner.nextLine();

            selectedProduct = products.get(id);

            if (selectedProduct != null) {
                break;
            } else
                Message.invalidOption("id");
        }

        if (!selectedProduct.isAvailable()) {
            Message.productHasNoInventory();
            return;
        }

        int quantity = selectedProduct.selectQuantity(scanner);
        selectedProduct.setNewInventory(-quantity);

        shoppingCart.addProduct(new SoldProduct(selectedProduct.getInfo(), quantity));
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
