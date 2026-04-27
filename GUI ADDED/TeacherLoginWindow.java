import javax.swing.*;
import java.awt.*;

public class TeacherLoginWindow extends JFrame {
    private LoginWindow loginWindow;
    private DataStore dataStore;

    public TeacherLoginWindow(LoginWindow loginWindow) {
        this.loginWindow = loginWindow;
        this.dataStore = DataStore.getInstance();

        setTitle("Teacher Login");
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

        add(new JLabel("Teacher Login", SwingConstants.CENTER), BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        loginBtn.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            Teacher teacher = dataStore.findTeacher(username, password);
            if (teacher != null) {
                dispose();
                new TeacherDashboard(loginWindow, teacher, dataStore);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials or teacher not found.");
            }
        });

        backBtn.addActionListener(e -> {
            dispose();
            loginWindow.setVisible(true);
        });

        setVisible(true);
    }
}
