package ecommerce.application.models.product;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductInfo implements Serializable {
    private final Long id;
    private String name;
    private String description;
    private String category;
    private BigDecimal price = BigDecimal.ZERO;

    public ProductInfo(long id, String name, BigDecimal price, String description, String category) {
        this.id = id;
        this.name = name;
        this.price = this.price.add(price);
        this.description = description;
        this.category = category;
    }

    public long getId() {
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

    public BigDecimal getPrice() {
        return price;
    }
}