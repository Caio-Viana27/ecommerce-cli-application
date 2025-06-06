package ecommerce.application.models;

import ecommerce.application.interfaces.UniqueIdentifier;

public class CNPJ extends UniqueIdentifier {
    private final String cnpj;

    public CNPJ(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "CNPJ: " + this.cnpj;
    }
}
