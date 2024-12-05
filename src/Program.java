import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;
import java.util.LinkedList;

public class Program {
    private LinkedList<Administrator> adminsList;
    private LinkedList<Customer> customersList;
    private LinkedList<Product> productList;

    public void start() {
        Menu.separator();
        this.loadData();
        if (adminsList.size() == 0)
            adminsList.add(this.createHardcodedAdmin());
        this.loginInterface();
    }

    private Administrator createHardcodedAdmin() {
        return new Administrator("admin", "admin@gmail.com", "admin");
    }

    private void loadData() {

        try (var loadFile = new FileInputStream("../data/data.dat");
                var in = new ObjectInputStream(loadFile)) {

            adminsList = (LinkedList<Administrator>) in.readObject();
            customersList = (LinkedList<Customer>) in.readObject();
            productList = (LinkedList<Product>) in.readObject();
            System.out.println("Data loaded successfully!");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No saved data found!");
            adminsList = new LinkedList<Administrator>();
            customersList = new LinkedList<Customer>();
            productList = new LinkedList<Product>();
        }
    }

    private void saveAndExit(Scanner scanner) {

        scanner.close();

        try (var saveFile = new FileOutputStream("../data/data.dat");
                var out = new ObjectOutputStream(saveFile)) {

            out.writeObject(adminsList);
            out.writeObject(customersList);
            out.writeObject(productList);
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

            account = searchAccount(email);
            if (account == null)
                Menu.invalidWarning("Email, Try again!");
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
                            adminsList.add(adminAccount.createAdministrator(scanner, this));
                            break;
                        case "1":
                            customersList.add(adminAccount.createCustomer(scanner));
                            break;
                        default:
                            Menu.invalidWarning("option!");
                            break;
                    }
                    break;
                case "1":
                    productList.add(adminAccount.createProduct(scanner));
                    break;
                case "2":
                    adminAccount.createReportMoreExpensiveOrder(customersList);
                    break;
                case "3":
                    adminAccount.createReportLowestInventoryProduct(productList);
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
                                if (productList.size() == 0) {
                                    System.out.println("Sorry, there are no products!");
                                    choice = "";
                                } else
                                    shoppingCart.addBoughtProduct(
                                            customerAccount.addProductToShoppingCart(productList, scanner));
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

    private Account searchAccount(String email) {
        for (Account account : adminsList) {
            if (account.emailMatches(email))
                return account;
        }
        for (Account account : customersList) {
            if (account.emailMatches(email))
                return account;
        }
        return null;
    }

    public boolean emailAlreadyExist(String email) {

        if (adminsList.size() == 0 && customersList.size() == 0)
            return false;
        if (this.searchAccount(email) == null)
            return false;
        return true;
    }

    private void displayEverything() {

        Menu.separator();
        System.out.println("Administrator(s)");
        for (var account : adminsList) {
            account.display();
        }
        Menu.separator();
        System.out.println("Customer(s)");
        for (var account : customersList) {
            account.display();
        }
        Menu.separator();
        System.out.println("Product(s)");
        for (var product : productList) {
            product.display();
        }
    }
}
