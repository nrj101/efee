// /Sprint-001/Story-001/source/Student.java

import java.util.Objects;

public class Student {
    private final String studentId;
    private String name;
    private String academicProfile;
    private boolean active;

    public Student(String studentId, String name, String academicProfile, boolean active) {
        this.studentId = studentId;
        this.name = name;
        this.academicProfile = academicProfile;
        this.active = active;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public String getAcademicProfile() {
        return academicProfile;
    }

    public void updateAcademicProfile(String academicProfile) {
        this.academicProfile = academicProfile;
    }

    public boolean isActive() {
        return active;
    }

    public void activate() {
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return active == student.active && studentId.equals(student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, active);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", academicProfile='" + academicProfile + '\'' +
                ", active=" + active +
                '}';
    }
}