package pbo.Model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author 
 *     12S23003 Chrismansyah Tolhas Siahaan
 *     12S23015 Kevin Kristoforus Samosir
 */

@Entity
@Table(name = "enrollments")
public class Enrollment implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "student_nim", referencedColumnName = "nim", nullable = false)
    private Student student;

    @Id
    @ManyToOne
    @JoinColumn(name = "course_code", referencedColumnName = "code", nullable = false)
    private Course course;

    public Enrollment() {
    }

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Enrollment{" + "studentNim='" + student.getNim() + '\'' + ", courseCode='" + course.getCode() + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Enrollment)) return false;
        Enrollment that = (Enrollment) o;
        return Objects.equals(student.getNim(), that.student.getNim()) &&
               Objects.equals(course.getCode(), that.course.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(student.getNim(), course.getCode());
    }
}
