import javax.swing.*;
import java.awt.*;

public class LoginWindow extends JFrame {

    public LoginWindow() {
        setTitle("Student Management System");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel title = new JLabel("Student Management System", SwingConstants.CENTER);
        title.setFont(new Font("Times new roman", Font.BOLD, 16));
        panel.add(title, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 10, 10));

        JButton adminBtn = new JButton("Login as Admin");
        JButton teacherBtn = new JButton("Login as Teacher");
        JButton studentBtn = new JButton("Login as Student");
        JButton exitBtn = new JButton("Exit");

        buttonPanel.add(adminBtn);
        buttonPanel.add(teacherBtn);
        buttonPanel.add(studentBtn);
        buttonPanel.add(exitBtn);

        panel.add(buttonPanel, BorderLayout.CENTER);
        add(panel);

        adminBtn.addActionListener(e -> openAdminLogin());
        teacherBtn.addActionListener(e -> openTeacherLogin());
        studentBtn.addActionListener(e -> openStudentLogin());
        exitBtn.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void openAdminLogin() {
        new AdminLoginWindow(this);
        setVisible(false);
    }

    private void openTeacherLogin() {
        new TeacherLoginWindow(this);
        setVisible(false);
    }

    private void openStudentLogin() {
        new StudentLoginWindow(this);
        setVisible(false);
    }
}
