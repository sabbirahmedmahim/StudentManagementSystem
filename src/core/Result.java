package core;

public class Result {
    private String studentId;
    private String courseId;
    private double marks;
    private String grade;

    public Result(String studentId, String courseId, double marks, String grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.marks = marks;
        this.grade = grade;
    }

    public String getStudentId() { return studentId; }
    public String getCourseId() { return courseId; }
    public double getMarks() { return marks; }
    public String getGrade() { return grade; }
}