package core;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String deptId;
    private String deptName;
    private List<Course> offeredCourses;

    public Department(String deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.offeredCourses = new ArrayList<>();
    }

    public String getDeptId() { return deptId; }
    public String getDeptName() { return deptName; }
    public void addCourse(Course course) { offeredCourses.add(course); }
    public List<Course> getOfferedCourses() { return offeredCourses; }
}