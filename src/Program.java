import java.util.Collection;
import java.util.Scanner;
import java.util.Map;

public class Program {
    private Map<String, Account> accounts;
    private Map<String, Product> products;

    Serialization data = new Serialization();
    Scanner scanner = new Scanner(System.in);

    public void start() {
        Menu.separator();

        if (data.loadData(accounts, products)) {
            Message.dataFound();
        }
        else {
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

        Message.login();

        Account account = null;
        while (account == null) {

            Message.enterOption("email");
            String email = scanner.nextLine();

            if ("0".equals(email)) {
                scanner.close();
                data.save(accounts, products);
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
                            adminAccount.createAdministrator(scanner, accounts);
                            break;
                        case "1":
                            adminAccount.createCustomer(scanner, accounts);
                            break;
                        default:
                            Message.invalidOption("option!");
                            break;
                    }
                    break;
                case "1":
                    adminAccount.createProduct(scanner, products);
                    break;
                case "2":
                    if (accounts.isEmpty())
                        Message.thereAreNoCustomers();
                    else
                        Menu.report(this, new ReportMostExpensiveOrder());
                    break;
                case "3":
                    if (products.isEmpty())
                        Message.thereAreNoProducts();
                    else
                        Menu.report(this, new ReportLowestInventoryProduct());
                    break;
                case "4":
                    if (data.save(accounts, products)) {
                        Message.dataSaved();
                    }
                    else {
                        Message.dataNotSaved();
                    }
                    System.exit(0);
                    break;
                case "5":
                    Menu.report(this, new FullReport());
                    break;
                default:
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
                    var shoppingCart = new ShoppingCart();
                    String choice = "";

                    while (!choice.equals("2")) {
                        Menu.startNewOrder();
                        choice = scanner.nextLine();

                        switch (choice) {
                            case "0":
                                if (products.isEmpty()) {
                                    Message.noProductsAvailable();
                                    choice = "";
                                } else
                                    customer.addProductToShoppingCart(products, shoppingCart, scanner);
                                break;
                            case "1":
                                if (shoppingCart.isEmpty()) {
                                    Message.noProducts("");
                                    choice = "";
                                } else
                                    shoppingCart.viewShoppingCart();
                                break;
                            case "2":
                                if (shoppingCart.isEmpty()) {
                                    Message.noProducts("Can not finish order, ");
                                } else
                                    customer.finishOrder(shoppingCart);
                                break;
                            default:
                                Message.invalidOption("option!");
                                break;
                        }
                    }
                    break;
                case "1":
                    if (data.save(accounts, products)) {
                        Message.dataSaved();
                    }
                    else {
                        Message.dataNotSaved();
                    }
                    System.exit(0);
                    break;
                default:
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
}
