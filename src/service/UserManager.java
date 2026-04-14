package service;

import core.User;
import interfaces.Authenticable;
import interfaces.Managable;
import java.util.ArrayList;
import java.util.List;

public class UserManager implements Managable<User>, Authenticable {
    private List<User> users;
    private User loggedInUser;

    public UserManager() {
        this.users = new ArrayList<>();
        this.loggedInUser = null;
    }

    @Override
    public void add(User user) { users.add(user); }

    @Override
    public void update(User user) { }

    @Override
    public void delete(String id) {
        users.removeIf(u -> u.getId().equals(id));
    }

    @Override
    public User get(String id) {
        for (User u : users) {
            if (u.getId().equals(id)) return u;
        }
        return null;
    }

    @Override
    public boolean login(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.checkPassword(password)) {
                loggedInUser = u;
                return true;
            }
        }
        return false;
    }

    @Override
    public void logout() { loggedInUser = null; }

    public User getLoggedInUser() { return loggedInUser; }
}