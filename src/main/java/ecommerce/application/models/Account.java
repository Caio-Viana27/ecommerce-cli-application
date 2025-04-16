package ecommerce.application.models;

import java.io.Serializable;

public abstract class Account implements Serializable {
    private AccountInfo info;

    public Account(String name, String email, String password, String typeOfAccount) {
        info = new AccountInfo(name, email, password, typeOfAccount);
    }

    public abstract void menu(Program program);

    public boolean passwordMatches(String enteredPassword) {
        return info.passwordMatches(enteredPassword);
    }

    public String toString() {
        String accountInfo;
        accountInfo =  "    id: " + info.getId() + "\n";
        accountInfo += "    Name: " + info.getName() + "\n";
        accountInfo += "    Email: " + info.getEmail() + "\n";
        accountInfo += "\n";
        return accountInfo;
    }
}
