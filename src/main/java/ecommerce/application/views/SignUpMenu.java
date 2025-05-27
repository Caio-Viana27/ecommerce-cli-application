package ecommerce.application.views;

import ecommerce.application.interfaces.Account;
import ecommerce.application.interfaces.Menu;
import ecommerce.application.models.account.Customer;
import ecommerce.application.models.account.CustomerBuilder;
import ecommerce.application.models.account.Seller;
import ecommerce.application.models.account.SellerBuilder;

public class SignUpMenu extends Menu {

    public SignUpMenu() {
    }

    @Override
    public void draw() {
        var menu = (CreateAccountMenu) MenuManager.instance().getMenu(CreateAccountMenu.class);

        Class<? extends Account> type = menu.selectAccountType();

        Account newAccount = null;
        if (type.isInstance(Customer.class)) {
            newAccount = menu.createAccount(new CustomerBuilder());
        }
        else {
            newAccount = menu.createAccount(new SellerBuilder());
        }


    }
}
