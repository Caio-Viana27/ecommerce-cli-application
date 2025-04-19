package ecommerce.application.views;

import ecommerce.application.controllers.OrderController;
import ecommerce.application.interfaces.Menu;
import ecommerce.application.interfaces.OnSelection;
import ecommerce.application.models.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OrderMenu extends Menu {
    public static OrderMenu instance;
    private Map<String, OnSelection> menuOptions;

    public OrderMenu(Scanner scanner) {
        super(scanner);

        if (instance != null) {
            throw new RuntimeException();
        }
        instance = this;

        menuOptions = new HashMap<>();

        Menu menu = new SelectProductMenu(scanner);
        addMenu("0", menu::draw);

        addMenu("1", this::viewOrder);

        addMenu("2", () -> {
            clearConsole();

            OrderController controller = OrderController.getInstance();
            if (controller.closeOrder()) {
                Message.orderFinished();
            }
            else {
                Message.noProducts();
            }
            Message.pressAnyKeyToExit();
            scanner.nextLine();

            CustomerMenu.getInstance().draw();
        });
    }

    public static OrderMenu getInstance() {
        return instance;
    }

    private void addMenu(String option, OnSelection action) {
        menuOptions.put(option, action);
    }

    @Override
    public void draw() {
        order();
    }

    private void order() {
        clearConsole();
        separator();
        System.out.println("    Menu order\n");
        System.out.println("    0 - Add product");
        System.out.println("    1 - View order");
        System.out.println("    2 - Finish order\n");

        OnSelection menu = selectOption();
        menu.action();
    }

    private OnSelection selectOption() {
        while (true) {
            System.out.print("    Option: ");
            String option = scanner.nextLine();

            OnSelection menuOption = menuOptions.get(option);

            if (menuOption != null) {
                return menuOption;
            }
            Message.invalidOption("option!");
        }
    }

    private void viewOrder() {
        clearConsole();
        separator();

        Order order = OrderController.getInstance().getCurrentOrder();

        if (order == null) {
            Message.thereAreNoOrders();
            draw();
        }

        display(order);

        Message.pressAnyKeyToExit();
        scanner.nextLine();

        draw();
    }
}
