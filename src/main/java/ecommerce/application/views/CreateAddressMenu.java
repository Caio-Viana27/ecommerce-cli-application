package ecommerce.application.views;

import ecommerce.application.interfaces.Menu;

import java.util.Scanner;

public class CreateAddressMenu extends Menu {

    public CreateAddressMenu(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void draw() {

    }
}

//System.out.println("Address");
//        System.out.print("Postalcode: ");
//String postalCode = scanner.nextLine();
//
//        System.out.print("Street: ");
//String Street = scanner.nextLine();
//
//        System.out.print("city: ");
//String city = scanner.nextLine();
//
//        System.out.print("Apartment or house number: ");
//String apartmentOrHouseNumber = scanner.nextLine();