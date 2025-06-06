package ecommerce.application.models.account;

import ecommerce.application.interfaces.Builder;
import ecommerce.application.interfaces.UniqueIdentifier;
import ecommerce.application.models.Email;

public class SellerBuilder extends Builder {

    private UniqueIdentifier uniqueIdentifier;
    private String name;
    private Email email;
    private String password;

    @Override
    public Builder reset() {
        this.uniqueIdentifier = null;
        this.name = null;
        this.email = null;
        this.password = null;
        return this;
    }

    @Override
    public Builder setUniqueIdentifier(UniqueIdentifier uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
        return this;
    }

    @Override
    public Builder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Builder setEmail(Email email) {
        this.email = email;
        return this;
    }

    @Override
    public Builder setPassword(String password) {
        this.password = password;
        return this;
    }

    public Seller getSeller() {
        return new Seller(new AccountInfo(uniqueIdentifier, name, email, password));
    }
}
