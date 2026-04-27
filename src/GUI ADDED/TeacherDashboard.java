import javax.swing.*;
import java.awt.*;

public class TeacherDashboard extends JFrame {
    private LoginWindow loginWindow;
    private Teacher teacher;
    private DataStore dataStore;

    public TeacherDashboard(LoginWindow loginWindow, Teacher teacher, DataStore dataStore) {
        this.loginWindow = loginWindow;
        this.teacher = teacher;
        this.dataStore = dataStore;

        setTitle("Teacher Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel title = new JLabel("Welcome, " + teacher.getName(), SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(title, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));

        JButton attendanceBtn = new JButton("Take Attendance");
        JButton marksBtn = new JButton("Give Marks to Student");
        JButton logoutBtn = new JButton("Logout");

        buttonPanel.add(attendanceBtn);
        buttonPanel.add(marksBtn);
        buttonPanel.add(logoutBtn);

        panel.add(buttonPanel, BorderLayout.CENTER);
        add(panel);

        attendanceBtn.addActionListener(e -> openAttendance());
        marksBtn.addActionListener(e -> openGiveMarks());
        logoutBtn.addActionListener(e -> logout());

        setVisible(true);
    }

    private void openAttendance() {
        new TakeAttendanceWindow(this, dataStore);
    }

    private void openGiveMarks() {
        new GiveMarksWindow(this, dataStore);
    }

    private void logout() {
        dispose();
        loginWindow.setVisible(true);
    }
}
