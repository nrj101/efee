// /Sprint-001/Story-004/source/Discount.java

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Discount {
    private final String discountIdentifier;
    private final String studentIdentifier;
    private final List<FeeComponent> applicableFeeComponents;
    private double discountValue;
    private boolean active;

    public Discount(String discountIdentifier, String studentIdentifier, List<FeeComponent> applicableFeeComponents, double discountValue, boolean active) {
        if (discountIdentifier == null || discountIdentifier.isEmpty()) {
            throw new IllegalArgumentException("Discount identifier cannot be null or empty");
        }
        if (studentIdentifier == null || studentIdentifier.isEmpty()) {
            throw new IllegalArgumentException("Student identifier cannot be null or empty");
        }
        if (discountValue < 0) {
            throw new IllegalArgumentException("Discount value cannot be negative");
        }
        validateFeeComponents(applicableFeeComponents);
        this.discountIdentifier = discountIdentifier;
        this.studentIdentifier = studentIdentifier;
        this.applicableFeeComponents = new ArrayList<>(applicableFeeComponents);
        this.discountValue = discountValue;
        this.active = active;
    }

    public void update(List<FeeComponent> applicableFeeComponents, double discountValue) {
        if (!this.active) {
            throw new IllegalStateException("Cannot update a retired discount");
        }
        if (discountValue < 0) {
            throw new IllegalArgumentException("Discount value cannot be negative");
        }
        validateFeeComponents(applicableFeeComponents);
        this.discountValue = discountValue;
        this.applicableFeeComponents.clear();
        this.applicableFeeComponents.addAll(applicableFeeComponents);
    }

    public void retire() {
        if (this.active) {
            this.active = false;
        } else {
            throw new IllegalStateException("Cannot retire an already retired discount");
        }
    }

    private void validateFeeComponents(List<FeeComponent> feeComponents) {
        if (feeComponents == null || feeComponents.isEmpty()) {
            throw new IllegalArgumentException("Applicable fee components cannot be null or empty");
        }
        Set<String> componentIds = new HashSet<>();
        for (FeeComponent component : feeComponents) {
            if (component == null) {
                throw new IllegalArgumentException("Fee component cannot be null");
            }
            if (componentIds.contains(component.getId())) {
                throw new IllegalArgumentException("Duplicate fee component ID: " + component.getId());
            }
            componentIds.add(component.getId());
        }
    }

    public String getDiscountIdentifier() {
        return discountIdentifier;
    }

    public String getStudentIdentifier() {
        return studentIdentifier;
    }

    public List<FeeComponent> getApplicableFeeComponents() {
        return Collections.unmodifiableList(applicableFeeComponents);
    }

    public double getDiscountValue() {
        return discountValue;
    }

    public boolean isActive() {
        return active;
    }
}