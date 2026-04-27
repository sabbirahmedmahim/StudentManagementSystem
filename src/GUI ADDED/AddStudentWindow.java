import javax.swing.*;
import java.awt.*;

public class AddStudentWindow extends JFrame {
    private AdminDashboard dashboard;
    private DataStore dataStore;

    public AddStudentWindow(AdminDashboard dashboard, DataStore dataStore) {
        this.dashboard = dashboard;
        this.dataStore = dataStore;

        setTitle("Add Student");
        setSize(380, 280);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        panel.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Student ID:"));
        JTextField idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Username:"));
        JTextField usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        JPasswordField passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton addBtn = new JButton("Add Student");
        JButton cancelBtn = new JButton("Cancel");
        panel.add(addBtn);
        panel.add(cancelBtn);

        add(new JLabel("Add New Student", SwingConstants.CENTER), BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        addBtn.addActionListener(e -> {
            String name = nameField.getText().trim();
            String id = idField.getText().trim();
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            if (name.isEmpty() || id.isEmpty() || username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
                return;
            }

            if (dataStore.isStudentUsernameTaken(username)) {
                JOptionPane.showMessageDialog(this, "Username already taken.");
                return;
            }

            dataStore.addStudent(new Student(name, id, username, password));
            JOptionPane.showMessageDialog(this, "Student added successfully!");
            dispose();
        });

        cancelBtn.addActionListener(e -> dispose());

        setVisible(true);
    }
}
