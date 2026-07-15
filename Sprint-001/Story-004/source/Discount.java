// /Sprint-001/Story-004/source/Discount.java

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Aggregate Root representing an approved financial concession
 * granted to a Student.
 */
public class Discount {

    private final String discountIdentifier;
    private final String studentIdentifier;

    private BigDecimal discountValue;
    private ApprovalInformation approvalInformation;
    private BusinessJustification businessJustification;

    private boolean active;

    public Discount(
            String discountIdentifier,
            String studentIdentifier,
            BigDecimal discountValue,
            ApprovalInformation approvalInformation,
            BusinessJustification businessJustification) {

        validateIdentifier(discountIdentifier, "Discount Identifier");
        validateIdentifier(studentIdentifier, "Student Identifier");
        validateDiscountValue(discountValue);

        this.approvalInformation = Objects.requireNonNull(
                approvalInformation,
                "Approval Information cannot be null.");

        this.businessJustification = Objects.requireNonNull(
                businessJustification,
                "Business Justification cannot be null.");

        this.discountIdentifier = discountIdentifier;
        this.studentIdentifier = studentIdentifier;
        this.discountValue = discountValue;
        this.active = true;
    }

    public void update(
            BigDecimal discountValue,
            ApprovalInformation approvalInformation,
            BusinessJustification businessJustification) {

        validateDiscountValue(discountValue);

        this.approvalInformation = Objects.requireNonNull(
                approvalInformation,
                "Approval Information cannot be null.");

        this.businessJustification = Objects.requireNonNull(
                businessJustification,
                "Business Justification cannot be null.");

        this.discountValue = discountValue;
    }

    public void retire() {

        if (!active) {
            throw new IllegalStateException(
                    "Discount has already been retired.");
        }

        active = false;
    }

    public String getDiscountIdentifier() {
        return discountIdentifier;
    }

    public String getStudentIdentifier() {
        return studentIdentifier;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public ApprovalInformation getApprovalInformation() {
        return approvalInformation;
    }

    public BusinessJustification getBusinessJustification() {
        return businessJustification;
    }

    public boolean isActive() {
        return active;
    }

    private void validateIdentifier(
            String identifier,
            String fieldName) {

        if (identifier == null || identifier.isBlank()) {
            throw new IllegalArgumentException(
                    fieldName + " cannot be null or blank.");
        }
    }

    private void validateDiscountValue(BigDecimal discountValue) {

        Objects.requireNonNull(
                discountValue,
                "Discount Value cannot be null.");

        if (discountValue.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    "Discount Value cannot be negative.");
        }
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof Discount other)) {
            return false;
        }

        return Objects.equals(
                discountIdentifier,
                other.discountIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountIdentifier);
    }

    @Override
    public String toString() {
        return "Discount{" +
                "discountIdentifier='" + discountIdentifier + '\'' +
                ", studentIdentifier='" + studentIdentifier + '\'' +
                ", discountValue=" + discountValue +
                ", approvalInformation=" + approvalInformation +
                ", businessJustification=" + businessJustification +
                ", active=" + active +
                '}';
    }
}