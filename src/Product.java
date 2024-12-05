import java.io.Serializable;
import java.util.Scanner;

public class Product implements Serializable {
    private String id_product;
    private String name;
    private double price;
    private int inventory;
    private String description;
    private String category;

    public Product(String name, double price, int inStorage, String description, String category) {
        this.id_product = new String("product." + IdGenerator.radomIdGenerator());
        this.name = name;
        this.price = price;
        this.inventory = inStorage;
        this.description = description;
        this.category = category;
    }

    public Product(Product product) {
        this.id_product = product.id_product;
        this.name = product.name;
        this.price = product.price;
        this.inventory = -1; // bought product has no need for inventory!
        this.description = product.description;
        this.category = product.category;
    }

    public boolean idMatches(String id) {
        return this.id_product.equals(id);
    }

    public static boolean validadeQuantity(int quantity, int inventory) {
        if (quantity <= 0 || quantity > inventory) {
            Menu.invalidWarning("quantity");
            return false;
        }
        return true;
    }

    public int selectQuantity(Scanner scanner) {

        while (true) {
            System.out.print("\nHow many products you wish to buy? ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            if (Product.validadeQuantity(quantity, this.inventory))
                return quantity;
        }
    }

    public void display() {
        System.out.println("\nProduct id: " + id_product);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("inventory: " + inventory);
        System.out.println("Descrition: " + description);
        System.out.println("Category: " + category);
    }

    public void display(int inventoryNotApplicable) {
        System.out.println("\nProduct id: " + id_product);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Descrition: " + description);
        System.out.println("Category: " + category);
    }

    public double getPrice() {
        return price;
    }

    public int getInStorage() {
        return this.inventory;
    }

    public void setNewInventory(int quantity) {
        this.inventory += quantity;
    }

    public boolean hasLowertInventory(Product product) {
        return this.inventory <= product.inventory;
    }
}
