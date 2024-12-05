import java.util.Scanner;
import java.util.LinkedList;

public class Administrator extends Account {

    public Administrator(String name, String email, String password) {
        super(name, email, password, "admin");
    }

    public Administrator createAdministrator(Scanner scanner, Program program) {

        System.out.println("\nMenu create admin");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        String email = null;
        boolean validEmail = false;
        while (!validEmail) {
            System.out.print("Email: ");
            email = scanner.nextLine();

            if (!program.emailAlreadyExist(email)) {
                validEmail = true;
            } else
                Menu.invalidWarning("email [this email already exist]");
        }

        System.out.print("Password: ");
        String password = scanner.nextLine();

        return new Administrator(name, email, password);
    }

    public Customer createCustomer(Scanner scanner) {

        System.out.println("\nMenu create customer");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

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

        return new Customer(name, email, password, myAddress);
    }

    public Product createProduct(Scanner scanner) {

        System.out.println("\nCreate product menu");
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

        return new Product(name, price, availableProducts, description, category);
    }

    public void createReportMoreExpensiveOrder(LinkedList<Customer> customersList) {
        if (customersList.size() == 0) {
            System.out.println("There are no customer accounts");
            return;
        }
        Order mostExpensiveOrder = null;
        for (var customer : customersList) {
            if (customer.hasHistoryOrder()) {
                mostExpensiveOrder = customer.searchMoreExpensiveOrder(mostExpensiveOrder);
            }
        }
        if (mostExpensiveOrder == null) {
            System.out.println("There are no orders yet");
            return;
        }
        mostExpensiveOrder.display();
    }

    public void createReportLowestInventoryProduct(LinkedList<Product> productList) {

        if (productList.size() == 0) {
            System.out.println("There are no products yet");
            return;
        }
        Product lowestInventoryProduct = null;

        for (var product : productList) {
            if (lowestInventoryProduct == null || !lowestInventoryProduct.hasLowertInventory(product)) {
                lowestInventoryProduct = product;
            }
        }
        lowestInventoryProduct.display();
    }
}
