import java.util.Map;

public class ReportMostExpensiveOrder implements Report {

    public void create(Program program) {
        Order mostExpensiveOrder = null;

        for (var account : program.getAccounts()) {
            Order CustomerMostExpensiveOrder = null;

            if (account instanceof Customer customer) {
                CustomerMostExpensiveOrder = customer.getMostExpensiveOrder();
            }

            if (CustomerMostExpensiveOrder == null) {
                continue;
            }

            if (CustomerMostExpensiveOrder.isMoreExpensive(mostExpensiveOrder)) {
                mostExpensiveOrder = CustomerMostExpensiveOrder;
            }
        }

        if (mostExpensiveOrder == null) {
            Message.thereAreNoOrders();
            return;
        }

        mostExpensiveOrder.display();
    }
}