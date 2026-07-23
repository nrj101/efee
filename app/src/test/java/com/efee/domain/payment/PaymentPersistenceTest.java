package com.efee.domain.payment;
/*
 * Reference Implementation:
 * Sprint-002 / Story-009
 */

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PaymentPersistenceTest {

    @Test
    void shouldConstructValidPaymentPersistence() {

        PaymentPersistence payment = new PaymentPersistence(
                "PAY-001",
                "P-123",
                new BigDecimal("500.00"),
                "CREDIT_CARD",
                "REF-789",
                PaymentLifecycle.RECORDED);

        assertAll(
                () -> assertEquals(
                        "PAY-001",
                        payment.getPaymentIdentifier()),

                () -> assertEquals(
                        "P-123",
                        payment.getPayerIdentifier()),

                () -> assertEquals(
                        new BigDecimal("500.00"),
                        payment.getPaymentAmount()),

                () -> assertEquals(
                        "CREDIT_CARD",
                        payment.getPaymentMethod()),

                () -> assertEquals(
                        "REF-789",
                        payment.getPaymentReference()),

                () -> assertEquals(
                        PaymentLifecycle.RECORDED,
                        payment.getLifecycleState())
        );
    }

    @Test
    void shouldAllowNullPaymentReference() {

        PaymentPersistence payment = new PaymentPersistence(
                "PAY-002",
                "P-456",
                new BigDecimal("100.00"),
                "BANK_TRANSFER",
                null,
                PaymentLifecycle.RECORDED);

        assertNull(payment.getPaymentReference());
    }

    @Test
    void shouldRejectNullRequiredConstructorArguments() {

        BigDecimal amount = new BigDecimal("100.00");

        assertAll(

                () -> assertThrows(
                        NullPointerException.class,
                        () -> new PaymentPersistence(
                                null,
                                "P-001",
                                amount,
                                "CASH",
                                null,
                                PaymentLifecycle.RECORDED)),

                () -> assertThrows(
                        NullPointerException.class,
                        () -> new PaymentPersistence(
                                "PAY-001",
                                null,
                                amount,
                                "CASH",
                                null,
                                PaymentLifecycle.RECORDED)),

                () -> assertThrows(
                        NullPointerException.class,
                        () -> new PaymentPersistence(
                                "PAY-001",
                                "P-001",
                                null,
                                "CASH",
                                null,
                                PaymentLifecycle.RECORDED)),

                () -> assertThrows(
                        NullPointerException.class,
                        () -> new PaymentPersistence(
                                "PAY-001",
                                "P-001",
                                amount,
                                null,
                                null,
                                PaymentLifecycle.RECORDED)),

                () -> assertThrows(
                        NullPointerException.class,
                        () -> new PaymentPersistence(
                                "PAY-001",
                                "P-001",
                                amount,
                                "CASH",
                                null,
                                null))
        );
    }
}