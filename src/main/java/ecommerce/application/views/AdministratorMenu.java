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

    public AdministratorMenu() {

        if (instance != null) {
            throw new RuntimeException();
        }
        instance = this;

        menuActions = new HashMap<>();

        Menu menu;

        menu = new CreateAccountMenu();
        addMenu("0", menu::draw);

        menu = new CreateProductMenu();
        addMenu("1", menu::draw);

        menu = new ReportMenu();
        addMenu("2", menu::draw);

        addMenu("3", () -> LoginMenu.getInstance().draw());

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
        clearConsole();
        separator();
        System.out.println("    Administrator Menu\n");
        System.out.println("    0 - Create new account");
        System.out.println("    1 - Create new product");
        System.out.println("    2 - Generate Report");
        System.out.println("    3 - Log out");
        System.out.println("    4 - Exit program\n");

        OnSelection menu = selectMenuOption();
        menu.action();
    }

    private OnSelection selectMenuOption() {
        OnSelection menuOption;

        while (true) {
            System.out.print("    Option: ");
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
