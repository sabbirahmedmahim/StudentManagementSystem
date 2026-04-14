package service;

import core.Attendance;
import interfaces.Managable;
import interfaces.Reportable;
import java.util.ArrayList;
import java.util.List;

public class AttendanceManager implements Managable<Attendance>, Reportable {
    private List<Attendance> records;

    public AttendanceManager() {
        this.records = new ArrayList<>();
    }

    @Override
    public void add(Attendance item) { records.add(item); }

    @Override
    public void update(Attendance item) { }

    @Override
    public void delete(String id) { }

    @Override
    public Attendance get(String id) { return null; }

    public List<Attendance> getStudentAttendance(String studentId) {
        List<Attendance> studentRecords = new ArrayList<>();
        for (Attendance a : records) {
            if (a.getStudentId().equals(studentId)) {
                studentRecords.add(a);
            }
        }
        return studentRecords;
    }

    @Override
    public void generateReport() {
        System.out.println("\n--- Global Attendance Report ---");
        System.out.println("Total attendance records logged: " + records.size());
    }
}