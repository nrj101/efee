// /Sprint-001/Story-002/tests/AcademicYearTest.java

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AcademicYearTest {
    @Test
    public void testActivate() {
        AcademicYear year = new AcademicYear("1", "2026", LocalDate.of(2026, 7, 1), LocalDate.of(2027, 6, 30));
        year.activate();
        assertEquals(AcademicYear.AcademicYearStatus.ACTIVE, year.getStatus());
    }

    @Test
    public void testClose() {
        AcademicYear year = new AcademicYear("1", "2026", LocalDate.of(2026, 7, 1), LocalDate.of(2027, 6, 30));
        year.activate();
        year.close();
        assertEquals(AcademicYear.AcademicYearStatus.CLOSED, year.getStatus());
    }

    @Test
    public void testCannotActivateNonPending() {
        AcademicYear year = new AcademicYear("1", "2026", LocalDate.of(2026, 7, 1), LocalDate.of(2027, 6, 30));
        year.activate();
        assertThrows(IllegalStateException.class, () -> year.activate());
    }

    @Test
    public void testCannotCloseNonActive() {
        AcademicYear year = new AcademicYear("1", "2026", LocalDate.of(2026, 7, 1), LocalDate.of(2027, 6, 30));
        assertThrows(IllegalStateException.class, () -> year.close());
    }

    @Test
    public void testUpdate() {
        AcademicYear year = new AcademicYear("1", "2026", LocalDate.of(2026, 7, 1), LocalDate.of(2027, 6, 30));
        year.update("2027", LocalDate.of(2027, 7, 1), LocalDate.of(2028, 6, 30));
        assertEquals("2027", year.getName());
        assertEquals(LocalDate.of(2027, 7, 1), year.getStartDate());
        assertEquals(LocalDate.of(2028, 6, 30), year.getEndDate());
    }

    @Test
    public void testUpdateWithInvalidName() {
        AcademicYear year = new AcademicYear("1", "2026", LocalDate.of(2026, 7, 1), LocalDate.of(2027, 6, 30));
        assertThrows(IllegalArgumentException.class, () -> year.update("", LocalDate.of(2027, 7, 1), LocalDate.of(2028, 6, 30)));
    }

    @Test
    public void testUpdateWithInvalidDates() {
        AcademicYear year = new AcademicYear("1", "2026", LocalDate.of(2026, 7, 1), LocalDate.of(2027, 6, 30));
        assertThrows(IllegalArgumentException.class, () -> year.update("2027", null, LocalDate.of(2028, 6, 30)));
        assertThrows(IllegalArgumentException.class, () -> year.update("2027", LocalDate.of(2028, 7, 1), null));
    }

    @Test
    public void testUpdateWithInvalidDateOrder() {
        AcademicYear year = new AcademicYear("1", "2026", LocalDate.of(2026, 7, 1), LocalDate.of(2027, 6, 30));
        assertThrows(IllegalArgumentException.class, () -> year.update("2027", LocalDate.of(2028, 6, 30), LocalDate.of(2027, 7, 1)));
    }

    @Test
    public void testConstructorWithInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> new AcademicYear(null, "2026", LocalDate.of(2026, 7, 1), LocalDate.of(2027, 6, 30)));
    }

    @Test
    public void testConstructorWithInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> new AcademicYear("1", null, LocalDate.of(2026, 7, 1), LocalDate.of(2027, 6, 30)));
        assertThrows(IllegalArgumentException.class, () -> new AcademicYear("1", "", LocalDate.of(2026, 7, 1), LocalDate.of(2027, 6, 30)));
    }

    @Test
    public void testConstructorWithInvalidStartDate() {
        assertThrows(IllegalArgumentException.class, () -> new AcademicYear("1", "2026", null, LocalDate.of(2027, 6, 30)));
    }

    @Test
    public void testConstructorWithInvalidEndDate() {
        assertThrows(IllegalArgumentException.class, () -> new AcademicYear("1", "2026", LocalDate.of(2026, 7, 1), null));
    }
}