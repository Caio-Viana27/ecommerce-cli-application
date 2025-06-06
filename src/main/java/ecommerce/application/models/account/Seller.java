package ecommerce.application.models.account;

import ecommerce.application.interfaces.Account;
import ecommerce.application.interfaces.UniqueIdentifier;
import ecommerce.application.models.Email;

public class Seller extends Account {

    public Seller() {}

    public Seller(UniqueIdentifier uniqueIdentifier, String name, Email email, String password) {
        super(uniqueIdentifier, name, email, password);
    }

    public Seller(AccountInfo info) {
        super(info);
    }
}
