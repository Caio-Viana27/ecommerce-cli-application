package ecommerce.application.models;

import java.io.Serializable;

public class AccountInfo implements Serializable {
    private String id;
    private String name;
    private String email;
    private Password password;

    public AccountInfo(String name, String email, String password, String typeOfAccount) {
        id = new String(typeOfAccount + "." + IdGenerator.radomIdGenerator());
        this.name = name;
        this.email = email;
        this.password = new Password(password);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean passwordMatches(String enteredPasswod) {
        return password.passwordMatches(enteredPasswod);
    }
}