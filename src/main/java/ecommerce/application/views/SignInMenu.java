package ecommerce.application.views;

import ecommerce.application.controllers.AccountController;
import ecommerce.application.interfaces.Account;
import ecommerce.application.interfaces.Menu;
import ecommerce.application.models.Administrator;
import ecommerce.application.models.Customer;
import ecommerce.application.models.Program;

import java.util.HashMap;
import java.util.Map;

public class SignInMenu extends Menu {
    private static SignInMenu instance = null;

    private final Map<Class<? extends Account>, Menu> menus;
    private Account logedAccount;

    public SignInMenu() {
        instance = this;
        menus = new HashMap<>();

        addMenu(Customer.class, new CustomerMenu());
        addMenu(Administrator.class, new AdministratorMenu());
        //addMenu(Seller.class, new SellerMenu());
    }

    private void addMenu(Class<? extends Account> accountClass, Menu menu) {
        menus.put(accountClass, menu);
    }

    @Override
    public void draw() {
        logedAccount = null;
        login();
    }

    private void login() {
        AccountController accountController = Program.getInstance().getAccountController();

        clearConsole();
        separator();
        Message.login();

        

        Account account = selectAccount(accountController.getAccountsMap());

        enterPassword(account);

        clearConsole();

        logedAccount = account;

        menus.get(account.getClass()).draw();
    }

    private Account selectAccount(Map<String, Account> accounts) {
        Account account = null;
        while (account == null) {

            Message.enterOption("email");
            String email = scanner.nextLine();

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
            String password = scanner.nextLine();

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

    public static SignInMenu getInstance() {
        return instance;
    }

    public Account getLogedAccount() {
        return logedAccount;
    }

    public void getLoginMethod() {
        Message.loginMethod();
        while (true) {
            System.out.print("option: ");
            String option = scanner.nextLine();

            option = option.toUpperCase();

            if ("N".equals(option)) {
                //return new SignUpMenu();
            }
            if ("Y".equals(option)) {
                //return new SignIn();
            }
            Message.invalidOption("option!");
        }
    }
}