import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Serialization {

    public boolean loadData(Map<String, Account> accounts, Map<String, Product> products) {

        try (var loadFile = new FileInputStream("../data/data.dat");
             var in = new ObjectInputStream(loadFile)) {

            accounts = (HashMap<String, Account>) in.readObject();
            products = (HashMap<String, Product>) in.readObject();

            return true;

        } catch (IOException | ClassNotFoundException e) {
            Menu.noDataFoundWarning();
            accounts = new HashMap<String, Account>();
            products = new HashMap<String, Product>();

            return false;
        }
    }

    public boolean save(Map<String, Account> accounts, Map<String, Product> products) {

        try (var saveFile = new FileOutputStream("../data/data.dat");
             var out = new ObjectOutputStream(saveFile)) {

            out.writeObject(accounts);
            out.writeObject(products);
            Menu.dataSavedWarning();

            return true;

        } catch (IOException e) {
            e.printStackTrace();

            return false;
        }
    }
}