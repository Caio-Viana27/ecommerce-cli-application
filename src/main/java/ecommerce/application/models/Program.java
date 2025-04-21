package ecommerce.application.models;

import ecommerce.application.controllers.AccountController;
import ecommerce.application.controllers.OrderController;
import ecommerce.application.controllers.ProductController;
import ecommerce.application.views.Message;
import ecommerce.application.views.Login;

import java.util.Scanner;

import static ecommerce.application.models.TestData.InsertTestData;

public class Program {
    public static Program instance = null;

    private final AccountController accountController = new AccountController();
    private final ProductController productController = new ProductController();
    private final OrderController orderController = new OrderController();

    private final Serialization data = new Serialization();
    private final Scanner scanner = new Scanner(System.in);

    public Program() {
        if (instance != null)
            throw new RuntimeException();

        instance = this;
    }

    public void start() {
        loadData();

        Login login = new Login(scanner);

        Thread UIThread = new Thread(login, "UIThread");
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
            InsertTestData(accountController, productController);
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
