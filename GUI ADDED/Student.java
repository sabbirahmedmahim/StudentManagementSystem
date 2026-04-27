public class Student {
    private String name;
    private String id;
    private String username;
    private String password;
    private int attendanceCount;
    private int totalClasses;
    private int marks;
    private boolean hasMarks;

    public Student(String name, String id, String username, String password) {
        this.name = name;
        this.id = id;
        this.username = username;
        this.password = password;
        this.attendanceCount = 0;
        this.totalClasses = 0;
        this.marks = 0;
        this.hasMarks = false;
    }

    public String getName() { return name; }
    public String getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public int getAttendanceCount() { return attendanceCount; }
    public int getTotalClasses() { return totalClasses; }
    public int getMarks() { return marks; }
    public boolean isHasMarks() { return hasMarks; }

    public void markPresent() {
        attendanceCount++;
        totalClasses++;
    }

    public void markAbsent() {
        totalClasses++;
    }

    public void setMarks(int marks) {
        this.marks = marks;
        this.hasMarks = true;
    }

    public String getAttendanceSummary() {
        if (totalClasses == 0) return "No classes held";
        return attendanceCount + " / " + totalClasses + " classes attended";
    }

    public String getResultSummary() {
        if (!hasMarks) return "No result given yet";
        return "Marks: " + marks + " / 100";
    }
}
