package ecommerce.application.models;

import ecommerce.application.controllers.AccountController;
import ecommerce.application.controllers.OrderController;
import ecommerce.application.interfaces.Account;
import ecommerce.application.views.Message;
import ecommerce.application.views.Login;

import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

public class Program {
    public static Program instance = null;
    private Thread UIThread = null;

    private AccountController accountController = null;
    private OrderController orderController = null;

    private Map<String, Account> accounts;
    private Map<String, Product> products;

    private Login login;

    private final Serialization data = new Serialization();
    private final Scanner scanner = new Scanner(System.in);

    public Program() {
        if (instance != null)
            throw new RuntimeException();

        instance = this;
        accountController = new AccountController();
        orderController = new OrderController();
    }

    public void init() {

        loadData();

        login = new Login(scanner);
        login.init(accounts);
        UIThread = new Thread(login, "UIThread");

        start();
    }

    private void start() {
        UIThread.start();

        //login.init(accounts).draw();
        try {
            UIThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        exit();
    }

    private void loadData() {
        if (data.load(this)) {
            Message.dataFound();
        }
        else {
            InsertTestData();
            Message.noDataFound();
        }

        if (accounts.isEmpty())
            accounts.put("admin@gmail.com", createHardcodedAdmin());
    }

    private void saveData() {
        if (data.save(accounts, products)) {
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

    private Administrator createHardcodedAdmin() {
        return new Administrator("admin", "admin@gmail.com", "admin");
    }

    public static Program getInstance() {
        return instance;
    }

    public AccountController getAccountController() {
        return accountController;
    }

    public OrderController getOrderController() {
        return orderController;
    }

    public Collection<Account> getAccountsList() {
        return accounts.values();
    }

    public Collection<Product> getProductsList() {
        return products.values();
    }

    public Map<String, Account> getAccountsMap() {
        return accounts;
    }

    public Map<String, Product> getProductsMap() {
        return products;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public void setProducts(Map<String, Product> products) {
        this.products = products;
    }

    public void InsertTestData() {
        accounts.put("admin@gmail.com", createHardcodedAdmin());
        accounts.put("Mateus@gmail.com",
                new Customer("Mateus", "Mateus@gmail.com", "mateus",
                        new Address("21332534", "Rua dos Guarapes", "Madre de Deus", "12")));
        accounts.put("ana@gmail.com",
                new Customer("Ana Souza", "ana@gmail.com", "ana",
                        new Address("01001000", "Avenida Paulista", "São Paulo", "100")));
        accounts.put("joao@hotmail.com",
                new Customer("João Lima", "joao@hotmail.com", "joao",
                        new Address("30140071", "Rua Rio de Janeiro", "Belo Horizonte", "202")));
        accounts.put("carla@yahoo.com",
                new Customer("Carla Mendes", "carla@yahoo.com", "carla",
                        new Address("40020030", "Avenida Sete de Setembro", "Salvador", "305")));
        accounts.put("pedro@outlook.com",
                new Customer("Pedro Santos", "pedro@outlook.com", "pedro",
                        new Address("70040900", "Esplanada dos Ministérios", "Brasília", "1")));
        accounts.put("juliana@live.com",
                new Customer("Juliana Ribeiro", "juliana@live.com", "juliana",
                        new Address("80010010", "Rua XV de Novembro", "Curitiba", "88")));

        //String name, double price, int inStorage, String description, String category
        var product = new Product("playstation 5", 3599.99, 10, "Video Game", "Video Game");
        products.put(product.getId(), product);

        product = new Product("Xbox Series X", 3399.99, 8, "Video Game", "Video Game");
        products.put(product.getId(), product);

        product = new Product("Nintendo Switch OLED", 2299.90, 15, "Video Game", "Video Game");
        products.put(product.getId(), product);

        product = new Product("iPhone 15 Pro", 7199.00, 5, "Smartphone", "Eletrônicos");
        products.put(product.getId(), product);

        product = new Product("Samsung Galaxy S24", 6899.00, 7, "Smartphone", "Eletrônicos");
        products.put(product.getId(), product);

        product = new Product("Notebook Dell Inspiron 15", 3899.99, 12, "Notebook", "Informática");
        products.put(product.getId(), product);

        product = new Product("Monitor LG UltraWide 29\"", 1299.90, 20, "Monitor", "Informática");
        products.put(product.getId(), product);

        product = new Product("Teclado Mecânico Redragon Kumara", 249.99, 25, "Periférico", "Informática");
        products.put(product.getId(), product);

        product = new Product("Fone de Ouvido JBL Tune 510BT", 199.90, 30, "Áudio", "Eletrônicos");
        products.put(product.getId(), product);

        product = new Product("Smart TV Samsung 50\" 4K", 2799.00, 9, "TV", "Eletrônicos");
        products.put(product.getId(), product);
    }
}
