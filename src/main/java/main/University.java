package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class University {
    private String FILENAME = "students.data";
    private ArrayList<Student> students;

    public University() {
        this.students = new ArrayList<>();
    }
    public void addStudents(Student student) {
        students.add(student);
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public void listStudents() {
        int i = 0;
        for (Student student:students) {
            System.out.println(students.get(i).getStudentNumber() + ": " + students.get(i).getName());
            i++;
        }
    }
    public void pickStudent() {
        int i = 0;
        for (Student student:students) {
            System.out.println(i + ": " + students.get(i).getName());
            i++;
        }
    }
    public void saveStudents() {
        try {
            ObjectOutputStream studentWriter = new ObjectOutputStream(new FileOutputStream(FILENAME));
            studentWriter.writeObject(students);
            studentWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadStudents() {
        try {
            ObjectInputStream studentReader = new ObjectInputStream(new FileInputStream(FILENAME));
            students = (ArrayList<Student>) studentReader.readObject();
            studentReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
