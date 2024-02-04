package main;

import java.util.ArrayList;

public class Calculator {
    public static double getAverageGrade(Student s) {
        double sum = 0;
        ArrayList<Grade> grades = s.getCoursesAndGrades();
        for (Grade grade:grades) {
            sum += grade.getGrade();
        }
        return sum / grades.size();
    }
    public static double getMedianGrade(Student s) {
        ArrayList<Grade> grades = s.getCoursesAndGrades();
        if (grades.size() % 2 != 0) {
            double median = grades.get(grades.size()/2).getGrade();
            return median;
        }
        else {
            int middleNumber1 = grades.size()/2 - 1;
            int middleNumber2 = grades.size()/2;
            double median = (grades.get(middleNumber1).getGrade() + grades.get(middleNumber2).getGrade()) / 2;
            return median;
        }
    }
}