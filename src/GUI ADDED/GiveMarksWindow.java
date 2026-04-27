import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GiveMarksWindow extends JFrame {

    private DataStore dataStore;

    public GiveMarksWindow(TeacherDashboard teacherDashboard, DataStore dataStore) {

        this.dataStore = dataStore;

        setTitle("Give Marks");
        setSize(380, 220);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        List<Student> students = dataStore.getStudents();

        if (students.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No students found.");
            dispose();
            return;
        }

        String[] names = new String[students.size()];
        for (int i = 0; i < students.size(); i++) {
            names[i] = students.get(i).getName() + " (" + students.get(i).getId() + ")";
        }

        JComboBox<String> studentBox = new JComboBox<>(names);
        JTextField marksField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        panel.add(new JLabel("Student:"));
        panel.add(studentBox);

        panel.add(new JLabel("Marks (0-100):"));
        panel.add(marksField);

        JButton submit = new JButton("Submit");
        JButton cancel = new JButton("Cancel");

        panel.add(submit);
        panel.add(cancel);

        add(panel);

        submit.addActionListener(e -> {
            try {
                int marks = Integer.parseInt(marksField.getText().trim());

                if (marks < 0 || marks > 100) {
                    JOptionPane.showMessageDialog(this, "Enter Marks");
                    return;
                }

                students.get(studentBox.getSelectedIndex()).setMarks(marks);

                JOptionPane.showMessageDialog(this, "Marks saved!");
                dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input.");
            }
        });

        cancel.addActionListener(e -> dispose());

        setVisible(true);
    }
}