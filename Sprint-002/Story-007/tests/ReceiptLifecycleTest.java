// tests/ReceiptLifecycleTest.java
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptLifecycleTest {

    @Test
    void shouldDefineIssuedState() {
        assertEquals(ReceiptLifecycle.ISSUED, ReceiptLifecycle.ISSUED);
    }

    @Test
    void shouldDefineCorrectedState() {
        assertEquals(ReceiptLifecycle.CORRECTED, ReceiptLifecycle.CORRECTED);
    }

    @Test
    void shouldDefineRetiredState() {
        assertEquals(ReceiptLifecycle.RETIRED, ReceiptLifecycle.RETIRED);
    }

    @Test
    void shouldDefineExactlyThreeLifecycleStates() {
        ReceiptLifecycle[] values = ReceiptLifecycle.values();
        assertEquals(3, values.length);
        assertEquals(ReceiptLifecycle.ISSUED, values[0]);
        assertEquals(ReceiptLifecycle.CORRECTED, values[1]);
        assertEquals(ReceiptLifecycle.RETIRED, values[2]);
    }
}