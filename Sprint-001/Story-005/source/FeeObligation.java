// /Sprint-001/Story-005/source/FeeObligation.java;

import java.util.*;

public class FeeObligation {
    private final String feeObligationIdentifier;
    private final String studentIdentifier;
    private final String academicYearIdentifier;
    private final String feeStructureIdentifier;
    private final List<ObligationLine> obligationLines;
    private MonetaryAmount outstandingAmount;
    private boolean active;

    // Helper method to validate obligation lines
    private void validateObligationLines(List<ObligationLine> obligationLines) {
        if (obligationLines == null || obligationLines.isEmpty()) {
            throw new IllegalArgumentException("Obligation lines must not be null or empty");
        }
        if (obligationLines.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("Obligation lines must not contain null entries");
        }
        if (obligationLines.stream().distinct().count() != obligationLines.size()) {
            throw new IllegalArgumentException("Obligation lines must not contain duplicates");
        }
    }

    // Constructor
    public FeeObligation(
        String feeObligationIdentifier,
        String studentIdentifier,
        String academicYearIdentifier,
        String feeStructureIdentifier,
        List<ObligationLine> obligationLines,
        MonetaryAmount outstandingAmount
    ) {
        if (feeObligationIdentifier == null || feeObligationIdentifier.isBlank()) {
            throw new IllegalArgumentException("Fee Obligation identifier must not be null or empty");
        }
        if (studentIdentifier == null || studentIdentifier.isBlank()) {
            throw new IllegalArgumentException("Student identifier must not be null or empty");
        }
        if (academicYearIdentifier == null || academicYearIdentifier.isBlank()) {
            throw new IllegalArgumentException("Academic Year identifier must not be null or empty");
        }
        if (feeStructureIdentifier == null || feeStructureIdentifier.isBlank()) {
            throw new IllegalArgumentException("Fee Structure identifier must not be null or empty");
        }
        if (obligationLines == null || obligationLines.isEmpty()) {
            throw new IllegalArgumentException("Obligation lines must not be null or empty");
        }
        if (obligationLines.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("Obligation lines must not contain null entries");
        }
        if (obligationLines.stream().distinct().count() != obligationLines.size()) {
            throw new IllegalArgumentException("Obligation lines must not contain duplicates");
        }
        if (outstandingAmount == null || outstandingAmount.isNegative()) {
            throw new IllegalArgumentException("Outstanding amount must not be null or negative");
        }

        this.feeObligationIdentifier = feeObligationIdentifier;
        this.studentIdentifier = studentIdentifier;
        this.academicYearIdentifier = academicYearIdentifier;
        this.feeStructureIdentifier = feeStructureIdentifier;
        this.obligationLines = new ArrayList<>(obligationLines);
        this.outstandingAmount = outstandingAmount;
        this.active = true;
    }

    // Update method
    public void update(
        List<ObligationLine> obligationLines,
        MonetaryAmount outstandingAmount
    ) {
        if (!active) {
            throw new IllegalStateException("Cannot update a retired Fee Obligation");
        }
        validateObligationLines(obligationLines);
        if (outstandingAmount == null || outstandingAmount.isNegative()) {
            throw new IllegalArgumentException("Outstanding amount must not be null or negative");
        }

        this.obligationLines.clear();
        this.obligationLines.addAll(obligationLines);
        this.outningAmount = outstandingAmount;
    }

    // Retirement method
    public void retire() {
        if (!active) {
            throw new IllegalStateException("Cannot retire a retired Fee Obligation");
        }
        this.active = false;
    }

    // Getters
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

    public MonetaryAmount getOutstandingAmount() {
        return outstandingAmount;
    }

    public boolean isActive() {
        return active;
    }
}