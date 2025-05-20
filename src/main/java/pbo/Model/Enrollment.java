package pbo.Model;

/**
    * @author 12S23003 Chrismansyah Tolhas Siahaan
    * @author 12S23015 Kevin Kristoforus Samosir
 */

public class Enrollment {
    private String studentNim;
    private String courseCode;

    public Enrollment(String studentNim, String courseCode) {
        this.studentNim = studentNim;
        this.courseCode = courseCode;
    }

    public String getStudentNim() {
        return studentNim;
    }

    public void setStudentNim(String studentNim) {
        this.studentNim = studentNim;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public String toString() {
    return "Enrollment{" + "studentNim='" + studentNim + '\'' + ", courseCode='" + courseCode + '\'' +'}';
    }
}
