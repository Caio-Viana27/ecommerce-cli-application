package ecommerce.application.models.account;

import java.io.Serializable;

public class Address implements Serializable {
    private String postalcode;
    private String street;
    private String city;
    private String apartmentOrHouseNumber;

    public Address(String postalcode, String street, String city, String apartmentOrHouseNumber) {
        this.postalcode = postalcode;
        this.street = street;
        this.city = city;
        this.apartmentOrHouseNumber = apartmentOrHouseNumber;
    }

    public String toString() {
        String deliveryAddressInfo;
        deliveryAddressInfo  = "    Delivery address:\n";
        deliveryAddressInfo += "    Postalcode: " + postalcode + "\n";
        deliveryAddressInfo += "    Street: " + street + "\n";
        deliveryAddressInfo += "    City: " + city + "\n";
        deliveryAddressInfo += "    House number: " + apartmentOrHouseNumber + "\n";
        deliveryAddressInfo += "\n";
        return deliveryAddressInfo;
    }
}
