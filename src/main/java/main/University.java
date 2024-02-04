package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class University {
    private String FILENAME;
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
    public void writeFile() {
        FILENAME = "students.txt";
        
        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FILENAME, true));
            fileWriter.write("\n");
            fileWriter.close();
            //System.out.println("Logimerkintä kirjattu");
        } catch (IOException e) {
            System.out.println("Virhe kirjoitettaessa logitiedostoa");
        }
    }
    public void readFile() {
        
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(FILENAME));
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Virhe kirjoitettaessa logitiedostoa");
        }
    }
}
