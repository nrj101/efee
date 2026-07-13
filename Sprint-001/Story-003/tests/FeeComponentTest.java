// /Sprint-001/Story-003/tests/FeeComponentTest.java

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FeeComponentTest {
    @Test
    public void testFeeComponentCreation() {
        FeeComponent feeComponent = new FeeComponent("Tuition", 1000.0, true);
        assertEquals("Tuition", feeComponent.getComponentName());
        assertEquals(1000.0, feeComponent.getAmount(), 0.001);
        assertTrue(feeComponent.isActive());
    }

    @Test
    public void testFeeComponentSetters() {
        FeeComponent feeComponent = new FeeComponent("Tuition", 1000.0, false);
        feeComponent.setComponentName("Registration Fee");
        feeComponent.setAmount(500.0);
        feeComponent.setActive(true);
        assertEquals("Registration Fee", feeComponent.getComponentName());
        assertEquals(500.0, feeComponent.getAmount(), 0.001);
        assertTrue(feeComponent.isActive());
    }
}