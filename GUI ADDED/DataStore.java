import java.util.ArrayList;
import java.util.List;

public class DataStore {
    private static DataStore instance;
    private List<Teacher> teachers;
    private List<Student> students;

    private DataStore() {
        teachers = new ArrayList<>();
        students = new ArrayList<>();
    }

    public static DataStore getInstance() {
        if (instance == null) {
            instance = new DataStore();
        }
        return instance;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Teacher findTeacher(String username, String password) {
        for (Teacher t : teachers) {
            if (t.getUsername().equals(username) && t.getPassword().equals(password)) {
                return t;
            }
        }
        return null;
    }

    public Student findStudent(String username, String password) {
        for (Student s : students) {
            if (s.getUsername().equals(username) && s.getPassword().equals(password)) {
                return s;
            }
        }
        return null;
    }

    public boolean isTeacherUsernameTaken(String username) {
        for (Teacher t : teachers) {
            if (t.getUsername().equals(username)) return true;
        }
        return false;
    }

    public boolean isStudentUsernameTaken(String username) {
        for (Student s : students) {
            if (s.getUsername().equals(username)) return true;
        }
        return false;
    }
}
