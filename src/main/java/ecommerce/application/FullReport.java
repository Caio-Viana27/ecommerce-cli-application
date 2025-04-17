package ecommerce.application;

import ecommerce.application.interfaces.IReport;
import ecommerce.application.models.Program;
import ecommerce.application.interfaces.Menu;

public class FullReport implements IReport {

    public void create(Program program) {
        Menu.separator();
        System.out.println("    Account(s)\n");

        for (var account : program.getAccounts()) {
            Menu.display(account);
        }
        Menu.separator();
        System.out.println("    Product(s)\n");

        for (var product : program.getProductsList()) {
            Menu.display(product);
        }
    }
}