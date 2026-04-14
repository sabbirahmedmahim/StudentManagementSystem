package core;

import java.time.LocalDate;

public class Attendance {
    private String studentId;
    private String courseId;
    private LocalDate date;
    private boolean isPresent;

    public Attendance(String studentId, String courseId, LocalDate date, boolean isPresent) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.date = date;
        this.isPresent = isPresent;
    }

    public String getStudentId() { return studentId; }
    public String getCourseId() { return courseId; }
    public LocalDate getDate() { return date; }
    public boolean isPresent() { return isPresent; }
}