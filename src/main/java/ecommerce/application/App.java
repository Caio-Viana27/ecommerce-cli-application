package ecommerce.application;

import ecommerce.application.models.Program;

public class App {
    public static void main(String[] args) {
        var program = Program.instantiate();
        program.init();
    }
}
