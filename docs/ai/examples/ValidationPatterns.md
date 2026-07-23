# Validation Patterns

```yaml
---
document_id: AI-REF-005
title: Validation Patterns
version: 1.0.0
status: Approved

owner: Product Owner

purpose: Validation Implementation Patterns
created: 2026-07-23
last_updated: 2026-07-23
---
```

---

# Purpose

This document contains canonical validation patterns used throughout the E-Fee platform.

Validation ensures that business objects are always created and modified in a valid state while preserving business invariants.

This document focuses on validation responsibilities only.

For related implementation guidance, see:

- AggregateExamples
- ValueObjectExamples
- LifecyclePatterns

---

# Validation Responsibilities

Validation is responsible for:

- protecting business invariants;
- rejecting invalid input;
- preventing inconsistent state;
- enforcing business rules at the point of change.

Validation should occur as early as possible.

---

# Constructor Validation

Objects should validate mandatory inputs during construction.

Preferred implementation:

```java
public StudentNumber(String value) {

    Objects.requireNonNull(value);

    if (value.isBlank()) {
        throw new IllegalArgumentException(
                "Student Number cannot be blank.");
    }

    this.value = value;
}
```

---

# Method Validation

Business operations should validate their inputs before modifying state.

Preferred implementation:

```java
public void registerFeeObligation(
        FeeObligationId obligationId) {

    Objects.requireNonNull(obligationId);

    feeObligations.add(obligationId);
}
```

---

# Validate Before State Change

Business rules should be evaluated before updating Aggregate state.

Preferred implementation:

```java
if (status != PaymentStatus.RECORDED) {
    throw new IllegalStateException(
            "Payment has already been realised.");
}

status = PaymentStatus.REALISED;
```

Validation should always precede state changes.

---

# Validate Business Rules

Business rules should be enforced inside the owning Aggregate.

Preferred implementation:

```java
if (outstandingAmount.isLessThan(allocationAmount)) {
    throw new IllegalArgumentException(
            "Allocation exceeds outstanding balance.");
}
```

Business rule validation belongs where the business state is owned.

---

# Fail Fast

Invalid operations should fail immediately.

Avoid allowing partially completed business operations.

Preferred implementation:

```java
Objects.requireNonNull(paymentId);

if (paymentAmount.isZero()) {
    throw new IllegalArgumentException(
            "Payment amount must be greater than zero.");
}
```

---

# Validation Scope

Different object types validate different concerns.

| Object | Typical Validation |
|---------|--------------------|
| Value Object | Value correctness |
| Aggregate | Business invariants |
| Application Service | Request completeness |
| Supporting Type | Mandatory fields |

---

# Common Mistakes

Avoid:

- delaying validation until persistence;
- duplicating validation across layers;
- allowing invalid objects to exist;
- validating after state has already changed;
- placing Aggregate business rules outside the Aggregate.

---

# Related Example Libraries

- AggregateExamples
- ValueObjectExamples
- LifecyclePatterns
- MethodPatterns

---

# Version History

| Version | Date | Description |
|----------|------------|-------------|
| 1.0.0 | 2026-07-23 | Initial validation patterns extracted from validated Sprint-001 and Sprint-002 implementations. |