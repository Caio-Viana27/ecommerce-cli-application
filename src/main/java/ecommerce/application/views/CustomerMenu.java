package ecommerce.application.views;

import ecommerce.application.interfaces.Menu;

import java.util.Scanner;

public class CustomerMenu extends Menu {

    public CustomerMenu(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void draw() {
        customer();
    }

    private void customer() {
        separator();
        System.out.println("    Customer Menu\n");
        System.out.println("    0 - Start new Order");
        System.out.println("    1 - log out");
        System.out.println("    2 - Exit program");
        System.out.print(  "    Option: ");
    }

//    public void storeMenu(Customer customer) {
//
//        while (true) {
//            Menu.Customer();
//            String option = scanner.nextLine();
//
//            switch (option) {
//                case "0":
//                    Menu.clearConsole();
//
//                    var shoppingCart = new ShoppingCart();
//                    String choice = "";
//
//                    while (!choice.equals("2")) {
//                        Menu.startNewOrder();
//                        choice = scanner.nextLine();
//
//                        switch (choice) {
//                            case "0":
//                                Menu.clearConsole();
//                                if (products.isEmpty()) {
//                                    Message.noProductsAvailable();
//                                    choice = "";
//                                } else
//                                    customer.addToShoppingCart(products, shoppingCart, scanner);
//                                break;
//                            case "1":
//                                Menu.clearConsole();
//                                if (shoppingCart.isEmpty()) {
//                                    Message.noProducts("");
//                                    choice = "";
//                                }
//                                else {
//                                    Menu.separator();
//                                    Menu.display(shoppingCart);
//                                }
//                                break;
//                            case "2":
//                                Menu.clearConsole();
//                                if (shoppingCart.isEmpty()) {
//                                    Message.noProducts("Can not finish order, ");
//                                } else
//                                    customer.finishOrder(shoppingCart);
//                                break;
//                            default:
//                                Menu.clearConsole();
//                                Message.invalidOption("option!");
//                                break;
//                        }
//                    }
//                    break;
//                case "1":
//                    Menu.clearConsole();
//                    loginInterface();
//                    break;
//                case "2":
//                    Menu.clearConsole();
//                    if (data.save(accounts, products)) {
//                        Message.dataSaved();
//                    }
//                    else {
//                        Message.dataNotSaved();
//                    }
//                    System.exit(0);
//                    break;
//                default:
//                    Menu.clearConsole();
//                    Message.invalidOption("option!");
//                    break;
//            }
//        }
//    }
}