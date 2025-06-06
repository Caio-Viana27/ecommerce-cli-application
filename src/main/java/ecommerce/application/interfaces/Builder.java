package ecommerce.application.interfaces;

import ecommerce.application.models.Email;
import ecommerce.application.models.Address;

public abstract class Builder {
    public abstract Builder reset();
    public Builder setUniqueIdentifier(UniqueIdentifier uniqueIdentifier) { return this; }
    public Builder setName(String name) { return this; }
    public Builder setEmail(Email email) { return this; }
    public Builder setPassword(String password) { return this; }
    public Builder addAddress(Address address) {
        return this;
    }
}
