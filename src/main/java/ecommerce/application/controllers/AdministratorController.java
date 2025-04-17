package ecommerce.application.controllers;

import ecommerce.application.interfaces.IAccountController;
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
}
