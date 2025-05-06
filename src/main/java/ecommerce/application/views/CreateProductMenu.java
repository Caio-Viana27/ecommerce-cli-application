package ecommerce.application.views;

import ecommerce.application.interfaces.Menu;
import ecommerce.application.models.Product;
import ecommerce.application.models.Program;

import java.util.Scanner;

public class CreateProductMenu extends Menu {

    public CreateProductMenu() {
    }

    @Override
    public void draw() {
        createProduct();
    }

    public void createProduct() {
        clearConsole();
        separator();
        System.out.println("    Menu Create product\n");
        System.out.print("    Name: ");
        String name = scanner.nextLine();

        double price = price();

        int inventory = inventory();

        System.out.print("    Description: ");
        String description = scanner.nextLine();

        System.out.print("    Category: ");
        String category = scanner.nextLine();

        Product newpProduct = new Product(name, price, inventory, description, category);
        Program.getInstance().getProductController().insertNewProduct(newpProduct);

        AdministratorMenu.getInstance().draw();
    }

    private double price() {
        while (true) {
            System.out.print("    Price: ");
            String strPrice = scanner.nextLine();

            try {
                return Double.parseDouble(strPrice);

            } catch (NumberFormatException e) {
                Message.invalidOption("price");
            }
        }
    }

    private int inventory() {
        while (true) {
            System.out.print("    Inventory: ");
            String strInventory = scanner.nextLine();

            try {
                int inventory = Integer.parseInt(strInventory);

                if (inventory < 0) {
                    Message.invalidOption("inventory");
                }
                else {
                    return inventory;
                }
            } catch (NumberFormatException e) {
                Message.invalidOption("inventory");
            }
        }
    }
}