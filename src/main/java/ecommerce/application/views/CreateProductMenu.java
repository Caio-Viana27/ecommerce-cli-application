package ecommerce.application.views;

import ecommerce.application.interfaces.Menu;
import ecommerce.application.models.Product;
import ecommerce.application.models.Program;

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

        System.out.println("\n    Menu Create product");
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
    }

    private Double price() {
        while (true) {
            System.out.print("    Price: ");
            String strPrice = scanner.nextLine();

            try {
                return Double.parseDouble(strPrice);

            } catch (NumberFormatException e) {
                Message.inlineInvalidOption("price");
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
                    Message.inlineInvalidOption("inventory");
                }
                else {
                    return inventory;
                }
            } catch (NumberFormatException e) {
                Message.inlineInvalidOption("inventory");
            }
        }
    }
}