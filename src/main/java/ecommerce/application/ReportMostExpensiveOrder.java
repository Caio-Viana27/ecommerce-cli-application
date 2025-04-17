package ecommerce.application;

import ecommerce.application.interfaces.IReport;
import ecommerce.application.models.Customer;
import ecommerce.application.models.Order;
import ecommerce.application.models.Program;
import ecommerce.application.interfaces.Menu;
import ecommerce.application.views.Message;

public class ReportMostExpensiveOrder implements IReport {

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

        Menu.display(mostExpensiveOrder);
    }
}