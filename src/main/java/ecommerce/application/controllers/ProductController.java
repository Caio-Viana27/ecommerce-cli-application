package ecommerce.application.controllers;

import ecommerce.application.interfaces.Account;
import ecommerce.application.interfaces.IAccountController;
import ecommerce.application.models.Administrator;
import ecommerce.application.models.Product;
import ecommerce.application.models.Program;
import ecommerce.application.views.AdministratorMenu;

public class ProductController implements IAccountController {
    private static ProductController instance = null;

    public ProductController() {
        if (instance != null)
            throw new RuntimeException();
        instance = this;
    }

    public static ProductController getInstance() {
        return instance;
    }

    public void insertNewProduct(Product newProduct) {
        Program.getInstance().getProductsMap().put(newProduct.getId(), newProduct);

        AdministratorMenu.getInstance().draw();
    }
}