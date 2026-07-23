# Lifecycle Patterns

```yaml
---
document_id: AI-REF-004
title: Lifecycle Patterns
version: 1.0.0
status: Approved

owner: Product Owner

purpose: Aggregate Lifecycle Patterns
created: 2026-07-23
last_updated: 2026-07-23
---
```

---

# Purpose

This document contains canonical patterns for modelling Aggregate lifecycles within the E-Fee platform.

Lifecycle patterns define how an Aggregate transitions between valid business states while preserving business invariants.

This document focuses on lifecycle management only.

For related implementation guidance, see:

- AggregateExamples
- ValidationPatterns

---

# Lifecycle Responsibilities

An Aggregate is responsible for:

- maintaining its current lifecycle state;
- enforcing valid state transitions;
- rejecting invalid operations;
- preventing inconsistent business states.

Lifecycle rules SHALL remain inside the Aggregate.

---

# Canonical Lifecycle State

```java
private PaymentStatus status;
```

The lifecycle state represents the current business status of the Aggregate.

---

# Lifecycle Transition

Business operations change lifecycle state only after all business rules have been satisfied.

Preferred implementation:

```java
public void realise() {

    if (status != PaymentStatus.RECORDED) {
        throw new IllegalStateException(
                "Payment has already been finalised.");
    }

    status = PaymentStatus.REALISED;
}
```

---

# Validate Before Transition

Business rules should be evaluated before changing lifecycle state.

Preferred implementation:

```java
if (!discount.canBeApproved()) {
    throw new IllegalStateException(
            "Discount cannot be approved.");
}

status = DiscountStatus.APPROVED;
```

State transitions should occur only after successful validation.

---

# Lifecycle Methods Should Express Business Meaning

Lifecycle methods should use business terminology.

Preferred examples:

```java
record()

realise()

approve()

reject()

cancel()

close()
```

Avoid generic names such as:

```java
update()

changeStatus()

setStatus()

process()
```

---

# Invalid Transitions

An Aggregate should reject invalid lifecycle transitions immediately.

Example:

```java
if (status == PaymentStatus.REALISED) {
    throw new IllegalStateException(
            "Payment has already been realised.");
}
```

Invalid transitions should never leave the Aggregate in a partially updated state.

---

# Lifecycle State Is Aggregate-Owned

Lifecycle state should never be modified directly by external callers.

Avoid:

```java
payment.setStatus(
        PaymentStatus.REALISED);
```

Lifecycle changes should always occur through business operations.

---

# Common Mistakes

Avoid:

- public lifecycle setters;
- changing status without validation;
- lifecycle changes outside the Aggregate;
- skipping intermediate business states;
- bypassing business operations.

---

# Related Example Libraries

- AggregateExamples
- ValidationPatterns
- MethodPatterns
- UnitTestExamples

---

# Version History

| Version | Date | Description |
|----------|------------|-------------|
| 1.0.0 | 2026-07-23 | Initial lifecycle patterns extracted from validated Sprint-001 and Sprint-002 implementations. |