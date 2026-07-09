package com.example.student;

public class Student {
    private String studentId;
    private String name;
    private String academicProfile;
    private boolean isActive;

    public Student(String studentId, String name, String academicProfile) {
        if (studentId == null || studentId.isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be null or empty");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be null or empty");
        }
        if (academicProfile == null || academicProfile.isEmpty()) {
            throw new IllegalArgumentException("Academic profile cannot be null or empty");
        }
        this.studentId = studentId;
        this.name = name;
        this.academicProfile = academicProfile;
        this.isActive = false; // Student is registered but not yet activated
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getAcademicProfile() {
        return academicProfile;
    }

    public boolean isActive() {
        return isActive;
    }

    public void activate() {
        if (!isActive) {
            isActive = true;
        }
    }

    public void deactivate() {
        if (isActive) {
            isActive = false;
        }
    }

    public void updateInformation(String name, String academicProfile) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
        if (academicProfile != null && !academicProfile.isEmpty()) {
            this.academicProfile = academicProfile;
        }
    }
}