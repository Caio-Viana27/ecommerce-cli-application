package ecommerce.application;

import ecommerce.application.models.Program;

public class App {
    public static void main(String[] args) throws Exception {
        var program = Program.Instance();
        program.init();
    }
}
