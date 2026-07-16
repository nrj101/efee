package com.efee.domain.feeobligation;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Immutable Supporting Entity representing a single financial obligation
 * owned by the FeeObligation Aggregate.
 *
 * The original financial obligation preserved by this Supporting Entity
 * never changes. Future Stories may introduce additional Supporting
 * Entities (AppliedDiscount and PaymentAllocation) that affect the
 * Aggregate's derived Outstanding Amount without modifying the original
 * obligation.
 */
public final class ObligationLine {

    private final String obligationLineIdentifier;
    private final String feeComponentIdentifier;
    private final BigDecimal originalAmount;

    public ObligationLine(
            String obligationLineIdentifier,
            String feeComponentIdentifier,
            BigDecimal originalAmount) {

        validateIdentifier(
                obligationLineIdentifier,
                "Obligation Line Identifier");

        validateIdentifier(
                feeComponentIdentifier,
                "Fee Component Identifier");

        validateAmount(originalAmount);

        this.obligationLineIdentifier = obligationLineIdentifier;
        this.feeComponentIdentifier = feeComponentIdentifier;
        this.originalAmount = originalAmount;
    }

    public String getObligationLineIdentifier() {
        return obligationLineIdentifier;
    }

    public String getFeeComponentIdentifier() {
        return feeComponentIdentifier;
    }

    /**
     * Returns the original financial obligation represented by this
     * Supporting Entity.
     */
    public BigDecimal getOriginalAmount() {
        return originalAmount;
    }

    /**
     * Convenience accessor used by the Aggregate when deriving the
     * current Outstanding Amount.
     *
     * In Sprint-001 this is identical to the Original Amount.
     * Future Stories may derive Outstanding Amount from additional
     * financial facts (Applied Discounts and Payment Allocations)
     * while the original obligation remains unchanged.
     */
    public BigDecimal getAmount() {
        return originalAmount;
    }

    private void validateIdentifier(
            String identifier,
            String fieldName) {

        if (identifier == null || identifier.isBlank()) {

            throw new IllegalArgumentException(
                    fieldName + " cannot be null or blank.");
        }
    }

    private void validateAmount(BigDecimal amount) {

        Objects.requireNonNull(
                amount,
                "Original Amount cannot be null.");

        if (amount.compareTo(BigDecimal.ZERO) < 0) {

            throw new IllegalArgumentException(
                    "Original Amount cannot be negative.");
        }
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof ObligationLine other)) {
            return false;
        }

        return Objects.equals(
                obligationLineIdentifier,
                other.obligationLineIdentifier)
                && Objects.equals(
                feeComponentIdentifier,
                other.feeComponentIdentifier)
                && Objects.equals(
                originalAmount,
                other.originalAmount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(
                obligationLineIdentifier,
                feeComponentIdentifier,
                originalAmount);
    }

    @Override
    public String toString() {

        return "ObligationLine{" +
                "obligationLineIdentifier='" + obligationLineIdentifier + '\'' +
                ", feeComponentIdentifier='" + feeComponentIdentifier + '\'' +
                ", originalAmount=" + originalAmount +
                '}';
    }

}