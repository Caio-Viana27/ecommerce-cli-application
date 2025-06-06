package ecommerce.application.interfaces;

import ecommerce.application.models.Email;
import ecommerce.application.models.account.AccountInfo;

import java.io.Serializable;

public abstract class Account implements Serializable {
    protected AccountInfo info;

    public Account() {}

    public Account(UniqueIdentifier uniqueIdentifier, String name, Email email, String password) {
        info = new AccountInfo(uniqueIdentifier, name, email, password);
    }

    public Account(AccountInfo info) {
        this.info = info;
    }

    public String getUniqueIdentifier() {
        return info.getUniqueIdentifier().toString();
    }

    public String getEmail() {
        return info.getEmail().toString();
    }

    public String getName() { return info.getName(); }

    public boolean passwordMatches(String enteredPassword) {
        return info.passwordMatches(enteredPassword);
    }

    @Override
    public String toString() {
        String accountInfo;
        accountInfo =  "    id: " + info.getUniqueIdentifier() + "\n";
        accountInfo += "    Name: " + info.getName() + "\n";
        accountInfo += "    Email: " + info.getEmail() + "\n";
        accountInfo += "\n";
        return accountInfo;
    }
}
