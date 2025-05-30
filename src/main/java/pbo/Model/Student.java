package pbo.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author 
 *     12S23003 Chrismansyah Tolhas Siahaan
 *     12S23015 Kevin Kristoforus Samosir
 */

@Entity
@Table(name = "students")
public class Student {

    @Id
    @Column(name = "nim", nullable = false, unique = true)
    private String nim;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "program_studi", nullable = false)
    private String programStudi;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JoinTable(
        name = "enrollments",
        joinColumns = @JoinColumn(name = "student_nim"),
        inverseJoinColumns = @JoinColumn(name = "course_code")
    )
    private List<Course> courses = new ArrayList<>();

    public Student() {                      
    }

    public Student(String nim, String name, String programStudi) {
        this.nim = nim;
        this.name = name;
        this.programStudi = programStudi;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgramStudi() {
        return programStudi;
    }

    public void setProgramStudi(String programStudi) {
        this.programStudi = programStudi;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public boolean enrollCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return nim + "|" + name + "|" + programStudi;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return nim.equals(student.nim);
    }

    @Override
    public int hashCode() {
        return nim.hashCode();
    }
}
