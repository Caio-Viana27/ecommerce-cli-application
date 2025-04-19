package ecommerce.application.views;

import ecommerce.application.FullReport;
import ecommerce.application.ReportLowestInventoryProduct;
import ecommerce.application.ReportMostExpensiveOrder;
import ecommerce.application.interfaces.IReport;
import ecommerce.application.interfaces.Menu;
import ecommerce.application.interfaces.OnSelection;
import ecommerce.application.models.Program;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReportMenu extends Menu {
    private final Map<String, OnSelection> menuOptions;

    public ReportMenu(Scanner scanner) {
        super(scanner);

        menuOptions = new HashMap<>();

        addMenu("0", this::drawReportMostExpensiveOrder);
        addMenu("1", this::drawReportProductWithLowestInventory);
        addMenu("2", this::drawFullReport);
        addMenu("3", AdministratorMenu.getInstance()::draw);
    }

    private void addMenu(String option, OnSelection action) {
        menuOptions.put(option, action);
    }

    @Override
    public void draw() {
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

        new ReportMostExpensiveOrder().create(Program.getInstance());

        Message.pressAnyKeyToExit();
        scanner.nextLine();

        draw();
    }

    private void drawReportProductWithLowestInventory() {
        clearConsole();

        new ReportLowestInventoryProduct().create(Program.getInstance());

        Message.pressAnyKeyToExit();
        scanner.nextLine();

        draw();
    }

    private void drawFullReport() {
        clearConsole();

        new FullReport().create(Program.getInstance());

        Message.pressAnyKeyToExit();
        scanner.nextLine();

        draw();
    }
}