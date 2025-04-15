package ecommerce.application.models;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Serialization {

    public boolean loadData(Program program) {

        try (var loadFile = new FileInputStream("../../data/data.dat");
             var in = new ObjectInputStream(loadFile)) {

            program.setAccounts((HashMap<String, Account>) in.readObject());
            program.setProducts((HashMap<String, Product>) in.readObject());

            return true;

        } catch (IOException | ClassNotFoundException e) {

            program.setAccounts(new HashMap<String, Account>());
            program.setProducts(new HashMap<String, Product>());

            return false;
        }
    }

    public boolean save(Map<String, Account> accounts, Map<String, Product> products) {

        try (var saveFile = new FileOutputStream("data/data.dat");
             var out = new ObjectOutputStream(saveFile)) {

            out.writeObject(accounts);
            out.writeObject(products);

            return true;

        } catch (IOException e) {
            e.printStackTrace();

            return false;
        }
    }
}