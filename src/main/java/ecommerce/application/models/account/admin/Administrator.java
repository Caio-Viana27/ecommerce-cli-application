package ecommerce.application.models.account.admin;

import ecommerce.application.models.account.Account;
import ecommerce.application.models.account.AccountInfo;
import ecommerce.application.models.account.UniqueIdentifier;
import ecommerce.application.models.account.Email;

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
