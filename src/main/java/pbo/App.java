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
 * @author 
 *     12S23003 Chrismansyah Tolhas Siahaan
 *     12S23015 Kevin Kristoforus Samosir
 */

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            Map<String, Student> students = new TreeMap<>();
            Map<String, Course> courses = new TreeMap<>();
            List<Enrollment> enrollments = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.equals("---")) break;

                String[] parts = line.split("#");
                String command = parts[0];

                switch (command) {
                    case "student-add": {
                        String nim = parts[1];
                        String name = parts[2];
                        String programStudi = parts[3];
                        students.putIfAbsent(nim, new Student(nim, name, programStudi));
                        break;
                    }

                    case "course-add": {
                        String code = parts[1];
                        String courseName = parts[2];
                        int semester = Integer.parseInt(parts[3]);
                        int credits = Integer.parseInt(parts[4]);
                        courses.putIfAbsent(code, new Course(code, courseName, semester, credits));
                        break;
                    }

                    case "enroll": {
                        String studentNim = parts[1];
                        String courseCode = parts[2];
                        Student student = students.get(studentNim);
                        Course course = courses.get(courseCode);

                        if (student != null && course != null) {
                            boolean alreadyEnrolled = enrollments.stream().anyMatch(e ->
                                e.getStudent().getNim().equals(studentNim) &&
                                e.getCourse().getCode().equals(courseCode)
                            );
                            if (!alreadyEnrolled) {
                                enrollments.add(new Enrollment(student, course));
                            }
                        }
                        break;
                    }

                    case "student-show": {
                        String targetNim = parts[1];
                        Student student = students.get(targetNim);
                        if (student != null) {
                            System.out.println(student.getNim() + "|" + student.getName() + "|" + student.getProgramStudi());
                            List<Course> enrolledCourses = new ArrayList<>();
                            for (Enrollment e : enrollments) {
                                if (e.getStudent().getNim().equals(targetNim)) {
                                    enrolledCourses.add(e.getCourse());
                                }
                            }
                            enrolledCourses.sort(Comparator.comparing(Course::getCode));
                            for (Course c : enrolledCourses) {
                                System.out.println(c.getCode() + "|" + c.getName() + "|" + c.getSemester() + "|" + c.getCredits());
                            }
                        }
                        break;
                    }

                    case "student-show-all": {
                        for (Student s : students.values()) {
                            System.out.println(s.getNim() + "|" + s.getName() + "|" + s.getProgramStudi());
                        }
                        break;
                    }

                    case "course-show-all": {
                        for (Course c : courses.values()) {
                            System.out.println(c.getCode() + "|" + c.getName() + "|" + c.getSemester() + "|" + c.getCredits());
                        }
                        break;
                    }

                    default:
                        // Ignore unrecognized command
                        break;
                }
            }
        }
    }
}
