// /Sprint-001/Story-001/source/Student.java

package com.efee.domain.student;
import java.util.Objects;

public class Student {

    private final String studentIdentifier;
    private String studentName;
    private String academicProfile;
    private boolean active;

    public Student(
            String studentIdentifier,
            String studentName,
            String academicProfile) {

        if (studentIdentifier == null || studentIdentifier.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Student Identifier cannot be null or empty");
        }

        if (studentName == null || studentName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Student Name cannot be null or empty");
        }

        if (academicProfile == null || academicProfile.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Academic Profile cannot be null or empty");
        }

        this.studentIdentifier = studentIdentifier;
        this.studentName = studentName;
        this.academicProfile = academicProfile;
        this.active = true;
    }

    public String getStudentIdentifier() {
        return studentIdentifier;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getAcademicProfile() {
        return academicProfile;
    }

    public boolean isActive() {
        return active;
    }

    public void update(
            String studentName,
            String academicProfile) {

        if (studentName == null || studentName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Student Name cannot be null or empty");
        }

        if (academicProfile == null || academicProfile.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Academic Profile cannot be null or empty");
        }

        this.studentName = studentName;
        this.academicProfile = academicProfile;
    }

    public void activate() {
        active = true;
    }

    public void deactivate() {
        active = false;
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof Student other)) {
            return false;
        }

        return Objects.equals(
                studentIdentifier,
                other.studentIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentIdentifier);
    }

    @Override
    public String toString() {

        return "Student{" +
                "studentIdentifier='" + studentIdentifier + '\'' +
                ", studentName='" + studentName + '\'' +
                ", academicProfile='" + academicProfile + '\'' +
                ", active=" + active +
                '}';
    }
}