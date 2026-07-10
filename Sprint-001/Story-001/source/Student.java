// /Sprint-001/Story-001/source/Student.java


import java.util.Objects;

public class Student {
    private final String studentId;
    private String name;
    private String academicProfile;
    private boolean active;

    public Student(String studentId, String name, String academicProfile) {
        if (studentId == null || studentId.trim().isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be null or empty");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (academicProfile == null || academicProfile.trim().isEmpty()) {
            throw new IllegalArgumentException("Academic profile cannot be null or empty");
        }
        
        this.studentId = studentId;
        this.name = name;
        this.academicProfile = academicProfile;
        this.active = true; // Aggregate controls initial lifecycle
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void updateInformation(String name, String academicProfile) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (academicProfile == null || academicProfile.trim().isEmpty()) {
            throw new IllegalArgumentException("Academic profile cannot be null or empty");
        }
        
        this.name = name;
        this.academicProfile = academicProfile;
    }

    public String getAcademicProfile() {
        return academicProfile;
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