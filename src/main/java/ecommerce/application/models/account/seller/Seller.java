package ecommerce.application.models.account.seller;

import ecommerce.application.models.account.Account;
import ecommerce.application.models.account.AccountInfo;
import ecommerce.application.models.account.UniqueIdentifier;
import ecommerce.application.models.account.Email;

public class Seller extends Account {

    public Seller() {}

    public Seller(UniqueIdentifier uniqueIdentifier, String name, Email email, String password) {
        super(uniqueIdentifier, name, email, password);
    }

    public Seller(AccountInfo info) {
        super(info);
    }
}
