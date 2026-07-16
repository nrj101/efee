
package com.efee.domain.student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void shouldCreateStudent() {

        Student student = new Student(
                "S123",
                "John Doe",
                "Undergraduate"
        );

        assertEquals("S123", student.getStudentIdentifier());
        assertEquals("John Doe", student.getStudentName());
        assertEquals("Undergraduate", student.getAcademicProfile());
        assertTrue(student.isActive());
    }

    @Test
    void shouldRejectEmptyStudentIdentifier() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Student("", "John Doe", "Undergraduate")
        );

        assertEquals(
                "Student Identifier cannot be null or empty",
                exception.getMessage()
        );
    }

    @Test
    void shouldRejectEmptyStudentName() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Student("S123", "", "Undergraduate")
        );

        assertEquals(
                "Student Name cannot be null or empty",
                exception.getMessage()
        );
    }

    @Test
    void shouldRejectEmptyAcademicProfile() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Student("S123", "John Doe", "")
        );

        assertEquals(
                "Academic Profile cannot be null or empty",
                exception.getMessage()
        );
    }

    @Test
    void shouldUpdateStudentInformation() {

        Student student = new Student(
                "S123",
                "John Doe",
                "Undergraduate"
        );

        student.update(
                "Jane Doe",
                "Postgraduate"
        );

        assertEquals("Jane Doe", student.getStudentName());
        assertEquals("Postgraduate", student.getAcademicProfile());
    }

    @Test
    void shouldRejectEmptyStudentNameDuringUpdate() {

        Student student = new Student(
                "S123",
                "John Doe",
                "Undergraduate"
        );

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> student.update("", "Postgraduate")
        );

        assertEquals(
                "Student Name cannot be null or empty",
                exception.getMessage()
        );
    }

    @Test
    void shouldRejectEmptyAcademicProfileDuringUpdate() {

        Student student = new Student(
                "S123",
                "John Doe",
                "Undergraduate"
        );

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> student.update("Jane Doe", "")
        );

        assertEquals(
                "Academic Profile cannot be null or empty",
                exception.getMessage()
        );
    }

    @Test
    void shouldActivateStudent() {

        Student student = new Student(
                "S123",
                "John Doe",
                "Undergraduate"
        );

        student.deactivate();
        student.activate();

        assertTrue(student.isActive());
    }

    @Test
    void shouldDeactivateStudent() {

        Student student = new Student(
                "S123",
                "John Doe",
                "Undergraduate"
        );

        student.deactivate();

        assertFalse(student.isActive());
    }

    @Test
    void studentsWithSameIdentifierShouldBeEqual() {

        Student first = new Student(
                "S123",
                "John Doe",
                "Undergraduate"
        );

        Student second = new Student(
                "S123",
                "Jane Doe",
                "Postgraduate"
        );

        assertEquals(first, second);
    }

    @Test
    void studentsWithDifferentIdentifiersShouldNotBeEqual() {

        Student first = new Student(
                "S123",
                "John Doe",
                "Undergraduate"
        );

        Student second = new Student(
                "S124",
                "John Doe",
                "Undergraduate"
        );

        assertNotEquals(first, second);
    }

    @Test
    void equalityShouldNotDependOnLifecycleState() {

        Student first = new Student(
                "S123",
                "John Doe",
                "Undergraduate"
        );

        Student second = new Student(
                "S123",
                "John Doe",
                "Undergraduate"
        );

        second.deactivate();

        assertEquals(first, second);
    }

    @Test
    void shouldNotEqualNull() {

        Student student = new Student(
                "S123",
                "John Doe",
                "Undergraduate"
        );

        assertNotEquals(student, null);
    }

    @Test
    void shouldEqualSameInstance() {

        Student student = new Student(
                "S123",
                "John Doe",
                "Undergraduate"
        );

        assertEquals(student, student);
    }
}