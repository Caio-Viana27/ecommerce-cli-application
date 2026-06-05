package ecommerce.application.models.report;

import ecommerce.application.views.Menu;
import ecommerce.application.Program;

public class FullReport implements Report {

    @Override
    public void generate() {
        Menu.separator();
        System.out.println("    Account(s)\n");

        for (var account : Program.Instance().getAccountController().getAccountsList()) {
            Menu.display(account);
        }

        Menu.separator();
        System.out.println("    Product(s)\n");

        for (var product : Program.Instance().getProductController().getProductsList()) {
            Menu.display(product);
        }
    }
}