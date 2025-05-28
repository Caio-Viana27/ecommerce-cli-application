package ecommerce.application;

import ecommerce.application.interfaces.Report;
import ecommerce.application.models.account.Customer;
import ecommerce.application.models.product.Order;
import ecommerce.application.models.Program;
import ecommerce.application.interfaces.Menu;
import ecommerce.application.views.Message;

public class ReportMostExpensiveOrder implements Report {

    @Override
    public void generate() {
        Order mostExpensiveOrder = null;

        for (var account : Program.Instance().getAccountController().getAccountsList()) {
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

        Menu.separator();
        Menu.display(mostExpensiveOrder);
    }
}