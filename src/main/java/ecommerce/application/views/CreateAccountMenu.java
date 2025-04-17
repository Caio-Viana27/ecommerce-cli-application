package ecommerce.application.views;

import ecommerce.application.interfaces.Menu;

import java.util.Scanner;

public class CreateAccountMenu extends Menu {

    public CreateAccountMenu(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void draw() {
        System.out.println("menu Account");
    }
}