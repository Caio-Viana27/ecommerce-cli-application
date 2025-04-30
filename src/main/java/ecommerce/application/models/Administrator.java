package ecommerce.application.models;

import ecommerce.application.interfaces.Account;

public class Administrator extends Account {
    private final AccountType type = AccountType.Administrator;

    public Administrator(String name, String email, String password) {
        super(name, email, password, "admin");
    }

    public Administrator(AccountInfo info) {
        super(info);
    }

    @Override
    public String toString() {
        String adminInfo;
        adminInfo = "<-- Administrator ------------------------------------------------------>\n\n";
        adminInfo += super.toString();
        return adminInfo;
    }
}
