package ecommerce.application.models.product;

import ecommerce.application.controllers.ProductController;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable {

    private ProductInfo info;
    private int inventory;


    public Product(String name, BigDecimal price, int inStorage, String description, String category) {
        info = new ProductInfo(ProductController.idCounter++, name, price, description, category);
        this.inventory = inStorage;
    }

    public static boolean hasEnoughInventory(Product product , int amount) {
        if (product == null) {
            return false;
        }

        return amount > 0 && amount <= product.inventory;
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

    public long getId() {
        return info.getId();
    }

    public BigDecimal getPrice() {
        return info.getPrice();
    }

    public void setNewInventory(int quantity) {
        this.inventory -= quantity;
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
