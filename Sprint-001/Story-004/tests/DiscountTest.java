// /Sprint-001/Story-004/tests/DiscountTest.java

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DiscountTest {

    @Test
    void shouldCreateDiscount() {

        Discount discount = new Discount(
                "D-001",
                "S-001",
                BigDecimal.valueOf(500),
                new ApprovalInformation(
                        "Principal",
                        "APR-001"),
                new BusinessJustification(
                        "Merit Scholarship"));

        assertEquals(
                "D-001",
                discount.getDiscountIdentifier());

        assertEquals(
                "S-001",
                discount.getStudentIdentifier());

        assertEquals(
                BigDecimal.valueOf(500),
                discount.getDiscountValue());

        assertEquals(
                new ApprovalInformation(
                        "Principal",
                        "APR-001"),
                discount.getApprovalInformation());

        assertEquals(
                new BusinessJustification(
                        "Merit Scholarship"),
                discount.getBusinessJustification());

        assertTrue(discount.isActive());
    }

    @Test
    void shouldRejectBlankDiscountIdentifier() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Discount(
                        "",
                        "S-001",
                        BigDecimal.ONE,
                        new ApprovalInformation(
                                "Principal",
                                "APR-001"),
                        new BusinessJustification(
                                "Reason")));
    }

    @Test
    void shouldRejectBlankStudentIdentifier() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Discount(
                        "D-001",
                        "",
                        BigDecimal.ONE,
                        new ApprovalInformation(
                                "Principal",
                                "APR-001"),
                        new BusinessJustification(
                                "Reason")));
    }

    @Test
    void shouldRejectNullDiscountValue() {

        assertThrows(
                NullPointerException.class,
                () -> new Discount(
                        "D-001",
                        "S-001",
                        null,
                        new ApprovalInformation(
                                "Principal",
                                "APR-001"),
                        new BusinessJustification(
                                "Reason")));
    }

    @Test
    void shouldRejectNegativeDiscountValue() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Discount(
                        "D-001",
                        "S-001",
                        BigDecimal.valueOf(-1),
                        new ApprovalInformation(
                                "Principal",
                                "APR-001"),
                        new BusinessJustification(
                                "Reason")));
    }

    @Test
    void shouldUpdateMutableState() {

        Discount discount = new Discount(
                "D-001",
                "S-001",
                BigDecimal.valueOf(500),
                new ApprovalInformation(
                        "Principal",
                        "APR-001"),
                new BusinessJustification(
                        "Merit Scholarship"));

        discount.update(
                BigDecimal.valueOf(750),
                new ApprovalInformation(
                        "Manager",
                        "APR-002"),
                new BusinessJustification(
                        "Financial Assistance"));

        assertEquals(
                BigDecimal.valueOf(750),
                discount.getDiscountValue());

        assertEquals(
                new ApprovalInformation(
                        "Manager",
                        "APR-002"),
                discount.getApprovalInformation());

        assertEquals(
                new BusinessJustification(
                        "Financial Assistance"),
                discount.getBusinessJustification());

        assertTrue(discount.isActive());
    }

    @Test
    void shouldRetireDiscount() {

        Discount discount = new Discount(
                "D-001",
                "S-001",
                BigDecimal.valueOf(500),
                new ApprovalInformation(
                        "Principal",
                        "APR-001"),
                new BusinessJustification(
                        "Merit Scholarship"));

        discount.retire();

        assertFalse(discount.isActive());
    }

    @Test
    void shouldRejectRepeatedRetirement() {

        Discount discount = new Discount(
                "D-001",
                "S-001",
                BigDecimal.valueOf(500),
                new ApprovalInformation(
                        "Principal",
                        "APR-001"),
                new BusinessJustification(
                        "Merit Scholarship"));

        discount.retire();

        assertThrows(
                IllegalStateException.class,
                discount::retire);
    }

    @Test
    void shouldImplementIdentityEquality() {

        Discount first = new Discount(
                "D-001",
                "S-001",
                BigDecimal.valueOf(500),
                new ApprovalInformation(
                        "Principal",
                        "APR-001"),
                new BusinessJustification(
                        "Merit Scholarship"));

        Discount second = new Discount(
                "D-001",
                "S-999",
                BigDecimal.valueOf(999),
                new ApprovalInformation(
                        "Manager",
                        "APR-999"),
                new BusinessJustification(
                        "Different"));

        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    void shouldGenerateReadableToString() {

        Discount discount = new Discount(
                "D-001",
                "S-001",
                BigDecimal.valueOf(500),
                new ApprovalInformation(
                        "Principal",
                        "APR-001"),
                new BusinessJustification(
                        "Merit Scholarship"));

        String value = discount.toString();

        assertTrue(value.contains("D-001"));
        assertTrue(value.contains("S-001"));
        assertTrue(value.contains("500"));
    }
}