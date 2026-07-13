// /Sprint-001/Story-003/source/FeeStructure.java

import java.util.*;

public class FeeStructure {
    private String feeStructureIdentifier;
    private String feeStructureName;
    private List<FeeComponent> feeComponents;
    private boolean active;

    public FeeStructure(String feeStructureIdentifier, String feeStructureName, List<FeeComponent> feeComponents) {
        if (feeStructureIdentifier == null || feeStructureIdentifier.isBlank()) {
            throw new IllegalArgumentException("Fee Structure Identifier is required");
        }
        if (feeStructureName == null || feeStructureName.isBlank()) {
            throw new IllegalArgumentException("Fee Structure Name is required");
        }
        if (feeComponents == null || feeComponents.isEmpty()) {
            throw new IllegalArgumentException("Fee Components are required");
        }

        Set<String> componentIdentifiers = new HashSet<>();

        for (FeeComponent component : feeComponents) {

            if (component == null) {
                throw new IllegalArgumentException(
                        "Fee Components cannot contain null entries");
            }

            if (!componentIdentifiers.add(component.getFeeComponentIdentifier())) {
                throw new IllegalArgumentException(
                        "Duplicate Fee Component Identifier found");
            }
        }

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
        return Collections.unmodifiableList(feeComponents);
    }

    public boolean isActive() {
        return active;
    }

    public void update(String feeStructureName,
                    List<FeeComponent> feeComponents) {

        if (!active) {
            throw new IllegalStateException(
                    "Cannot update a retired Fee Structure");
        }

        if (feeStructureName == null || feeStructureName.isBlank()) {
            throw new IllegalArgumentException(
                    "Fee Structure Name is required");
        }

        if (feeComponents == null || feeComponents.isEmpty()) {
            throw new IllegalArgumentException(
                    "Fee Components are required");
        }

        Set<String> componentIdentifiers = new HashSet<>();

        for (FeeComponent component : feeComponents) {

            if (component == null) {
                throw new IllegalArgumentException(
                        "Fee Components cannot contain null entries");
            }

            if (!componentIdentifiers.add(component.getFeeComponentIdentifier())) {
                throw new IllegalArgumentException(
                        "Duplicate Fee Component Identifier found");
            }
        }

        this.feeStructureName = feeStructureName;

        this.feeComponents.clear();
        this.feeComponents.addAll(feeComponents);
    }

    public void addFeeComponent(FeeComponent feeComponent) {

        if (!active) {
            throw new IllegalStateException(
                    "Cannot modify a retired Fee Structure");
        }

        if (feeComponent == null) {
            throw new IllegalArgumentException(
                    "Fee Component is required");
        }

        for (FeeComponent existingComponent : feeComponents) {
            if (existingComponent.getFeeComponentIdentifier()
                    .equals(feeComponent.getFeeComponentIdentifier())) {

                throw new IllegalArgumentException(
                        "Duplicate Fee Component Identifier found");
            }
        }

        feeComponents.add(feeComponent);
    }

    public void retire() {
        if (!active) {
            throw new IllegalStateException("Cannot retire an already retired Fee Structure");
        }

        active = false;
    }
}
