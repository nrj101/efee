/*
 * Reference Implementation:
 * Sprint-001 / Story-003
 */


package com.efee.domain.feestructure;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class FeeComponentTest {

    @Test
    void shouldCreateFeeComponent() {

        FeeComponent feeComponent = new FeeComponent(
                "FC-001",
                "Tuition Fee",
                new BigDecimal("5000.00")
        );

        assertEquals(
                "FC-001",
                feeComponent.getFeeComponentIdentifier());

        assertEquals(
                "Tuition Fee",
                feeComponent.getFeeComponentName());

        assertEquals(
                new BigDecimal("5000.00"),
                feeComponent.getFeeAmount());
    }

    @Test
    void shouldRejectEmptyIdentifier() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new FeeComponent(
                        "",
                        "Tuition Fee",
                        new BigDecimal("5000.00"))
        );

        assertEquals(
                "Fee Component Identifier cannot be null or empty",
                exception.getMessage());
    }

    @Test
    void shouldRejectEmptyName() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new FeeComponent(
                        "FC-001",
                        "",
                        new BigDecimal("5000.00"))
        );

        assertEquals(
                "Fee Component Name cannot be null or empty",
                exception.getMessage());
    }

    @Test
    void shouldRejectNullAmount() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new FeeComponent(
                        "FC-001",
                        "Tuition Fee",
                        null)
        );

        assertEquals(
                "Fee Amount cannot be null",
                exception.getMessage());
    }

    @Test
    void shouldRejectZeroAmount() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new FeeComponent(
                        "FC-001",
                        "Tuition Fee",
                        BigDecimal.ZERO)
        );

        assertEquals(
                "Fee Amount must be greater than zero",
                exception.getMessage());
    }

    @Test
    void shouldRejectNegativeAmount() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new FeeComponent(
                        "FC-001",
                        "Tuition Fee",
                        new BigDecimal("-100"))
        );

        assertEquals(
                "Fee Amount must be greater than zero",
                exception.getMessage());
    }

    @Test
    void feeComponentsWithSameIdentifierShouldBeEqual() {

        FeeComponent first = new FeeComponent(
                "FC-001",
                "Tuition Fee",
                new BigDecimal("5000.00")
        );

        FeeComponent second = new FeeComponent(
                "FC-001",
                "Library Fee",
                new BigDecimal("1000.00")
        );

        assertEquals(first, second);
    }

    @Test
    void feeComponentsWithDifferentIdentifiersShouldNotBeEqual() {

        FeeComponent first = new FeeComponent(
                "FC-001",
                "Tuition Fee",
                new BigDecimal("5000.00")
        );

        FeeComponent second = new FeeComponent(
                "FC-002",
                "Tuition Fee",
                new BigDecimal("5000.00")
        );

        assertNotEquals(first, second);
    }

    @Test
    void equalityShouldNotDependOnNameOrAmount() {

        FeeComponent first = new FeeComponent(
                "FC-001",
                "Tuition Fee",
                new BigDecimal("5000.00")
        );

        FeeComponent second = new FeeComponent(
                "FC-001",
                "Sports Fee",
                new BigDecimal("750.00")
        );

        assertEquals(first, second);
    }

    @Test
    void shouldNotEqualNull() {

        FeeComponent feeComponent = new FeeComponent(
                "FC-001",
                "Tuition Fee",
                new BigDecimal("5000.00")
        );

        assertNotEquals(feeComponent, null);
    }

    @Test
    void shouldEqualSameInstance() {

        FeeComponent feeComponent = new FeeComponent(
                "FC-001",
                "Tuition Fee",
                new BigDecimal("5000.00")
        );

        assertEquals(feeComponent, feeComponent);
    }

    @Test
    void shouldPreserveImmutableState() {

        FeeComponent feeComponent = new FeeComponent(
                "FC-001",
                "Tuition Fee",
                new BigDecimal("5000.00")
        );

        assertAll(
                () -> assertEquals("FC-001", feeComponent.getFeeComponentIdentifier()),
                () -> assertEquals("Tuition Fee", feeComponent.getFeeComponentName()),
                () -> assertEquals(new BigDecimal("5000.00"), feeComponent.getFeeAmount())
        );
    }

}