package ecommerce.application.views;

import ecommerce.application.interfaces.Account;
import ecommerce.application.interfaces.Menu;

public class SignUpMenu extends Menu {

    public SignUpMenu() {
    }

    @Override
    public void draw() {
        var menu = (CreateAccountMenu) MenuManager.instance().getMenu(CreateAccountMenu.class);

        Class<? extends Account> type = menu.selectAccountType();

        menu.createAccount(type);
    }
}
