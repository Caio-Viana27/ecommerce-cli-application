package ecommerce.application.models;

import ecommerce.application.views.Message;
import java.io.Serializable;
import java.util.Scanner;

public class Product implements Serializable {
    private ProductInfo info;
    private int inventory;


    public Product(String name, double price, int inStorage, String description, String category) {
        info = new ProductInfo(name, price, description, category);
        this.inventory = inStorage;
    }

    public static boolean hasEnoughInventory(Product product , int quantity) {
        if (product == null) {
            return false;
        }

        if (quantity <= 0 || quantity > product.inventory) {
            Message.invalidOption("quantity");
            return false;
        }

        return true;
    }

    public int selectQuantity(Scanner scanner) {

        while (true) {
            System.out.print("\nHow many products you wish to buy? ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            if (Product.hasEnoughInventory(this, quantity))
                return quantity;
        }
    }

    @Override
    public String toString() {
        String productInfo;
        productInfo =  "    Product id: " + info.getId() + "\n";
        productInfo += "    Name: " + info.getName() + "\n";
        productInfo += "    Price: " + info.getPrice() + "\n";
        productInfo += "    inventory: " + inventory + "\n";
        productInfo += "    Description: " + info.getDescription() + "\n";
        productInfo += "    Category: " + info.getCategory() + "\n";
        return productInfo;
    }

    public ProductInfo getInfo() {
        return info;
    }

    public String getId() {
        return info.getId();
    }

    public void setNewInventory(int quantity) {
        this.inventory += quantity;
    }

    public boolean hasLowerInventory(Product product) {
        if (product == null)
            return true;

        return this.inventory <= product.inventory;
    }

    public boolean isAvailable() {
        return inventory > 0;
    }
}
