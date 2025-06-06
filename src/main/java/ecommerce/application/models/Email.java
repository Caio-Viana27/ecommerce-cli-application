package ecommerce.application.models;

import java.io.Serializable;

public class Email implements Serializable {
    private final String email;

    public Email(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return this.email;
    }
}
