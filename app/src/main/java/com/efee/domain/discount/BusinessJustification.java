/*
 * Reference Implementation:
 * Sprint-001 / Story-004
 */

package com.efee.domain.discount;

import java.util.Objects;

/**
 * Immutable Value Object representing the business justification
 * for granting an approved Discount.
 */
public final class BusinessJustification {

    private final String reason;

    public BusinessJustification(String reason) {

        if (reason == null || reason.isBlank()) {
            throw new IllegalArgumentException(
                    "Business Justification cannot be null or blank.");
        }

        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof BusinessJustification other)) {
            return false;
        }

        return Objects.equals(reason, other.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reason);
    }

    @Override
    public String toString() {
        return "BusinessJustification{" +
                "reason='" + reason + '\'' +
                '}';
    }
}