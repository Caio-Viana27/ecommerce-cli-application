package ecommerce.application.models;

import java.io.Serializable;

public class Address implements Serializable {
    private String postalcode;
    private String street;
    private String city;
    private String appartmentOrHouseNumber;

    public Address(String postalcode, String street, String city, String appartmentOrHouseNumber) {
        this.postalcode = postalcode;
        this.street = street;
        this.city = city;
        this.appartmentOrHouseNumber = appartmentOrHouseNumber;
    }

    public void display() {
        System.out.println("    Postalcode: " + postalcode);
        System.out.println("    Street: " + street);
        System.out.println("    City: " + city);
        System.out.println("    House number: " + appartmentOrHouseNumber);
    }
}
