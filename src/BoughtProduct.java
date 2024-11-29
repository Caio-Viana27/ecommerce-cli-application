public class BoughtProduct extends Product {
    private int quantityBought;

    public BoughtProduct(Product product, int quantityBought) {
        super(product);
        this.quantityBought = quantityBought;
    }

    public double getPrice() {
        return super.getPrice() * quantityBought;
    }

    public void display() {
        super.display();
        System.out.println("Quantity bought: " + quantityBought);
    }
}
