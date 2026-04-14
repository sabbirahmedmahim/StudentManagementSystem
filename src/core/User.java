package core;

import java.util.Scanner;

public abstract class User {
    protected String id;
    protected String name;
    protected String username;
    protected String password;

    public User(String id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getUsername() { return username; }

    public boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }


    public abstract void displayDashboard(Scanner scanner);
}