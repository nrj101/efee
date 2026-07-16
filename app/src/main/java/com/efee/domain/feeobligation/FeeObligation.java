package com.efee.domain.feeobligation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Aggregate Root representing a Student's financial responsibility
 * for an Academic Year.
 */
public class FeeObligation {

    private final String feeObligationIdentifier;
    private final String studentIdentifier;
    private final String academicYearIdentifier;
    private final String feeStructureIdentifier;

    private final List<ObligationLine> obligationLines;

    /**
     * Derived Aggregate state.
     *
     * This value is always derived from the Aggregate's owned
     * financial facts (Obligation Lines).
     */
    private BigDecimal outstandingAmount;

    private FeeObligationLifecycle lifecycleState;

    public FeeObligation(
            String feeObligationIdentifier,
            String studentIdentifier,
            String academicYearIdentifier,
            String feeStructureIdentifier,
            List<ObligationLine> obligationLines) {

        validateIdentifier(
                feeObligationIdentifier,
                "Fee Obligation Identifier");

        validateIdentifier(
                studentIdentifier,
                "Student Identifier");

        validateIdentifier(
                academicYearIdentifier,
                "Academic Year Identifier");

        validateIdentifier(
                feeStructureIdentifier,
                "Fee Structure Identifier");

        validateObligationLines(obligationLines);

        this.feeObligationIdentifier = feeObligationIdentifier;
        this.studentIdentifier = studentIdentifier;
        this.academicYearIdentifier = academicYearIdentifier;
        this.feeStructureIdentifier = feeStructureIdentifier;

        this.obligationLines = new ArrayList<>(obligationLines);

        this.outstandingAmount = calculateOutstandingAmount();

        this.lifecycleState = FeeObligationLifecycle.ACTIVE;
    }

    public void update(
            List<ObligationLine> obligationLines) {

        ensureActive();

        validateObligationLines(obligationLines);

        this.obligationLines.clear();
        this.obligationLines.addAll(new ArrayList<>(obligationLines));

        this.outstandingAmount = calculateOutstandingAmount();
    }

    public void retire() {

        ensureActive();

        this.lifecycleState = FeeObligationLifecycle.RETIRED;
    }

    public String getFeeObligationIdentifier() {
        return feeObligationIdentifier;
    }

    public String getStudentIdentifier() {
        return studentIdentifier;
    }

    public String getAcademicYearIdentifier() {
        return academicYearIdentifier;
    }

    public String getFeeStructureIdentifier() {
        return feeStructureIdentifier;
    }

    public List<ObligationLine> getObligationLines() {
        return List.copyOf(obligationLines);
    }

    public BigDecimal getOutstandingAmount() {
        return outstandingAmount;
    }

    public FeeObligationLifecycle getLifecycleState() {
        return lifecycleState;
    }

    private BigDecimal calculateOutstandingAmount() {

        BigDecimal total = BigDecimal.ZERO;

        for (ObligationLine obligationLine : obligationLines) {
            total = total.add(obligationLine.getAmount());
        }

        return total;
    }

    private void ensureActive() {

        if (lifecycleState == FeeObligationLifecycle.RETIRED) {

            throw new IllegalStateException(
                    "Fee Obligation has already been retired.");
        }
    }

    private void validateIdentifier(
            String identifier,
            String fieldName) {

        if (identifier == null || identifier.isBlank()) {

            throw new IllegalArgumentException(
                    fieldName + " cannot be null or blank.");
        }
    }

    private void validateObligationLines(
            List<ObligationLine> obligationLines) {

        if (obligationLines == null) {

            throw new IllegalArgumentException(
                    "Obligation Lines cannot be null.");
        }

        if (obligationLines.isEmpty()) {

            throw new IllegalArgumentException(
                    "At least one Obligation Line is required.");
        }

        Set<String> identifiers = new HashSet<>();

        for (ObligationLine obligationLine : obligationLines) {

            if (obligationLine == null) {

                throw new IllegalArgumentException(
                        "Obligation Line cannot be null.");
            }

            if (!identifiers.add(
                    obligationLine.getObligationLineIdentifier())) {

                throw new IllegalArgumentException(
                        "Duplicate Obligation Line Identifier: "
                                + obligationLine.getObligationLineIdentifier());
            }
        }
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof FeeObligation other)) {
            return false;
        }

        return Objects.equals(
                feeObligationIdentifier,
                other.feeObligationIdentifier);
    }

    @Override
    public int hashCode() {

        return Objects.hash(feeObligationIdentifier);
    }

    @Override
    public String toString() {

        return "FeeObligation{" +
                "feeObligationIdentifier='" + feeObligationIdentifier + '\'' +
                ", studentIdentifier='" + studentIdentifier + '\'' +
                ", academicYearIdentifier='" + academicYearIdentifier + '\'' +
                ", feeStructureIdentifier='" + feeStructureIdentifier + '\'' +
                ", obligationLines=" + obligationLines +
                ", outstandingAmount=" + outstandingAmount +
                ", lifecycleState=" + lifecycleState +
                '}';
    }

}