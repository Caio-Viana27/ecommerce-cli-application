package ecommerce.application.models;

import java.io.Serializable;

public class Address implements Serializable {
    private PostalCode postalcode;
    private String street;
    private String city;
    private String houseNumber;

    public Address(PostalCode postalcode, String street, String city, String houseNumber) {
        this.postalcode = postalcode;
        this.street = street;
        this.city = city;
        this.houseNumber = houseNumber;
    }

    public String toString() {
        String deliveryAddressInfo;
        deliveryAddressInfo  = "    Delivery address:\n";
        deliveryAddressInfo += "    Postal Code: " + postalcode + "\n";
        deliveryAddressInfo += "    Street: " + street + "\n";
        deliveryAddressInfo += "    City: " + city + "\n";
        deliveryAddressInfo += "    House number: " + houseNumber + "\n";
        deliveryAddressInfo += "\n";
        return deliveryAddressInfo;
    }
}
