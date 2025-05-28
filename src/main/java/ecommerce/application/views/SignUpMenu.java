package ecommerce.application.views;

import ecommerce.application.interfaces.Account;
import ecommerce.application.interfaces.Menu;
import ecommerce.application.models.Program;
import ecommerce.application.models.account.Customer;
import ecommerce.application.models.account.Seller;

public class SignUpMenu extends Menu {

    public SignUpMenu() {
    }

    @Override
    public void draw() {
        clearConsole();
        separator();
        System.out.println("    Sign up menu:");

        Class<? extends Account> type = selectAccountType();

        var menu = (CreateAccountMenu) MenuManager.instance().getMenu(CreateAccountMenu.class);

        Account newAccount = null;
        if (type.isInstance(new Customer())) {
            newAccount = menu.createCustomer();
        }
        if (type.isInstance(new Seller())) {
            newAccount = menu.createSeller();
        }
        if (newAccount == null) {
            throw new NullPointerException();
        }

        separator();
        System.out.println("    Account created!");
        Message.pressAnyKeyToExit();
        scanner.nextLine();

        var signIn = (SignInMenu) MenuManager.instance().getMenu(SignInMenu.class);
        signIn.init();

        Program.Instance().setLoggedAccount(newAccount);

        var accountMenu = signIn.getMenu(newAccount.getClass());
        accountMenu.draw();
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
                Program.Instance().exit();
            }
            if ("1".equals(option)) {
                return Seller.class;
            }
            if ("0".equals(option)) {
                return Customer.class;
            }

            Message.invalidOption("option!");
        }
    }
}
