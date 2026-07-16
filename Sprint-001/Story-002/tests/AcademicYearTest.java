// /Sprint-001/Story-002/tests/AcademicYearTest.java

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AcademicYearTest {

    @Test
    void shouldCreateAcademicYear() {

        AcademicYear academicYear = new AcademicYear(
                "AY-2026",
                "2026-2027",
                LocalDate.of(2026, 7, 1),
                LocalDate.of(2027, 6, 30),
                "FS-001"
        );

        assertEquals(
                "AY-2026",
                academicYear.getAcademicYearIdentifier());

        assertEquals(
                "2026-2027",
                academicYear.getAcademicYearCode());

        assertEquals(
                LocalDate.of(2026, 7, 1),
                academicYear.getStartDate());

        assertEquals(
                LocalDate.of(2027, 6, 30),
                academicYear.getEndDate());

        assertEquals(
                "FS-001",
                academicYear.getFeeStructureIdentifier());

        assertEquals(
                AcademicYearLifecycle.PLANNED,
                academicYear.getLifecycleState());
    }

    @Test
    void shouldRejectEmptyAcademicYearIdentifier() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new AcademicYear(
                        "",
                        "2026-2027",
                        LocalDate.now(),
                        LocalDate.now().plusDays(1),
                        "FS-001"));

        assertEquals(
                "Academic Year Identifier cannot be null or empty",
                exception.getMessage());
    }

    @Test
    void shouldRejectEmptyAcademicYearCode() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new AcademicYear(
                        "AY-2026",
                        "",
                        LocalDate.now(),
                        LocalDate.now().plusDays(1),
                        "FS-001"));

        assertEquals(
                "Academic Year Code cannot be null or empty",
                exception.getMessage());
    }

    @Test
    void shouldRejectEmptyFeeStructureIdentifier() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new AcademicYear(
                        "AY-2026",
                        "2026-2027",
                        LocalDate.now(),
                        LocalDate.now().plusDays(1),
                        ""));

        assertEquals(
                "Fee Structure Identifier cannot be null or empty",
                exception.getMessage());
    }

    @Test
    void shouldRejectInvalidDateRange() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new AcademicYear(
                        "AY-2026",
                        "2026-2027",
                        LocalDate.of(2027, 1, 1),
                        LocalDate.of(2026, 1, 1),
                        "FS-001"));

        assertEquals(
                "Start date cannot be after end date",
                exception.getMessage());
    }

    @Test
    void shouldAssignFeeStructure() {

        AcademicYear academicYear = new AcademicYear(
                "AY-2026",
                "2026-2027",
                LocalDate.of(2026, 7, 1),
                LocalDate.of(2027, 6, 30),
                "FS-001");

        academicYear.assignFeeStructure("FS-002");

        assertEquals(
                "FS-002",
                academicYear.getFeeStructureIdentifier());
    }

    @Test
    void shouldActivateAcademicYear() {

        AcademicYear academicYear = new AcademicYear(
                "AY-2026",
                "2026-2027",
                LocalDate.of(2026, 7, 1),
                LocalDate.of(2027, 6, 30),
                "FS-001");

        academicYear.activate();

        assertEquals(
                AcademicYearLifecycle.ACTIVE,
                academicYear.getLifecycleState());
    }

    @Test
    void shouldCloseAcademicYear() {

        AcademicYear academicYear = new AcademicYear(
                "AY-2026",
                "2026-2027",
                LocalDate.of(2026, 7, 1),
                LocalDate.of(2027, 6, 30),
                "FS-001");

        academicYear.activate();
        academicYear.close();

        assertEquals(
                AcademicYearLifecycle.CLOSED,
                academicYear.getLifecycleState());
    }

    @Test
    void shouldRejectActivatingNonPlannedAcademicYear() {

        AcademicYear academicYear = new AcademicYear(
                "AY-2026",
                "2026-2027",
                LocalDate.of(2026, 7, 1),
                LocalDate.of(2027, 6, 30),
                "FS-001");

        academicYear.activate();

        assertThrows(
                IllegalStateException.class,
                academicYear::activate);
    }

    @Test
    void shouldRejectClosingPlannedAcademicYear() {

        AcademicYear academicYear = new AcademicYear(
                "AY-2026",
                "2026-2027",
                LocalDate.of(2026, 7, 1),
                LocalDate.of(2027, 6, 30),
                "FS-001");

        assertThrows(
                IllegalStateException.class,
                academicYear::close);
    }

    @Test
    void shouldRejectAssigningFeeStructureToClosedAcademicYear() {

        AcademicYear academicYear = new AcademicYear(
                "AY-2026",
                "2026-2027",
                LocalDate.of(2026, 7, 1),
                LocalDate.of(2027, 6, 30),
                "FS-001");

        academicYear.activate();
        academicYear.close();

        assertThrows(
                IllegalStateException.class,
                () -> academicYear.assignFeeStructure("FS-002"));
    }

    @Test
    void academicYearsWithSameIdentifierShouldBeEqual() {

        AcademicYear first = new AcademicYear(
                "AY-2026",
                "2026-2027",
                LocalDate.of(2026, 7, 1),
                LocalDate.of(2027, 6, 30),
                "FS-001");

        AcademicYear second = new AcademicYear(
                "AY-2026",
                "Different",
                LocalDate.of(2030, 1, 1),
                LocalDate.of(2031, 1, 1),
                "FS-999");

        assertEquals(first, second);
    }

    @Test
    void academicYearsWithDifferentIdentifiersShouldNotBeEqual() {

        AcademicYear first = new AcademicYear(
                "AY-2026",
                "2026-2027",
                LocalDate.now(),
                LocalDate.now().plusDays(1),
                "FS-001");

        AcademicYear second = new AcademicYear(
                "AY-2027",
                "2026-2027",
                LocalDate.now(),
                LocalDate.now().plusDays(1),
                "FS-001");

        assertNotEquals(first, second);
    }
}