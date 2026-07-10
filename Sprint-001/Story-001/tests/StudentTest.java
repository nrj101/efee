// /Sprint-001/Story-001/tests/StudentTest.java


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StudentTest {

    @Test
    public void testStudentCreation() {
        Student student = new Student("S123", "John Doe", "Undergraduate");
        assertEquals("S123", student.getStudentId());
        assertEquals("John Doe", student.getName());
        assertEquals("Undergraduate", student.getAcademicProfile());
        assertTrue(student.isActive());
    }

    @Test
    public void testStudentCreationWithInvalidStudentId() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
            new Student("", "John Doe", "Undergraduate")
        );
        assertEquals("Student ID cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testStudentCreationWithInvalidName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
            new Student("S123", "", "Undergraduate")
        );
        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testStudentCreationWithInvalidAcademicProfile() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
            new Student("S123", "John Doe", "")
        );
        assertEquals("Academic profile cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testStudentUpdateInformation() {
        Student student = new Student("S123", "John Doe", "Undergraduate");
        student.updateInformation("Jane Doe", "Postgraduate");
        assertEquals("Jane Doe", student.getName());
        assertEquals("Postgraduate", student.getAcademicProfile());
    }

    @Test
    public void testStudentUpdateInformationWithInvalidName() {
        Student student = new Student("S123", "John Doe", "Undergraduate");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
            student.updateInformation("", "Postgraduate")
        );
        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testStudentUpdateInformationWithInvalidAcademicProfile() {
        Student student = new Student("S123", "John Doe", "Undergraduate");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
            student.updateInformation("Jane Doe", "")
        );
        assertEquals("Academic profile cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testStudentActivation() {
        Student student = new Student("S123", "John Doe", "Undergraduate");
        student.activate();
        assertTrue(student.isActive());
    }

    @Test
    public void testStudentDeactivation() {
        Student student = new Student("S123", "John Doe", "Undergraduate");
        student.deactivate();
        assertFalse(student.isActive());
    }

    @Test
    public void testStudentEquality() {
        Student student1 = new Student("S123", "John Doe", "Undergraduate");
        Student student2 = new Student("S123", "John Doe", "Undergraduate");
        assertEquals(student1, student2);
    }

    @Test
    public void testStudentInequality() {
        Student student1 = new Student("S123", "John Doe", "Undergraduate");
        Student student2 = new Student("S124", "Jane Doe", "Postgraduate");
        assertNotEquals(student1, student2);
    }
}