package ecommerce.application.views;

import ecommerce.application.interfaces.Menu;

import java.util.Scanner;

public class SellerMenu extends Menu {

    public SellerMenu(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void draw() {

    }

    private void seller() {
        clearConsole();
        separator();
    }
}