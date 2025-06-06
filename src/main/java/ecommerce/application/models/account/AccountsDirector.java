package ecommerce.application.models.account;

import ecommerce.application.interfaces.Builder;
import ecommerce.application.interfaces.UniqueIdentifier;
import ecommerce.application.models.Address;
import ecommerce.application.models.Email;

public class AccountsDirector {

    private Builder builder;

    public AccountsDirector(Builder builder) {
        this.builder = builder;
    }

    public void createAccount(UniqueIdentifier uniqueIdentifier, String name, Email email, String password, Address address) {
        builder.reset()
                .setUniqueIdentifier(uniqueIdentifier)
                .setName(name)
                .setEmail(email)
                .setPassword(password)
                .addAddress(address);
    }
}
