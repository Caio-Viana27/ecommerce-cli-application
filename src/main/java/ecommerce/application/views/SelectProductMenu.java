package ecommerce.application.views;

import ecommerce.application.interfaces.Menu;
import ecommerce.application.models.product.Product;
import ecommerce.application.models.Program;

import java.util.Map;

public class SelectProductMenu extends Menu {

    public SelectProductMenu() {
    }

    @Override
    public void draw() {
        menu();
    }

    public void menu() {
        clearConsole();

        Map<Long, Product> products = Program.Instance().getProductController().getProductsMap();

        if (products.isEmpty()) {
            Message.noProductsAvailable();
            MenuManager.instance().getMenu(OrderMenu.class).draw();
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
            MenuManager.instance().getMenu(OrderMenu.class).draw();
        }

        System.out.println("    Select the amount:");
        int amount = selectAmount(product);

        Program.Instance().getOrderController().newOrder(product, amount);

        MenuManager.instance().getMenu(OrderMenu.class).draw();
    }

    private Product selectProduct(Map<Long, Product> products) {
        while (true) {
            System.out.print("    ID: ");
            String productId = scanner.nextLine();

            if ("0".equals(productId)) {
                return null;
            }

            long id;
            Product product;
            try {
                id = Long.parseLong(productId);
            } catch (NumberFormatException e) {
                Message.invalidOption("id!");
                continue;
            }
            product = products.get(id);

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