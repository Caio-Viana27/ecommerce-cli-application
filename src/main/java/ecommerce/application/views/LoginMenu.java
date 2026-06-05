package ecommerce.application.views;

import ecommerce.application.Program;

public class LoginMenu extends Menu {

    @Override
    public void draw() {
        selectLoginMethod();
    }

    public final Menu selectLoginMethod() {

        while (true) {
            separator();
            System.out.println("    Select a login method\n");
            System.out.println("    0 - Sign in");
            System.out.println("    1 - Sign up");
            System.out.println("    2 - Exit\n");
            System.out.print(  "    option: ");

            String option = scanner.nextLine();

            if ("2".equals(option)) {
                Program.Instance().exit();
            }
            if ("1".equals(option)) {
                return MenuManager.instance().getMenu(SignUpMenu.class);
            }
            if ("0".equals(option)) {
                return MenuManager.instance().getMenu(SignInMenu.class);
            }
            Message.invalidOption("option!");
        }
    }
}
