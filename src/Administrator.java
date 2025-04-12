import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Administrator extends Account {

    public Administrator(String name, String email, String password) {
        super(name, email, password, "admin");
    }

    private String getValidEmail(Scanner scanner, Map<String, Account> accounts) {

        String email;
        do {
            System.out.print("Email: ");
            email = scanner.nextLine();
            if (accounts.get(email) != null)
                Message.invalidOption("email [this email already exist]");
        } while (accounts.get(email) != null);

        return email;
    }

    public void menu(Program program) {
        program.storeMenu(this);
    }

    public void createAdministrator(Scanner scanner, Map<String, Account> accounts) {

        System.out.println("\nMenu create admin");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        String email = getValidEmail(scanner, accounts);

        System.out.print("Password: ");
        String password = scanner.nextLine();

        accounts.put(email, new Administrator(name, email, password));
    }

    public void createCustomer(Scanner scanner, Map<String, Account> accounts) {

        System.out.println("\nMenu create customer");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        String email = getValidEmail(scanner, accounts);

        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.println("Address");
        System.out.print("Postalcode: ");
        String postalCode = scanner.nextLine();

        System.out.print("Street: ");
        String Street = scanner.nextLine();

        System.out.print("city: ");
        String city = scanner.nextLine();

        System.out.print("Appartment or house number: ");
        String appartmentOrHouseNumber = scanner.nextLine();

        Address myAddress = new Address(postalCode, Street, city, appartmentOrHouseNumber);

        accounts.put(email, new Customer(name, email, password, myAddress));
    }

    public void createProduct(Scanner scanner, Map<String, Product> products) {

        System.out.println("\nMenu Create product");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Inventory: ");
        int availableProducts = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Category: ");
        String category = scanner.nextLine();

        Product newpProduct = new Product(name, price, availableProducts, description, category);
        products.put(newpProduct.getId(), newpProduct);
    }

    public void createReportLowestInventoryProduct(Map<String, Product> products) {

        Product lowestInventoryProduct = null;

        for (Map.Entry<String, Product> entry : products.entrySet()) {
            if (lowestInventoryProduct == null || !lowestInventoryProduct.hasLowertInventory(entry.getValue())) {
                lowestInventoryProduct = entry.getValue();
            }
        }
        lowestInventoryProduct.display();
    }
}
