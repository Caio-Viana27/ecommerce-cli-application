package ecommerce.application.models.account;

import ecommerce.application.interfaces.Builder;

public class AccountsDirector {

    private Builder builder;

    public AccountsDirector(Builder builder) {
        this.builder = builder;
    }

    public void createAccount(AccountInfo info, String email, Address address, String cnpj) {
        builder.reset()
                .setAccountInfo(info)
                .setEmail(email)
                .setCNPJ(cnpj)
                .addAddress(address);
    }
}
