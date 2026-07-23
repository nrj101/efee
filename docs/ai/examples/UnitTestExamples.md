# Unit Test Examples

```yaml
---
document_id: AI-REF-011
title: Unit Test Examples
version: 1.0.0
status: Approved

owner: Product Owner

purpose: Unit Test Implementation Patterns
created: 2026-07-23
last_updated: 2026-07-23
---
```

---

# Purpose

This document contains canonical examples for implementing unit tests within the E-Fee platform.

Unit tests verify the behaviour of individual business objects in isolation and ensure that business rules continue to be enforced as the implementation evolves.

This document focuses on unit testing patterns only.

For related implementation guidance, see:

- AggregateExamples
- ValidationPatterns
- LifecyclePatterns

---

# Unit Test Responsibilities

Unit tests are responsible for:

- verifying business behaviour;
- validating business rules;
- confirming state transitions;
- protecting against regressions.

Unit tests SHOULD execute without infrastructure dependencies.

---

# Test Business Behaviour

Tests should verify business operations rather than implementation details.

Preferred implementation:

```java
@Test
void shouldRealiseRecordedPayment() {

    Payment payment = createRecordedPayment();

    payment.realise();

    assertEquals(
            PaymentStatus.REALISED,
            payment.status());
}
```

---

# Test Business Rules

Business rules should be verified using both valid and invalid scenarios.

Preferred implementation:

```java
@Test
void shouldRejectRealisingAlreadyRealisedPayment() {

    Payment payment = createRealisedPayment();

    assertThrows(
            IllegalStateException.class,
            payment::realise);
}
```

---

# Verify State Changes

Business operations should produce the expected state changes.

Example assertions include:

- lifecycle status;
- outstanding amount;
- allocated amount;
- collection contents.

---

# Keep Tests Independent

Each unit test should:

- create its own test data;
- execute independently;
- avoid relying on execution order.

Tests should not share mutable state.

---

# Use Business Terminology

Test names should describe business behaviour.

Preferred examples:

```text
shouldRecordPayment()

shouldAllocatePayment()

shouldRejectDuplicateAllocation()

shouldApproveDiscount()
```

Avoid generic names such as:

```text
test1()

validate()

paymentTest()

process()
```

---

# Focus on Observable Behaviour

Tests should verify externally observable behaviour.

Avoid testing:

- private methods;
- internal implementation details;
- field assignment sequences.

Tests should remain stable as implementations evolve.

---

# Common Mistakes

Avoid:

- testing implementation details;
- shared mutable test data;
- infrastructure dependencies;
- multiple business scenarios in a single test;
- unclear test names.

---

# Related Example Libraries

- AggregateExamples
- ValidationPatterns
- LifecyclePatterns
- MethodPatterns

---

# Version History

| Version | Date | Description |
|----------|------------|-------------|
| 1.0.0 | 2026-07-23 | Initial unit test examples extracted from validated Sprint-001 and Sprint-002 implementations. |