package ecommerce.application.models.account;

public class CPF extends UniqueIdentifier {
    private final String cpf;

    public CPF(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "CPF: " + this.cpf;
    }
}
