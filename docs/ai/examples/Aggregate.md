# Aggregate Examples

```yaml
---
document_id: AI-REF-001
title: Aggregate Examples
version: 1.0.0
status: Approved

owner: Product Owner

purpose: Aggregate Implementation Patterns
created: 2026-07-23
last_updated: 2026-07-23
---
```

---

# Purpose

This document contains canonical examples for implementing Aggregates within the E-Fee platform.

The examples in this document are derived from validated implementations completed during the project and represent the preferred Aggregate implementation style.

This document focuses on Aggregate responsibilities only.

For related implementation guidance, see:

- ValidationPatterns
- ConstructorPatterns
- CollectionPatterns
- LifecyclePatterns

---

# Aggregate Responsibilities

An Aggregate is responsible for:

- owning business state;
- protecting business invariants;
- enforcing lifecycle rules;
- exposing business behaviour;
- maintaining consistency of its internal state.

An Aggregate SHALL NOT:

- perform persistence;
- coordinate multiple Aggregates;
- perform infrastructure operations;
- expose mutable internal state;
- depend on framework annotations.

---

# Canonical Aggregate Structure

```java
public final class Student {

    private final StudentId studentId;

    private StudentNumber studentNumber;

    private StudentName studentName;

    private StudentStatus status;

    private final List<FeeObligationId> feeObligations =
            new ArrayList<>();

}
```

---

# What This Demonstrates

- immutable identity;
- explicit business state;
- Aggregate-owned collections;
- minimal internal representation;
- no infrastructure concerns.

---

# Business Operations Belong Inside the Aggregate

Business behaviour should be implemented by the Aggregate that owns the business state.

Preferred implementation:

```java
public void registerFeeObligation(
        FeeObligationId obligationId) {

    Objects.requireNonNull(obligationId);

    feeObligations.add(obligationId);
}
```

Another example:

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

# What This Demonstrates

- Aggregate owns behaviour;
- business operations modify Aggregate state;
- lifecycle changes remain internal;
- callers cannot bypass business rules.

---

# Aggregate Identity

Aggregate identity should be:

- immutable;
- created during construction;
- independent of business attributes.

Preferred implementation:

```java
private final PaymentId paymentId;
```

Identity should never be modified after construction.

---

# Aggregate Relationships

Aggregates should reference other Aggregates using identifiers rather than direct object references.

Preferred implementation:

```java
private final List<FeeObligationId> feeObligations;
```

Avoid:

```java
private final List<FeeObligation> feeObligations;
```

Identifier-based relationships reduce coupling and preserve Aggregate boundaries.

---

# Aggregate Size

Aggregates should contain only the state required to enforce their business invariants.

Avoid storing unrelated information simply because it is frequently accessed.

If data belongs to another Aggregate, reference it by identifier.

---

# Aggregate Behaviour

Business behaviour should:

- be expressed using business terminology;
- modify Aggregate state;
- preserve business invariants;
- reject invalid operations immediately.

Examples:

```java
recordPayment()

allocate()

applyDiscount()

realise()

cancel()
```

Avoid generic method names such as:

```java
update()

process()

execute()

performAction()
```

Business methods should clearly express the business capability being provided.

---

# Aggregate Encapsulation

Aggregate internals should remain private.

External callers should interact only through the Aggregate's public business interface.

Avoid exposing mutable fields or allowing external code to modify Aggregate state directly.

---

# Common Mistakes

Avoid:

- public mutable fields;
- setters for business state;
- exposing mutable collections;
- infrastructure dependencies;
- persistence logic;
- orchestration logic;
- business rules implemented outside the Aggregate.

---

# Related Example Libraries

- ValidationPatterns
- ConstructorPatterns
- CollectionPatterns
- LifecyclePatterns
- UnitTestExamples
- ArchitectureResponsibilities

---

# Version History

| Version | Date | Description |
|----------|------------|-------------|
| 1.0.0 | 2026-07-23 | Initial Aggregate implementation examples extracted from validated Sprint-001 and Sprint-002 implementations. |