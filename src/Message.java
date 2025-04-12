public class Message {

    public static void login() {
        System.out.println("Login");
    }
    public static void enterOption(String string) {
        System.out.print("Enter " + string + " or zero to exit: ");
    }

    public static void invalidOption(String string) {
        System.out.println("Invalid " + string);
    }

    public static void thereAreNoCustomers() {
        System.out.println("There are no customer accounts");
    }

    public static void thereAreNoOrders() {
        System.out.println("There are no orders yet");
    }

    public static void thereAreNoProducts() {
        System.out.println("There are no products yet");
    }

    public static void noProducts(String string) {
        System.out.println(string + "no products in the shopping cart!");
    }

    public static void productHasNoInventory() {
        System.out.println("Sorry, the selected product has no inventory");
    }

    public static void noProductsAvailable() {
        System.out.println("Sorry, there are no products!");
    }

    public static void dataFound() {
        System.out.println("Data loaded successfully!");
    }

    public static void dataNotSaved() {
        System.out.println("No saved data found!");
    }

    public static void dataSaved() {
        System.out.println("\nData saved successfully.");
    }

    public static void noDataFound() {
        System.out.println("No saved data found!");
    }
}