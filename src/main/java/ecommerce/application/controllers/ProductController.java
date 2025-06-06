package ecommerce.application.controllers;

import ecommerce.application.models.product.Product;

import java.util.Collection;
import java.util.Map;

public class ProductController {

    public static Long idCounter = 0L;
    private Map<Long, Product> products;

    public ProductController() {}

    public void insertNewProduct(Product newProduct) {
        products.put(newProduct.getId(), newProduct);
    }

    public Collection<Product> getProductsList() {
        return products.values();
    }

    public Map<Long, Product> getProductsMap() {
        return products;
    }

    public void setProducts(Map<Long, Product> products) {
        this.products = products;
    }
}