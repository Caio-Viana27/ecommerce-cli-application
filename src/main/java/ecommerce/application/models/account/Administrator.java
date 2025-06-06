package ecommerce.application.models.account;

import ecommerce.application.interfaces.Account;
import ecommerce.application.interfaces.UniqueIdentifier;
import ecommerce.application.models.Email;

public class Administrator extends Account {
    public Administrator() {}

    public Administrator(UniqueIdentifier uniqueIdentifier, String name, Email email, String password) {
        super(uniqueIdentifier, name, email, password);
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
