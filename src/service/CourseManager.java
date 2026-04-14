package service;

import core.Course;
import interfaces.Managable;
import java.util.ArrayList;
import java.util.List;

public class CourseManager implements Managable<Course> {
    private List<Course> courses;

    public CourseManager() {
        this.courses = new ArrayList<>();
    }

    @Override
    public void add(Course item) { courses.add(item); }

    @Override
    public void update(Course item) { }

    @Override
    public void delete(String id) {
        courses.removeIf(c -> c.getCourseId().equals(id));
    }

    @Override
    public Course get(String id) {
        for (Course c : courses) {
            if (c.getCourseId().equals(id)) return c;
        }
        return null;
    }

    public List<Course> getAllCourses() { return courses; }
}