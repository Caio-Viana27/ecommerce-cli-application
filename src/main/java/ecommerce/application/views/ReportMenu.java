package ecommerce.application.views;

import ecommerce.application.FullReport;
import ecommerce.application.ReportLowestInventoryProduct;
import ecommerce.application.ReportMostExpensiveOrder;
import ecommerce.application.interfaces.Menu;
import ecommerce.application.interfaces.OnSelection;

import java.util.HashMap;
import java.util.Map;

public class ReportMenu extends Menu {
    private final Map<String, OnSelection> menuOptions;

    public ReportMenu() {
        menuOptions = new HashMap<>();
    }

    public void init() {
        addMenu("0", this::drawReportMostExpensiveOrder);
        addMenu("1", this::drawReportProductWithLowestInventory);
        addMenu("2", this::drawFullReport);
        addMenu("3", MenuManager.instance().getMenu(AdministratorMenu.class)::draw);
    }

    private void addMenu(String option, OnSelection action) {
        menuOptions.put(option, action);
    }

    @Override
    public void draw() {
        init();
        report();
    }

    private void report() {
        clearConsole();
        separator();
        System.out.println("    Report Menu\n");
        System.out.println("    0 - Report (most expensive order)");
        System.out.println("    1 - Report (product with lowest inventory)");
        System.out.println("    2 - Full Report");
        System.out.println("    3 - Return\n");

        OnSelection report = selectReportOption();
        report.action();
    }

    private OnSelection selectReportOption() {
        while (true) {
            System.out.print("    Option: ");
            String option = scanner.nextLine();

            OnSelection menuOption = menuOptions.get(option);

            if (menuOption != null) {
                return menuOption;
            }

            Message.invalidOption("option");
        }
    }

    private void drawReportMostExpensiveOrder() {
        clearConsole();

        new ReportMostExpensiveOrder().generate();

        Message.pressAnyKeyToExit();
        scanner.nextLine();

        draw();
    }

    private void drawReportProductWithLowestInventory() {
        clearConsole();

        new ReportLowestInventoryProduct().generate();

        Message.pressAnyKeyToExit();
        scanner.nextLine();

        draw();
    }

    private void drawFullReport() {
        clearConsole();

        new FullReport().generate();

        Message.pressAnyKeyToExit();
        scanner.nextLine();

        draw();
    }
}