package ecommerce.application.models;

import ecommerce.application.controllers.AccountController;
import ecommerce.application.controllers.OrderController;
import ecommerce.application.controllers.ProductController;
import ecommerce.application.interfaces.Account;
import ecommerce.application.models.product.Product;

import java.io.*;
import java.util.HashMap;

public class Serialization {

    public boolean load(AccountController accountController, ProductController productController) {

        try (var loadFile = new FileInputStream("data/data.dat");
             var in = new ObjectInputStream(loadFile)) {

            accountController.setAccounts((HashMap<String, Account>) in.readObject());
            productController.setProducts((HashMap<Long, Product>) in.readObject());

            ProductController.idCounter = (Long) in.readObject();
            OrderController.idCounter = (Long) in.readObject();

            return true;

        } catch (IOException | ClassNotFoundException e) {

            accountController.setAccounts(new HashMap<String, Account>());
            productController.setProducts(new HashMap<Long, Product>());

            return false;
        }
    }

    public boolean save(AccountController accountController, ProductController productController) {

        try (var saveFile = new FileOutputStream("data/data.dat");
             var out = new ObjectOutputStream(saveFile)) {

            out.writeObject(accountController.getAccountsMap());
            out.writeObject(productController.getProductsMap());

            out.writeObject(ProductController.idCounter);
            out.writeObject(OrderController.idCounter);

            return true;

        } catch (IOException e) {
            e.printStackTrace();

            return false;
        }
    }
}