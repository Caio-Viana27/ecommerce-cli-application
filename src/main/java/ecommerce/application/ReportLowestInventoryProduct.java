package ecommerce.application;

import ecommerce.application.interfaces.IReport;
import ecommerce.application.models.Product;
import ecommerce.application.models.Program;
import ecommerce.application.interfaces.Menu;
import ecommerce.application.views.Message;

public class ReportLowestInventoryProduct implements IReport {

    public void create(Program program) {
        Product lowestInventoryProduct = null;

        for (var product : program.getProductsList()) {
            lowestInventoryProduct = getLowerInventoryProduct(lowestInventoryProduct, product);
        }

        if (lowestInventoryProduct == null) {
            Message.thereAreNoProducts();
            return;
        }

        Menu.display(lowestInventoryProduct);
    }

    private Product getLowerInventoryProduct(Product p1, Product p2) {
        if (p1 == null || !p1.hasLowerInventory(p2)) {
            return p2;
        }
        return p1;
    }

}