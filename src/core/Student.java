package core;

import java.util.Scanner;

public class Student extends User {
    private String department;
    private int batch;

    public Student(String id, String name, String username, String password, String department, int batch) {
        super(id, name, username, password);
        this.department = department;
        this.batch = batch;
    }

    @Override
    public void displayDashboard(Scanner scanner) {
        boolean inDashboard = true;
        while (inDashboard) {
            System.out.println("\n--- Student Dashboard ---");
            System.out.println("Welcome, " + name + " (Batch " + batch + ")");
            System.out.println("Department: " + department);
            System.out.println("1. View My Results (Coming Soon)");
            System.out.println("2. Logout");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            if (choice.equals("2")) {
                inDashboard = false;
                System.out.println("Logging out of Student portal...");
            } else {
                System.out.println("Feature not implemented yet.");
            }
        }
    }
}