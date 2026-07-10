// /Sprint-001/Story-001/tests/StudentTest.java

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StudentTest {

    @Test
    public void testStudentCreation() {
        Student student = new Student("S123", "John Doe", "Undergraduate", true);
        assertEquals("S123", student.getStudentId());
        assertEquals("John Doe", student.getName());
        assertEquals("Undergraduate", student.getAcademicProfile());
        assertTrue(student.isActive());
    }

    @Test
    public void testStudentUpdateName() {
        Student student = new Student("S123", "John Doe", "Undergraduate", true);
        student.updateName("Jane Doe");
        assertEquals("Jane Doe", student.getName());
    }

    @Test
    public void testStudentUpdateAcademicProfile() {
        Student student = new Student("S123", "John Doe", "Undergraduate", true);
        student.updateAcademicProfile("Postgraduate");
        assertEquals("Postgraduate", student.getAcademicProfile());
    }

    @Test
    public void testStudentActivation() {
        Student student = new Student("S123", "John Doe", "Undergraduate", false);
        student.activate();
        assertTrue(student.isActive());
    }

    @Test
    public void testStudentDeactivation() {
        Student student = new Student("S123", "John Doe", "Undergraduate", true);
        student.deactivate();
        assertFalse(student.isActive());
    }

    @Test
    public void testStudentEquality() {
        Student student1 = new Student("S123", "John Doe", "Undergraduate", true);
        Student student2 = new Student("S123", "John Doe", "Undergraduate", true);
        assertEquals(student1, student2);
    }

    @Test
    public void testStudentInequality() {
        Student student1 = new Student("S123", "John Doe", "Undergraduate", true);
        Student student2 = new Student("S124", "Jane Doe", "Postgraduate", false);
        assertNotEquals(student1, student2);
    }
}