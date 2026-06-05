package ecommerce.application.views;

import ecommerce.application.Program;

import java.util.HashMap;
import java.util.Map;

public class AdministratorMenu extends Menu {
    private final Map<String, OnSelection> menuActions;

    public AdministratorMenu() {
        menuActions = new HashMap<>();

        addMenu("0", MenuManager.instance().getMenu(CreateAccountMenu.class)::draw);
        addMenu("1", MenuManager.instance().getMenu(CreateProductMenu.class)::draw);
        addMenu("2", MenuManager.instance().getMenu(ReportMenu.class)::draw);
        addMenu("3", MenuManager.instance().getMenu(ReportMenu.class)::draw);
        addMenu("4", new LoginMenu().selectLoginMethod()::draw);
        addMenu("5", () -> Program.Instance().exit());
    }

    @Override
    public void draw() {
        clearConsole();
        separator();
        System.out.println("    Administrator Menu\n");
        System.out.println("    0 - Create new account");
        System.out.println("    1 - Create new product");
        System.out.println("    2 - Delete account");
        System.out.println("    3 - Generate Report");
        System.out.println("    4 - Log out");
        System.out.println("    5 - Exit program\n");

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

    private void addMenu(String option, OnSelection action) {
        menuActions.put(option, action);
    }
}
