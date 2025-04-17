package ecommerce.application.models;

import ecommerce.application.interfaces.Account;
import ecommerce.application.views.Message;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Map;

public class Customer extends Account {
    public AccountType type = AccountType.Customer;
    private Address deliveryAddresses;
    private List<Order> orderHistory;

    public Customer(String name, String email, String password, Address address) {
        super(name, email, password, "customer");
        //this.deliveryAddresses = new LinkedList<Address>();
        deliveryAddresses = address;
        this.orderHistory = new LinkedList<Order>();
    }

    @Override
    public AccountType login() {
        return type;
    }

//    public void addDeliveryAddress(Address address) {
//        deliveryAddresses.add(address);
//    }

    public void addToShoppingCart(Map<String, Product> products,
            ShoppingCart shoppingCart, Scanner scanner) {

//        Menu.separator();
        System.out.println("List of products");
        System.out.println("To select a product type its id");

//        for (Product product : products.values()) {
//            Menu.display(product);
//        }

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
        orderHistory.add(new Order(shoppingCart, null));
    }

    @Override
    public String toString() {
        String customerInfo;
        customerInfo  = "<-- Customer ----------------------------------------------------------->\n\n";
        customerInfo += super.toString();
        customerInfo += deliveryAddresses.toString();
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
