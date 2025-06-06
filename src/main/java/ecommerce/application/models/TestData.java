package ecommerce.application.models;

import ecommerce.application.controllers.AccountController;
import ecommerce.application.controllers.ProductController;
import ecommerce.application.models.account.Administrator;
import ecommerce.application.models.account.Customer;
import ecommerce.application.models.product.Product;

import java.math.BigDecimal;

public class TestData {

    private static Administrator createHardcodedAdmin() {
        return new Administrator(new CPF("000.000.000-00"), "admin", new Email("admin@gmail.com"), "admin");
    }

    public static void insertTestData(AccountController accountController, ProductController productController) {
        accountController.getAccountsMap().put("admin@gmail.com", createHardcodedAdmin());
        accountController.getAccountsMap().put("Mateus@gmail.com",
                new Customer(new CPF("543.435.343-12"),"Mateus", new Email("Mateus@gmail.com"), "mateus",
                        new Address(new PostalCode("21332534"), "Rua dos Guarapes", "Madre de Deus", "12")));
        accountController.getAccountsMap().put("ana@gmail.com",
                new Customer(new CPF("653.634.567-09"),  "Ana Souza", new Email("ana@gmail.com"), "ana",
                        new Address(new PostalCode("01001000"), "Avenida Paulista", "São Paulo", "100")));
        accountController.getAccountsMap().put("joao@hotmail.com",
                new Customer(new CPF("322.525.927-12"),  "João Lima", new Email("joao@hotmail.com"), "joao",
                        new Address(new PostalCode("30140071"), "Rua Rio de Janeiro", "Belo Horizonte", "202")));
        accountController.getAccountsMap().put("carla@yahoo.com",
                new Customer(new CPF("789.543.565-56"), "Carla Mendes", new Email("carla@yahoo.com"), "carla",
                        new Address(new PostalCode("40020030"), "Avenida Sete de Setembro", "Salvador", "305")));
        accountController.getAccountsMap().put("pedro@outlook.com",
                new Customer(new CPF("341.565.893-20"), "Pedro Santos", new Email("pedro@outlook.com"), "pedro",
                        new Address(new PostalCode("70040900"), "Esplanada dos Ministérios", "Brasília", "1")));
        accountController.getAccountsMap().put("juliana@live.com",
                new Customer(new CPF("900.675.355-42"), "Juliana Ribeiro", new Email("juliana@live.com"), "juliana",
                        new Address(new PostalCode("80010010"), "Rua XV de Novembro", "Curitiba", "88")));

        //String name, double price, int inStorage, String description, String category
        var product = new Product("playstation 5", new BigDecimal("3599.99"), 10, "Video Game", "Video Game");
        productController.getProductsMap().put(product.getId(), product);

        product = new Product("Xbox Series X", new BigDecimal("3399.99"), 8, "Video Game", "Video Game");
        productController.getProductsMap().put(product.getId(), product);

        product = new Product("Nintendo Switch OLED", new BigDecimal("2299.90"), 15, "Video Game", "Video Game");
        productController.getProductsMap().put(product.getId(), product);

        product = new Product("iPhone 15 Pro", new BigDecimal("7199.00"), 5, "Smartphone", "Eletrônicos");
        productController.getProductsMap().put(product.getId(), product);

        product = new Product("Samsung Galaxy S24", new BigDecimal("6899.00"), 7, "Smartphone", "Eletrônicos");
        productController.getProductsMap().put(product.getId(), product);

        product = new Product("Notebook Dell Inspiron 15", new BigDecimal("3899.99"), 12, "Notebook", "Informática");
        productController.getProductsMap().put(product.getId(), product);

        product = new Product("Monitor LG UltraWide 29\"", new BigDecimal("1299.90"), 20, "Monitor", "Informática");
        productController.getProductsMap().put(product.getId(), product);

        product = new Product("Teclado Mecânico Redragon Kumara", new BigDecimal("249.99"), 25, "Periférico", "Informática");
        productController.getProductsMap().put(product.getId(), product);

        product = new Product("Fone de Ouvido JBL Tune 510BT", new BigDecimal("199.90"), 30, "Áudio", "Eletrônicos");
        productController.getProductsMap().put(product.getId(), product);

        product = new Product("Smart TV Samsung 50\" 4K", new BigDecimal("2799.00"), 9, "TV", "Eletrônicos");
        productController.getProductsMap().put(product.getId(), product);
    }
}
