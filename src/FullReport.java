
public class FullReport implements Report {

    public void create(Program program) {
        Menu.separator();
        System.out.println("    Acount(s)\n");

        for (var account : program.getAccounts()) {
            account.display();
        }
        Menu.separator();
        System.out.println("    Product(s)\n");

        for (var product : program.getProducts()) {
            product.display();
        }
    }
}