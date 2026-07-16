package com.efee.domain.feestructure;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FeeStructureTest {

    @Test
    void shouldCreateFeeStructure() {

        FeeComponent tuition = new FeeComponent(
                "FC-001",
                "Tuition Fee",
                new BigDecimal("5000.00"));

        FeeStructure feeStructure = new FeeStructure(
                "FS-001",
                "Standard Fee Structure",
                List.of(tuition));

        assertEquals(
                "FS-001",
                feeStructure.getFeeStructureIdentifier());

        assertEquals(
                "Standard Fee Structure",
                feeStructure.getFeeStructureName());

        assertEquals(
                1,
                feeStructure.getFeeComponents().size());

        assertTrue(feeStructure.isActive());
    }

    @Test
    void shouldRejectEmptyIdentifier() {

        FeeComponent tuition = new FeeComponent(
                "FC-001",
                "Tuition Fee",
                new BigDecimal("5000.00"));

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new FeeStructure(
                        "",
                        "Standard Fee Structure",
                        List.of(tuition)));

        assertEquals(
                "Fee Structure Identifier cannot be null or empty",
                exception.getMessage());
    }

    @Test
    void shouldRejectEmptyName() {

        FeeComponent tuition = new FeeComponent(
                "FC-001",
                "Tuition Fee",
                new BigDecimal("5000.00"));

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new FeeStructure(
                        "FS-001",
                        "",
                        List.of(tuition)));

        assertEquals(
                "Fee Structure Name cannot be null or empty",
                exception.getMessage());
    }

    @Test
    void shouldRejectNullFeeComponents() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new FeeStructure(
                        "FS-001",
                        "Standard Fee Structure",
                        null));

        assertEquals(
                "Fee Components cannot be null",
                exception.getMessage());
    }

    @Test
    void shouldRejectEmptyFeeComponents() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new FeeStructure(
                        "FS-001",
                        "Standard Fee Structure",
                        List.of()));

        assertEquals(
                "Fee Structure must contain at least one Fee Component",
                exception.getMessage());
    }

    @Test
    void shouldRejectNullFeeComponent() {

        List<FeeComponent> feeComponents = new ArrayList<>();

        feeComponents.add(null);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new FeeStructure(
                        "FS-001",
                        "Standard Fee Structure",
                        feeComponents));

        assertEquals(
                "Fee Components cannot contain null values",
                exception.getMessage());
    }

    @Test
    void shouldRejectDuplicateFeeComponentIdentifiers() {

        FeeComponent first = new FeeComponent(
                "FC-001",
                "Tuition",
                new BigDecimal("5000"));

        FeeComponent second = new FeeComponent(
                "FC-001",
                "Library",
                new BigDecimal("1000"));

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new FeeStructure(
                        "FS-001",
                        "Standard",
                        List.of(first, second)));

        assertEquals(
                "Duplicate Fee Component Identifier",
                exception.getMessage());
    }

    @Test
    void shouldUpdateFeeStructure() {

        FeeComponent tuition = new FeeComponent(
                "FC-001",
                "Tuition Fee",
                new BigDecimal("5000"));

        FeeComponent laboratory = new FeeComponent(
                "FC-002",
                "Laboratory Fee",
                new BigDecimal("1500"));

        FeeStructure feeStructure = new FeeStructure(
                "FS-001",
                "Standard",
                List.of(tuition));

        feeStructure.update(
                "Revised",
                List.of(tuition, laboratory));

        assertEquals(
                "Revised",
                feeStructure.getFeeStructureName());

        assertEquals(
                2,
                feeStructure.getFeeComponents().size());
    }

    @Test
    void shouldAddFeeComponent() {

        FeeComponent tuition = new FeeComponent(
                "FC-001",
                "Tuition",
                new BigDecimal("5000"));

        FeeComponent sports = new FeeComponent(
                "FC-002",
                "Sports",
                new BigDecimal("750"));

        FeeStructure feeStructure = new FeeStructure(
                "FS-001",
                "Standard",
                List.of(tuition));

        feeStructure.addFeeComponent(sports);

        assertEquals(
                2,
                feeStructure.getFeeComponents().size());
    }

    @Test
    void shouldRejectDuplicateFeeComponentWhenAdding() {

        FeeComponent tuition = new FeeComponent(
                "FC-001",
                "Tuition",
                new BigDecimal("5000"));

        FeeStructure feeStructure = new FeeStructure(
                "FS-001",
                "Standard",
                List.of(tuition));

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> feeStructure.addFeeComponent(
                        new FeeComponent(
                                "FC-001",
                                "Duplicate",
                                new BigDecimal("200"))));

        assertEquals(
                "Duplicate Fee Component Identifier",
                exception.getMessage());
    }

    @Test
    void shouldRetireFeeStructure() {

        FeeComponent tuition = new FeeComponent(
                "FC-001",
                "Tuition",
                new BigDecimal("5000"));

        FeeStructure feeStructure = new FeeStructure(
                "FS-001",
                "Standard",
                List.of(tuition));

        feeStructure.retire();

        assertFalse(feeStructure.isActive());
    }

    @Test
    void shouldRejectUpdateAfterRetirement() {

        FeeComponent tuition = new FeeComponent(
                "FC-001",
                "Tuition",
                new BigDecimal("5000"));

        FeeStructure feeStructure = new FeeStructure(
                "FS-001",
                "Standard",
                List.of(tuition));

        feeStructure.retire();

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> feeStructure.update(
                        "Updated",
                        List.of(tuition)));

        assertEquals(
                "Cannot modify a retired Fee Structure",
                exception.getMessage());
    }

    @Test
    void shouldRejectAddingFeeComponentAfterRetirement() {

        FeeComponent tuition = new FeeComponent(
                "FC-001",
                "Tuition",
                new BigDecimal("5000"));

        FeeStructure feeStructure = new FeeStructure(
                "FS-001",
                "Standard",
                List.of(tuition));

        feeStructure.retire();

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> feeStructure.addFeeComponent(
                        new FeeComponent(
                                "FC-002",
                                "Sports",
                                new BigDecimal("750"))));

        assertEquals(
                "Cannot modify a retired Fee Structure",
                exception.getMessage());
    }

    @Test
    void shouldReturnImmutableFeeComponents() {

        FeeComponent tuition = new FeeComponent(
                "FC-001",
                "Tuition",
                new BigDecimal("5000"));

        FeeStructure feeStructure = new FeeStructure(
                "FS-001",
                "Standard",
                List.of(tuition));

        List<FeeComponent> components =
                feeStructure.getFeeComponents();

        assertThrows(
                UnsupportedOperationException.class,
                () -> components.add(
                        new FeeComponent(
                                "FC-002",
                                "Sports",
                                new BigDecimal("750"))));
    }

    @Test
    void feeStructuresWithSameIdentifierShouldBeEqual() {

        FeeComponent tuition = new FeeComponent(
                "FC-001",
                "Tuition",
                new BigDecimal("5000"));

        FeeStructure first = new FeeStructure(
                "FS-001",
                "Standard",
                List.of(tuition));

        FeeStructure second = new FeeStructure(
                "FS-001",
                "Different",
                List.of(tuition));

        assertEquals(first, second);
    }

    @Test
    void feeStructuresWithDifferentIdentifiersShouldNotBeEqual() {

        FeeComponent tuition = new FeeComponent(
                "FC-001",
                "Tuition",
                new BigDecimal("5000"));

        FeeStructure first = new FeeStructure(
                "FS-001",
                "Standard",
                List.of(tuition));

        FeeStructure second = new FeeStructure(
                "FS-002",
                "Standard",
                List.of(tuition));

        assertNotEquals(first, second);
    }

    @Test
    void equalityShouldNotDependOnLifecycleState() {

        FeeComponent tuition = new FeeComponent(
                "FC-001",
                "Tuition",
                new BigDecimal("5000"));

        FeeStructure first = new FeeStructure(
                "FS-001",
                "Standard",
                List.of(tuition));

        FeeStructure second = new FeeStructure(
                "FS-001",
                "Standard",
                List.of(tuition));

        second.retire();

        assertEquals(first, second);
    }

    @Test
    void shouldNotEqualNull() {

        FeeComponent tuition = new FeeComponent(
                "FC-001",
                "Tuition",
                new BigDecimal("5000"));

        FeeStructure feeStructure = new FeeStructure(
                "FS-001",
                "Standard",
                List.of(tuition));

        assertNotEquals(feeStructure, null);
    }

    @Test
    void shouldEqualSameInstance() {

        FeeComponent tuition = new FeeComponent(
                "FC-001",
                "Tuition",
                new BigDecimal("5000"));

        FeeStructure feeStructure = new FeeStructure(
                "FS-001",
                "Standard",
                List.of(tuition));

        assertEquals(feeStructure, feeStructure);
    }
}