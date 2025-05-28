package ecommerce.application.controllers;

import ecommerce.application.interfaces.Controller;
import ecommerce.application.models.product.Product;

import java.util.Collection;
import java.util.Map;

public class ProductController implements Controller {
    private Map<String, Product> products;

    public ProductController() {}

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