package core;

import java.util.Scanner;

public class Admin extends User {
    public Admin(String id, String name, String username, String password) {
        super(id, name, username, password);
    }

    @Override
    public void displayDashboard(Scanner scanner) {
        boolean inDashboard = true;
        while (inDashboard) {
            System.out.println("\n--- Admin Dashboard ---");
            System.out.println("Welcome Administrator: " + name);
            System.out.println("1. View All Users (Coming Soon)");
            System.out.println("2. Logout");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            if (choice.equals("2")) {
                inDashboard = false;
                System.out.println("Logging out of Admin portal...");
            } else {
                System.out.println("Feature not implemented yet.");
            }
        }
    }
}