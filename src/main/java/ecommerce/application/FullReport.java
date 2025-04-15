package ecommerce.application;

import ecommerce.application.interfaces.IReport;
import ecommerce.application.models.Program;
import ecommerce.application.views.Menu;

public class FullReport implements IReport {

    public void create(Program program) {
        Menu.separator();
        System.out.println("    Acount(s)\n");

        for (var account : program.getAccounts()) {
            account.display();
        }
        Menu.separator();
        System.out.println("    Product(s)\n");

        for (var product : program.getProducts()) {
            product.display();
        }
    }
}