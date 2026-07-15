// /Sprint-001/Story-005/tests/FeeObligationTest.java

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FeeObligationTest {

    @Test
    void shouldCreateFeeObligation() {

        FeeObligation feeObligation =
                new FeeObligation(
                        "FO-001",
                        "ST-001",
                        "AY-2026",
                        "FS-001",
                        List.of(
                                new ObligationLine(
                                        "OL-001",
                                        "FC-TUITION",
                                        BigDecimal.valueOf(5000))));

        assertEquals(
                "FO-001",
                feeObligation.getFeeObligationIdentifier());

        assertEquals(
                "ST-001",
                feeObligation.getStudentIdentifier());

        assertEquals(
                "AY-2026",
                feeObligation.getAcademicYearIdentifier());

        assertEquals(
                "FS-001",
                feeObligation.getFeeStructureIdentifier());

        assertEquals(
                BigDecimal.valueOf(5000),
                feeObligation.getOutstandingAmount());

        assertEquals(
                1,
                feeObligation.getObligationLines().size());

        assertTrue(feeObligation.isActive());
    }

    @Test
    void shouldRejectBlankFeeObligationIdentifier() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new FeeObligation(
                        "",
                        "ST-001",
                        "AY-2026",
                        "FS-001",
                        List.of(
                                new ObligationLine(
                                        "OL-001",
                                        "FC-TUITION",
                                        BigDecimal.ONE))));
    }

    @Test
    void shouldRejectBlankStudentIdentifier() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new FeeObligation(
                        "FO-001",
                        "",
                        "AY-2026",
                        "FS-001",
                        List.of(
                                new ObligationLine(
                                        "OL-001",
                                        "FC-TUITION",
                                        BigDecimal.ONE))));
    }

    @Test
    void shouldRejectBlankAcademicYearIdentifier() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new FeeObligation(
                        "FO-001",
                        "ST-001",
                        "",
                        "FS-001",
                        List.of(
                                new ObligationLine(
                                        "OL-001",
                                        "FC-TUITION",
                                        BigDecimal.ONE))));
    }

    @Test
    void shouldRejectBlankFeeStructureIdentifier() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new FeeObligation(
                        "FO-001",
                        "ST-001",
                        "AY-2026",
                        "",
                        List.of(
                                new ObligationLine(
                                        "OL-001",
                                        "FC-TUITION",
                                        BigDecimal.ONE))));
    }

    @Test
    void shouldRejectEmptyObligationLines() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new FeeObligation(
                        "FO-001",
                        "ST-001",
                        "AY-2026",
                        "FS-001",
                        List.of()));
    }

    @Test
    void shouldUpdateMutableState() {

        FeeObligation feeObligation =
                new FeeObligation(
                        "FO-001",
                        "ST-001",
                        "AY-2026",
                        "FS-001",
                        List.of(
                                new ObligationLine(
                                        "OL-001",
                                        "FC-TUITION",
                                        BigDecimal.valueOf(5000))));

        feeObligation.update(
                List.of(
                        new ObligationLine(
                                "OL-002",
                                "FC-LIBRARY",
                                BigDecimal.valueOf(750))));

        assertEquals(
                BigDecimal.valueOf(750),
                feeObligation.getOutstandingAmount());

        assertEquals(
                1,
                feeObligation.getObligationLines().size());

        assertEquals(
                "OL-002",
                feeObligation.getObligationLines()
                        .get(0)
                        .getObligationLineIdentifier());

        assertTrue(feeObligation.isActive());
    }

    @Test
    void shouldRetireFeeObligation() {

        FeeObligation feeObligation =
                new FeeObligation(
                        "FO-001",
                        "ST-001",
                        "AY-2026",
                        "FS-001",
                        List.of(
                                new ObligationLine(
                                        "OL-001",
                                        "FC-TUITION",
                                        BigDecimal.valueOf(5000))));

        feeObligation.retire();

        assertFalse(feeObligation.isActive());
    }

    @Test
    void shouldRejectRepeatedRetirement() {

        FeeObligation feeObligation =
                new FeeObligation(
                        "FO-001",
                        "ST-001",
                        "AY-2026",
                        "FS-001",
                        List.of(
                                new ObligationLine(
                                        "OL-001",
                                        "FC-TUITION",
                                        BigDecimal.valueOf(5000))));

        feeObligation.retire();

        assertThrows(
                IllegalStateException.class,
                feeObligation::retire);
    }

    @Test
    void shouldRejectUpdateAfterRetirement() {

        FeeObligation feeObligation =
                new FeeObligation(
                        "FO-001",
                        "ST-001",
                        "AY-2026",
                        "FS-001",
                        List.of(
                                new ObligationLine(
                                        "OL-001",
                                        "FC-TUITION",
                                        BigDecimal.valueOf(5000))));

        feeObligation.retire();

        assertThrows(
                IllegalStateException.class,
                () -> feeObligation.update(
                        List.of(
                                new ObligationLine(
                                        "OL-002",
                                        "FC-LIBRARY",
                                        BigDecimal.valueOf(750)))));
    }

    @Test
    void shouldRejectDuplicateObligationLines() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new FeeObligation(
                        "FO-001",
                        "ST-001",
                        "AY-2026",
                        "FS-001",
                        List.of(
                                new ObligationLine(
                                        "OL-001",
                                        "FC-TUITION",
                                        BigDecimal.valueOf(5000)),
                                new ObligationLine(
                                        "OL-001",
                                        "FC-LIBRARY",
                                        BigDecimal.valueOf(750)))));
    }

    @Test
    void shouldExposeImmutableObligationLines() {

        FeeObligation feeObligation =
                new FeeObligation(
                        "FO-001",
                        "ST-001",
                        "AY-2026",
                        "FS-001",
                        List.of(
                                new ObligationLine(
                                        "OL-001",
                                        "FC-TUITION",
                                        BigDecimal.valueOf(5000))));

        assertThrows(
                UnsupportedOperationException.class,
                () -> feeObligation.getObligationLines().add(
                        new ObligationLine(
                                "OL-002",
                                "FC-LIBRARY",
                                BigDecimal.valueOf(750))));
    }

    @Test
    void shouldDefensivelyCopyCollections() {

        List<ObligationLine> lines = new ArrayList<>();

        lines.add(
                new ObligationLine(
                        "OL-001",
                        "FC-TUITION",
                        BigDecimal.valueOf(5000)));

        FeeObligation feeObligation =
                new FeeObligation(
                        "FO-001",
                        "ST-001",
                        "AY-2026",
                        "FS-001",
                        lines);

        lines.add(
                new ObligationLine(
                        "OL-002",
                        "FC-LIBRARY",
                        BigDecimal.valueOf(750)));

        assertEquals(
                1,
                feeObligation.getObligationLines().size());
    }

    @Test
    void shouldImplementIdentityEquality() {

        FeeObligation first =
                new FeeObligation(
                        "FO-001",
                        "ST-001",
                        "AY-2026",
                        "FS-001",
                        List.of(
                                new ObligationLine(
                                        "OL-001",
                                        "FC-TUITION",
                                        BigDecimal.ONE)));

        FeeObligation second =
                new FeeObligation(
                        "FO-001",
                        "ST-999",
                        "AY-9999",
                        "FS-999",
                        List.of(
                                new ObligationLine(
                                        "OL-999",
                                        "FC-OTHER",
                                        BigDecimal.TEN)));

        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    void shouldNotEqualNull() {

        FeeObligation feeObligation =
                new FeeObligation(
                        "FO-001",
                        "ST-001",
                        "AY-2026",
                        "FS-001",
                        List.of(
                                new ObligationLine(
                                        "OL-001",
                                        "FC-TUITION",
                                        BigDecimal.ONE)));

        assertNotEquals(feeObligation, null);
    }

    @Test
    void shouldEqualSameInstance() {

        FeeObligation feeObligation =
                new FeeObligation(
                        "FO-001",
                        "ST-001",
                        "AY-2026",
                        "FS-001",
                        List.of(
                                new ObligationLine(
                                        "OL-001",
                                        "FC-TUITION",
                                        BigDecimal.ONE)));

        assertEquals(feeObligation, feeObligation);
    }

    @Test
    void shouldGenerateReadableToString() {

        FeeObligation feeObligation =
                new FeeObligation(
                        "FO-001",
                        "ST-001",
                        "AY-2026",
                        "FS-001",
                        List.of(
                                new ObligationLine(
                                        "OL-001",
                                        "FC-TUITION",
                                        BigDecimal.valueOf(5000))));

        String value = feeObligation.toString();

        assertTrue(value.contains("FO-001"));
        assertTrue(value.contains("ST-001"));
        assertTrue(value.contains("5000"));
    }

}