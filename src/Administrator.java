import java.util.Scanner;

public class Administrator extends Account {

    public Administrator(String name, String email, String password) {
        super(name, email, password, "admin");
    }

    public Administrator createAdministrator(Scanner scanner) {

        System.out.println("Menu create admin\n");
        System.out.print("Set Name: ");
        String name = scanner.nextLine();
        System.out.println();

        System.out.print("Set email: ");
        String email = scanner.nextLine();
        System.out.println();

        System.out.print("Set password: ");
        String password = scanner.nextLine();
        System.out.println();

        return new Administrator(name, email, password);
    }

    public Customer createCustomer(Scanner scanner) {

        System.out.println("Menu create customer\n");
        System.out.print("Set Name: ");
        String name = scanner.nextLine();
        System.out.println();

        System.out.print("Set email: ");
        String email = scanner.nextLine();
        System.out.println();

        System.out.print("set password: ");
        String password = scanner.nextLine();
        System.out.println();

        System.out.println("Set address");
        System.out.print("Postalcode: ");
        String postalCode = scanner.nextLine();
        System.out.println();

        System.out.print("Street: ");
        String Street = scanner.nextLine();
        System.out.println();

        System.out.print("city: ");
        String city = scanner.nextLine();
        System.out.println();

        System.out.print("Appartment or house number: ");
        String appartmentOrHouseNumber = scanner.nextLine();
        System.out.println();

        Address myAddress = new Address(postalCode, Street, city, appartmentOrHouseNumber);

        return new Customer(name, email, password, myAddress);
    }

    public Product createProduct(Scanner scanner) {

        System.out.println("Create product menu");
        System.out.print("Product Name: ");
        String name = scanner.nextLine();
        System.out.println();

        System.out.print("Product Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println();

        System.out.print("Amount of Products available: ");
        int availableProducts = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        System.out.print("Products description: ");
        String description = scanner.nextLine();
        System.out.println();

        System.out.print("Products category: ");
        String category = scanner.nextLine();
        System.out.println();

        return new Product(name, price, availableProducts, description, category);
    }

    public void createReportMoreExpensiveOrder() {

    }

    public void createReportLowestProductInventory() {

    }
}
