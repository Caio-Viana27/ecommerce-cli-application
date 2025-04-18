package ecommerce.application.views;

import ecommerce.application.interfaces.Menu;
import ecommerce.application.interfaces.OnSelection;
import ecommerce.application.models.Program;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomerMenu extends Menu {
    private static CustomerMenu instance = null;
    private Map<String, OnSelection> menuOptions;

    public CustomerMenu(Scanner scanner) {
        super(scanner);

        if (instance != null)
            throw new RuntimeException();

        instance = this;

        menuOptions = new HashMap<>();

        Menu menu = new OrderMenu(scanner);
        addMenu("0", menu::draw);

        addMenu("1", () -> {
            Login.getInstance().draw();
        });

        addMenu("2", () -> {
            Program.getInstance().exit();
        });
    }

    public static CustomerMenu getInstance() {
        return instance;
    }

    private void addMenu(String option, OnSelection action) {
        menuOptions.put(option, action);
    }

    @Override
    public void draw() {
        customer();
    }

    private void customer() {
        separator();
        System.out.println("    Customer Menu\n");
        System.out.println("    0 - New order");
        System.out.println("    1 - Log out");
        System.out.println("    2 - Exit program");
        System.out.print("    Option: ");

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
                Message.invalidOption("");
            } else {
                validOption = true;
            }
        }
        return menuOption;
    }
}