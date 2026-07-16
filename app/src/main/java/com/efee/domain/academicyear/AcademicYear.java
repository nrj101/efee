/*
 * Reference Implementation:
 * Sprint-001 / Story-002
 */

package com.efee.domain.academicyear;
import java.time.LocalDate;
import java.util.Objects;

public class AcademicYear {

    private final String academicYearIdentifier;
    private final String academicYearCode;
    private final LocalDate startDate;
    private final LocalDate endDate;

    private String feeStructureIdentifier;
    private AcademicYearLifecycle lifecycleState;

    public AcademicYear(
            String academicYearIdentifier,
            String academicYearCode,
            LocalDate startDate,
            LocalDate endDate,
            String feeStructureIdentifier) {

        if (academicYearIdentifier == null || academicYearIdentifier.isBlank()) {
            throw new IllegalArgumentException(
                    "Academic Year Identifier cannot be null or empty");
        }

        if (academicYearCode == null || academicYearCode.isBlank()) {
            throw new IllegalArgumentException(
                    "Academic Year Code cannot be null or empty");
        }

        if (startDate == null) {
            throw new IllegalArgumentException(
                    "Start date cannot be null");
        }

        if (endDate == null) {
            throw new IllegalArgumentException(
                    "End date cannot be null");
        }

        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException(
                    "Start date cannot be after end date");
        }

        if (feeStructureIdentifier == null || feeStructureIdentifier.isBlank()) {
            throw new IllegalArgumentException(
                    "Fee Structure Identifier cannot be null or empty");
        }

        this.academicYearIdentifier = academicYearIdentifier;
        this.academicYearCode = academicYearCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.feeStructureIdentifier = feeStructureIdentifier;
        this.lifecycleState = AcademicYearLifecycle.PLANNED;
    }

    public void assignFeeStructure(String feeStructureIdentifier) {

        if (lifecycleState == AcademicYearLifecycle.CLOSED) {
            throw new IllegalStateException(
                    "Cannot assign Fee Structure to a closed Academic Year");
        }

        if (feeStructureIdentifier == null || feeStructureIdentifier.isBlank()) {
            throw new IllegalArgumentException(
                    "Fee Structure Identifier cannot be null or empty");
        }

        this.feeStructureIdentifier = feeStructureIdentifier;
    }

    public void activate() {

        if (lifecycleState != AcademicYearLifecycle.PLANNED) {
            throw new IllegalStateException(
                    "Only a planned Academic Year can be activated");
        }

        lifecycleState = AcademicYearLifecycle.ACTIVE;
    }

    public void close() {

        if (lifecycleState != AcademicYearLifecycle.ACTIVE) {
            throw new IllegalStateException(
                    "Only an active Academic Year can be closed");
        }

        lifecycleState = AcademicYearLifecycle.CLOSED;
    }

    public String getAcademicYearIdentifier() {
        return academicYearIdentifier;
    }

    public String getAcademicYearCode() {
        return academicYearCode;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getFeeStructureIdentifier() {
        return feeStructureIdentifier;
    }

    public AcademicYearLifecycle getLifecycleState() {
        return lifecycleState;
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof AcademicYear other)) {
            return false;
        }

        return Objects.equals(
                academicYearIdentifier,
                other.academicYearIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(academicYearIdentifier);
    }

    @Override
    public String toString() {

        return "AcademicYear{" +
                "academicYearIdentifier='" + academicYearIdentifier + '\'' +
                ", academicYearCode='" + academicYearCode + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", feeStructureIdentifier='" + feeStructureIdentifier + '\'' +
                ", lifecycleState=" + lifecycleState +
                '}';
    }
}