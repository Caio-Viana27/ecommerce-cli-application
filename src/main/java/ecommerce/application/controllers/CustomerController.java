package ecommerce.application.controllers;

import ecommerce.application.interfaces.IAccountController;

public class CustomerController implements IAccountController {
    private static CustomerController instance = null;

    public CustomerController() {
        if (instance != null)
            throw new RuntimeException();
        instance = this;
    }

    public static CustomerController getInstance() {
        return instance;
    }
}
