package ecommerce.application.models;

import ecommerce.application.controllers.AccountController;
import ecommerce.application.controllers.OrderController;
import ecommerce.application.controllers.ProductController;
import ecommerce.application.interfaces.Menu;
import ecommerce.application.views.Message;
import ecommerce.application.views.SignInMenu;

public class Program {
    public static Program instance = null;

    private final AccountController accountController = new AccountController();
    private final ProductController productController = new ProductController();
    private final OrderController orderController = new OrderController();

    private final Serialization data = new Serialization();

    public void init() throws Exception {
        loadData();

        Menu loginMenu = MenuManager.instance().getMenu(SignInMenu.class);

        Thread UIThread = new Thread(loginMenu, "UIThread");
        UIThread.start();

        try {
            UIThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        exit();
    }

    private void loadData() {
        if (data.load(accountController, productController)) {
            Message.dataFound();
        }
        else {
            TestData.insertTestData(accountController, productController);
            Message.noDataFound();
        }
    }

    private void saveData() {
        if (data.save(accountController, productController)) {
            Message.dataSaved();
        }
        else {
            Message.dataNotSaved();
        }
    }

    public void exit() {
        saveData();
        Menu.closeScanner();
        System.exit(0);
    }

    public static Program getInstance() {
        if (instance == null) {
            instance = new Program();
        }
        return instance;
    }

    public AccountController getAccountController() {
        return accountController;
    }

    public ProductController getProductController() {
        return productController;
    }

    public OrderController getOrderController() {
        return orderController;
    }
}
