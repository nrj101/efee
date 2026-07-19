// /Sprint-002/Story-006/tests/PaymentLifecycleTest.java

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaymentLifecycleTest {

    @Test
    void shouldDefineLifecycleStates() {
        assertEquals(3, PaymentLifecycle.values().length);
        assertTrue(containsState(PaymentLifecycle.RECORDED));
        assertTrue(containsState(PaymentLifecycle.REALISED));
        assertTrue(containsState(PaymentLifecycle.CANCELLED));
    }

    private boolean containsState(PaymentLifecycle state) {
        for (PaymentLifecycle s : PaymentLifecycle.values()) {
            if (s == state) {
                return true;
            }
        }
        return false;
    }

    @Test
    void shouldExecuteThroughLifecycleTransitions() {
        PaymentLifecycle current = PaymentLifecycle.RECORDED;
        assertEquals(0, current.ordinal());
        assertEquals(1, PaymentLifecycle.REALISED.ordinal());
        assertEquals(2, PaymentLifecycle.CANCELLED.ordinal());
    }
}