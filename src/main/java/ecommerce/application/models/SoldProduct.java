package ecommerce.application.models;

public class SoldProduct extends Product {
    private int quantityBought;

    public SoldProduct(Product product, int quantityBought) {
        super(product);
        this.quantityBought = quantityBought;
    }

    public double getPrice() {
        return super.getPrice() * quantityBought;
    }

    public void display() {
        super.display(-1);
        System.out.println("    Quantity bought: " + quantityBought + "\n");
    }
}
