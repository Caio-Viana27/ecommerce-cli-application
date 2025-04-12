
public class FullReport implements Report {

    public void create(Program program) {
        Menu.separator();
        System.out.println("Acount(s)");

        for (var account : program.getAccounts()) {
            account.display();
        }
        Menu.separator();
        System.out.println("Product(s)");

        for (var product : program.getProducts()) {
            product.display();
        }
    }
}