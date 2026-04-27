import javax.swing.*;
import java.awt.*;

public class AdminDashboard extends JFrame {
    private LoginWindow loginWindow;
    private DataStore dataStore;

    public AdminDashboard(LoginWindow loginWindow) {
        this.loginWindow = loginWindow;
        this.dataStore = DataStore.getInstance();

        setTitle("Admin Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel title = new JLabel("Welcome, Admin", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(title, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));

        JButton addTeacherBtn = new JButton("Add Teacher");
        JButton addStudentBtn = new JButton("Add Student");
        JButton logoutBtn = new JButton("Logout");

        buttonPanel.add(addTeacherBtn);
        buttonPanel.add(addStudentBtn);
        buttonPanel.add(logoutBtn);

        panel.add(buttonPanel, BorderLayout.CENTER);
        add(panel);

        addTeacherBtn.addActionListener(e -> openAddTeacher());
        addStudentBtn.addActionListener(e -> openAddStudent());
        logoutBtn.addActionListener(e -> logout());

        setVisible(true);
    }

    private void openAddTeacher() {
        new AddTeacherWindow(this, dataStore);
    }

    private void openAddStudent() {
        new AddStudentWindow(this, dataStore);
    }

    private void logout() {
        dispose();
        loginWindow.setVisible(true);
    }
}
