import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TakeAttendanceWindow extends JFrame {

    private List<Student> studentList;
    private JCheckBox[] checkBoxes;

    public TakeAttendanceWindow(TeacherDashboard teacherDashboard, DataStore dataStore) {

        setTitle("Take Attendance");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        studentList = dataStore.getStudents();

        if (studentList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No students found.");
            dispose();
            return;
        }

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        mainPanel.add(new JLabel(
                "Select Present Students",
                SwingConstants.CENTER
        ), BorderLayout.NORTH);

        JPanel studentPanel = new JPanel(new GridLayout(studentList.size(), 1, 5, 5));

        checkBoxes = new JCheckBox[studentList.size()];

        for (int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);
            checkBoxes[i] = new JCheckBox(s.getName() + " (ID: " + s.getId() + ")");
            studentPanel.add(checkBoxes[i]);
        }

        mainPanel.add(new JScrollPane(studentPanel), BorderLayout.CENTER);

        JButton submitButton = new JButton("Submit");
        mainPanel.add(submitButton, BorderLayout.SOUTH);

        submitButton.addActionListener(e -> submitAttendance());

        add(mainPanel);
        setVisible(true);
    }

    private void submitAttendance() {
        for (int i = 0; i < studentList.size(); i++) {
            if (checkBoxes[i].isSelected()) {
                studentList.get(i).markPresent();
            } else {
                studentList.get(i).markAbsent();
            }
        }

        JOptionPane.showMessageDialog(this, "Attendance saved!");
        dispose();
    }
}