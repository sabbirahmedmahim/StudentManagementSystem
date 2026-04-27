import javax.swing.*;
import java.awt.*;

public class StudentLoginWindow extends JFrame {
    private LoginWindow loginWindow;
    private DataStore dataStore;

    public StudentLoginWindow(LoginWindow loginWindow) {
        this.loginWindow = loginWindow;
        this.dataStore = DataStore.getInstance();

        setTitle("Student Login");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        panel.add(new JLabel("Username:"));
        JTextField usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        JPasswordField passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton loginBtn = new JButton("Login");
        JButton backBtn = new JButton("Back");
        panel.add(loginBtn);
        panel.add(backBtn);

        add(new JLabel("Student Login", SwingConstants.CENTER), BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        loginBtn.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            Student student = dataStore.findStudent(username, password);
            if (student != null) {
                dispose();
                new StudentDashboard(loginWindow, student);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials or student not found.");
            }
        });

        backBtn.addActionListener(e -> {
            dispose();
            loginWindow.setVisible(true);
        });

        setVisible(true);
    }
}
