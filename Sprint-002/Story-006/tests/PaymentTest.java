// /Sprint-002/Story-006/tests/PaymentTest.java

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

class PaymentTest {

    @Test
    void shouldCreatePayment() {
        Payment payment = new Payment(
                "PAY-001",
                "PAYER-001",
                new BigDecimal("1000.00"),
                "CREDIT_CARD",
                "REF-001"
        );

        assertNotNull(payment.getPaymentIdentifier());
        assertEquals("PAY-001", payment.getPaymentIdentifier());
        assertEquals("PAYER-001", payment.getPayerIdentifier());
        assertEquals(new BigDecimal("1000.00"), payment.getPaymentAmount());
        assertEquals("CREDIT_CARD", payment.getPaymentMethod());
        assertEquals("REF-001", payment.getPaymentReference());
        assertEquals(PaymentLifecycle.RECORDED, payment.getLifecycleState());
    }

    @Test
    void shouldRejectNullPaymentIdentifier() {
        assertThrows(NullPointerException.class,
                () -> new Payment(null, "PAYER-001", 
                        new BigDecimal("1000.00"), "CREDIT_CARD", "REF-001"));
    }

    @Test
    void shouldRejectNullPayerIdentifier() {
        assertThrows(NullPointerException.class,
                () -> new Payment("PAY-001", null,
                        new BigDecimal("1000.00"), "CREDIT_CARD", "REF-001"));
    }

    @Test
    void shouldRejectNullPaymentAmount() {
        assertThrows(NullPointerException.class,
                () -> new Payment("PAY-001", "PAYER-001", null,
                        "CREDIT_CARD", "REF-001"));
    }

    @Test
    void shouldRejectNullPaymentMethod() {
        assertThrows(NullPointerException.class,
                () -> new Payment("PAY-001", "PAYER-001",
                        new BigDecimal("1000.00"), null, "REF-001"));
    }

    @Test
    void shouldRejectNegativePaymentAmount() {
        assertThrows(IllegalArgumentException.class,
                () -> new Payment("PAY-001", "PAYER-001",
                        new BigDecimal("-100.00"), "CREDIT_CARD", "REF-001"));
    }

    @Test
    void shouldRealisePayment() {
        Payment payment = new Payment(
                "PAY-001", "PAYER-001",
                new BigDecimal("1000.00"), "CREDIT_CARD", "REF-001");

        payment.realise();

        assertEquals(PaymentLifecycle.REALISED, payment.getLifecycleState());
    }

    @Test
    void shouldRejectRealiseAfterAlreadyRealised() {
        Payment payment = new Payment(
                "PAY-001", "PAYER-001",
                new BigDecimal("1000.00"), "CREDIT_CARD", "REF-001");
        payment.realise();

        assertThrows(IllegalStateException.class,
                payment::realise);
    }

    @Test
    void shouldRejectRealiseAfterCancelled() {
        Payment payment = new Payment(
                "PAY-001", "PAYER-001",
                new BigDecimal("1000.00"), "CREDIT_CARD", "REF-001");
        payment.cancel();

        assertThrows(IllegalStateException.class,
                payment::realise);
    }

    @Test
    void shouldCancelPayment() {
        Payment payment = new Payment(
                "PAY-001", "PAYER-001",
                new BigDecimal("1000.00"), "CREDIT_CARD", "REF-001");

        payment.cancel();

        assertEquals(PaymentLifecycle.CANCELLED, payment.getLifecycleState());
    }

    @Test
    void shouldRejectCancelAfterAlreadyCancelled() {
        Payment payment = new Payment(
                "PAY-001", "PAYER-001",
                new BigDecimal("1000.00"), "CREDIT_CARD", "REF-001");
        payment.cancel();

        assertThrows(IllegalStateException.class,
                payment::cancel);
    }

    @Test
    void shouldRejectCancelAfterRealised() {
        Payment payment = new Payment(
                "PAY-001", "PAYER-001",
                new BigDecimal("1000.00"), "CREDIT_CARD", "REF-001");
        payment.realise();

        assertThrows(IllegalStateException.class,
                payment::cancel);
    }

    @Test
    void shouldPreserveAmountImmutability() {
        Payment payment = new Payment(
                "PAY-001", "PAYER-001",
                new BigDecimal("1000.00"), "CREDIT_CARD", "REF-001");

        BigDecimal amount = payment.getPaymentAmount();
        assertEquals(new BigDecimal("1000.00"), amount);
    }

    @Test
    void shouldPreserveIdentifierImmutability() {
        Payment payment = new Payment(
                "PAY-001", "PAYER-001",
                new BigDecimal("1000.00"), "CREDIT_CARD", "REF-001");

        String identifier = payment.getPaymentIdentifier();
        assertEquals("PAY-001", identifier);
    }
}