/*
 * Reference Implementation:
 * Sprint-001 / Story-004
 */

package com.efee.domain.discount;

import java.util.Objects;

/**
 * Immutable Value Object representing the approval information
 * associated with an approved Discount.
 */
public final class ApprovalInformation {

    private final String approvedBy;
    private final String approvalReference;

    public ApprovalInformation(String approvedBy,
                               String approvalReference) {

        if (approvedBy == null || approvedBy.isBlank()) {
            throw new IllegalArgumentException(
                    "Approved By cannot be null or blank.");
        }

        if (approvalReference == null || approvalReference.isBlank()) {
            throw new IllegalArgumentException(
                    "Approval Reference cannot be null or blank.");
        }

        this.approvedBy = approvedBy;
        this.approvalReference = approvalReference;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public String getApprovalReference() {
        return approvalReference;
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof ApprovalInformation other)) {
            return false;
        }

        return Objects.equals(approvedBy, other.approvedBy)
                && Objects.equals(approvalReference,
                                  other.approvalReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                approvedBy,
                approvalReference
        );
    }

    @Override
    public String toString() {
        return "ApprovalInformation{" +
                "approvedBy='" + approvedBy + '\'' +
                ", approvalReference='" + approvalReference + '\'' +
                '}';
    }
}