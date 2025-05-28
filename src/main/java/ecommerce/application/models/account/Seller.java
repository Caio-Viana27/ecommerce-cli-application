package ecommerce.application.models.account;

import ecommerce.application.interfaces.Account;

public class Seller extends Account {
    private String cnpj = null;

    public Seller() {}

    public Seller(String name, String email, String password,String cnpj, String typeOfAccount) {
        super(name, email, password, typeOfAccount);
        this.cnpj = cnpj;
    }

    public Seller(AccountInfo info, String cnpj) {
        super(info);
        this.cnpj = cnpj;
    }
}
