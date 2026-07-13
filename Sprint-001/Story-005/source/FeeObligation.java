// /Sprint-001/Story-005/source/FeeObligation.java;

import java.util.*;


public class FeeObligation {

    private final String feeObligationIdentifier;
    private final String studentIdentifier;
    private final String academicYearIdentifier;
    private final String feeStructureIdentifier;

    private final List<ObligationLine> obligationLines;

    private BigDecimal outstandingAmount;

    private boolean active;

    public FeeObligation(
            String feeObligationIdentifier,
            String studentIdentifier,
            String academicYearIdentifier,
            String feeStructureIdentifier,
            List<ObligationLine> obligationLines,
            BigDecimal outstandingAmount) {

        if (feeObligationIdentifier == null || feeObligationIdentifier.isBlank()) {
            throw new IllegalArgumentException(
                    "Fee Obligation Identifier is required");
        }

        if (studentIdentifier == null || studentIdentifier.isBlank()) {
            throw new IllegalArgumentException(
                    "Student Identifier is required");
        }

        if (academicYearIdentifier == null || academicYearIdentifier.isBlank()) {
            throw new IllegalArgumentException(
                    "Academic Year Identifier is required");
        }

        if (feeStructureIdentifier == null || feeStructureIdentifier.isBlank()) {
            throw new IllegalArgumentException(
                    "Fee Structure Identifier is required");
        }

        if (outstandingAmount == null
                || outstandingAmount.compareTo(BigDecimal.ZERO) < 0) {

            throw new IllegalArgumentException(
                    "Outstanding Amount cannot be negative");
        }

        validateObligationLines(obligationLines);

        this.feeObligationIdentifier = feeObligationIdentifier;
        this.studentIdentifier = studentIdentifier;
        this.academicYearIdentifier = academicYearIdentifier;
        this.feeStructureIdentifier = feeStructureIdentifier;
        this.obligationLines = new ArrayList<>(obligationLines);
        this.outstandingAmount = outstandingAmount;
        this.active = true;
    }

    public void update(
            List<ObligationLine> obligationLines,
            BigDecimal outstandingAmount) {

        if (!active) {
            throw new IllegalStateException(
                    "Cannot update a retired Fee Obligation");
        }

        if (outstandingAmount == null
                || outstandingAmount.compareTo(BigDecimal.ZERO) < 0) {

            throw new IllegalArgumentException(
                    "Outstanding Amount cannot be negative");
        }

        validateObligationLines(obligationLines);

        List<ObligationLine> updatedLines =
                new ArrayList<>(obligationLines);

        this.obligationLines.clear();
        this.obligationLines.addAll(updatedLines);

        this.outstandingAmount = outstandingAmount;
    }

    public void retire() {

        if (!active) {
            throw new IllegalStateException(
                    "Cannot retire an already retired Fee Obligation");
        }

        active = false;
    }

    private void validateObligationLines(
            List<ObligationLine> obligationLines) {

        if (obligationLines == null || obligationLines.isEmpty()) {
            throw new IllegalArgumentException(
                    "Obligation Lines are required");
        }

        Set<String> obligationLineIdentifiers = new HashSet<>();

        for (ObligationLine obligationLine : obligationLines) {

            if (obligationLine == null) {
                throw new IllegalArgumentException(
                        "Obligation Lines cannot contain null entries");
            }

            if (!obligationLineIdentifiers.add(
                    obligationLine.getObligationLineIdentifier())) {

                throw new IllegalArgumentException(
                        "Duplicate Obligation Line Identifier found");
            }
        }
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
        return Collections.unmodifiableList(obligationLines);
    }

    public BigDecimal getOutstandingAmount() {
        return outstandingAmount;
    }

    public boolean isActive() {
        return active;
    }
}