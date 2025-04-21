package ecommerce.application.controllers;

import ecommerce.application.interfaces.Controller;
import ecommerce.application.models.Product;

import java.util.Collection;
import java.util.Map;

public class ProductController implements Controller {
    private static ProductController instance = null;
    private Map<String, Product> products;

    public ProductController() {
        if (instance != null)
            throw new RuntimeException();
        instance = this;
    }

    public static ProductController getInstance() {
        return instance;
    }

    public void insertNewProduct(Product newProduct) {
        products.put(newProduct.getId(), newProduct);
    }

    public Collection<Product> getProductsList() {
        return products.values();
    }

    public Map<String, Product> getProductsMap() {
        return products;
    }

    public void setProducts(Map<String, Product> products) {
        this.products = products;
    }
}