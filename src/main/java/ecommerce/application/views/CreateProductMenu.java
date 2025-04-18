package ecommerce.application.views;

import ecommerce.application.interfaces.Menu;
import ecommerce.application.models.Product;

import java.util.Map;
import java.util.Scanner;

public class CreateProductMenu extends Menu {

    public CreateProductMenu(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void draw() {
        createProduct();
    }

    public void createProduct() {

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