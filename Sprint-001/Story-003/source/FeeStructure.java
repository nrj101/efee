// /Sprint-001/Story-003/source/FeeStructure.java

import java.util.*;

public class FeeStructure {
    private final String feeStructureIdentifier;
    private String feeStructureName;
    private final List<FeeComponent> feeComponents;
    private boolean active;

    public FeeStructure(String feeStructureIdentifier, String feeStructureName, List<FeeComponent> feeComponents) {
        if (feeStructureIdentifier == null || feeStructureIdentifier.isEmpty()) {
            throw new IllegalArgumentException("Fee Structure Identifier is required");
        }
        if (feeStructureName == null || feeStructureName.isEmpty()) {
            throw new IllegalArgumentException("Fee Structure Name is required");
        }
        if (feeComponents == null || feeComponents.isEmpty()) {
            throw new IllegalArgumentException("Fee Components are required");
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

    public void update(String feeStructureName, List<FeeComponent> feeComponents) {
        if (feeStructureName == null || feeStructureName.isEmpty()) {
            throw new IllegalArgumentException("Fee Structure Name is required");
        }
        if (feeComponents == null || feeComponents.isEmpty()) {
            throw new IllegalArgumentException("Fee Components are required");
        }

        // Check for duplicate components
        Set<String> componentIdentifiers = new HashSet<>();
        for (FeeComponent component : feeComponents) {
            if (componentIdentifiers.contains(component.getFeeComponentIdentifier())) {
                throw new IllegalArgumentException("Duplicate Fee Component Identifier found");
            }
            componentIdentifiers.add(component.getFeeComponentIdentifier());
        }

        this.feeStructureName = feeStructureName;
        this.feeComponents = new ArrayList<>(feeComponents);
    }

    public void addFeeComponent(FeeComponent feeComponent) {
        if (feeComponent == null) {
            throw new IllegalArgumentException("Fee Component is required");
        }

        // Check for duplicate component
        for (FeeComponent component : feeComponents) {
            if (component.getFeeComponentIdentifier().equals(feeComponent.getFeeComponentIdentifier())) {
                throw new IllegalArgumentException("Duplicate Fee Component Identifier found");
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
