# Collection Patterns

```yaml
---
document_id: AI-REF-008
title: Collection Patterns
version: 1.0.0
status: Approved

owner: Product Owner

purpose: Collection Ownership and Encapsulation Patterns
created: 2026-07-23
last_updated: 2026-07-23
---
```

---

# Purpose

This document contains canonical patterns for implementing collections within the E-Fee platform.

Collections represent Aggregate-owned state and should be managed exclusively through the Aggregate's business behaviour.

This document focuses on collection ownership and encapsulation only.

For related implementation guidance, see:

- AggregateExamples
- MethodPatterns
- ValidationPatterns

---

# Collection Responsibilities

Collections are responsible for:

- maintaining Aggregate-owned relationships;
- preserving business invariants;
- preventing uncontrolled modification;
- exposing business behaviour instead of implementation details.

Collections SHALL NOT be modified directly by external callers.

---

# Aggregate Owns Its Collections

Collections should be owned by the Aggregate that is responsible for the associated business state.

Preferred implementation:

```java
private final List<FeeObligationId> feeObligations =
        new ArrayList<>();
```

The Aggregate is responsible for controlling all modifications to the collection.

---

# Modify Collections Through Business Methods

Collection changes should occur through explicit business operations.

Preferred implementation:

```java
public void registerFeeObligation(
        FeeObligationId obligationId) {

    Objects.requireNonNull(obligationId);

    feeObligations.add(obligationId);
}
```

Business behaviour should determine when items are added, removed, or updated.

---

# Protect Internal Collections

Internal collections should not be exposed directly.

Preferred implementation:

```java
public List<FeeObligationId> feeObligations() {

    return List.copyOf(feeObligations);
}
```

Avoid:

```java
public List<FeeObligationId> getFeeObligations() {

    return feeObligations;
}
```

External callers should not be able to modify Aggregate state.

---

# Initialize Collections During Construction

Collections should always be initialized when the object is created.

Preferred implementation:

```java
private final List<PaymentAllocation> allocations =
        new ArrayList<>();
```

Avoid lazy initialization unless there is a clear architectural reason.

---

# Store Aggregate References by Identifier

Collections should reference other Aggregates using identifiers.

Preferred implementation:

```java
private final List<StudentId> students;
```

Avoid:

```java
private final List<Student> students;
```

Identifier-based relationships preserve Aggregate boundaries and reduce coupling.

---

# Common Mistakes

Avoid:

- exposing mutable collections;
- public collection fields;
- allowing external modification;
- storing Aggregate object references;
- bypassing business methods when updating collections.

---

# Related Example Libraries

- AggregateExamples
- MethodPatterns
- ValidationPatterns
- LifecyclePatterns

---

# Version History

| Version | Date | Description |
|----------|------------|-------------|
| 1.0.0 | 2026-07-23 | Initial collection patterns extracted from validated Sprint-001 and Sprint-002 implementations. |