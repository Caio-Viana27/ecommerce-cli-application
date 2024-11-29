import java.util.Scanner;
import java.util.LinkedList;

public class Administrator extends Account {

    public Administrator(String name, String email, String password) {
        super(name, email, password, "admin");
    }

    public Administrator createAdministrator(Scanner scanner) {

        System.out.println("\nMenu create admin");
        System.out.print("Set Name: ");
        String name = scanner.nextLine();

        System.out.print("Set email: ");
        String email = scanner.nextLine();

        System.out.print("Set password: ");
        String password = scanner.nextLine();

        return new Administrator(name, email, password);
    }

    public Customer createCustomer(Scanner scanner) {

        System.out.println("\nMenu create customer");
        System.out.print("Set Name: ");
        String name = scanner.nextLine();

        System.out.print("Set email: ");
        String email = scanner.nextLine();

        System.out.print("set password: ");
        String password = scanner.nextLine();

        System.out.println("Set address");
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
        System.out.print("Product Name: ");
        String name = scanner.nextLine();

        System.out.print("Product Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Product inventory: ");
        int availableProducts = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Products description: ");
        String description = scanner.nextLine();

        System.out.print("Products category: ");
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
