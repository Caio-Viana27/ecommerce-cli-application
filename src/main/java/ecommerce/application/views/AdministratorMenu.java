package ecommerce.application.views;

import ecommerce.application.interfaces.Menu;
import ecommerce.application.interfaces.OnSelection;

import ecommerce.application.models.Program;

import java.util.HashMap;
import java.util.Map;

public class AdministratorMenu extends Menu {
    private final Map<String, OnSelection> menuActions;

    public AdministratorMenu() {
        menuActions = new HashMap<>();
    }

    public void init() {
        addMenu("0", MenuManager.instance().getMenu(CreateAccountMenu.class)::draw);
        addMenu("1", MenuManager.instance().getMenu(CreateProductMenu.class)::draw);
        addMenu("2", MenuManager.instance().getMenu(ReportMenu.class)::draw);
        addMenu("3", () -> {
            SignInMenu.selectLoginMethod().draw();
        });
        addMenu("4", () -> Program.Instance().exit());
    }

    private void addMenu(String option, OnSelection action) {
        menuActions.put(option, action);
    }

    @Override
    public void draw() {
        init();
        menu();
    }

    private void menu() {
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
