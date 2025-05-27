package ecommerce.application.views;

import ecommerce.application.interfaces.Menu;
import ecommerce.application.interfaces.OnSelection;
import ecommerce.application.models.Program;

import java.util.HashMap;
import java.util.Map;

public class CustomerMenu extends Menu {
    private final Map<String, OnSelection> menuOptions;

    public CustomerMenu() {
        menuOptions = new HashMap<>();
    }

    public void init() {
        addMenu("0", MenuManager.instance().getMenu(OrderMenu.class)::draw);
        addMenu("1", MenuManager.instance().getMenu(SignInMenu.class)::draw);
        addMenu("2", Program.getInstance()::exit);
    }

    private void addMenu(String option, OnSelection action) {
        menuOptions.put(option, action);
    }

    @Override
    public void draw() {
        init();
        menu();
    }

    private void menu() {
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