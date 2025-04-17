package ecommerce.application.views;

import ecommerce.application.interfaces.Menu;

import java.util.Scanner;

public class CreateProductMenu extends Menu {

    public CreateProductMenu(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void draw() {
        System.out.println("menu product");
    }
}