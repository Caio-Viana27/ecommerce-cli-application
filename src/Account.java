import java.io.Serializable;

public abstract class Account implements Serializable {
    private String id;
    private String name;
    private String email;
    private String password;

    // abstract void logIn();

    // abstract void logOut();
    public Account(String name, String email, String password, String typeOfAccount) {
        this.id = new String(typeOfAccount + "." + IdGenerator.radomIdGenerator());
        this.name = name;
        this.email = email;
        this.password = Account.passwordEncryption(password);
    }

    public boolean emailMatches(String email) {
        return this.email.equals(email);
    }

    public boolean passwordMatches(String password) {
        return this.password.equals(password);
    }

    private String passwordDecryption(String encryptedPassword) {
        return encryptedPassword;
    }

    private static String passwordEncryption(String password) {
        return password;
    }

    public void display() {
        System.out.println("\nid: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("password: " + password);
    }
}
