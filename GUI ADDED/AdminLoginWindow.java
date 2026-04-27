import javax.swing.*;
import java.awt.*;

public class AdminLoginWindow extends JFrame {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";
    private LoginWindow loginWindow;

    public AdminLoginWindow(LoginWindow loginWindow) {
        this.loginWindow = loginWindow;

        setTitle("Admin Login");
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

        add(new JLabel("Admin Login", SwingConstants.CENTER), BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        loginBtn.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
                dispose();
                new AdminDashboard(loginWindow);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }
        });

        backBtn.addActionListener(e -> {
            dispose();
            loginWindow.setVisible(true);
        });

        setVisible(true);
    }
}
