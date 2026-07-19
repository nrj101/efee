import java.math.BigDecimal;
import java.util.Objects;

public class PaymentPersistence {
    private final String paymentIdentifier;
    private final String payerIdentifier;
    private final BigDecimal paymentAmount;
    private final String paymentMethod;
    private final String paymentReference;
    private final PaymentLifecycle lifecycleState;

    public PaymentPersistence(String paymentIdentifier,
                              String payerIdentifier,
                              BigDecimal paymentAmount,
                              String paymentMethod,
                              String paymentReference,
                              PaymentLifecycle lifecycleState) {
        this.paymentIdentifier = Objects.requireNonNull(paymentIdentifier);
        this.payerIdentifier = Objects.requireNonNull(payerIdentifier);
        this.paymentAmount = Objects.requireNonNull(paymentAmount);
        this.paymentMethod = Objects.requireNonNull(paymentMethod);
        this.paymentReference = paymentReference;
        this.lifecycleState = Objects.requireNonNull(lifecycleState);
        
        validateAmount();
    }

    private void validateAmount() {
        if (paymentAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Payment amount cannot be negative.");
        }
    }

    // Getters
    public String getPaymentIdentifier() { return paymentIdentifier; }
    public String getPayerIdentifier() { return payerIdentifier; }
    public BigDecimal getPaymentAmount() { return paymentAmount; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getPaymentReference() { return paymentReference; }
    public PaymentLifecycle getLifecycleState() { return lifecycleState; }
}
