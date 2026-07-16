// /Sprint-001/Story-003/source/FeeComponent.java

package com.efee.domain.feestructure;
import java.math.BigDecimal;
import java.util.Objects;

public class FeeComponent {

    private final String feeComponentIdentifier;
    private final String feeComponentName;
    private final BigDecimal feeAmount;

    public FeeComponent(
            String feeComponentIdentifier,
            String feeComponentName,
            BigDecimal feeAmount) {

        validateIdentifier(feeComponentIdentifier);
        validateName(feeComponentName);
        validateAmount(feeAmount);

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

    private void validateIdentifier(String feeComponentIdentifier) {

        if (feeComponentIdentifier == null ||
                feeComponentIdentifier.isBlank()) {

            throw new IllegalArgumentException(
                    "Fee Component Identifier cannot be null or empty");
        }
    }

    private void validateName(String feeComponentName) {

        if (feeComponentName == null ||
                feeComponentName.isBlank()) {

            throw new IllegalArgumentException(
                    "Fee Component Name cannot be null or empty");
        }
    }

    private void validateAmount(BigDecimal feeAmount) {

        if (feeAmount == null) {

            throw new IllegalArgumentException(
                    "Fee Amount cannot be null");
        }

        if (feeAmount.compareTo(BigDecimal.ZERO) <= 0) {

            throw new IllegalArgumentException(
                    "Fee Amount must be greater than zero");
        }
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof FeeComponent other)) {
            return false;
        }

        return Objects.equals(
                feeComponentIdentifier,
                other.feeComponentIdentifier);
    }

    @Override
    public int hashCode() {

        return Objects.hash(feeComponentIdentifier);
    }

    @Override
    public String toString() {

        return "FeeComponent{" +
                "feeComponentIdentifier='" + feeComponentIdentifier + '\'' +
                ", feeComponentName='" + feeComponentName + '\'' +
                ", feeAmount=" + feeAmount +
                '}';
    }

}