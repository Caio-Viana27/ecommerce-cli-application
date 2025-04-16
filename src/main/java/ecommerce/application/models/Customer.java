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

    @Override
    public String toString() {
        String customerInfo;
        customerInfo  = "<-- Customer ----------------------------------------------------------->\n\n";
        customerInfo += super.toString();
        customerInfo += deliveryAddress.toString();
        customerInfo += orderHistoryToString();
        return customerInfo + "\n";
    }

    private String orderHistoryToString() {
        if (orderHistory.isEmpty()) {
            return "  [ No order history yet ]";
        }

        StringBuilder orderHistoryInfo = new StringBuilder();
        for (var order : orderHistory) {
            orderHistoryInfo.append(order);
        }

        return orderHistoryInfo.toString();
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
