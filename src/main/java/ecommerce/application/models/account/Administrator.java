package ecommerce.application.models.account;

import ecommerce.application.interfaces.Account;

public class Administrator extends Account {
    public Administrator() {}

    public Administrator(String name, String email, String password) {
        super(name, email, password, "admin");
    }

    public Administrator(AccountInfo info) {
        super(info);
    }

    @Override
    public String toString() {
        String adminInfo;
        adminInfo = "<== Administrator ======================================================>\n\n";
        adminInfo += super.toString();
        return adminInfo;
    }
}
