package service;

import core.Result;
import interfaces.Managable;
import interfaces.Reportable;
import java.util.ArrayList;
import java.util.List;

public class ResultManager implements Managable<Result>, Reportable {
    private List<Result> results;

    public ResultManager() {
        this.results = new ArrayList<>();
    }

    @Override
    public void add(Result item) { results.add(item); }

    @Override
    public void update(Result item) { }

    @Override
    public void delete(String id) { }

    @Override
    public Result get(String id) { return null; }

    public List<Result> getResultsByStudent(String studentId) {
        List<Result> studentResults = new ArrayList<>();
        for (Result r : results) {
            if (r.getStudentId().equals(studentId)) {
                studentResults.add(r);
            }
        }
        return studentResults;
    }

    @Override
    public void generateReport() {
        System.out.println("\n--- Academic Performance Report ---");
        System.out.println("Total grades submitted: " + results.size());
    }
}