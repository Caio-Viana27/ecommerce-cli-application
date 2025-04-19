package ecommerce.application.views;

import ecommerce.application.controllers.OrderController;
import ecommerce.application.interfaces.Menu;
import ecommerce.application.models.Product;
import ecommerce.application.models.Program;
import ecommerce.application.models.ShoppingCart;

import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

public class SelectProductMenu extends Menu {

    public SelectProductMenu(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void draw() {
        ProductMenu();
    }

    public void ProductMenu() {
        clearConsole();
        separator();

        Map<String, Product> products = Program.getInstance().getProductsMap();

        if (products.isEmpty()) {
            Message.noProductsAvailable();
            OrderMenu.getInstance().draw();
        }

        separator();
        System.out.println("    Products List");
        separator();

        for (Product product : products.values()) {
            display(product);
        }

        separator();
        System.out.println("    Select a product id or zero to exit:");

        Product product = selectProduct(products);

        if (product == null) {
            OrderMenu.getInstance().draw();
        }

        System.out.println("    Select the amount:");
        int amount = selectAmount(product);

        Program.getInstance().getOrderController().newOrder(product, amount);
    }

    private Product selectProduct(Map<String, Product> products) {
        while (true) {
            System.out.print("    ID: ");
            String id = scanner.nextLine();

            if ("0".equals(id)) {
                return null;
            }

            Product product = products.get(id);

            if (product == null) {
                Message.invalidOption("id!");
            }
            else {
                return product;
            }
        }
    }

    private int selectAmount(Product product) {
        while (true) {
            System.out.print("    Amount: ");
            String strAmount = scanner.nextLine();

            int amount;

            try {
                amount = Integer.parseInt(strAmount, 10);

                if (amount <= 0 || !Product.hasEnoughInventory(product, amount)) {
                    Message.invalidOption("Amount!");
                }
                else {
                    return amount;
                }

            } catch (NumberFormatException e) {
                Message.invalidOption("Amount!");
            }
        }
    }
}