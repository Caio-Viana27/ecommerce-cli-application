import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Program {
    private HashMap<String, Account> accounts;
    private HashMap<String, Product> products;

    public void start() {
        Menu.separator();
        this.loadData();
        if (accounts.isEmpty())
            accounts.put("admin@gmail.com", createHardcodedAdmin());
        this.loginInterface();
    }

    private Administrator createHardcodedAdmin() {
        return new Administrator("admin", "admin@gmail.com", "admin");
    }

    private void loadData() {

        try (var loadFile = new FileInputStream("../data/data.dat");
                var in = new ObjectInputStream(loadFile)) {

            accounts = (HashMap<String, Account>) in.readObject();
            products = (HashMap<String, Product>) in.readObject();
            System.out.println("Data loaded successfully!");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No saved data found!");
            accounts = new HashMap<String, Account>();
            products = new HashMap<String, Product>();
        }
    }

    private void saveAndExit(Scanner scanner) {

        scanner.close();

        try (var saveFile = new FileOutputStream("../data/data.dat");
                var out = new ObjectOutputStream(saveFile)) {

            out.writeObject(accounts);
            out.writeObject(products);
            System.out.println("\nData saved successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }

    private void loginInterface() {

        System.out.println("Login");
        Scanner scanner = new Scanner(System.in);

        Account account = null;
        while (account == null) {

            Menu.enterOption("email");
            String email = scanner.nextLine();

            if (email.equals("0")) {
                this.saveAndExit(scanner);
            }

            account = accounts.get(email);
            if (account == null)
                Menu.invalidWarning("email, Try again!");
        }

        boolean passwordValid = false;
        while (!passwordValid) {

            Menu.enterOption("password");
            String password = scanner.nextLine();

            if (password.equals("0")) {
                this.saveAndExit(scanner);
            }

            if (account.passwordMatches(password)) {
                passwordValid = true;
            } else
                Menu.invalidWarning("password, Try again!");
        }

        if (account instanceof Administrator) {
            this.storeInterface((Administrator) account, scanner);
        } else
            this.storeInterface((Customer) account, scanner);
    }

    private void storeInterface(Administrator adminAccount, Scanner scanner) {

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
                            Menu.invalidWarning("option!");
                            break;
                    }
                    break;
                case "1":
                    adminAccount.createProduct(scanner, products);
                    break;
                case "2":
                    if (accounts.isEmpty())
                        System.out.println("There are no customer accounts");
                    else
                        adminAccount.createReportMoreExpensiveOrder(accounts);
                    break;
                case "3":
                    if (products.isEmpty())
                        System.out.println("There are no products yet");
                    else
                        adminAccount.createReportLowestInventoryProduct(products);
                    break;
                case "4":
                    this.saveAndExit(scanner);
                    break;
                case "5":
                    this.displayEverything();
                    break;
                default:
                    Menu.invalidWarning("option!");
                    break;
            }
        }
    }

    private void storeInterface(Customer customerAccount, Scanner scanner) {

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
                                    System.out.println("Sorry, there are no products!");
                                    choice = "";
                                } else
                                    customerAccount.addProductToShoppingCart(products, shoppingCart, scanner);
                                break;
                            case "1":
                                if (shoppingCart.isEmpty()) {
                                    Menu.noProductWarning("");
                                    choice = "";
                                } else
                                    shoppingCart.viewShoppingCart();
                                break;
                            case "2":
                                if (shoppingCart.isEmpty()) {
                                    Menu.noProductWarning("Can not finish order, ");
                                } else
                                    customerAccount.finishOrder(shoppingCart);
                                break;
                            default:
                                Menu.invalidWarning("option!");
                                break;
                        }
                    }
                    break;
                case "1":
                    this.saveAndExit(scanner);
                    break;
                default:
                    Menu.invalidWarning("option!");
                    break;
            }
        }
    }

    private void displayEverything() {

        Menu.separator();
        System.out.println("Acount(s)");
        for (Map.Entry<String, Account> entry : accounts.entrySet()) {
            entry.getValue().display();
        }
        Menu.separator();
        System.out.println("Product(s)");
        for (Map.Entry<String, Product> entry : products.entrySet()) {
            entry.getValue().display();
        }
    }
}
