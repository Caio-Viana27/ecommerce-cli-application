import java.io.Serializable;

public class Product implements Serializable {
    private String id_product;
    private String name;
    private double price;
    private int availableProducts;
    private String description;
    private String category;
    static int numberOfProducts = 0;

    public Product(String name, double price, int availableProducts, String description, String category) {

        this.id_product = new String("product" + numberOfProducts++);
        this.name = name;
        this.price = price;
        this.availableProducts = availableProducts;
        this.description = description;
        this.category = category;
    }

    public void display() {
        System.out.println("product id: " + id_product);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Storage: " + availableProducts);
        System.out.println("Descrition: " + description);
        System.out.println("Category: " + category);
    }
}
