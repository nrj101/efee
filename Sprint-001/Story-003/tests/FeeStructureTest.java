// /Sprint-001/Story-003/tests/FeeStructureTest.java

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class FeeStructureTest {
    @Test
    public void testFeeStructureCreation() {
        FeeComponent component = new FeeComponent("C001", "Registration Fee", new BigDecimal("100.00"));
        FeeStructure feeStructure = new FeeStructure("FS001", "2026 Academic Year", Arrays.asList(component));

        assertEquals("FS001", feeStructure.getFeeStructureIdentifier());
        assertEquals("2026 Academic Year", feeStructure.getFeeStructureName());
        assertEquals(1, feeStructure.getFeeComponents().size());
        assertTrue(feeStructure.isActive());
    }

    @Test
    public void testFeeStructureUpdate() {
        FeeComponent component = new FeeComponent("C001", "Registration Fee", new BigDecimal("100.00"));
        FeeStructure feeStructure = new FeeStructure("FS001", "2026 Academic Year", Arrays.asList(component));

        feeStructure.update("2026 Academic Year Updated", Arrays.asList(new FeeComponent("C002", "Tuition Fee", new BigDecimal("500.00"))));

        assertEquals("2026 Academic Year Updated", feeStructure.getFeeStructureName());
        assertEquals(1, feeStructure.getFeeComponents().size());
        assertTrue(feeStructure.isActive());
    }

    @Test
    public void testFeeStructureRetire() {
        FeeComponent component = new FeeComponent("C001", "Registration Fee", new BigDecimal("100.00"));
        FeeStructure feeStructure = new FeeStructure("FS001", "2026 Academic Year", Arrays.asList(component));

        feeStructure.retire();

        assertFalse(feeStructure.isActive());
    }

    @Test
    public void testFeeStructureUpdateWithDuplicateComponents() {
        FeeComponent component1 = new FeeComponent("C001", "Registration Fee", new BigDecimal("100.00"));
        FeeComponent component2 = new FeeComponent("C002", "Tuition Fee", new BigDecimal("500.00"));
        FeeStructure feeStructure = new FeeStructure("FS001", "2026 Academic Year", Arrays.asList(component1, component2));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            feeStructure.update("2026 Academic Year Updated", Arrays.asList(
                new FeeComponent("C001", "Duplicate Fee", new BigDecimal("150.00")),
                new FeeComponent("C001", "Tuition Fee", new BigDecimal("500.00"))
            ));
        });

        assertEquals("Duplicate Fee Component Identifier found", exception.getMessage());
    }

    @Test
    public void testFeeStructureAddDuplicateComponent() {
        FeeComponent component = new FeeComponent("C001", "Registration Fee", new BigDecimal("100.00"));
        FeeStructure feeStructure = new FeeStructure("FS001", "2026 Academic Year", Arrays.asList(component));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            feeStructure.addFeeComponent(new FeeComponent("C001", "Duplicate Fee", new BigDecimal("150.00")));
        });

        assertEquals("Duplicate Fee Component Identifier found", exception.getMessage());
    }

    @Test
    public void testFeeStructureRetireAlreadyRetired() {
        FeeComponent component = new FeeComponent("C001", "Registration Fee", new BigDecimal("100.00"));
        FeeStructure feeStructure = new FeeStructure("FS001", "2026 Academic Year", Arrays.asList(component));
        feeStructure.retire();

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            feeStructure.retire();
        });

        assertEquals("Cannot retire an already retired Fee Structure", exception.getMessage());
    }

    @Test
    public void testCannotUpdateRetiredFeeStructure() {

        FeeComponent component =
                new FeeComponent(
                        "C001",
                        "Registration Fee",
                        new BigDecimal("100.00"));

        FeeStructure feeStructure =
                new FeeStructure(
                        "FS001",
                        "2026 Academic Year",
                        Arrays.asList(component));

        feeStructure.retire();

        IllegalStateException exception =
                assertThrows(
                        IllegalStateException.class,
                        () -> feeStructure.update(
                                "Updated",
                                Arrays.asList(component)));

        assertEquals(
                "Cannot update a retired Fee Structure",
                exception.getMessage());
    }

    @Test
    public void testCannotAddFeeComponentToRetiredFeeStructure() {

        FeeComponent component =
                new FeeComponent(
                        "C001",
                        "Registration Fee",
                        new BigDecimal("100.00"));

        FeeStructure feeStructure =
                new FeeStructure(
                        "FS001",
                        "2026 Academic Year",
                        Arrays.asList(component));

        feeStructure.retire();

        IllegalStateException exception =
                assertThrows(
                        IllegalStateException.class,
                        () -> feeStructure.addFeeComponent(
                                new FeeComponent(
                                        "C002",
                                        "Tuition Fee",
                                        new BigDecimal("500.00"))));

        assertEquals(
                "Cannot modify a retired Fee Structure",
                exception.getMessage());
    }

}