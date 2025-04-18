package ecommerce.application.models;

import ecommerce.application.interfaces.Account;
import ecommerce.application.views.Message;

import java.util.Scanner;
import java.util.Map;

public class Administrator extends Account {
    private AccountType type = AccountType.Administrator;

    public Administrator(String name, String email, String password) {
        super(name, email, password, "admin");
    }

    public Administrator(AccountInfo info) {
        super(info);
    }

    @Override
    public AccountType login() {
        return type;
    }

    @Override
    public String toString() {
        String adminInfo;
        adminInfo = "<-- Administrator ------------------------------------------------------>\n\n";
        adminInfo += super.toString();
        return adminInfo;
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
}
