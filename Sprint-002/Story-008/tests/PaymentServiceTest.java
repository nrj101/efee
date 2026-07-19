

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    private final PaymentService paymentService = new PaymentService();

    // Record Payment Tests

    @Test
    void shouldRecordPaymentSuccessfully() {
        Payment payment = paymentService.recordPayment(
                "PAY-001",
                "STUDENT-123",
                new BigDecimal("100.00"),
                "CASH",
                "REF-001"
        );

        assertNotNull(payment.getPaymentIdentifier());
        assertEquals("STUDENT-123", payment.getPayerIdentifier());
        assertEquals(new BigDecimal("100.00"), payment.getPaymentAmount());
        assertEquals("CASH", payment.getPaymentMethod());
        assertEquals("REF-001", payment.getPaymentReference());
        assertEquals(PaymentLifecycle.RECORDED, payment.getLifecycleState());
    }

    @Test
    void shouldCreatePaymentWithoutReference() {
        Payment payment = paymentService.recordPayment(
                "PAY-002",
                "STUDENT-456",
                new BigDecimal("50.00"),
                "CARD",
                null
        );

        assertNull(payment.getPaymentReference());
        assertEquals(PaymentLifecycle.RECORDED, payment.getLifecycleState());
    }

    // Realize Payment Tests

    @Test
    void shouldRealizePaymentSuccessfully() {
        Payment payment = paymentService.recordPayment(
                "PAY-003",
                "STUDENT-789",
                new BigDecimal("200.00"),
                "BANK_TRANSFER",
                "REF-002"
        );

        assertEquals(PaymentLifecycle.RECORDED, payment.getLifecycleState());

        Payment realisedPayment = paymentService.realizePayment(payment);

        assertSame(payment, realisedPayment);
        assertEquals(PaymentLifecycle.REALISED, payment.getLifecycleState());
    }

    @Test
    void shouldRejectRealizationOfAlreadyRealisedPayment() {
        Payment payment = paymentService.recordPayment(
                "PAY-004",
                "STUDENT-111",
                new BigDecimal("75.00"),
                "CHEQUE",
                null
        );

        paymentService.realizePayment(payment);

        assertThrows(IllegalStateException.class, () -> paymentService.realizePayment(payment));
    }
}