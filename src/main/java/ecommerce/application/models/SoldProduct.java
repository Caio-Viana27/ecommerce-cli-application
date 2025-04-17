package ecommerce.application.models;

import java.io.Serializable;

public record SoldProduct(ProductInfo info, int quantitySold) implements Serializable {

    public double getPrice() {
        return info.getPrice();
    }

    @Override
    public String toString() {
        String productInfo;
        productInfo  = "    Id: " + info.getId() + "\n";
        productInfo += "    Name: " + info.getName() + "\n";
        productInfo += "    Description: " + info.getDescription() + "\n";
        productInfo += "    Category: " + info.getCategory() + "\n";
        productInfo += "    Price: " + info.getPrice() + "\n";
        productInfo += "    Quantity: " + quantitySold + "\n";
        return productInfo + "\n";
    }
}
