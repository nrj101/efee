// /Sprint-002/Story-007/source/Receipt.java

import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class Receipt {

    private final String receiptIdentifier;
    private final String paymentIdentifier;
    private final String receiptNumber;
    private final Instant acknowledgementTimestamp;
    private ReceiptLifecycle lifecycleState;
    private final CorrectionHistory correctionHistory;

    public Receipt(
            String receiptIdentifier,
            String paymentIdentifier,
            String receiptNumber,
            Instant acknowledgementTimestamp) {

        this.receiptIdentifier = Objects.requireNonNull(receiptIdentifier);
        this.paymentIdentifier = Objects.requireNonNull(paymentIdentifier);
        this.receiptNumber = Objects.requireNonNull(receiptNumber);
        this.acknowledgementTimestamp = Objects.requireNonNull(acknowledgementTimestamp);

        this.lifecycleState = ReceiptLifecycle.ISSUED;
        this.correctionHistory = new CorrectionHistory();
    }

    public String getReceiptIdentifier() {
        return receiptIdentifier;
    }

    public String getPaymentIdentifier() {
        return paymentIdentifier;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public Instant getAcknowledgementTimestamp() {
        return acknowledgementTimestamp;
    }

    public ReceiptLifecycle getLifecycleState() {
        return lifecycleState;
    }

    public List<String> getCorrectionHistory() {
        return correctionHistory.getCorrections();
    }

    public void correct(String correctionDescription) {

        Objects.requireNonNull(correctionDescription);

        if (lifecycleState == ReceiptLifecycle.RETIRED) {
            throw new IllegalStateException(
                    "Cannot correct a retired receipt.");
        }

        correctionHistory.addCorrection(correctionDescription);

        lifecycleState = ReceiptLifecycle.CORRECTED;
    }

    public void retire() {

        if (lifecycleState == ReceiptLifecycle.RETIRED) {
            throw new IllegalStateException(
                    "Receipt is already retired.");
        }

        lifecycleState = ReceiptLifecycle.RETIRED;
    }
}