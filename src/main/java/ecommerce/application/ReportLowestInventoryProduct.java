package ecommerce.application;

import ecommerce.application.interfaces.Report;
import ecommerce.application.models.Product;
import ecommerce.application.interfaces.Menu;
import ecommerce.application.models.Program;
import ecommerce.application.views.Message;

public class ReportLowestInventoryProduct implements Report {

    @Override
    public void generate() {
        Product lowestInventoryProduct = null;

        for (var product : Program.getInstance().getProductController().getProductsList()) {
            lowestInventoryProduct = getLowerInventoryProduct(lowestInventoryProduct, product);
        }

        if (lowestInventoryProduct == null) {
            Message.thereAreNoProducts();
            return;
        }

        Menu.separator();
        Menu.display(lowestInventoryProduct);
    }

    private Product getLowerInventoryProduct(Product p1, Product p2) {
        if (p1 == null || !p1.hasLowerInventory(p2)) {
            return p2;
        }
        return p1;
    }

}