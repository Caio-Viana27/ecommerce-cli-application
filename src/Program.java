import java.util.Collection;
import java.util.Scanner;
import java.util.Map;

public class Program {
    private Map<String, Account> accounts;
    private Map<String, Product> products;

    Serialization data = new Serialization();
    Scanner scanner = new Scanner(System.in);

    public void start() {
        Menu.clearConsole();

        if (data.loadData(this)) {
            Message.dataFound();
        }
        else {
            InsertTestData();
            Message.noDataFound();
        }

        if (accounts.isEmpty())
            accounts.put("admin@gmail.com", createHardcodedAdmin());

        loginInterface();
    }

    private Administrator createHardcodedAdmin() {
        return new Administrator("admin", "admin@gmail.com", "admin");
    }

    private void loginInterface() {
        Menu.separator();
        Message.login();

        Account account = null;
        while (account == null) {

            Message.enterOption("email");
            String email = scanner.nextLine();

            if ("0".equals(email)) {
                data.save(accounts, products);
                scanner.close();
                Menu.clearConsole();
                System.exit(0);
            }

            account = accounts.get(email);
            if (account == null)
                Message.invalidOption("email, Try again!");
        }

        boolean passwordValid = false;
        while (!passwordValid) {

            Message.enterOption("password");
            String password = scanner.nextLine();

            if ("0".equals(password)) {
                data.save(accounts, products);
            }

            if (account.passwordMatches(password)) {
                passwordValid = true;
            }
            else {
                Message.invalidOption("password, Try again!");
            }
        }
        Menu.clearConsole();

        account.menu(this);
    }

    public void storeMenu(Administrator adminAccount) {

        while (true) {
            Menu.Administrator();
            String option = scanner.nextLine();

            switch (option) {
                case "0":
                    Menu.createAccount();
                    String choice = scanner.nextLine();

                    switch (choice) {
                        case "0":
                            Menu.clearConsole();
                            adminAccount.createAdministrator(scanner, accounts);
                            break;
                        case "1":
                            Menu.clearConsole();
                            adminAccount.createCustomer(scanner, accounts);
                            break;
                        default:
                            Message.invalidOption("option!");
                            break;
                    }
                    Menu.clearConsole();
                    break;
                case "1":
                    Menu.clearConsole();
                    adminAccount.createProduct(scanner, products);
                    break;
                case "2":
                    Menu.clearConsole();
                    if (accounts.isEmpty()) {
                        Message.thereAreNoCustomers();
                    }
                    else {
                        Menu.separator();
                        Menu.report(this, new ReportMostExpensiveOrder());
                    }
                    break;
                case "3":
                    Menu.clearConsole();
                    if (products.isEmpty()) {
                        Message.thereAreNoProducts();
                    }
                    else {
                        Menu.separator();
                        Menu.report(this, new ReportLowestInventoryProduct());
                    }
                    break;
                case "4":
                    Menu.clearConsole();
                    Menu.separator();
                    Menu.report(this, new FullReport());
                    break;
                case "5":
                    Menu.clearConsole();
                    loginInterface();
                    break;
                case "6":
                    Menu.clearConsole();
                    if (data.save(accounts, products)) {
                        Message.dataSaved();
                    }
                    else {
                        Message.dataNotSaved();
                    }
                    System.exit(0);
                    break;
                default:
                    Menu.clearConsole();
                    Message.invalidOption("option!");
                    break;
            }
        }
    }

    public void storeMenu(Customer customer) {

        while (true) {
            Menu.Customer();
            String option = scanner.nextLine();

            switch (option) {
                case "0":
                    Menu.clearConsole();

                    var shoppingCart = new ShoppingCart();
                    String choice = "";

                    while (!choice.equals("2")) {
                        Menu.startNewOrder();
                        choice = scanner.nextLine();

                        switch (choice) {
                            case "0":
                                Menu.clearConsole();
                                if (products.isEmpty()) {
                                    Message.noProductsAvailable();
                                    choice = "";
                                } else
                                    customer.addToShoppingCart(products, shoppingCart, scanner);
                                break;
                            case "1":
                                Menu.clearConsole();
                                if (shoppingCart.isEmpty()) {
                                    Message.noProducts("");
                                    choice = "";
                                }
                                else {
                                    Menu.separator();
                                    shoppingCart.viewShoppingCart();
                                }
                                break;
                            case "2":
                                Menu.clearConsole();
                                if (shoppingCart.isEmpty()) {
                                    Message.noProducts("Can not finish order, ");
                                } else
                                    customer.finishOrder(shoppingCart);
                                break;
                            default:
                                Menu.clearConsole();
                                Message.invalidOption("option!");
                                break;
                        }
                    }
                    break;
                case "1":
                    Menu.clearConsole();
                    loginInterface();
                    break;
                case "2":
                    Menu.clearConsole();
                    if (data.save(accounts, products)) {
                        Message.dataSaved();
                    }
                    else {
                        Message.dataNotSaved();
                    }
                    System.exit(0);
                    break;
                default:
                    Menu.clearConsole();
                    Message.invalidOption("option!");
                    break;
            }
        }
    }

    public Collection<Account> getAccounts() {
        return accounts.values();
    }

    public Collection<Product> getProducts() {
        return products.values();
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
