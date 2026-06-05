package ecommerce.application.models.report;

import ecommerce.application.Program;
import ecommerce.application.models.product.Product;
import ecommerce.application.views.Menu;
import ecommerce.application.views.Message;

public class ReportLowestInventoryProduct implements Report {

    @Override
    public void generate() {
        Product lowestInventoryProduct = null;

        for (var product : Program.Instance().getProductController().getProductsList()) {
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