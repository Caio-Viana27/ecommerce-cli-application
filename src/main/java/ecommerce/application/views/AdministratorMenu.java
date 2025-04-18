package ecommerce.application.views;

import ecommerce.application.interfaces.Menu;
import ecommerce.application.interfaces.OnSelection;

import ecommerce.application.models.Program;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdministratorMenu extends Menu {
    private static AdministratorMenu instance;
    private Map<String, OnSelection> menuActions;

    public AdministratorMenu(Scanner scanner) {
        super(scanner);

        if (instance != null) {
            throw new RuntimeException();
        }
        instance = this;

        menuActions = new HashMap<>();

        Menu menu;

        menu = new CreateAccountMenu(scanner);
        addMenu("0", menu::draw);

        menu = new CreateProductMenu(scanner);
        addMenu("1", menu::draw);

        menu = new ReportMenu(scanner);
        addMenu("2", menu::draw);

        addMenu("3", () -> Login.getInstance().draw());

        addMenu("4", () -> Program.getInstance().exit());
    }

    public static AdministratorMenu getInstance() {
        return instance;
    }

    private void addMenu(String option, OnSelection action) {
        menuActions.put(option, action);
    }

    @Override
    public void draw() {
        administrator();
    }

    private void administrator() {
        separator();
        System.out.println("    Administrator Menu\n");
        System.out.println("    0 - Create new account");
        System.out.println("    1 - Create new product");
        System.out.println("    2 - Generate Report");
        System.out.println("    3 - Logout");
        System.out.println("    4 - Exit program");
        System.out.print(  "    Option: ");

        OnSelection menu = selectMenuOption();
        menu.action();
    }

    private OnSelection selectMenuOption() {
        OnSelection menuOption;

        while (true) {
            String option = scanner.nextLine();

            menuOption = menuActions.get(option);

            if (menuOption == null) {
                Message.invalidOption("option!");
            }
            else {
                return menuOption;
            }
        }
    }
}
