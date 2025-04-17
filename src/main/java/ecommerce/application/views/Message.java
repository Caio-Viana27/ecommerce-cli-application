package ecommerce.application.views;

import ecommerce.application.interfaces.Menu;

public class Message {

    public static void login() {
        System.out.println("    Login");
    }
    public static void enterOption(String string) {
        System.out.print("    Enter " + string + " or zero to exit: ");
    }

    public static void invalidOption(String string) {
        Menu.separator();
        System.out.println("    Invalid " + string);
    }

    public static void thereAreNoCustomers() {
        Menu.separator();
        System.out.println("    There are no customer accounts");
    }

    public static void thereAreNoOrders() {
        Menu.separator();
        System.out.println("    There are no orders yet");
    }

    public static void thereAreNoProducts() {
        Menu.separator();
        System.out.println("    There are no products yet");
    }

    public static void noProducts(String string) {
        Menu.separator();
        System.out.println("    " + string + "no products in the shopping cart!");
    }

    public static void productHasNoInventory() {
        Menu.separator();
        System.out.println("    Sorry, the selected product has no inventory");
    }

    public static void noProductsAvailable() {
        Menu.separator();
        System.out.println("    Sorry, there are no products!");
    }

    public static void dataFound() {
        Menu.separator();
        System.out.println("    Data loaded successfully!");
    }

    public static void dataNotSaved() {
        Menu.separator();
        System.out.println("    Unable to save data!");
        Menu.separator();
    }

    public static void dataSaved() {
        Menu.separator();
        System.out.println("    Data saved successfully.");
        Menu.separator();
    }

    public static void noDataFound() {
        Menu.separator();
        System.out.println("    No saved data found!");
    }
}