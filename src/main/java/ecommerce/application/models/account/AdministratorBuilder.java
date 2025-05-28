package ecommerce.application.models.account;

import ecommerce.application.interfaces.Builder;

public class AdministratorBuilder extends Builder {

    private AccountInfo info;

    @Override
    public Builder reset() {
        return this;
    }

    @Override
    public Builder setAccountInfo(AccountInfo info) {
        this.info = info;
        return this;
    }

    public Administrator getAdministrator() {
        return new Administrator(info);
    }
}
