package interfaces;

public interface Authenticable {
    boolean login(String username, String password);
    void logout();
}