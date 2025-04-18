package ecommerce.application.views;

import ecommerce.application.interfaces.Account;
import ecommerce.application.interfaces.Menu;
import ecommerce.application.interfaces.OnSelection;
import ecommerce.application.models.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CreateAccountMenu extends Menu {
    private Map<String, OnSelection> menuOptions;

    public CreateAccountMenu(Scanner scanner) {
        super(scanner);

        menuOptions = new HashMap<>();

        addMenu("0", this::createAdministrator);
        addMenu("1", this::createCustomer);
        addMenu("2", AdministratorMenu.getInstance()::draw);
    }

    private void addMenu(String option, OnSelection action) {
        menuOptions.put(option, action);
    }

    @Override
    public void draw() {
        createAccount();
    }

    private void createAccount() {
        clearConsole();
        separator();
        System.out.println("    Create Account\n");
        System.out.println("    0 - Create new Administrator");
        System.out.println("    1 - Create new Customer");
        System.out.println("    2 - Return");

        OnSelection menu = selectOption();
        menu.action();
    }

    private OnSelection selectOption() {
        while (true) {
            System.out.print("    option: ");
            String option = scanner.nextLine();

            OnSelection menuAction = menuOptions.get(option);

            if (menuAction == null) {
                Message.invalidOption("");
            }
            else {
                return menuAction;
            }
        }
    }

    private void createAdministrator() {
        clearConsole();
        separator();
        System.out.println("    Menu create admin\n");

        AccountInfo info = createAccountInfo();

        Program.getInstance().getAccountController().insertNewAccount(new Administrator(info));

        AdministratorMenu.getInstance().draw();
    }

    private void createCustomer() {
        System.out.println("    Menu create customer\n");

        AccountInfo info = createAccountInfo();

        Program.getInstance().getAccountController().insertNewAccount(new Customer(info));

        AdministratorMenu.getInstance().draw();
    }

    private AccountInfo createAccountInfo() {
        System.out.print("    Name: ");
        String name = scanner.nextLine();

        String email = createAccountEmail();

        System.out.print("    Password: ");
        String password = scanner.nextLine();

        return new AccountInfo(name, email, password);
    }

    private String createAccountEmail() {
        Map<String, Account> accounts = Program.getInstance().getAccountsMap();

        String email;
        do {
            System.out.print("    Email: ");
            email = scanner.nextLine();

            if (accounts.get(email) != null) {
                separator();
                Message.invalidOption("    Email [this email already exists]");
            }

        } while (accounts.get(email) != null);

        return email;
    }
}