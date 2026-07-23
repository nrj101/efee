# Story-006 — Payment Aggregate

```yaml
---
story_id: Story-006
title: Payment Aggregate
version: 1.0.0
status: Approved

sprint: Sprint-002
priority: High

owner: Product Owner

aggregate_root: Payment

created: 2026-07-16
last_updated: 2026-07-16

related_documents:
  - ../Sprint-002.md
  - ../../architecture/AggregateDesign.md
  - ../../architecture/aggregates/Payment.md
  - ../../technical-specification/aggregates/Payment.md
  - ../../technical-design/persistence/Payment.md
  - ../../spec/docs/SoftwareDomainModel.md
  - ../../spec/docs/BusinessRules.md
  - ../../spec/docs/workflows/PaymentManagement.md
---
```

---

# Purpose

Implement the Payment Aggregate defined by the approved Software Architecture.

The implementation establishes ownership of institutional Payment records while preserving Aggregate ownership, lifecycle consistency and financial integrity.

No additional business behaviour shall be introduced.

---

# Business Objective

Introduce the Payment Aggregate responsible for preserving the institutional record of money received by the institution.

The Aggregate owns:

- Payment identity
- Payment information
- Payment lifecycle

The Payment Aggregate preserves the lifecycle of an individual Payment while remaining independent of Fee Obligation settlement and Receipt generation.

---

# Architectural Context

This Story realizes the approved **Payment Aggregate** defined by the Software Architecture.

Aggregate responsibilities, ownership boundaries, lifecycle and collaboration contracts remain authoritatively defined by the Architecture documentation.

This Story SHALL faithfully implement the approved Aggregate without redefining architectural responsibilities.

---

# Architecture Traceability

## Aggregate Root

Payment

## Primary Business Truth

Institutional Payment

## Architecture References

- AggregateDesign.md
- SoftwareArchitecture.md
- Payment Aggregate Technical Specification
- Payment Aggregate Persistence Model

## Product Specification References

- SoftwareDomainModel.md
- BusinessRules.md
- PaymentManagement.md

---

# Supporting Value Objects

Implement the following immutable Supporting Value Object owned exclusively by the Payment Aggregate.

- PaymentLifecycle

The Supporting Value Object SHALL exist only within the owning Aggregate.

Ownership SHALL NOT be transferred to collaborating Aggregates.

---

# Collaborating Aggregates

- Fee Obligation
- Receipt

Collaborations SHALL preserve Aggregate ownership boundaries.

---

# Implementation Scope

This Story implements only:

- Payment Aggregate Root
- PaymentLifecycle Supporting Value Object
- Aggregate unit tests
- Supporting Value Object unit tests
- Story README

The implementation SHALL preserve the approved Aggregate contract defined by the Aggregate Technical Specification.

---

# Story Implementation Decisions

Sprint-wide implementation decisions defined by **Sprint-002.md** continue to apply.

---

## Package

The implementation SHALL preserve the approved Story Package structure.

Production package organization is intentionally outside the scope of this Story.

---

# Approved Aggregate Model

The implementation SHALL realize the Aggregate state approved by the Aggregate Technical Specification.

The implementation SHALL preserve:

- Payment identity
- Payer reference
- Payment amount
- Payment method
- Payment reference
- Payment lifecycle

The implementation SHALL NOT introduce undocumented Aggregate state.

---

# Approved Public Operations

The following public behaviour is approved.

| Operation | Purpose |
|-----------|---------|
| Record Payment | Create a valid Payment Aggregate. |
| Realise Payment | Transition the Aggregate into the Realised lifecycle state. |
| Cancel Payment | Transition the Aggregate into the Cancelled lifecycle state. |

Future Stories may implement additional approved operations defined by the Aggregate Technical Specification while preserving this contract.

---

# Acceptance Criteria

The implementation SHALL:

- preserve approved Aggregate ownership;
- preserve approved Aggregate state;
- preserve approved lifecycle;
- preserve approved Aggregate invariants;
- preserve approved public operations;
- implement the approved Supporting Value Object;
- generate only approved implementation artifacts;
- include unit tests for the Aggregate Root and Supporting Value Object.

Implementation SHALL NOT:

- modify collaborating Aggregates;
- introduce additional Supporting Entities;
- introduce additional Supporting Value Objects;
- introduce repositories;
- introduce persistence;
- introduce REST APIs;
- introduce framework annotations;
- introduce undocumented behaviour.

---

# Implementation Contract

## Write Scope

### Source

```text
/Sprint-002/Story-006/source/Payment.java

/Sprint-002/Story-006/source/PaymentLifecycle.java
```

### Tests

```text
/Sprint-002/Story-006/tests/PaymentTest.java

/Sprint-002/Story-006/tests/PaymentLifecycleTest.java
```

### Documentation

```text
/Sprint-002/Story-006/README.md
```

No additional implementation artifacts are approved.

---

## Output Locations

| Artifact | Output Location |
|----------|-----------------|
| Payment.java | /Sprint-002/Story-006/source/Payment.java |
| PaymentLifecycle.java | /Sprint-002/Story-006/source/PaymentLifecycle.java |
| PaymentTest.java | /Sprint-002/Story-006/tests/PaymentTest.java |
| PaymentLifecycleTest.java | /Sprint-002/Story-006/tests/PaymentLifecycleTest.java |
| README.md | /Sprint-002/Story-006/README.md |

---

# Dependencies

Implementation depends upon:

- Sprint-002.md
- Payment Aggregate Design
- Payment Aggregate Technical Specification
- Payment Aggregate Persistence Model

Implementation SHALL NOT depend upon implementation details of previous Stories.

---

# Out of Scope

This Story intentionally excludes:

- Payment Allocation;
- Fee Obligation settlement;
- Receipt generation;
- persistence;
- REST APIs;
- infrastructure;
- database mapping.

Although the Aggregate Technical Specification defines collaboration with the Fee Obligation and Receipt Aggregates, implementation of those collaborations is intentionally deferred to future Stories.

The implementation produced by this Story SHALL preserve the approved Aggregate contract while remaining extensible for those future operations.

---

# Completion Checklist

Before marking this Story complete, verify:

- Payment responsibilities implemented.
- Aggregate ownership preserved.
- Approved Aggregate state preserved.
- Supporting Value Object implemented.
- Lifecycle preserved.
- Architecture preserved.
- Only approved implementation artifacts modified.
- Unit tests completed.
- No undocumented assumptions introduced.

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-16 | Initial approved implementation Story for the Payment Aggregate. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- CTO

## Approval Date

2026-07-16