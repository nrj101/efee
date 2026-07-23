// /Sprint-002/Story-006/tests/PaymentLifecycleTest.java

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaymentLifecycleTest {

    @Test
    void shouldDefineLifecycleStates() {
        assertEquals(3, PaymentLifecycle.values().length);

        assertNotNull(PaymentLifecycle.RECORDED);
        assertNotNull(PaymentLifecycle.REALISED);
        assertNotNull(PaymentLifecycle.CANCELLED);
    }

}