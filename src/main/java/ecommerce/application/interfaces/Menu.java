package ecommerce.application.interfaces;

import java.util.Scanner;

public abstract class Menu implements Runnable {
    protected Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void run() {
        draw();
    }

    public abstract void draw();

    public static void separator() {
        System.out.println("\n<=======================================================================>\n");
    }

    public static void display(Object item) {
        if (item == null) {
            throw new NullPointerException();
        }
        System.out.println(item);
    }

    public static void clearConsole()
    {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}