package sprint002.story009.tests;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class PaymentPersistenceTest {

    @Test
    void shouldConstructValidPayment() {
        PaymentPersistence payment = new PaymentPersistence(
                "PAY-001",
                "P-123",
                new BigDecimal("500.00"),
                "CREDIT_CARD",
                "REF-789",
                PaymentLifecycle.RECORDED
        );

        assertEquals("PAY-001", payment.getPaymentIdentifier());
        assertEquals("P-123", payment.getPayerIdentifier());
        assertEquals(new BigDecimal("500.00"), payment.getPaymentAmount());
        assertEquals("CREDIT_CARD", payment.getPaymentMethod());
        assertEquals("REF-789", payment.getPaymentReference());
        assertEquals(PaymentLifecycle.RECORDED, payment.getLifecycleState());
    }

    @Test
    void shouldRejectNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PaymentPersistence(
                "PAY-002",
                "P-456",
                new BigDecimal("-100.00"),
                "BANK_TRANSFER",
                "REF-012",
                PaymentLifecycle.RECORDED
            );
        });
    }
}