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

        OrderController controller = OrderController.getInstance();
        addMenu("2", controller::closeOrder);
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
        separator();
        System.out.println("    Menu order\n");
        System.out.println("    0 - Add product");
        System.out.println("    1 - View order");
        System.out.println("    2 - Finish order");
        System.out.print(  "    Option: ");

        OnSelection menu = selectOption();
        menu.action();
    }

    private OnSelection selectOption() {
        boolean validOption = false;
        OnSelection menuOption = null;

        while (!validOption) {
            String option = scanner.nextLine();

            menuOption = menuOptions.get(option);

            if (menuOption == null) {
                Message.invalidOption("option!");
            }
            else {
                validOption = true;
            }
        }
        return menuOption;
    }

    private void viewOrder() {
        Order order = OrderController.getInstance().getCurrentOrder();

        if (order == null) {
            Message.thereAreNoOrders();
            draw();
        }

        display(order);
        draw();
    }
}
