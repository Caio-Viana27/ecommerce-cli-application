package ecommerce.application.interfaces;

import ecommerce.application.models.AccountInfo;
import ecommerce.application.models.AccountType;

import java.io.Serializable;

public abstract class Account implements Serializable {
    protected AccountInfo info;

    public Account(String name, String email, String password, String typeOfAccount) {
        info = new AccountInfo(name, email, password, typeOfAccount);
    }

    public abstract AccountType login();

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
