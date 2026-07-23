# Supporting Type Examples

```yaml
---
document_id: AI-REF-003
title: Supporting Type Examples
version: 1.0.0
status: Approved

owner: Product Owner

purpose: Supporting Type Implementation Patterns
created: 2026-07-23
last_updated: 2026-07-23
---
```

---

# Purpose

This document contains canonical examples for implementing Supporting Types within the E-Fee platform.

Supporting Types encapsulate structured information exchanged between architectural layers while remaining independent of business ownership.

This document focuses on Supporting Type responsibilities only.

For related implementation guidance, see:

- ValueObjectExamples
- ApplicationServiceExamples

---

# Supporting Type Responsibilities

A Supporting Type is responsible for:

- grouping related information;
- simplifying method signatures;
- communicating between architectural layers;
- representing structured requests or responses.

A Supporting Type SHALL NOT:

- own business state;
- enforce business workflows;
- maintain lifecycle state;
- contain persistence logic;
- coordinate Aggregates.

---

# Canonical Supporting Type Structure

```java
public final class PaymentAllocationRequest {

    private final FeeObligationId feeObligationId;

    private final Money allocationAmount;

    public PaymentAllocationRequest(
            FeeObligationId feeObligationId,
            Money allocationAmount) {

        this.feeObligationId =
                Objects.requireNonNull(feeObligationId);

        this.allocationAmount =
                Objects.requireNonNull(allocationAmount);
    }

    public FeeObligationId getFeeObligationId() {
        return feeObligationId;
    }

    public Money getAllocationAmount() {
        return allocationAmount;
    }

}
```

---

# What This Demonstrates

- immutable structure;
- constructor validation;
- grouped business information;
- no business ownership;
- simple data carrier.

---

# Supporting Types Group Related Information

Supporting Types improve readability by grouping logically related values into a single object.

Preferred implementation:

```java
PaymentAllocationRequest
```

Instead of:

```java
allocate(
    FeeObligationId obligationId,
    Money allocationAmount)
```

Supporting Types become increasingly valuable as the number of related parameters grows.

---

# Supporting Types Are Immutable

Supporting Types should be immutable after construction.

Preferred implementation:

```java
private final Money allocationAmount;
```

Avoid:

```java
private Money allocationAmount;

public void setAllocationAmount(Money amount) {
    ...
}
```

---

# Supporting Types Do Not Own Business Behaviour

Supporting Types exist to carry information.

Business decisions remain inside Aggregates or Application Services.

Avoid implementations such as:

```java
request.validate();

request.allocate();

request.process();
```

Supporting Types should not become miniature business objects.

---

# Common Examples

Typical Supporting Types within E-Fee include:

- PaymentAllocationRequest
- PaymentRecordRequest
- StudentReference
- FeeStructureReference

---

# Common Mistakes

Avoid:

- mutable fields;
- setters;
- lifecycle state;
- business workflows;
- persistence behaviour;
- Aggregate ownership.

---

# Related Example Libraries

- ValueObjectExamples
- AggregateExamples
- ApplicationServiceExamples
- ValidationPatterns

---

# Version History

| Version | Date | Description |
|----------|------------|-------------|
| 1.0.0 | 2026-07-23 | Initial Supporting Type implementation examples extracted from validated Sprint-002 implementations. |