package pbo.Model;

/**
    * @author 12S23003 Chrismansyah Tolhas Siahaan
    * @author 12S23015 Kevin Kristoforus Samosir
 */

public class Student {
    private String nim;
    private String name;
    private String programStudi;

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

    @Override
    public String toString() {
        return "Student{" +  "nim='" + nim + '\'' + ", name='" + name + '\'' + ", programStudi='" + programStudi + '\'' +'}';
    }
}
