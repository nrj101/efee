// /Sprint-002/Story-009/source/PaymentPersistence.java

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Technology-neutral persistent representation
 * of the Payment Aggregate.
 */
public class PaymentPersistence {

    private final String paymentIdentifier;
    private final String payerIdentifier;
    private final BigDecimal paymentAmount;
    private final String paymentMethod;
    private final String paymentReference;
    private final PaymentLifecycle lifecycleState;

    public PaymentPersistence(
            String paymentIdentifier,
            String payerIdentifier,
            BigDecimal paymentAmount,
            String paymentMethod,
            String paymentReference,
            PaymentLifecycle lifecycleState) {

        this.paymentIdentifier =
                Objects.requireNonNull(paymentIdentifier);

        this.payerIdentifier =
                Objects.requireNonNull(payerIdentifier);

        this.paymentAmount =
                Objects.requireNonNull(paymentAmount);

        this.paymentMethod =
                Objects.requireNonNull(paymentMethod);

        this.paymentReference = paymentReference;

        this.lifecycleState =
                Objects.requireNonNull(lifecycleState);
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
}