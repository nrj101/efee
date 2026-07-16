package com.efee.domain.feeobligation;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ObligationLineTest {

    @Test
    void shouldCreateObligationLine() {

        ObligationLine obligationLine =
                new ObligationLine(
                        "OL-001",
                        "FC-TUITION",
                        BigDecimal.valueOf(5000));

        assertEquals(
                "OL-001",
                obligationLine.getObligationLineIdentifier());

        assertEquals(
                "FC-TUITION",
                obligationLine.getFeeComponentIdentifier());

        assertEquals(
                BigDecimal.valueOf(5000),
                obligationLine.getOriginalAmount());

        assertEquals(
                BigDecimal.valueOf(5000),
                obligationLine.getAmount());
    }

    @Test
    void shouldRejectNullObligationLineIdentifier() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new ObligationLine(
                        null,
                        "FC-TUITION",
                        BigDecimal.ONE));
    }

    @Test
    void shouldRejectBlankObligationLineIdentifier() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new ObligationLine(
                        " ",
                        "FC-TUITION",
                        BigDecimal.ONE));
    }

    @Test
    void shouldRejectNullFeeComponentIdentifier() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new ObligationLine(
                        "OL-001",
                        null,
                        BigDecimal.ONE));
    }

    @Test
    void shouldRejectBlankFeeComponentIdentifier() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new ObligationLine(
                        "OL-001",
                        "",
                        BigDecimal.ONE));
    }

    @Test
    void shouldRejectNullOriginalAmount() {

        assertThrows(
                NullPointerException.class,
                () -> new ObligationLine(
                        "OL-001",
                        "FC-TUITION",
                        null));
    }

    @Test
    void shouldRejectNegativeOriginalAmount() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new ObligationLine(
                        "OL-001",
                        "FC-TUITION",
                        BigDecimal.valueOf(-1)));
    }

    @Test
    void shouldImplementValueEquality() {

        ObligationLine first =
                new ObligationLine(
                        "OL-001",
                        "FC-TUITION",
                        BigDecimal.valueOf(5000));

        ObligationLine second =
                new ObligationLine(
                        "OL-001",
                        "FC-TUITION",
                        BigDecimal.valueOf(5000));

        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    void shouldNotBeEqualWhenValuesDiffer() {

        ObligationLine first =
                new ObligationLine(
                        "OL-001",
                        "FC-TUITION",
                        BigDecimal.valueOf(5000));

        ObligationLine second =
                new ObligationLine(
                        "OL-002",
                        "FC-LIBRARY",
                        BigDecimal.valueOf(500));

        assertNotEquals(first, second);
    }

    @Test
    void shouldNotEqualNull() {

        ObligationLine obligationLine =
                new ObligationLine(
                        "OL-001",
                        "FC-TUITION",
                        BigDecimal.valueOf(5000));

        assertNotEquals(obligationLine, null);
    }

    @Test
    void shouldEqualSameInstance() {

        ObligationLine obligationLine =
                new ObligationLine(
                        "OL-001",
                        "FC-TUITION",
                        BigDecimal.valueOf(5000));

        assertEquals(obligationLine, obligationLine);
    }

    @Test
    void shouldGenerateReadableToString() {

        ObligationLine obligationLine =
                new ObligationLine(
                        "OL-001",
                        "FC-TUITION",
                        BigDecimal.valueOf(5000));

        String value = obligationLine.toString();

        assertTrue(value.contains("OL-001"));
        assertTrue(value.contains("FC-TUITION"));
        assertTrue(value.contains("5000"));
    }

}