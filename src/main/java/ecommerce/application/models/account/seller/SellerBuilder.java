package ecommerce.application.models.account.seller;

import ecommerce.application.models.account.*;

public class SellerBuilder extends AccountBuilder {

    private UniqueIdentifier uniqueIdentifier;
    private String name;
    private Email email;
    private String password;

    @Override
    public AccountBuilder reset() {
        this.uniqueIdentifier = null;
        this.name = null;
        this.email = null;
        this.password = null;
        return this;
    }

    @Override
    public AccountBuilder setUniqueIdentifier(UniqueIdentifier uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
        return this;
    }

    @Override
    public AccountBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public AccountBuilder setEmail(Email email) {
        this.email = email;
        return this;
    }

    @Override
    public AccountBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public Seller getSeller() {
        return new Seller(new AccountInfo(uniqueIdentifier, name, email, password));
    }
}
