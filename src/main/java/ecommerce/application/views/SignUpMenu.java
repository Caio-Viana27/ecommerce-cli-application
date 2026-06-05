package ecommerce.application.views;

import ecommerce.application.models.account.Account;
import ecommerce.application.models.account.customer.Customer;
import ecommerce.application.models.account.seller.Seller;
import ecommerce.application.Program;

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

        Message.confirmationMessage("Account created", scanner);

        var signIn = (SignInMenu) MenuManager.instance().getMenu(SignInMenu.class);

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
