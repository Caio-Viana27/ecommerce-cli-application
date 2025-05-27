package ecommerce.application.models.account;

import ecommerce.application.interfaces.Builder;

public class SellerBuilder extends Builder {

    @Override
    public Builder reset() {
        return this;
    }

    public Seller getSeller() {
        return null; // new Seller()
    }
}
