package ecommerce.application.models.account;

import ecommerce.application.interfaces.UniqueIdentifier;
import ecommerce.application.models.Email;
import ecommerce.application.models.Password;
import java.io.Serializable;

public class AccountInfo implements Serializable {

    private UniqueIdentifier uniqueIdentifier;
    private String name;
    private Email email;
    private Password password;

    public AccountInfo(UniqueIdentifier uniqueIdentifier, String name, Email email, String password) {
        this.uniqueIdentifier = uniqueIdentifier;
        this.name = name;
        this.email = email;
        this.password = new Password(password);
    }

    public UniqueIdentifier getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public boolean passwordMatches(String enteredPassword) {
        return password.passwordMatches(enteredPassword);
    }
}