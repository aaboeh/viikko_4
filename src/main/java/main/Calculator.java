package main;

import java.util.ArrayList;
import java.util.Collections;

public class Calculator {
    public static double getAverageGrade(Student s) {
        double sum = 0;
        ArrayList<Grade> grades = s.getCoursesAndGrades();
        if (grades.isEmpty()) {
            return sum;
        }
        for (Grade grade:grades) {
            sum += grade.getGrade();
        }
        return sum / grades.size();
    }
    public static double getMedianGrade(Student s) {
        ArrayList<Grade> grades = s.getCoursesAndGrades();
        if (grades.isEmpty())
            return 0.0;
        ArrayList<Integer> gradeValues = new ArrayList<>();
        for (Grade grade : grades) {
            gradeValues.add(grade.getGrade());
        }
        Collections.sort(gradeValues);
        int size = gradeValues.size();        
        double median = size/2;
        if (size % 2 == 0) {
            int middleNumber1 = (size/2) - 1;
            int middleNumber2 = size/2;
            double sum = gradeValues.get(middleNumber1) + gradeValues.get(middleNumber2);
            median = sum / 2;
        }
        else {
            median = gradeValues.get(size/2);
        }
        return median;
    }
}
