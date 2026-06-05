package ecommerce.application.models.account;;

public abstract class AccountBuilder {
    public abstract AccountBuilder reset();
    public AccountBuilder setUniqueIdentifier(UniqueIdentifier uniqueIdentifier) { return this; }
    public AccountBuilder setName(String name) { return this; }
    public AccountBuilder setEmail(Email email) { return this; }
    public AccountBuilder setPassword(String password) { return this; }
    public AccountBuilder addAddress(Address address) {
        return this;
    }
}
