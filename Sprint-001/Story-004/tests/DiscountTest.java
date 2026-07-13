// /Sprint-001/Story-004/tests/DiscountTest.java

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiscountTest {

    @Test
    void testDiscountConstructor() {
        List<FeeComponent> components = Arrays.asList(new FeeComponent("F1", 100.0));
        Discount discount = new Discount("D1", "S1", components, 20.0, true);
        assertEquals("D1", discount.getDiscountIdentifier());
        assertEquals("S1", discount.getStudentIdentifier());
        assertEquals(components, discount.getApplicableFeeComponents());
        assertEquals(20.0, discount.getDiscount0Value());
        assertTrue(discount.isActive());
    }

    @Test
    void testUpdateDiscount() {
        List<FeeComponent> components = Arrays.asList(new FeeComponent("F1", 100.0));
        Discount discount = new Discount("D1", "S1", components, 20.0, true);
        discount.update(Arrays.asList(new FeeComponent("F2", 200.0)), 30.0);
        assertEquals(Arrays.asList(new FeeComponent("F2", 200.0)), discount.getApplicableFeeComponents());
        assertEquals(30.0, discount.getDiscountValue());
        assertFalse(discount.isActive());
    }

    @Test
    void testRetireDiscount() {
        List<FeeComponent> components = Arrays.asList(new FeeComponent("F1", 100.0));
        Discount discount = new Discount("D1", "S1", components, 20.0, true);
        discount.retire();
        assertFalse(discount.isActive());
    }

    @Test
    void testUpdateRetiredDiscount() {
        List<FeeComponent> components = Arrays.asList(new FeeComponent("F1", 100.0));
        Discount discount = new Discount("D1", "S1", components, 20.0, true);
        discount.retire();
        assertThrows(IllegalStateException.class, () -> discount.update(components, 30.0));
    }

    @Test
    void testInvalidDiscountIdentifier() {
        assertThrows(IllegalArgumentException.class, () -> new Discount("", "S1", Arrays.asList(new FeeComponent("F1", 100.0)), 20.0, true));
    }

    @Test
    void testInvalidStudentIdentifier() {
        assertThrows(IllegalArgumentException.class, () -> new Discount("D1", "", Arrays.asList(new FeeComponent("F1", 100.0)), 20.0, true));
    }

    @Test
    void testInvalidApplicableFeeComponents() {
        assertThrows(IllegalArgumentException.class, () -> new Discount("D1", "S1", Arrays.asList(), 20.0, true));
    }

    @Test
    void testNegativeDiscountValue() {
        assertThrows(IllegalArgumentException.class, () -> new Discount("D1", "S1", Arrays.asList(new FeeComponent("F1", 100.0)), -10.0, true));
    }

    @Test
    void testRetireAlreadyRetiredDiscount() {
        List<FeeComponent> components = Arrays.asList(new FeeComponent("F1", 100.0));
        Discount discount = new Discount("D1", "S1", components, 20.0, true);
        discount.retire();
        assertThrows(IllegalStateException.class, () -> discount.retire());
    }

    @Test
    void testDuplicateFeeComponents() {
        List<FeeComponent> components = Arrays.asList(
            new FeeComponent("F1", 100.0),
            new FeeComponent("F1", 100.0)
        );
        assertThrows(IllegalArgumentException.class, () -> new Discount("D1", "S1", components, 20.0, true));
    }

    @Test
    void testNullFeeComponent() {
        assertThrows(IllegalArgumentException.class, () -> new Discount("D1", "S1", Arrays.asList(null), 20.0, true));
    }

    @Test
    void testImmutableApplicableFeeComponents() {
        List<FeeComponent> components = Arrays.asList(new FeeComponent("F1", 100.0));
        Discount discount = new Discount("D1", "S1", components, 20.0, true);
        assertThrows(UnsupportedOperationException.class, () -> discount.getApplicableFeeComponents().add(new FeeComponent("F2", 200.0)));
    }

    @Test
    void testRepeatedRetirement() {
        List<FeeComponent> components = Arrays.asList(new FeeComponent("F1", 100.0));
        Discount discount = new Discount("D1", "S1", components, 20.0, true);
        discount.retire();
        assertThrows(IllegalStateException.class, () -> discount.retire());
    }

    @Test
    void testInvalidUpdateAfterRetirement() {
        List<FeeComponent> components = Arrays.asList(new FeeComponent("F1", 100.0));
        Discount discount = new Discount("D1", "S1", components, 20.0, true);
        discount.retire();
        assertThrows(IllegalStateException.class, () -> discount.update(components, 30.0));
    }

    @Test
    void testExternalModificationDoesNotAffectAggregate() {
        List<FeeComponent> components = Arrays.asList(new FeeComponent("F1", 100.0));
        Discount discount = new Discount("D1", "S1", components, 20.0, true);
        List<FeeComponent> externalList = discount.getApplicableFeeComponents();
        externalList.add(new FeeComponent("F2", 200.0));
        assertEquals(1, discount.getApplicableFeeComponents().size());
    }
}