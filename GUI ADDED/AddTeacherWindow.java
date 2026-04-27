import javax.swing.*;
import java.awt.*;

public class AddTeacherWindow extends JFrame {
    private AdminDashboard dashboard;
    private DataStore dataStore;

    public AddTeacherWindow(AdminDashboard dashboard, DataStore dataStore) {
        this.dashboard = dashboard;
        this.dataStore = dataStore;

        setTitle("Add Teacher");
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

        panel.add(new JLabel("Teacher ID:"));
        JTextField idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Username:"));
        JTextField usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        JPasswordField passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton addBtn = new JButton("Add Teacher");
        JButton cancelBtn = new JButton("Cancel");
        panel.add(addBtn);
        panel.add(cancelBtn);

        add(new JLabel("Add New Teacher", SwingConstants.CENTER), BorderLayout.NORTH);
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

            if (dataStore.isTeacherUsernameTaken(username)) {
                JOptionPane.showMessageDialog(this, "Username already taken.");
                return;
            }

            dataStore.addTeacher(new Teacher(name, id, username, password));
            JOptionPane.showMessageDialog(this, "Teacher added successfully!");
            dispose();
        });

        cancelBtn.addActionListener(e -> dispose());

        setVisible(true);
    }
}
