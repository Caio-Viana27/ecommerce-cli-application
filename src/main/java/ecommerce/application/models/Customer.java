package ecommerce.application.models;

import ecommerce.application.interfaces.Account;

import java.util.LinkedList;
import java.util.List;

public class Customer extends Account {
    public final AccountType type = AccountType.Customer;
    private Address deliveryAddresses;
    private List<Order> orderHistory;

    public Customer(String name, String email, String password, Address address) {
        super(name, email, password, "customer");
        //this.deliveryAddresses = new LinkedList<Address>();
        deliveryAddresses = address;
        this.orderHistory = new LinkedList<>();
    }

    public Customer(AccountInfo info) {
        super(info);
        deliveryAddresses = null;
        this.orderHistory = new LinkedList<>();
    }

    @Override
    public AccountType login() {
        return type;
    }

//    public void addDeliveryAddress(Address address) {
//        deliveryAddresses.add(address);
//    }

    public void addOrder(Order order) {
        orderHistory.add(order);
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
