package ecommerce.application.views;

import ecommerce.application.interfaces.Account;
import ecommerce.application.interfaces.Menu;
import ecommerce.application.interfaces.OnSelection;
import ecommerce.application.interfaces.UniqueIdentifier;
import ecommerce.application.models.*;
import ecommerce.application.models.account.*;

import java.util.HashMap;
import java.util.Map;

public class CreateAccountMenu extends Menu {
    private final Map<String, OnSelection> menuOptions;

    public CreateAccountMenu() {
        menuOptions = new HashMap<>();
    }

    public void init() {
        addMenu("0", () -> {
            var _ignoreReturn = this.createAdministrator();
            MenuManager.instance().getMenu(SignInMenu.class).draw();
        });
        addMenu("1", () -> {
            var _ignoreReturn = this.createCustomer();
            MenuManager.instance().getMenu(SignInMenu.class).draw();
        });
        addMenu("2", () -> {
            var _ignoreReturn = this.createSeller();
            MenuManager.instance().getMenu(SignInMenu.class).draw();
        });
        addMenu("3",  MenuManager.instance().getMenu(AdministratorMenu.class)::draw);
    }

    private void addMenu(String option, OnSelection action) {
        menuOptions.put(option, action);
    }

    @Override
    public void draw() {
        init();
        menu();
    }

    public void menu() {
        clearConsole();
        separator();
        System.out.println("    Create Account\n");
        System.out.println("    0 - Create new Administrator");
        System.out.println("    1 - Create new Customer");
        System.out.println("    2 - Create new Seller");
        System.out.println("    3 - Return\n");

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

    private Administrator createAdministrator() {
        clearConsole();
        separator();
        System.out.println("    Menu create administrator\n");

        CPF cpf = createAccountCPF();
        String name = createAccountName();
        Email email = createAccountEmail();
        String password = createAccountPassword();

        var builder = new AdministratorBuilder();
        var director = new AccountsDirector(builder);
        director.createAccount(cpf,name, email, password, null);
        Administrator administrator = builder.getAdministrator();

        Program.Instance().getAccountController().insertNewAccount(administrator);

        return administrator;
    }

    public Customer createCustomer() {
        clearConsole();
        separator();
        System.out.println("    Menu create customer\n");

        CPF cpf = createAccountCPF();
        String name = createAccountName();
        Email email = createAccountEmail();
        String password = createAccountPassword();

        var addressMenu = (CreateAddressMenu) MenuManager.instance().getMenu(CreateAddressMenu.class);
        addressMenu.draw();

        Address address = addressMenu.getAddress();

        var builder = new CustomerBuilder();
        var director = new AccountsDirector(builder);
        director.createAccount(cpf,name, email, password, address);
        Customer customer = builder.getCustomer();

        Program.Instance().getAccountController().insertNewAccount(customer);

        return customer;
    }

    public Seller createSeller() {
        clearConsole();
        separator();
        System.out.println("    Menu create seller\n");

        UniqueIdentifier uniqueIdentifier = createUniqueIdentifier();
        String name = createAccountName();
        Email email = createAccountEmail();
        String password = createAccountPassword();

        var builder = new SellerBuilder();
        var director = new AccountsDirector(builder);
        director.createAccount(uniqueIdentifier, name, email, password, null);
        Seller seller = builder.getSeller();

        Program.Instance().getAccountController().insertNewAccount(seller);

        return seller;
    }

    private CPF createAccountCPF() {
        return null;
    }

    private UniqueIdentifier createUniqueIdentifier() {
        return null;
    }

    private String createAccountName() {
        System.out.print("    Name: ");
        return scanner.nextLine();
    }

    private String createAccountPassword() {
        System.out.print("    Password: ");
        return scanner.nextLine();
    }

    private Email createAccountEmail() {
        Map<String, Account> accounts = Program.Instance().getAccountController().getAccountsMap();

        String email;
        do {
            System.out.print("    Email: ");
            email = scanner.nextLine();

            if (accounts.get(email) != null) {
                separator();
                Message.invalidOption("    Email [this email already exists]");
            }

        } while (accounts.get(email) != null);

        return new Email(email);
    }
}