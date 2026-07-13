// /Sprint-001/Story-003/tests/FeeComponentTest.java

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class FeeComponentTest {
    @Test
    public void testFeeComponentCreation() {
        FeeComponent component = new FeeComponent("C001", "Registration Fee", new BigDecimal("100.00"));

        assertEquals("C001", component.getFeeComponentIdentifier());
        assertEquals("Registration Fee", component.getFeeComponentName());
        assertEquals(new BigDecimal("100.00"), component.getFeeAmount());
    }

    @Test
    public void testFeeComponentValidation() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new FeeComponent(null, "Registration Fee", new BigDecimal("100.00"));
        });
        assertEquals("Fee Component Identifier is required", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new FeeComponent("C001", null, new BigDecimal("100.00"));
        });
        assertEquals("Fee Component Name is required", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new FeeComponent("C001", "Registration Fee", null);
        });
        assertEquals("Fee Amount must be a positive value", exception.getMessage());
    }
}