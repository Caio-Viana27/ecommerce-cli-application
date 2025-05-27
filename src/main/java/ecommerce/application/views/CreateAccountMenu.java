package ecommerce.application.views;

import ecommerce.application.interfaces.Account;
import ecommerce.application.interfaces.Menu;
import ecommerce.application.interfaces.OnSelection;
import ecommerce.application.models.*;
import ecommerce.application.models.account.AccountInfo;
import ecommerce.application.models.account.Administrator;
import ecommerce.application.models.account.Customer;
import ecommerce.application.models.account.Seller;

import java.util.HashMap;
import java.util.Map;

public class CreateAccountMenu extends Menu {
    private final Map<String, OnSelection> menuOptions;

    public CreateAccountMenu() {

        menuOptions = new HashMap<>();

        addMenu("0", this::createAdministrator);
        addMenu("1", this::createCustomer);
        addMenu("2",  MenuManager.instance().getMenu(AdministratorMenu.class)::draw);
    }

    private void addMenu(String option, OnSelection action) {
        menuOptions.put(option, action);
    }

    @Override
    public void draw() {
        clearConsole();
        separator();
        System.out.println("    Create Account\n");
        System.out.println("    0 - Create new Administrator");
        System.out.println("    1 - Create new Customer");
        System.out.println("    2 - Return\n");

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

        MenuManager.instance().getMenu(SignInMenu.class).draw();
    }

    private void createCustomer() {
        clearConsole();
        separator();
        System.out.println("    Menu create customer\n");

        AccountInfo info = createAccountInfo();

        Program.getInstance().getAccountController().insertNewAccount(new Customer(info));

        MenuManager.instance().getMenu(SignInMenu.class).draw();
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
        Map<String, Account> accounts = Program.getInstance().getAccountController().getAccountsMap();

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

    public Class<? extends Account> selectAccountType() {

        while (true) {
            clearConsole();
            separator();
            System.out.println("    Select account type\n");
            System.out.println("    0 - Customer");
            System.out.println("    1 - Seller");
            System.out.println("    2 - Exit\n");
            System.out.print(  "    Option: ");

            String option = scanner.nextLine();

            if ("2".equals(option)) {
                Program.getInstance().exit();
            }
            if ("1".equals(option)) {
                return Seller.class;
            }
            if ("2".equals(option)) {
                return Customer.class;
            }

            Message.invalidOption("option!");
        }
    }

    public CreateAccountMenu(Class<? extends Account>)
}