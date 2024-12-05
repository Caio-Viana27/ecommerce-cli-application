import java.util.Scanner;

public class Menu {

    public static void invalidWarning(String string) {
        System.out.println("Invalid " + string);
    }

    public static void enterOption(String string) {
        System.out.print("Enter " + string + " or zero to exit: ");
    }

    public static void noProductWarning(String string) {
        System.out.println(string + "no products in the shopping cart!");
    }

    public static void separator() {
        System.out.println("\n=======================================================");
    }

    public static void Administrator() {
        Menu.separator();
        System.out.println("Administrator Menu");
        System.out.println("0 - Create new account");
        System.out.println("1 - Create new product");
        System.out.println("2 - Report (more expensive order)");
        System.out.println("3 - Report (product with lowest inventory)");
        System.out.println("4 - Exit");
        System.out.println("5 - Display everything");
        System.out.print("Option: ");
    }

    public static void createAccount() {
        Menu.separator();
        System.out.println("Menu create account");
        System.out.println("0 - to create a new admin");
        System.out.println("1 - to create a new customer");
        System.out.print("Option: ");
    }

    public static void Customer() {
        Menu.separator();
        System.out.println("Customer Menu");
        System.out.println("0 - Start new Order");
        System.out.println("1 - Exit");
        System.out.print("Option: ");
    }

    public static void startNewOrder() {
        Menu.separator();
        System.out.println("Menu start new order");
        System.out.println("0 - Add product");
        System.out.println("1 - View shopping cart");
        System.out.println("2 - Finish order");
        System.out.print("Option: ");
    }
}
