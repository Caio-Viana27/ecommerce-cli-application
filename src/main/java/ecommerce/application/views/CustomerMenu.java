package ecommerce.application.views;

import ecommerce.application.interfaces.Menu;
import ecommerce.application.interfaces.OnSelection;
import ecommerce.application.models.Program;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomerMenu extends Menu {
    private static CustomerMenu instance = null;
    private final Map<String, OnSelection> menuOptions;

    public CustomerMenu() {

        if (instance != null)
            throw new RuntimeException();

        instance = this;

        menuOptions = new HashMap<>();

        Menu menu = new OrderMenu();
        addMenu("0", menu::draw);

        addMenu("1", () -> LoginMenu.getInstance().draw());

        addMenu("2", () -> Program.getInstance().exit());
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
        clearConsole();
        separator();
        System.out.println("    Customer Menu\n");
        System.out.println("    0 - New order");
        System.out.println("    1 - Log out");
        System.out.println("    2 - Exit program\n");

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
            Message.invalidOption("option");
        }
    }
}