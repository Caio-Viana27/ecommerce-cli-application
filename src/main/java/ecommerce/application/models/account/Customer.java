package ecommerce.application.models.account;

import ecommerce.application.interfaces.Account;
import ecommerce.application.models.Address;
import ecommerce.application.models.product.Order;

import java.util.LinkedList;
import java.util.List;

public class Customer extends Account {
    private List<Address> deliveryAddresses;
    private List<Order> orderHistory;

    public Customer() {}

    public Customer(String name, String email, String password, Address address) {
        super(name, email, password, "customer");
        this.orderHistory = new LinkedList<>();
        deliveryAddresses = new LinkedList<>();
        deliveryAddresses.add(address);
    }

    public Customer(AccountInfo info) {
        super(info);
        deliveryAddresses = new LinkedList<>();
        this.orderHistory = new LinkedList<>();
    }

    public void addDeliveryAddress(Address address) {
        deliveryAddresses.add(address);
    }

    public void addOrder(Order order) {
        orderHistory.add(order);
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

    private String orderHistoryToString() {
        if (orderHistory.isEmpty()) {
            return "    User has no order history yet";
        }

        StringBuilder orderHistoryInfo = new StringBuilder();
        for (var order : orderHistory) {
            orderHistoryInfo.append(order);
        }

        return orderHistoryInfo.toString();
    }

    private String addressesToString() {
        if (deliveryAddresses.isEmpty()) {
            return "    User has no delivery addresses";
        }

        StringBuilder stringAddresses = new StringBuilder();
        for (var address : deliveryAddresses) {
            stringAddresses.append(address);
        }

        return stringAddresses.toString();
    }

    @Override
    public String toString() {
        String customerInfo;
        customerInfo  = "<== Customer ===========================================================>\n\n";
        customerInfo += super.toString();
        customerInfo += addressesToString();
        customerInfo += orderHistoryToString();
        return customerInfo + "\n";
    }
}
