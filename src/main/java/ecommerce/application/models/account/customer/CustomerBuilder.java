package ecommerce.application.models.account.customer;

import ecommerce.application.models.account.UniqueIdentifier;
import ecommerce.application.models.account.Address;
import ecommerce.application.models.account.Email;
import ecommerce.application.models.account.AccountBuilder;
import ecommerce.application.models.account.AccountInfo;

public class CustomerBuilder extends AccountBuilder {

    private UniqueIdentifier uniqueIdentifier;
    private String name;
    private Email email;
    private String password;
    private Address address;

    @Override
    public AccountBuilder reset() {
        this.uniqueIdentifier = null;
        this.name = null;
        this.email = null;
        this.password = null;
        this.address = null;
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

    @Override
    public AccountBuilder addAddress(Address address) {
        this.address = address;
        return this;
    }

    public Customer getCustomer() {
        return new Customer(new AccountInfo(uniqueIdentifier, name, email, password), address);
    }
}
