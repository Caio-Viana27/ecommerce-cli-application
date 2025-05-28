package ecommerce.application;

import ecommerce.application.interfaces.Report;
import ecommerce.application.interfaces.Menu;
import ecommerce.application.models.Program;

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