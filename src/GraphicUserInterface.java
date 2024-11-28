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

        try (var loadFile = new FileInputStream("../data/savedObjects.ser");
                var in = new ObjectInputStream(loadFile)) {

            adminsList = (LinkedList<Administrator>) in.readObject();
            customersList = (LinkedList<Customer>) in.readObject();
            productList = (LinkedList<Product>) in.readObject();
            System.out.println("Data loaded successfully!");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No saved data found!");
            adminsList = new LinkedList<>();
            customersList = new LinkedList<>();
            productList = new LinkedList<>();
        }
    }

    private void saveAndExit() {
        try (var saveFile = new FileOutputStream("../data/savedObjects.ser");
                var out = new ObjectOutputStream(saveFile)) {

            out.writeObject(adminsList);
            out.writeObject(customersList);
            out.writeObject(productList);
            System.out.println("Data saved successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }

    private void loginInterface() {

        System.out.println("Login interface\n");
        Scanner scanner = new Scanner(System.in);

        Account account = null;
        while (account == null) {

            System.out.print("Enter account email or press '0' to exit: ");
            String email = scanner.nextLine();

            if (email.equals("0")) {
                scanner.close();
                this.saveAndExit();
            }

            account = searchAccount(email);
            if (account == null)
                System.out.println("Email doesn't match!");
        }

        boolean passwordValid = false;
        while (!passwordValid) {

            System.out.println();
            System.out.print("Enter account password or press '0' to exit: ");
            String password = scanner.nextLine();

            if (password.equals("0")) {
                scanner.close();
                this.saveAndExit();
            }

            if (account.passwordMatches(password)) {
                passwordValid = true;
            } else
                System.out.println("Wrong password, Try again!");
        }

        if (account instanceof Administrator) {
            this.storeInterface((Administrator) account, scanner);
        } else
            this.storeInterface((Customer) account, scanner);
    }

    private void storeInterface(Administrator adminAccount, Scanner scanner) {

        while (true) {
            System.out.println("Administrator Menu\n");
            System.out.println("0 - Create new account");
            System.out.println("1 - Create new product");
            System.out.println("2 - Report (more expensive order)");
            System.out.println("3 - Report (product with lowest inventory)");
            System.out.println("4 - Exit\n");
            System.out.println("5 - Display everything");
            System.out.print("Option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "0":
                    System.out.println("Chose an option");
                    System.out.println("0 - to create a new admin");
                    System.out.println("1 - to create a new customer");
                    System.out.print("Option: ");

                    String string = scanner.nextLine();

                    switch (string) {
                        case "0":
                            adminsList.add(adminAccount.createAdministrator(scanner));
                            break;
                        case "1":
                            customersList.add(adminAccount.createCustomer(scanner));
                            break;
                        default:
                            System.out.println("invalid option!");
                            break;
                    }
                    break;
                case "1":
                    productList.add(adminAccount.createProduct(scanner));
                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":
                    scanner.close();
                    this.saveAndExit();
                    break;
                case "5":
                    this.displayEverything();
                    break;
                default:
                    System.out.println("\nInvalid option!\n");
                    break;
            }
        }
    }

    private void storeInterface(Customer CustomerAccount, Scanner scanner) {

        while (true) {
            System.out.println("Customer Menu\n");
            System.out.println("0 - Create new Order");
            System.out.println("1 - View shopping cart");
            System.out.println("2 - Finish current order");
            System.out.println("3 - Exit\n");
            System.out.print("Option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "0":

                    break;
                case "1":

                    break;
                case "2":

                    break;
                case "3":
                    scanner.close();
                    this.saveAndExit();
                    break;
                default:
                    System.out.println("\nInvalid option!\n");
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

        for (var account : adminsList) {
            account.display();
        }
        for (var account : customersList) {
            account.display();
        }
        for (var product : productList) {
            product.display();
        }
    }
}
