import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;
import java.util.LinkedList;

public class GraphicUserInterface {
    private LinkedList<Administrator> adminsList;
    private LinkedList<Customer> customersList;
    private LinkedList<Product> productList;

    public void start() {
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

        Menu.separator();
        System.out.println("Login");
        Scanner scanner = new Scanner(System.in);

        Account account = null;
        while (account == null) {

            System.out.print("Enter email or zero to exit: ");
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

            System.out.print("Enter password or zero to exit: ");
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
                            adminsList.add(adminAccount.createAdministrator(scanner));
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
                                if (shoppingCart.getCartSize() == 0) {
                                    System.out.println("There's nothing to see in the shopping cart!");
                                    choice = "";
                                } else
                                    shoppingCart.viewShoppingCart();
                                break;
                            case "2":
                                if (shoppingCart.getCartSize() == 0) {
                                    System.out.println("Can not finish order, there's no product in shopping cart!");
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

    private void displayEverything() {

        Menu.separator();
        System.out.println("Administrator(s)");
        for (var account : adminsList) {
            account.display();
        }
        Menu.separator();
        System.out.println("\nCustomer(s)");
        for (var account : customersList) {
            account.display();
            Menu.separator();
        }
        Menu.separator();
        System.out.println("\nProduct(s)");
        for (var product : productList) {
            product.display();
        }
    }
}
