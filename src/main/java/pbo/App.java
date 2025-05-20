package pbo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import pbo.Model.Course;
import pbo.Model.Enrollment;
import pbo.Model.Student;

/**
    * @author 12S23003 Chrismansyah Tolhas Siahaan
    * @author 12S23015 Kevin Kristoforus Samosir
 */

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Student> students = new TreeMap<>();
        Map<String, Course> courses = new TreeMap<>();
        List<Enrollment> enrollments = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.equals("---")) break;

            String[] parts = line.split("#");
            String command = parts[0];

            switch (command) {
                case "student-add":
                    String nim = parts[1];
                    String name = parts[2];
                    String programStudi = parts[3];
                    students.put(nim, new Student(nim, name, programStudi));
                    break;

                case "course-add":
                    String code = parts[1];
                    String courseName = parts[2];
                    int semester = Integer.parseInt(parts[3]);
                    int credits = Integer.parseInt(parts[4]);
                    courses.put(code, new Course(code, courseName, semester, credits));
                    break;

                case "enroll":
                    String studentNim = parts[1];
                    String courseCode = parts[2];
                    enrollments.add(new Enrollment(studentNim, courseCode));
                    break;

                case "student-show":
                    String targetNim = parts[1];
                    Student student = students.get(targetNim);
                    if (student != null) {
                        System.out.println(student.getNim() + "|" + student.getName() + "|" + student.getProgramStudi());
                        List<Course> studentCourses = new ArrayList<>();
                        for (Enrollment e : enrollments) {
                            if (e.getStudentNim().equals(targetNim)) {
                                Course c = courses.get(e.getCourseCode());
                                if (c != null) studentCourses.add(c);
                            }
                        }
                        studentCourses.sort(Comparator.comparing(Course::getCourseCode));
                        for (Course c : studentCourses) {
                            System.out.println(c.getCourseCode() + "|" + c.getCourseName() + "|" + c.getSemester() + "|" + c.getCredits());
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }
}
