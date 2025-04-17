package ecommerce.application.views;

import ecommerce.application.interfaces.Menu;
import ecommerce.application.interfaces.IReport;
import ecommerce.application.interfaces.OnSelection;

import ecommerce.application.models.Program;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdministratorMenu extends Menu {
    private Map<String, OnSelection> menuActions;

    public AdministratorMenu(Scanner scanner) {
        super(scanner);

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
        System.out.println("    2 - Generate Report (most expensive order)");
        System.out.println("    3 - logout");
        System.out.println("    4 - Exit program");
        System.out.print(  "    Option: ");

        OnSelection menu = selectMenuOption();
        menu.action();
    }

    private OnSelection selectMenuOption() {

        boolean validOption = false;
        OnSelection menuOption = null;

        while (!validOption) {
            String option = scanner.nextLine();

            menuOption = menuActions.get(option);

            if (menuOption == null) {
                Message.invalidOption("option!");
            }
            else {
                validOption = true;
            }
        }
        return menuOption;
    }

//    public void storeMenu(Administrator adminAccount) {
//
//        while (true) {
//            Menu.Administrator();
//            String option = scanner.nextLine();
//
//            switch (option) {
//                case "0":
//                    Menu.createAccount();
//                    String choice = scanner.nextLine();
//
//                    switch (choice) {
//                        case "0":
//                            Menu.clearConsole();
//                            adminAccount.createAdministrator(scanner, accounts);
//                            break;
//                        case "1":
//                            Menu.clearConsole();
//                            adminAccount.createCustomer(scanner, accounts);
//                            break;
//                        default:
//                            Message.invalidOption("option!");
//                            break;
//                    }
//                    Menu.clearConsole();
//                    break;
//                case "1":
//                    Menu.clearConsole();
//                    adminAccount.createProduct(scanner, products);
//                    break;
//                case "2":
//                    Menu.clearConsole();
//                    if (accounts.isEmpty()) {
//                        Message.thereAreNoCustomers();
//                    }
//                    else {
//                        Menu.separator();
//                        Menu.report(this, new ReportMostExpensiveOrder());
//                    }
//                    break;
//                case "3":
//                    Menu.clearConsole();
//                    if (products.isEmpty()) {
//                        Message.thereAreNoProducts();
//                    }
//                    else {
//                        Menu.separator();
//                        Menu.report(this, new ReportLowestInventoryProduct());
//                    }
//                    break;
//                case "4":
//                    Menu.clearConsole();
//                    Menu.report(this, new FullReport());
//                    break;
//                case "5":
//                    Menu.clearConsole();
//                    loginInterface();
//                    break;
//                case "6":
//                    Menu.clearConsole();
//                    if (data.save(accounts, products)) {
//                        Message.dataSaved();
//                    }
//                    else {
//                        Message.dataNotSaved();
//                    }
//                    System.exit(0);
//                    break;
//                default:
//                    Menu.clearConsole();
//                    Message.invalidOption("option!");
//                    break;
//            }
//        }
//    }
}
