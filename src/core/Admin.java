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

            System.out.println("1. View All Users");
            System.out.println("2. Add New User");
            System.out.println("3. Delete User");
            System.out.println("4. Logout");

            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    System.out.println("Showing all users...");
                    System.out.println("(Feature will connect with UserManager)");
                    break;

                case "2":
                    System.out.println("Add new user selected.");
                    System.out.print("Enter User Name: ");
                    String newUser = scanner.nextLine();

                    System.out.println(newUser + " added successfully!");
                    break;

                case "3":
                    System.out.print("Enter User ID to delete: ");
                    String deleteId = scanner.nextLine();

                    System.out.println("User ID " + deleteId + " deleted successfully!");
                    break;

                case "4":
                    inDashboard = false;
                    System.out.println("Logging out of Admin portal...");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
