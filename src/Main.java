import core.Admin;
import core.Student;
import core.Teacher;
import core.User;
import service.UserManager;
import java.util.Scanner;

public class Main {
    private static UserManager userManager = new UserManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        seedData();

        boolean running = true;
        while (running) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Teacher");
            System.out.println("3. Login as Student");
            System.out.println("4. Exit");
            System.out.print("Choose your portal: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    handleLogin("Admin");
                    break;
                case "2":
                    handleLogin("Teacher");
                    break;
                case "3":
                    handleLogin("Student");
                    break;
                case "4":
                    running = false;
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private static void handleLogin(String expectedRole) {
        System.out.println("\n--- " + expectedRole + " Login ---");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (userManager.login(username, password)) {
            User currentUser = userManager.getLoggedInUser();
            boolean hasPermission = false;

            if (expectedRole.equals("Admin") && currentUser instanceof Admin) {
                hasPermission = true;
            } else if (expectedRole.equals("Teacher") && currentUser instanceof Teacher) {
                hasPermission = true;
            } else if (expectedRole.equals("Student") && currentUser instanceof Student) {
                hasPermission = true;
            }

            if (hasPermission) {
                System.out.println("\nLogin successful!");

                currentUser.displayDashboard(scanner);
            } else {
                System.out.println("\nAccess Denied: You do not have permission to access the " + expectedRole + " portal.");
            }

            userManager.logout();
        } else {
            System.out.println("\nInvalid credentials. Please try again.");
        }
    }

    private static void seedData() {
        userManager.add(new Admin("A01", "System Admin", "admin", "admin123"));
        userManager.add(new Teacher("T01", "Dr. Rahman", "rahman_cse", "teach123", "CSE"));
        userManager.add(new Student("S101", "Mahim", "mahim_cse", "pass123", "CSE", 46));
    }
}
