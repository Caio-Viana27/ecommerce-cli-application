package ecommerce.application.views;

import ecommerce.application.controllers.AccountController;
import ecommerce.application.interfaces.Account;
import ecommerce.application.interfaces.Menu;
import ecommerce.application.models.*;
import ecommerce.application.models.account.Administrator;
import ecommerce.application.models.account.Customer;
import ecommerce.application.models.account.Seller;

import java.util.HashMap;
import java.util.Map;

public class SignInMenu extends Menu {
    private final Map<Class<? extends Account>, Menu> menus;

    public SignInMenu() {
        menus = new HashMap<>();
        addMenu(Customer.class, new CustomerMenu());
        addMenu(Administrator.class, new AdministratorMenu());
        addMenu(Seller.class, new SellerMenu());
    }

    @Override
    public void draw() {
        AccountController accountController = Program.Instance().getAccountController();

        clearConsole();
        separator();
        Message.login();
        Account account = selectAccount(accountController.getAccountsMap());
        enterPassword(account);
        clearConsole();

        Program.Instance().setLoggedAccount(account);
        menus.get(account.getClass()).draw();
    }

    private Account selectAccount(Map<String, Account> accounts) {
        Account account = null;
        while (account == null) {

            Message.enterOption("email");
            String email = scanner.nextLine();

            if ("0".equals(email)) {
                clearConsole();
                Program.Instance().exit();
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
            String password = scanner.nextLine();

            if ("0".equals(password)) {
                clearConsole();
                Program.Instance().exit();
            }

            if (account.passwordMatches(password)) {
                passwordValid = true;
            }
            else {
                Message.invalidOption("password, Try again!");
            }
        }
    }

    private void addMenu(Class<? extends Account> accountClass, Menu menu) {
        menus.put(accountClass, menu);
    }

    public Menu getMenu(Class<? extends Account> key) {
        return menus.get(key);
    }
}