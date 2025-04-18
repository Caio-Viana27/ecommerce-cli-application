package ecommerce.application.controllers;

import ecommerce.application.interfaces.IAccountController;
import ecommerce.application.models.Administrator;
import ecommerce.application.models.Program;
import ecommerce.application.views.AdministratorMenu;

public class AdministratorController implements IAccountController {
    private static AdministratorController instance = null;

    public AdministratorController() {
        if (instance != null)
            throw new RuntimeException();
        instance = this;
    }

    public static AdministratorController getInstance() {
        return instance;
    }

    public void insertNewAdmin(Administrator newAdmin) {
        Program.getInstance().getAccountsMap().put(newAdmin.getEmail(), newAdmin);
    }
}
