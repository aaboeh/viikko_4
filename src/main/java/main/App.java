package main;

import java.util.ArrayList;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        University university = new University();

        boolean exit = false;
        while(!exit) {
            System.out.println( "1) Lisää opiskelija, 2) Listaa opiskelijat, 3) Lisää opiskelijalle suorite, 4) Listaa opiskelijan suoritteet, 5) Laske opiskelijan suoritusten keskiarvo, 6) Laske opiskelijan suoritusten mediaani, 7) Tallenna opiskelijat tiedostoon, 8) Lataa opiskelijat tiedostosta, 0) Lopeta ohjelma" );
            if (sc.hasNext()) {
                int i = 0;
                String stringInput = sc.nextLine();
                i = Integer.parseInt(stringInput);

                switch(i) {
                    case 1:
                        System.out.println("Anna opiskelijan nimi?");
                        String name = sc.nextLine();
                        System.out.println("Anna opiskelijan opiskelijanumero:");
                        String studentNumber = sc.nextLine();
                        university.addStudents(new Student(name, studentNumber));
                        break;
                    case 2:
                        System.out.println("Opiskelijat:");
                        university.listStudents();
                        break;
                    case 3:
                        university.pickStudent();
                        System.out.println("Mille opiskelijalle suorite lisätään?");
                        int studentPick = Integer.parseInt(sc.nextLine());
                        System.out.println("Mille kurssille suorite lisätään?");
                        String course = sc.nextLine();
                        System.out.println("Mikä arvosana kurssille lisätään?");
                        int grade = Integer.parseInt(sc.nextLine());
                        university.getStudents().get(studentPick).addGrade(course, grade);
                        break;
                    case 4:
                        university.pickStudent();
                        System.out.println("Minkä opiskelijan suoritteet listataan?");
                        int studentCourses = Integer.parseInt(sc.nextLine());
                        ArrayList<Grade> studentCoursesAndGrades = university.getStudents().get(studentCourses).getCoursesAndGrades();
                        for (Grade courseAndGrade:studentCoursesAndGrades) {
                            System.out.println(courseAndGrade.getCourse() + ": " + courseAndGrade.getGrade());
                        }
                        break;
                    case 5:
                        university.pickStudent();
                        System.out.println("Minkä opiskelijan suoritteiden keskiarvo lasketaan?");
                        int studentAverage = Integer.parseInt(sc.nextLine());
                        System.out.println("Keskiarvo on " + Calculator.getAverageGrade(university.getStudents().get(studentAverage)));
                        break;
                    case 6:
                        university.pickStudent();
                        System.out.println("Minkä opiskelijan suoritteiden mediaani lasketaan?");
                        int studentMedian = Integer.parseInt(sc.nextLine());
                        System.out.println("Mediaani on " + Calculator.getMedianGrade(university.getStudents().get(studentMedian)));
                        break;
                    case 7:
                        university.saveStudents();
                        break;
                    case 8:
                        university.loadStudents();
                        break;
                    case 0:
                        System.out.println("Kiitos ohjelman käytöstä.");
                        exit = true;
                        break;
                    default:
                        System.out.println("Syöte oli väärä");
                }
            }
        }
        sc.close();
    }
}
