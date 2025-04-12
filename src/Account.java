import java.io.Serializable;
import java.security.NoSuchAlgorithmException;

public abstract class Account implements Serializable {
    private String id;
    private String name;
    private String email;
    private Password AccountPassword;

    class Password implements Serializable {
        private byte[] salt;
        private String password;

        public Password(String createdPassword) {
            try {
                this.salt = PasswordEncryption.generateSalt();
                this.password = PasswordEncryption.generateEncryptedPassword(createdPassword, this.salt);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("Error hashing password", e);
            }
        }

        public boolean passwordMatches(String enteredPassword) {
            return this.password.equals(PasswordEncryption.generateEncryptedPassword(enteredPassword, this.salt));
        }

        // public void display() {
        // System.out.println("Password: " + password);
        // }
    }

    public Account(String name, String email, String password, String typeOfAccount) {
        this.id = new String(typeOfAccount + "." + IdGenerator.radomIdGenerator());
        this.name = name;
        this.email = email;
        this.AccountPassword = new Password(password);
    }

    public abstract void menu(Program program);

    public boolean emailMatches(String email) {
        return this.email.equals(email);
    }

    public boolean passwordMatches(String enteredPassword) {
        return this.AccountPassword.passwordMatches(enteredPassword);
    }

    public void display() {
        System.out.println("\nid: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        // this.AccountPassword.display();
    }
}
