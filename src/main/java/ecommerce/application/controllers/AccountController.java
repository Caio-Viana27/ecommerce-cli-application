package ecommerce.application.controllers;

import ecommerce.application.interfaces.Account;

import java.util.Collection;
import java.util.Map;

public class AccountController {
    private Map<String, Account> accounts;

    public AccountController() {}

    public void insertNewAccount(Account newAccount) {
        accounts.put(newAccount.getEmail(), newAccount);
    }

    public Collection<Account> getAccountsList() { return accounts.values(); }

    public Map<String, Account> getAccountsMap() {
        return accounts;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }
}
