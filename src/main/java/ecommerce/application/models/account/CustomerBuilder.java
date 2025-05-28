package ecommerce.application.models.account;

import ecommerce.application.interfaces.Builder;

public class CustomerBuilder extends Builder {

    private AccountInfo info;
    private Address address;

    @Override
    public Builder reset() {
        return this;
    }

    @Override
    public Builder setAccountInfo(AccountInfo info) {
        this.info = info;
        return this;
    }

    @Override
    public Builder addAddress(Address address) {
        this.address = address;
        return this;
    }

    public Customer getCustomer() {
        return new Customer(info);
    }
}
