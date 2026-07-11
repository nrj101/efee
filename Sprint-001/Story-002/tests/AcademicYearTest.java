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
}