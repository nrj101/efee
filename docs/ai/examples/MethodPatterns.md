# Method Patterns

```yaml
---
document_id: AI-REF-007
title: Method Patterns
version: 1.0.0
status: Approved

owner: Product Owner

purpose: Business Method Implementation Patterns
created: 2026-07-23
last_updated: 2026-07-23
---
```

---

# Purpose

This document contains canonical patterns for implementing business methods within the E-Fee platform.

Business methods expose the behaviour of an object while preserving its business invariants.

This document focuses on method implementation only.

For related implementation guidance, see:

- AggregateExamples
- ValidationPatterns
- LifecyclePatterns

---

# Method Responsibilities

Business methods are responsible for:

- expressing business behaviour;
- validating inputs;
- enforcing business rules;
- updating object state;
- preserving business invariants.

Business methods SHALL NOT:

- perform persistence;
- invoke repositories;
- publish events;
- coordinate multiple Aggregates.

---

# Business-Oriented Method Names

Method names should describe business behaviour.

Preferred examples:

```java
recordPayment()

allocate()

approve()

reject()

cancel()

close()

registerFeeObligation()
```

Avoid:

```java
update()

execute()

process()

performAction()

change()
```

Method names should clearly communicate the business operation being performed.

---

# Validate Before State Change

Business methods should validate inputs before modifying state.

Preferred implementation:

```java
public void realise() {

    if (status != PaymentStatus.RECORDED) {
        throw new IllegalStateException(
                "Payment has already been realised.");
    }

    status = PaymentStatus.REALISED;
}
```

---

# Keep Methods Focused

Each business method should perform a single business operation.

Preferred implementation:

```java
applyDiscount()

approve()

cancel()
```

Avoid methods that perform multiple unrelated business operations.

---

# Modify Internal State Only

Business methods should update only the state owned by the current object.

Avoid directly modifying another Aggregate.

Preferred implementation:

```java
this.status = PaymentStatus.REALISED;
```

---

# Preserve Business Invariants

Every business method should leave the object in a valid state.

Business rules should be enforced before any state changes occur.

---

# Return Meaningful Results

Methods should return only information required by the caller.

Examples include:

- completion without return value;
- calculated business values;
- newly created identifiers.

Avoid exposing unnecessary internal state.

---

# Common Mistakes

Avoid:

- generic method names;
- multiple unrelated responsibilities;
- modifying state before validation;
- infrastructure calls;
- persistence logic;
- direct manipulation of another Aggregate.

---

# Related Example Libraries

- AggregateExamples
- LifecyclePatterns
- ValidationPatterns
- CollectionPatterns

---

# Version History

| Version | Date | Description |
|----------|------------|-------------|
| 1.0.0 | 2026-07-23 | Initial business method patterns extracted from validated Sprint-001 and Sprint-002 implementations. |