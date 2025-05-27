package ecommerce.application.views;

import ecommerce.application.interfaces.Menu;

import java.util.HashMap;
import java.util.Map;

public class MenuManager {
    private static MenuManager instance = null;
    private final Map<Class<? extends Menu>, Menu> menusMap;

    private MenuManager() {
        menusMap = new HashMap<>();

        menusMap.put(SignInMenu.class, new SignInMenu());
        menusMap.put(SignIn.class, new SignIn());
        menusMap.put(SignUpMenu.class, new SignUpMenu());
        menusMap.put(AdministratorMenu.class, new AdministratorMenu());
        menusMap.put(CustomerMenu.class, new CustomerMenu());
        menusMap.put(SellerMenu.class, new SellerMenu());
        menusMap.put(SelectProductMenu.class, new SelectProductMenu());
        menusMap.put(OrderMenu.class, new OrderMenu());
        menusMap.put(ReportMenu.class, new ReportMenu());
        menusMap.put(CreateAccountMenu.class, new CreateAccountMenu());
        menusMap.put(CreateAddressMenu.class, new CreateAddressMenu());
        menusMap.put(CreateProductMenu.class, new CreateProductMenu());
    }

    public static MenuManager instance() {
        if (instance == null)
            instance = new MenuManager();

        return instance;
    }

    public Menu getMenu(Class<? extends Menu> key) {
        if (!menusMap.containsKey(key)) {
            return null; // create exception logic
        }

        return menusMap.get(key);
    }
}
