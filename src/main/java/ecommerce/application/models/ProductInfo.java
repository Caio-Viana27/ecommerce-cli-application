package ecommerce.application.models;

import java.io.Serializable;

public class ProductInfo implements Serializable {
    private final String id;
    private String name;
    private String description;
    private String category;
    private double price;

    public ProductInfo(String name, double price, String description, String category) {
        this.id = new String("product." + IdGenerator.radomIdGenerator());
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}