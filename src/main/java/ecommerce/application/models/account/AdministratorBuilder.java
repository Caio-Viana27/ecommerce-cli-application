package ecommerce.application.models.account;

import ecommerce.application.interfaces.Builder;

public class AdministratorBuilder extends Builder {

    @Override
    public Builder reset() {
        return this;
    }

    public Administrator getAdministrator() {
        return null; //new Administrator()
    }
}
