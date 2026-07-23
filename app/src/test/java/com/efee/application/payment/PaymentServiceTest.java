package com.efee.application.payment;
/*
 * Reference Implementation:
 * Sprint-002 / Story-008
 */

import java.math.BigDecimal;
import com.efee.domain.payment.Payment;
import com.efee.domain.payment.PaymentLifecycle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    private final PaymentService paymentService = new PaymentService();

    @Test
    void shouldRecordPaymentSuccessfully() {

        Payment payment = paymentService.recordPayment(
                "PAY-001",
                "STUDENT-123",
                new BigDecimal("100.00"),
                "CASH",
                "REF-001");

        assertAll(
                () -> assertEquals("PAY-001", payment.getPaymentIdentifier()),
                () -> assertEquals("STUDENT-123", payment.getPayerIdentifier()),
                () -> assertEquals(
                        new BigDecimal("100.00"),
                        payment.getPaymentAmount()),
                () -> assertEquals("CASH", payment.getPaymentMethod()),
                () -> assertEquals("REF-001", payment.getPaymentReference()),
                () -> assertEquals(
                        PaymentLifecycle.RECORDED,
                        payment.getLifecycleState())
        );
    }

    @Test
    void shouldCreatePaymentWithoutReference() {

        Payment payment = paymentService.recordPayment(
                "PAY-002",
                "STUDENT-456",
                new BigDecimal("50.00"),
                "CARD",
                null);

        assertAll(
                () -> assertNull(payment.getPaymentReference()),
                () -> assertEquals(
                        PaymentLifecycle.RECORDED,
                        payment.getLifecycleState())
        );
    }

    @Test
    void shouldRealisePaymentSuccessfully() {

        Payment payment = paymentService.recordPayment(
                "PAY-003",
                "STUDENT-789",
                new BigDecimal("200.00"),
                "BANK_TRANSFER",
                "REF-002");

        Payment realisedPayment =
                paymentService.realisePayment(payment);

        assertAll(
                () -> assertSame(payment, realisedPayment),
                () -> assertEquals(
                        PaymentLifecycle.REALISED,
                        realisedPayment.getLifecycleState())
        );
    }

    @Test
    void shouldRejectRealisingAlreadyRealisedPayment() {

        Payment payment = paymentService.recordPayment(
                "PAY-004",
                "STUDENT-111",
                new BigDecimal("75.00"),
                "CHEQUE",
                null);

        paymentService.realisePayment(payment);

        assertThrows(
                IllegalStateException.class,
                () -> paymentService.realisePayment(payment));
    }
}