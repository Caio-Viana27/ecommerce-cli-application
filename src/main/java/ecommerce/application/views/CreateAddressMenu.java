package ecommerce.application.views;

import ecommerce.application.interfaces.Menu;
import ecommerce.application.models.Address;
import ecommerce.application.models.PostalCode;

public class CreateAddressMenu extends Menu {
    private Address createdAddress;

    public CreateAddressMenu() {}

    @Override
    public void draw() {
        createdAddress = null;
        menu();
    }

    private void menu() {
        separator();
        System.out.println("    Create Address\n");

        System.out.println("    Postal Code");
        var postalCode = getPostalCode();
        System.out.println("    City");
        var city = getCity();
        System.out.println("    Street");
        var street = getStreet();
        System.out.println("    House number");
        var houseNumber = getHouseNumber();

        createdAddress = new Address(postalCode, street,  city,  houseNumber);
    }

    public Address getAddress() {
        return createdAddress;
    }

    private PostalCode getPostalCode() {
        while (true) {
            System.out.print("    : ");
            String postalCode = scanner.nextLine();

            if (!"".equals(postalCode)) {
                return new PostalCode(postalCode);
            }

            Message.invalidOption("input!");
        }
    }

    private String getCity() {
        while (true) {
            System.out.print("    : ");
            String city = scanner.nextLine();

            if (!"".equals(city) && containsOnlyValidChars(city)) {
                return city;
            }

            Message.invalidOption("input!");
        }
    }

    private String getStreet() {
        while (true) {
            System.out.print("    : ");
            String street = scanner.nextLine();

            if (!"".equals(street)) {
                return street;
            }

            Message.invalidOption("input!");
        }
    }

    private String getHouseNumber() {
        while (true) {
            System.out.print("    : ");
            String houseNumber = scanner.nextLine();

            if (!"".equals(houseNumber)) {
                return houseNumber;
            }

            Message.invalidOption("input!");
        }
    }

    private boolean containsOnlyValidChars(String string) {
        int numValidChars = 0;
        for (int index = 0; index < string.length(); index++) {

            if ( (string.charAt(index) >= 'A' && string.charAt(index) <= 'Z') ||
                    (string.charAt(index) >= 'a' && string.charAt(index) <= 'z') ||
                    (string.charAt(index) == ' '))
            {
                numValidChars++;
            }
        }
        return numValidChars == string.length();
    }
}