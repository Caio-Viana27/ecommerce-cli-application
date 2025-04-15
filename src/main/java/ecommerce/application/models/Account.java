package ecommerce.application.models;

import java.io.Serializable;

public abstract class Account implements Serializable {
    private String id;
    private String name;
    private String email;
    private Password AccountPassword;

    public Account(String name, String email, String password, String typeOfAccount) {
        this.id = new String(typeOfAccount + "." + IdGenerator.radomIdGenerator());
        this.name = name;
        this.email = email;
        this.AccountPassword = new Password(password);
    }

    public abstract void menu(Program program);

    public boolean emailMatches(String email) {
        return email.equals(this.email);
    }

    public boolean passwordMatches(String enteredPassword) {
        return this.AccountPassword.passwordMatches(enteredPassword);
    }

    public void display() {
        System.out.println("    id: " + id);
        System.out.println("    Name: " + name);
        System.out.println("    Email: " + email + "\n");
    }
}
