package ecommerce.application.models;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;

public class Password implements Serializable {
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
        return password.equals(PasswordEncryption.generateEncryptedPassword(enteredPassword, this.salt));
    }

    public String getPassword() {
        return password;
    }
}