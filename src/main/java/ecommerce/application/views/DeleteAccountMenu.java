package ecommerce.application.views;

import ecommerce.application.interfaces.Account;
import ecommerce.application.interfaces.Menu;
import ecommerce.application.models.Program;

import java.util.Map;

public class DeleteAccountMenu extends Menu {

    @Override
    public void draw() {
        deleteAccount();
    }

    private void deleteAccount() {
        var accountController = Program.Instance().getAccountController();
        var loggedAccount = Program.Instance().getLoggedAccount();

        clearConsole();
        separator();
        System.out.println("    Select account by email");
        separator();

        for (var account : accountController.getAccountsList()) {
            if (!loggedAccount.getEmail().equals(account.getEmail())) {
                System.out.println(account.getId());
                System.out.println(account.getName());
                System.out.println(account.getEmail());
                separator();
            }
        }

        Map<String, Account> accountsMap = accountController.getAccountsMap();
        String option;
        while (true) {
            System.out.print("    option: ");
            option = scanner.nextLine();

            if (accountsMap.containsKey(option)) {
                break;
            }

            Message.invalidOption("email!");
        }
        accountsMap.remove(option);

        Message.confirmationMessage("Account deleted", scanner);

        MenuManager.instance().getMenu(AdministratorMenu.class).draw();
    }

    public void deleteAccount(Account account) {
        Map<String, Account> map = Program.Instance().getAccountController().getAccountsMap();

        map.remove(account.getEmail());

        Message.confirmationMessage("Account deleted", scanner);
    }
}
