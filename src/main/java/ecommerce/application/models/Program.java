package ecommerce.application.models;

import ecommerce.application.controllers.AccountController;
import ecommerce.application.controllers.OrderController;
import ecommerce.application.controllers.ProductController;
import ecommerce.application.views.Message;
import ecommerce.application.views.SignInMenu;

import java.util.Scanner;

public class Program {
    public static Program instance = null;

    private final AccountController accountController = new AccountController();
    private final ProductController productController = new ProductController();
    private final OrderController orderController = new OrderController();

    private final Serialization data = new Serialization();
    private final Scanner scanner = new Scanner(System.in);

    private Program() {
        instance = this;
    }

    public static Program instantiate() {
        if (instance != null)
            return instance;

        return new Program();
    }

    public void init() {
        loadData();

        SignInMenu signInMenu = new SignInMenu(scanner);

        Thread UIThread = new Thread(signInMenu, "UIThread");
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
        scanner.close();
        System.exit(0);
    }

    public static Program getInstance() {
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
