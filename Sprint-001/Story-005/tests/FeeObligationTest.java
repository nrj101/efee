// /Sprint-001/Story-005/tests/FeeObligationTest.java;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class FeeObligationTest {

    @Test
    public void testFeeObligationCreation() {

        ObligationLine line =
                new ObligationLine(
                        "OL001",
                        "Registration Fee",
                        new BigDecimal("500.00"));

        FeeObligation feeObligation =
                new FeeObligation(
                        "FO001",
                        "ST001",
                        "AY2026",
                        "FS001",
                        Arrays.asList(line),
                        new BigDecimal("500.00"));

        assertEquals(
                "FO001",
                feeObligation.getFeeObligationIdentifier());

        assertEquals(
                "ST001",
                feeObligation.getStudentIdentifier());

        assertEquals(
                "AY2026",
                feeObligation.getAcademicYearIdentifier());

        assertEquals(
                "FS001",
                feeObligation.getFeeStructureIdentifier());

        assertEquals(
                1,
                feeObligation.getObligationLines().size());

        assertEquals(
                new BigDecimal("500.00"),
                feeObligation.getOutstandingAmount());

        assertTrue(feeObligation.isActive());
    }

    @Test
    public void testFeeObligationUpdate() {

        FeeObligation feeObligation =
                new FeeObligation(
                        "FO001",
                        "ST001",
                        "AY2026",
                        "FS001",
                        Arrays.asList(
                                new ObligationLine(
                                        "OL001",
                                        "Registration Fee",
                                        new BigDecimal("500.00"))),
                        new BigDecimal("500.00"));

        feeObligation.update(

                Arrays.asList(

                        new ObligationLine(
                                "OL002",
                                "Tuition Fee",
                                new BigDecimal("1200.00"))),

                new BigDecimal("1200.00"));

        assertEquals(
                1,
                feeObligation.getObligationLines().size());

        assertEquals(
                new BigDecimal("1200.00"),
                feeObligation.getOutstandingAmount());

        assertTrue(feeObligation.isActive());
    }

    @Test
    public void testFeeObligationRetire() {

        FeeObligation feeObligation =
                new FeeObligation(
                        "FO001",
                        "ST001",
                        "AY2026",
                        "FS001",
                        Arrays.asList(
                                new ObligationLine(
                                        "OL001",
                                        "Registration Fee",
                                        new BigDecimal("500.00"))),
                        new BigDecimal("500.00"));

        feeObligation.retire();

        assertFalse(feeObligation.isActive());
    }

    @Test
    public void testUpdateRetiredFeeObligation() {

        FeeObligation feeObligation =
                new FeeObligation(
                        "FO001",
                        "ST001",
                        "AY2026",
                        "FS001",
                        Arrays.asList(
                                new ObligationLine(
                                        "OL001",
                                        "Registration Fee",
                                        new BigDecimal("500.00"))),
                        new BigDecimal("500.00"));

        feeObligation.retire();

        IllegalStateException exception =
                assertThrows(
                        IllegalStateException.class,
                        () -> feeObligation.update(
                                Arrays.asList(
                                        new ObligationLine(
                                                "OL002",
                                                "Tuition Fee",
                                                new BigDecimal("1200.00"))),
                                new BigDecimal("1200.00")));

        assertEquals(
                "Cannot update a retired Fee Obligation",
                exception.getMessage());
    }

    @Test
    public void testRetireAlreadyRetiredFeeObligation() {

        FeeObligation feeObligation =
                new FeeObligation(
                        "FO001",
                        "ST001",
                        "AY2026",
                        "FS001",
                        Arrays.asList(
                                new ObligationLine(
                                        "OL001",
                                        "Registration Fee",
                                        new BigDecimal("500.00"))),
                        new BigDecimal("500.00"));

        feeObligation.retire();

        IllegalStateException exception =
                assertThrows(
                        IllegalStateException.class,
                        feeObligation::retire);

        assertEquals(
                "Cannot retire an already retired Fee Obligation",
                exception.getMessage());
    }

    @Test
    public void testDuplicateObligationLines() {

        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> new FeeObligation(

                                "FO001",
                                "ST001",
                                "AY2026",
                                "FS001",

                                Arrays.asList(

                                        new ObligationLine(
                                                "OL001",
                                                "Registration Fee",
                                                new BigDecimal("500.00")),

                                        new ObligationLine(
                                                "OL001",
                                                "Duplicate Fee",
                                                new BigDecimal("700.00"))),

                                new BigDecimal("1200.00")));

        assertEquals(
                "Duplicate Obligation Line Identifier found",
                exception.getMessage());
    }

    @Test
    public void testNullObligationLine() {

        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> new FeeObligation(

                                "FO001",
                                "ST001",
                                "AY2026",
                                "FS001",

                                Arrays.asList((ObligationLine) null),

                                new BigDecimal("500.00")));

        assertEquals(
                "Obligation Lines cannot contain null entries",
                exception.getMessage());
    }

    @Test
    public void testNegativeOutstandingAmount() {

        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> new FeeObligation(

                                "FO001",
                                "ST001",
                                "AY2026",
                                "FS001",

                                Arrays.asList(
                                        new ObligationLine(
                                                "OL001",
                                                "Registration Fee",
                                                new BigDecimal("500.00"))),

                                new BigDecimal("-1.00")));

        assertEquals(
                "Outstanding Amount cannot be negative",
                exception.getMessage());
    }

    @Test
    public void testImmutableObligationLines() {

        FeeObligation feeObligation =
                new FeeObligation(

                        "FO001",
                        "ST001",
                        "AY2026",
                        "FS001",

                        Arrays.asList(
                                new ObligationLine(
                                        "OL001",
                                        "Registration Fee",
                                        new BigDecimal("500.00"))),

                        new BigDecimal("500.00"));

        assertThrows(
                UnsupportedOperationException.class,
                () -> feeObligation
                        .getObligationLines()
                        .add(
                                new ObligationLine(
                                        "OL002",
                                        "Library Fee",
                                        new BigDecimal("200.00"))));
    }

    @Test
    public void testConstructorDefensiveCopy() {

        List<ObligationLine> lines = new ArrayList<>();

        lines.add(
                new ObligationLine(
                        "OL001",
                        "Registration Fee",
                        new BigDecimal("500.00")));

        FeeObligation feeObligation =
                new FeeObligation(
                        "FO001",
                        "ST001",
                        "AY2026",
                        "FS001",
                        lines,
                        new BigDecimal("500.00"));

        lines.add(
                new ObligationLine(
                        "OL002",
                        "Library Fee",
                        new BigDecimal("200.00")));

        assertEquals(
                1,
                feeObligation.getObligationLines().size());
    }

    @Test
    public void testUpdateDefensiveCopy() {

        FeeObligation feeObligation =
                new FeeObligation(

                        "FO001",
                        "ST001",
                        "AY2026",
                        "FS001",

                        Arrays.asList(
                                new ObligationLine(
                                        "OL001",
                                        "Registration Fee",
                                        new BigDecimal("500.00"))),

                        new BigDecimal("500.00"));

        List<ObligationLine> updatedLines = new ArrayList<>();

        updatedLines.add(
                new ObligationLine(
                        "OL002",
                        "Tuition Fee",
                        new BigDecimal("1000.00")));

        feeObligation.update(
                updatedLines,
                new BigDecimal("1000.00"));

        updatedLines.add(
                new ObligationLine(
                        "OL003",
                        "Transport Fee",
                        new BigDecimal("300.00")));

        assertEquals(
                1,
                feeObligation.getObligationLines().size());
    }
}