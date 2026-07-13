// /Sprint-001/Story-003/tests/FeeStructureTest.java

package com.example.fee.structure;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class FeeStructure {
    private final String feeStructureId;
    private final String name;
    private final List<FeeComponent> feeComponents;
    private final boolean active;

    public FeeStructure(String feeStructureId, String name, List<FeeComponent> feeComponents, boolean active) {
        if (feeStructureId == null || feeStructureId.isEmpty()) {
            throw new IllegalArgumentException("Fee structure ID cannot be null or empty");
        }
        
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        
        if (feeComponents == null || feeComponents.isEmpty()) {
            throw new IllegalArgumentException("Fee structure must contain at least one fee component");
        }
        
        if (feeComponents.stream().anyMatch(component -> component.getAmount().compareTo(BigDecimal.ZERO) <= 0)) {
            throw new IllegalArgumentException("All fee components must have positive amounts");
        }
        
        this.feeStructureId = feeStructureId;
        this.name = name;
        this.feeComponents = new ArrayList<>(feeComponents);
        this.active = active;
    }

    // Business operations
    public void addFeeComponent(FeeComponent feeComponent) {
        if (feeComponent.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Fee component amount must be positive");
        }
        
        this.feeComponents.add(feeComponent);
    }

    public void activate() {
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }

    public void retire() {
        this.active = false;
        // Additional retirement logic can be added here
    }

    public void update(String newName, List<FeeComponent> newFeeComponents) {
        if (newName == null || newName.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        
        if (newFeeComponents == null || newFeeComponents.isEmpty()) {
            throw new IllegalArgumentException("Fee structure must contain at least one fee component");
        }
        
        if (newFeeComponents.stream().anyMatch(component -> component.getAmount().compareTo(BigDecimal.ZERO) <= 0)) {
            throw new IllegalArgumentException("All fee components must have positive amounts");
        }
        
        this.name = newName;
        this.feeComponents = new ArrayList<>(newFeeComponents);
    }

    // Getters
    public String getFeeStructureId() {
        return feeStructureId;
    }

    public String getName() {
        return name;
    }

    public List<FeeComponent> getFeeComponents() {
        return feeComponents;
    }

    public boolean isActive() {
        return active;
    }

    // FeeComponent class
    public static class FeeComponent {
        private final String componentName;
        private final BigDecimal amount;
        private final boolean active;

        public FeeComponent(String componentName, BigDecimal amount, boolean active) {
            if (componentName == null || componentName.isEmpty()) {
                throw new IllegalArgumentException("Component name cannot be null or empty");
            }
            
            if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Amount must be a positive number");
            }
            
            this.componentName = componentName;
            this.amount = amount;
            this.active = active;
        }

        // Getters
        public String getComponentName() {
            return componentName;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public boolean isActive() {
            return active;
        }
    }
}