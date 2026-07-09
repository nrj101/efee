package com.example.student;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StudentTest {

    @Test
    public void testStudentRegistration() {
        Student student = new Student("S12345", "John Doe", "Undergraduate");
        assertEquals("S12345", student.getStudentId());
        assertEquals("John Doe", student.getName());
        assertEquals("Undergraduate", student.getAcademicProfile());
        assertFalse(student.isActive());
    }

    @Test
    public void testStudentActivation() {
        Student student = new Student("S12345", "John Doe", "Undergraduate");
        student.activate();
        assertTrue(student.isActive());
    }

    @Test
    public void testStudentDeactivation() {
        Student student = new Student("S12345", "John Doe", "Undergraduate");
        student.activate();
        student.deactivate();
        assertFalse(student.isActive());
    }

    @Test
    public void testStudentInformationUpdate() {
        Student student = new Student("S12345", "John Doe", "Undergraduate");
        student.updateInformation("Jane Doe", "Postgraduate");
        assertEquals("Jane Doe", student.getName());
        assertEquals("Postgraduate", student.getAcademicProfile());
    }

    @Test
    public void testInvalidStudentRegistration() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Student("", "John Doe", "Undergraduate");
        });
        assertEquals("Student ID cannot be null or empty", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Student("S12345", "", "Undergraduate");
        });
        assertEquals("Student name cannot be null or empty", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Student("S12345", "John Doe", "");
        });
        assertEquals("Academic profile cannot be null or empty", exception.getMessage());
    }
}