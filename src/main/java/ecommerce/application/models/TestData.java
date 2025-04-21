package ecommerce.application.models;

import ecommerce.application.controllers.AccountController;
import ecommerce.application.controllers.ProductController;

public class TestData {

    private static Administrator createHardcodedAdmin() {
        return new Administrator("admin", "admin@gmail.com", "admin");
    }

    public static void InsertTestData(AccountController accountController, ProductController productController) {
        accountController.getAccountsMap().put("admin@gmail.com", createHardcodedAdmin());
        accountController.getAccountsMap().put("Mateus@gmail.com",
                new Customer("Mateus", "Mateus@gmail.com", "mateus",
                        new Address("21332534", "Rua dos Guarapes", "Madre de Deus", "12")));
        accountController.getAccountsMap().put("ana@gmail.com",
                new Customer("Ana Souza", "ana@gmail.com", "ana",
                        new Address("01001000", "Avenida Paulista", "São Paulo", "100")));
        accountController.getAccountsMap().put("joao@hotmail.com",
                new Customer("João Lima", "joao@hotmail.com", "joao",
                        new Address("30140071", "Rua Rio de Janeiro", "Belo Horizonte", "202")));
        accountController.getAccountsMap().put("carla@yahoo.com",
                new Customer("Carla Mendes", "carla@yahoo.com", "carla",
                        new Address("40020030", "Avenida Sete de Setembro", "Salvador", "305")));
        accountController.getAccountsMap().put("pedro@outlook.com",
                new Customer("Pedro Santos", "pedro@outlook.com", "pedro",
                        new Address("70040900", "Esplanada dos Ministérios", "Brasília", "1")));
        accountController.getAccountsMap().put("juliana@live.com",
                new Customer("Juliana Ribeiro", "juliana@live.com", "juliana",
                        new Address("80010010", "Rua XV de Novembro", "Curitiba", "88")));

        //String name, double price, int inStorage, String description, String category
        var product = new Product("playstation 5", 3599.99, 10, "Video Game", "Video Game");
        productController.getProductsMap().put(product.getId(), product);

        product = new Product("Xbox Series X", 3399.99, 8, "Video Game", "Video Game");
        productController.getProductsMap().put(product.getId(), product);

        product = new Product("Nintendo Switch OLED", 2299.90, 15, "Video Game", "Video Game");
        productController.getProductsMap().put(product.getId(), product);

        product = new Product("iPhone 15 Pro", 7199.00, 5, "Smartphone", "Eletrônicos");
        productController.getProductsMap().put(product.getId(), product);

        product = new Product("Samsung Galaxy S24", 6899.00, 7, "Smartphone", "Eletrônicos");
        productController.getProductsMap().put(product.getId(), product);

        product = new Product("Notebook Dell Inspiron 15", 3899.99, 12, "Notebook", "Informática");
        productController.getProductsMap().put(product.getId(), product);

        product = new Product("Monitor LG UltraWide 29\"", 1299.90, 20, "Monitor", "Informática");
        productController.getProductsMap().put(product.getId(), product);

        product = new Product("Teclado Mecânico Redragon Kumara", 249.99, 25, "Periférico", "Informática");
        productController.getProductsMap().put(product.getId(), product);

        product = new Product("Fone de Ouvido JBL Tune 510BT", 199.90, 30, "Áudio", "Eletrônicos");
        productController.getProductsMap().put(product.getId(), product);

        product = new Product("Smart TV Samsung 50\" 4K", 2799.00, 9, "TV", "Eletrônicos");
        productController.getProductsMap().put(product.getId(), product);
    }
}
