package ecommerce.application.controllers;

import ecommerce.application.interfaces.Account;
import ecommerce.application.interfaces.IAccountController;
import ecommerce.application.models.Program;

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

    public void insertNewProduct(Account newAccount) {
        Program.getInstance().getAccountsMap().put(newAccount.getEmail(), newAccount);
    }
}