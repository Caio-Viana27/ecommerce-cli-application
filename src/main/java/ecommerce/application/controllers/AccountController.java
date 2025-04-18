package ecommerce.application.controllers;

import ecommerce.application.interfaces.Account;
import ecommerce.application.interfaces.IAccountController;
import ecommerce.application.models.Customer;
import ecommerce.application.models.Program;

public class AccountController implements IAccountController {
    private static AccountController instance = null;

    public AccountController() {
        if (instance != null)
            throw new RuntimeException();
        instance = this;
    }

    public static AccountController getInstance() {
        return instance;
    }

    public void insertNewAccount(Account newAccount) {
        Program.getInstance().getAccountsMap().put(newAccount.getEmail(), newAccount);
    }
}
