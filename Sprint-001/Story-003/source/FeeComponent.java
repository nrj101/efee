// /Sprint-001/Story-003/source/FeeComponent.java

import java.math.BigDecimal;

public class FeeComponent {
    private final String componentName;
    private final BigDecimal amount;
    private boolean active;

    public FeeComponent(String componentName, BigDecimal amount, boolean active) {
        if (componentName == null || componentName.isEmpty()) {
            throw new IllegalArgumentException("Component name cannot be null or empty");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount cannot be null or negative");
        }

        this.componentName = componentName;
        this.amount = amount;
        this.active = active;
    }

    // Business operations
    public void setActive(boolean active) {
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