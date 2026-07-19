// /Sprint-002/Story-006/source/Payment.java

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Payment {

    private final String paymentIdentifier;
    private final String payerIdentifier;
    private final BigDecimal paymentAmount;
    private final String paymentMethod;
    private final String paymentReference;
    private PaymentLifecycle lifecycleState;

    public Payment(String paymentIdentifier,
                   String payerIdentifier,
                   BigDecimal paymentAmount,
                   String paymentMethod,
                   String paymentReference) {

        this.paymentIdentifier = Objects.requireNonNull(paymentIdentifier);
        this.payerIdentifier = Objects.requireNonNull(payerIdentifier);
        this.paymentAmount = Objects.requireNonNull(paymentAmount);
        this.paymentMethod = Objects.requireNonNull(paymentMethod);
        this.paymentReference = paymentReference;

        validateBusinessRules();

        this.lifecycleState = PaymentLifecycle.RECORDED;
    }

    private void validateBusinessRules() {
        if (paymentAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    "Payment amount cannot be negative.");
        }
    }

    public String getPaymentIdentifier() {
        return paymentIdentifier;
    }

    public String getPayerIdentifier() {
        return payerIdentifier;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public PaymentLifecycle getLifecycleState() {
        return lifecycleState;
    }

    public void realise() {
        if (lifecycleState != PaymentLifecycle.RECORDED) {
            throw new IllegalStateException(
                    "Payment has already been finalised: " + lifecycleState);
        }
        this.lifecycleState = PaymentLifecycle.REALISED;
    }

    public void cancel() {
        if (lifecycleState != PaymentLifecycle.RECORDED) {
            throw new IllegalStateException(
                    "Payment has already been finalised: " + lifecycleState);
        }
        this.lifecycleState = PaymentLifecycle.CANCELLED;
    }
}