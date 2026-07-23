// /Sprint-002/Story-007/tests/ReceiptLifecycleTest.java

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptLifecycleTest {

    @Test
    void shouldDefineApprovedLifecycleStates() {

        ReceiptLifecycle[] values = ReceiptLifecycle.values();

        assertAll(
                () -> assertEquals(3, values.length),
                () -> assertEquals(ReceiptLifecycle.ISSUED, values[0]),
                () -> assertEquals(ReceiptLifecycle.CORRECTED, values[1]),
                () -> assertEquals(ReceiptLifecycle.RETIRED, values[2])
        );
    }
}