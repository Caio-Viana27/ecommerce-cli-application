public class Menu {

    public static void separator() {
        System.out.println("\n<=======================================================================>\n");
    }

    public static void Administrator() {
        Menu.separator();
        System.out.println("    Administrator Menu\n");
        System.out.println("    0 - Create new account");
        System.out.println("    1 - Create new product");
        System.out.println("    2 - Report (most expensive order)");
        System.out.println("    3 - Report (product with lowest inventory)");
        System.out.println("    4 - Full Report");
        System.out.println("    5 - log out");
        System.out.println("    6 - Exit program");
        System.out.print(  "    Option: ");
    }

    public static void createAccount() {
        Menu.separator();
        System.out.println("    Menu create account\n");
        System.out.println("    0 - to create a new admin");
        System.out.println("    1 - to create a new customer");
        System.out.print(  "    Option: ");
    }

    public static void Customer() {
        Menu.separator();
        System.out.println("    Customer Menu\n");
        System.out.println("    0 - Start new Order");
        System.out.println("    1 - log out");
        System.out.println("    2 - Exit program");
        System.out.print(  "    Option: ");
    }

    public static void startNewOrder() {
        Menu.separator();
        System.out.println("    Menu start new order\n");
        System.out.println("    0 - Add product");
        System.out.println("    1 - View shopping cart");
        System.out.println("    2 - Finish order");
        System.out.print(  "    Option: ");
    }

    public static void report(Program program, Report report) {
        report.create(program);
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
