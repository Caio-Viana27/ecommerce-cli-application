import java.util.Map;

public class ReportLowestInventoryProduct implements Report {

    public void create(Program program) {
        Product lowestInventoryProduct = null;

        for (var product : program.getProducts()) {
            lowestInventoryProduct = getLowerInventoryProduct(lowestInventoryProduct, product);
        }

        if (lowestInventoryProduct == null) {
            Message.thereAreNoProducts();
            return;
        }

        lowestInventoryProduct.display();
    }

    private Product getLowerInventoryProduct(Product p1, Product p2) {
        if (p1 == null || !p1.hasLowerInventory(p2)) {
            return p2;
        }
        return p1;
    }

}