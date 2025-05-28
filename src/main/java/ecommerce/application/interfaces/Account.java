package ecommerce.application.interfaces;

import ecommerce.application.models.account.AccountInfo;

import java.io.Serializable;

public abstract class Account implements Serializable {
    protected AccountInfo info;

    public Account() {}

    public Account(String name, String email, String password, String typeOfAccount) {
        info = new AccountInfo(name, email, password);
    }

    public Account(AccountInfo info) {
        this.info = info;
    }

    public String getEmail() {
        return info.getEmail();
    }

    public boolean passwordMatches(String enteredPassword) {
        return info.passwordMatches(enteredPassword);
    }

    @Override
    public String toString() {
        String accountInfo;
        accountInfo =  "    id: " + info.getId() + "\n";
        accountInfo += "    Name: " + info.getName() + "\n";
        accountInfo += "    Email: " + info.getEmail() + "\n";
        accountInfo += "\n";
        return accountInfo;
    }
}
