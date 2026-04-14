package core;

import java.util.Scanner;

public class Teacher extends User {
    private String department;

    public Teacher(String id, String name, String username, String password, String department) {
        super(id, name, username, password);
        this.department = department;
    }

    @Override
    public void displayDashboard(Scanner scanner) {
        boolean inDashboard = true;
        while (inDashboard) {
            System.out.println("\n--- Teacher Dashboard ---");
            System.out.println("Welcome, Professor " + name);
            System.out.println("Department: " + department);
            System.out.println("1. Add Student Result (Coming Soon)");
            System.out.println("2. Logout");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            if (choice.equals("2")) {
                inDashboard = false;
                System.out.println("Logging out of Teacher portal...");
            } else {
                System.out.println("Feature not implemented yet.");
            }
        }
    }
}