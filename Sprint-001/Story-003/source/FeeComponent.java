// /Sprint-001/Story-003/source/FeeComponent.java

import java.math.BigDecimal;

public class FeeComponent {
    private final String feeComponentIdentifier;
    private final String feeComponentName;
    private final BigDecimal feeAmount;

    public FeeComponent(String feeComponentIdentifier, String feeComponentName, BigDecimal feeAmount) {
        if (feeComponentIdentifier == null || feeComponentIdentifier.isBlank()) {
            throw new IllegalArgumentException("Fee Component Identifier is required");
        }
        if (feeComponentName == null || feeComponentName.isBlank()) {
            throw new IllegalArgumentException("Fee Component Name is required");
        }
        if (feeAmount == null || feeAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Fee Amount must be a positive value");
        }

        this.feeComponentIdentifier = feeComponentIdentifier;
        this.feeComponentName = feeComponentName;
        this.feeAmount = feeAmount;
    }

    public String getFeeComponentIdentifier() {
        return feeComponentIdentifier;
    }

    public String getFeeComponentName() {
        return feeComponentName;
    }

    public BigDecimal getFeeAmount() {
        return feeAmount;
    }
}