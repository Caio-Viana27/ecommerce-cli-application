package ecommerce.application.models.product;

import java.io.Serializable;
import java.math.BigDecimal;

public record SoldProduct(ProductInfo info, int amount) implements Serializable {

    public BigDecimal getPrice() {
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
        productInfo += "    Quantity: " + amount + "\n";
        return productInfo + "\n";
    }
}
