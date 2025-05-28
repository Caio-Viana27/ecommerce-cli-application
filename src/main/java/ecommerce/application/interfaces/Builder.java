package ecommerce.application.interfaces;

import ecommerce.application.models.account.AccountInfo;
import ecommerce.application.models.account.Address;

public abstract class Builder {
    public abstract Builder reset();

    public Builder setAccountInfo(AccountInfo info) {
        return this;
    }
    public Builder setCNPJ(String cnpj) {
        return this;
    }
    public Builder addAddress(Address address) {
        return this;
    }
}
