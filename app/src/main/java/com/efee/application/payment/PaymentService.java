package com.efee.application.payment;
/*
 * Reference Implementation:
 * Sprint-002 / Story-008
 */

import java.math.BigDecimal;
import com.efee.domain.payment.Payment;
import com.efee.domain.payment.PaymentLifecycle;

/**
 * Application Service coordinating the approved Payment Service workflow.
 * Implements only the public operations explicitly authorized by Story-008.
 */
public class PaymentService {

    /**
     * Coordinates the approved Record Payment workflow by invoking the
     * approved Payment Aggregate constructor.
     */
    public Payment recordPayment(
            String paymentIdentifier,
            String payerIdentifier,
            BigDecimal paymentAmount,
            String paymentMethod,
            String paymentReference) {

        return new Payment(
                paymentIdentifier,
                payerIdentifier,
                paymentAmount,
                paymentMethod,
                paymentReference);
    }

    /**
     * Coordinates the approved Realise Payment workflow by invoking the
     * approved Payment Aggregate realisation operation.
     */
    public Payment realisePayment(Payment payment) {

        payment.realise();

        return payment;
    }
}