
import java.math.BigDecimal;

/**
 * Application Service coordinating the approved Payment Service workflow.
 * Implements only the public operations explicitly authorized by Story-008.
 */
public class PaymentService {

    /**
     * Coordinates the approved Record Payment workflow.
     * Creates a new Payment Aggregate using the approved constructor.
     *
     * @param paymentIdentifier identifier of the payment
     * @param payerIdentifier payer identifier
     * @param paymentAmount amount received
     * @param paymentMethod method of payment
     * @param paymentReference external payment reference (may be null)
     * @return newly created Payment Aggregate
     */
    public Payment recordPayment(String paymentIdentifier,
                                 String payerIdentifier,
                                 BigDecimal paymentAmount,
                                 String paymentMethod,
                                 String paymentReference) {
        Payment payment = new Payment(paymentIdentifier, payerIdentifier, paymentAmount, paymentMethod, paymentReference);
        return payment;
    }

    /**
     * Coordinates the approved Realize Payment workflow.
     * Invokes the approved Payment Aggregate realization operation.
     *
     * @param payment payment to realize
     * @return the same payment after realization
     */
    public Payment realizePayment(Payment payment) {
        payment.realize();
        return payment;
    }
}