public class Teacher {
    private String name;
    private String id;
    private String username;
    private String password;

    public Teacher(String name, String id, String username, String password) {
        this.name = name;
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getName() { return name; }
    public String getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
}
