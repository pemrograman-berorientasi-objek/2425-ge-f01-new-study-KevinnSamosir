package pbo.Model;

/**
    * @author 12S23003 Chrismansyah Tolhas Siahaan
    * @author 12S23015 Kevin Kristoforus Samosir
 */

public class Course {
    private String courseCode;
    private String courseName;
    private int semester;
    private int credits;

    public Course(String courseCode, String courseName, int semester, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.semester = semester;
        this.credits = credits;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
    
    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", semester=" + semester +
                ", credits=" + credits +
                '}';
    }
}
