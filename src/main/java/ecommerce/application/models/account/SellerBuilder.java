package ecommerce.application.models.account;

import ecommerce.application.interfaces.Builder;

public class SellerBuilder extends Builder {

    private AccountInfo info;
    private String cnpj;

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
    public Builder setCNPJ(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public Seller getSeller() {
        return new Seller(info, null);
    }
}
