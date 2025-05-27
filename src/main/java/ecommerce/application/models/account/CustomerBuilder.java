package ecommerce.application.models.account;

import ecommerce.application.interfaces.Builder;

public class CustomerBuilder extends Builder {

    @Override
    public Builder reset() {
        return this;
    }

    public Customer getCustomer() {
        return null; //new Customer()
    }
}
