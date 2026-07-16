// /Sprint-001/Story-003/source/FeeStructure.java

package com.efee.domain.feestructure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class FeeStructure {

    private final String feeStructureIdentifier;
    private String feeStructureName;
    private final List<FeeComponent> feeComponents;
    private boolean active;

    public FeeStructure(
            String feeStructureIdentifier,
            String feeStructureName,
            List<FeeComponent> feeComponents) {

        validateIdentifier(feeStructureIdentifier);
        validateName(feeStructureName);
        validateFeeComponents(feeComponents);

        this.feeStructureIdentifier = feeStructureIdentifier;
        this.feeStructureName = feeStructureName;
        this.feeComponents = new ArrayList<>(feeComponents);
        this.active = true;
    }

    public String getFeeStructureIdentifier() {
        return feeStructureIdentifier;
    }

    public String getFeeStructureName() {
        return feeStructureName;
    }

    public List<FeeComponent> getFeeComponents() {
        return List.copyOf(feeComponents);
    }

    public boolean isActive() {
        return active;
    }

    public void update(
            String feeStructureName,
            List<FeeComponent> feeComponents) {

        ensureActive();

        validateName(feeStructureName);
        validateFeeComponents(feeComponents);

        this.feeStructureName = feeStructureName;

        this.feeComponents.clear();
        this.feeComponents.addAll(feeComponents);
    }

    public void addFeeComponent(FeeComponent feeComponent) {

        ensureActive();

        if (feeComponent == null) {
            throw new IllegalArgumentException(
                    "Fee Component cannot be null");
        }

        for (FeeComponent existing : feeComponents) {

            if (existing.getFeeComponentIdentifier().equals(
                    feeComponent.getFeeComponentIdentifier())) {

                throw new IllegalArgumentException(
                        "Duplicate Fee Component Identifier");
            }
        }

        feeComponents.add(feeComponent);
    }

    public void retire() {

        ensureActive();

        active = false;
    }

    private void ensureActive() {

        if (!active) {
            throw new IllegalStateException(
                    "Cannot modify a retired Fee Structure");
        }
    }

    private void validateIdentifier(String feeStructureIdentifier) {

        if (feeStructureIdentifier == null ||
                feeStructureIdentifier.isBlank()) {

            throw new IllegalArgumentException(
                    "Fee Structure Identifier cannot be null or empty");
        }
    }

    private void validateName(String feeStructureName) {

        if (feeStructureName == null ||
                feeStructureName.isBlank()) {

            throw new IllegalArgumentException(
                    "Fee Structure Name cannot be null or empty");
        }
    }

    private void validateFeeComponents(List<FeeComponent> feeComponents) {

        if (feeComponents == null) {
            throw new IllegalArgumentException(
                    "Fee Components cannot be null");
        }

        if (feeComponents.isEmpty()) {
            throw new IllegalArgumentException(
                    "Fee Structure must contain at least one Fee Component");
        }

        Set<String> identifiers = new HashSet<>();

        for (FeeComponent feeComponent : feeComponents) {

            if (feeComponent == null) {
                throw new IllegalArgumentException(
                        "Fee Components cannot contain null values");
            }

            if (!identifiers.add(
                    feeComponent.getFeeComponentIdentifier())) {

                throw new IllegalArgumentException(
                        "Duplicate Fee Component Identifier");
            }
        }
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof FeeStructure other)) {
            return false;
        }

        return Objects.equals(
                feeStructureIdentifier,
                other.feeStructureIdentifier);
    }

    @Override
    public int hashCode() {

        return Objects.hash(feeStructureIdentifier);
    }

    @Override
    public String toString() {

        return "FeeStructure{" +
                "feeStructureIdentifier='" + feeStructureIdentifier + '\'' +
                ", feeStructureName='" + feeStructureName + '\'' +
                ", feeComponents=" + feeComponents +
                ", active=" + active +
                '}';
    }

}