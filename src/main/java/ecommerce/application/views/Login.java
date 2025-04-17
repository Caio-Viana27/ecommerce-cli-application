package ecommerce.application.views;

import ecommerce.application.interfaces.Account;
import ecommerce.application.interfaces.Menu;
import ecommerce.application.models.AccountType;
import ecommerce.application.models.Program;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login extends Menu {
    private static Login instance;

    private Map<AccountType, Menu> menus;
    private Map<String, Account> accounts;

    public Login(Scanner scanner) {
        super(scanner);
        instance = this;
        menus = new HashMap<>();
    }

    public Login init(Map<String, Account> accounts) {
        this.accounts = accounts;
        addMenu(AccountType.Customer, new CustomerMenu(scanner));
        addMenu(AccountType.Administrator, new AdministratorMenu(scanner));
        addMenu(AccountType.Seller, new SellerMenu(scanner));
        return this;
    }

    private void addMenu(AccountType type, Menu menu) {
        menus.put(type, menu);
    }

    @Override
    public void draw() {
        login();
    }

    private void login() {
        separator();
        Message.login();

        Account account = selectAccount();

        enterPassword(account);

        clearConsole();

        menus.get(account.login()).draw();
    }

    private Account selectAccount() {
        Account account = null;
        while (account == null) {

            Message.enterOption("email");
            String email = super.scanner.nextLine();

            if ("0".equals(email)) {
                clearConsole();
                Program.getInstance().exit();
            }

            account = accounts.get(email);
            if (account == null)
                Message.invalidOption("email, Try again!");
        }
        return account;
    }

    private void enterPassword(Account account) {
        boolean passwordValid = false;
        while (!passwordValid) {

            Message.enterOption("password");
            String password = super.scanner.nextLine();

            if ("0".equals(password)) {
                clearConsole();
                Program.getInstance().exit();
            }

            if (account.passwordMatches(password)) {
                passwordValid = true;
            }
            else {
                Message.invalidOption("password, Try again!");
            }
        }
    }

    public static Login getInstance() {
        return instance;
    }
}