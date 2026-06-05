package ecommerce.application.models.account;

public class AccountsDirector {

    private AccountBuilder builder;

    public AccountsDirector(AccountBuilder builder) {
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
