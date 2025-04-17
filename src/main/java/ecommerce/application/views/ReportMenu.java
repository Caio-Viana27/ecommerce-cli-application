package ecommerce.application.views;

import ecommerce.application.interfaces.IReport;
import ecommerce.application.interfaces.Menu;
import ecommerce.application.models.Program;

import java.util.Scanner;

public class ReportMenu extends Menu {

    public ReportMenu(Scanner scanner) {
        super(scanner);
    }

    //System.out.println("    1 - Report (most expensive order)");
    //System.out.println("    2 - Report (product with lowest inventory)");
    //System.out.println("    3 - Full Report");

    @Override
    public void draw() {
        System.out.println("menu report");
    }

    private void report(Program program, IReport report) {
        report.create(program);
    }
}