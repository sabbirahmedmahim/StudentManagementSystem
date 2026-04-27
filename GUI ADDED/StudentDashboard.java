import javax.swing.*;
import java.awt.*;

public class StudentDashboard extends JFrame {
    private LoginWindow loginWindow;
    private Student student;

    public StudentDashboard(LoginWindow loginWindow, Student student) {
        this.loginWindow = loginWindow;
        this.student = student;

        setTitle("Student Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel title = new JLabel("Welcome, " + student.getName(), SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(title, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));

        JButton attendanceBtn = new JButton("View My Attendance");
        JButton resultBtn = new JButton("View My Result");
        JButton logoutBtn = new JButton("Logout");

        buttonPanel.add(attendanceBtn);
        buttonPanel.add(resultBtn);
        buttonPanel.add(logoutBtn);

        panel.add(buttonPanel, BorderLayout.CENTER);
        add(panel);

        attendanceBtn.addActionListener(e -> showAttendance());
        resultBtn.addActionListener(e -> showResult());
        logoutBtn.addActionListener(e -> logout());

        setVisible(true);
    }

    private void showAttendance() {
        JOptionPane.showMessageDialog(this,
            "Attendance Report\n" +
            "Name: " + student.getName() + "\n" +
            "ID: " + student.getId() + "\n" +
            "Attendance: " + student.getAttendanceSummary(),
            "My Attendance",
            JOptionPane.INFORMATION_MESSAGE);
    }

    private void showResult() {
        JOptionPane.showMessageDialog(this,
            "Result Report\n" +
            "Name: " + student.getName() + "\n" +
            "ID: " + student.getId() + "\n" +
            "Result: " + student.getResultSummary(),
            "My Result",
            JOptionPane.INFORMATION_MESSAGE);
    }

    private void logout() {
        dispose();
        loginWindow.setVisible(true);
    }
}
