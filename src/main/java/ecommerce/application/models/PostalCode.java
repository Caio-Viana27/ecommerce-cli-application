package ecommerce.application.models;

import java.io.Serializable;

public class PostalCode implements Serializable {
    String code;

    public PostalCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
