package main;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable{
    private String name;
    private String studentNumber;
    private ArrayList<Grade> courses_and_grades;

    public Student (String name, String studentNumber){
        this.name = name;
        this.studentNumber = studentNumber;
        this.courses_and_grades = new ArrayList<>();
    }
    public void addGrade (String course, int grade) {
        courses_and_grades.add(new Grade(course, grade));
    }
    public String getName() {
        return name;
    }

    public String getStudentNumber() {
        return studentNumber;
    }
    public ArrayList<Grade> getCoursesAndGrades() {
        return courses_and_grades;
    }
}
