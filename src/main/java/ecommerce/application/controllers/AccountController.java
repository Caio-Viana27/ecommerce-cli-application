package ecommerce.application.controllers;

import ecommerce.application.interfaces.Account;
import ecommerce.application.interfaces.IController;
import ecommerce.application.models.Product;
import ecommerce.application.models.Program;

import java.util.Collection;
import java.util.Map;

public class AccountController implements IController {
    private static AccountController instance = null;
    private Map<String, Account> accounts;

    public AccountController() {
        if (instance != null)
            throw new RuntimeException();
        instance = this;
    }

    public static AccountController getInstance() {
        return instance;
    }

    public void insertNewAccount(Account newAccount) {
        accounts.put(newAccount.getEmail(), newAccount);
    }

    public Collection<Account> getAccountsList() {
        return accounts.values();
    }

    public Map<String, Account> getAccountsMap() {
        return accounts;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }
}
