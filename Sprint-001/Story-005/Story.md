# Story-005 — Fee Obligation Aggregate

```yaml
---
story_id: Story-005
title: Fee Obligation Aggregate
version: 1.2.0
status: Approved

sprint: Sprint-001
priority: High

owner: Product Owner

aggregate_root: FeeObligation

created: 2026-07-13
last_updated: 2026-07-15

related_documents:
  - ../Sprint-001.md
  - ../../architecture/AggregateDesign.md
  - ../../architecture/aggregates/FeeObligation.md
  - ../../technical-specification/aggregates/FeeObligation.md
  - ../../technical-design/persistence/FeeObligation.md
  - ../../spec/docs/SoftwareDomainModel.md
  - ../../spec/docs/BusinessRules.md
  - ../../spec/docs/workflows/FeeObligationManagement.md
  - ../../spec/docs/rfc/RFC-001-Financial-Truth-Model.md
---
```

---

# Purpose

Implement the Fee Obligation Aggregate defined by the approved Software Architecture.

The implementation establishes ownership of a Student's financial responsibility for an Academic Year while preserving Aggregate ownership, financial integrity and lifecycle consistency.

No additional business behaviour shall be introduced.

---

# Business Objective

Introduce the Fee Obligation Aggregate responsible for preserving a Student's financial responsibility for an Academic Year.

The Aggregate owns:

- Fee Obligation identity
- Obligation Lines
- Derived Outstanding Amount
- Aggregate lifecycle

The current financial position is derived from the financial facts preserved within the Aggregate in accordance with **RFC-001 – Financial Truth Model**.

---

# Architectural Context

This Story realizes the approved **Fee Obligation Aggregate** defined by the Software Architecture.

Aggregate responsibilities, ownership boundaries, financial derivation model, lifecycle and collaboration contracts remain authoritatively defined by the Architecture documentation.

This Story SHALL faithfully implement the approved Aggregate without redefining architectural responsibilities.

---

# Architecture Traceability

## Aggregate Root

FeeObligation

## Primary Business Truth

Student Financial Responsibility

## Architecture References

- AggregateDesign.md
- SoftwareArchitecture.md
- Fee Obligation Aggregate Technical Specification
- Fee Obligation Aggregate Persistence Model

## Product Specification References

- SoftwareDomainModel.md
- BusinessRules.md
- FeeObligationManagement.md
- RFC-001 – Financial Truth Model

---

# Supporting Value Objects

Implement the following immutable Supporting Value Object owned exclusively by the Fee Obligation Aggregate.

- ObligationLine

The Supporting Value Object SHALL exist only within the owning Aggregate.

Ownership SHALL NOT be transferred to collaborating Aggregates.

---

# Collaborating Aggregates

- Student
- Academic Year
- Fee Structure
- Discount
- Payment

Collaborations SHALL preserve Aggregate ownership boundaries.

---

# Implementation Scope

This Story implements only:

- Fee Obligation Aggregate Root
- ObligationLine Supporting Value Object
- Aggregate unit tests
- Supporting Value Object unit tests
- Story README

The implementation SHALL preserve the approved Aggregate contract defined by the Aggregate Technical Specification.

---

# Story Implementation Decisions

Sprint-wide implementation decisions defined by **Sprint-001.md** continue to apply.

---

## Package

The implementation SHALL preserve the approved Story Package structure.

Production package organization is intentionally outside the scope of this Story.

---

# Approved Aggregate Model

The implementation SHALL realize the Aggregate state approved by the Aggregate Technical Specification.

The implementation SHALL preserve:

- Fee Obligation identity
- Student reference
- Academic Year reference
- Fee Structure reference
- Obligation Line collection
- Derived Outstanding Amount
- Aggregate lifecycle

Outstanding Amount SHALL remain derived from the Aggregate's owned financial facts.

The implementation SHALL NOT introduce undocumented Aggregate state.

---

# Approved Public Operations

The following public behaviour is approved.

| Operation | Purpose |
|-----------|---------|
| Create Fee Obligation | Create a valid Fee Obligation Aggregate. |
| Update Obligation Lines | Update approved owned financial facts. |
| Retire Fee Obligation | Transition the Aggregate into the Retired lifecycle state. |

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
- preserve Outstanding Amount consistency;
- derive Outstanding Amount from owned financial facts;
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
/Sprint-001/Story-005/source/FeeObligation.java

/Sprint-001/Story-005/source/FeeObligationLifecycle.java

/Sprint-001/Story-005/source/ObligationLine.java
```

### Tests

```text
/Sprint-001/Story-005/tests/FeeObligationTest.java

/Sprint-001/Story-005/tests/FeeObligationLifecycleTest.java

/Sprint-001/Story-005/tests/ObligationLineTest.java
```

### Documentation

```text
/Sprint-001/Story-005/README.md
```

No additional implementation artifacts are approved.

---

## Output Locations

| Artifact | Output Location |
|----------|-----------------|
| FeeObligation.java | /Sprint-001/Story-005/source/FeeObligation.java |
| FeeObligationLifecycle.java | /Sprint-001/Story-005/source/FeeObligationLifecycle.java |
| ObligationLine.java | /Sprint-001/Story-005/source/ObligationLine.java |
| FeeObligationTest.java | /Sprint-001/Story-005/tests/FeeObligationTest.java |
| FeeObligationLifecycleTest.java | /Sprint-001/Story-005/tests/FeeObligationLifecycleTest.java |
| ObligationLineTest.java | /Sprint-001/Story-005/tests/ObligationLineTest.java |
| README.md | /Sprint-001/Story-005/README.md |

---

# Dependencies

Implementation depends upon:

- Sprint-001.md
- Fee Obligation Aggregate Design
- Fee Obligation Aggregate Technical Specification
- Fee Obligation Aggregate Persistence Model
- RFC-001 – Financial Truth Model

Implementation SHALL NOT depend upon implementation details of previous Stories.

---

# Out of Scope

This Story intentionally excludes:

- application of Discounts;
- recording Payment Allocations;
- Receipt generation;
- persistence;
- REST APIs;
- infrastructure;
- database mapping.

Although the Aggregate Technical Specification defines `applyDiscount()` and `allocatePayment()` as approved Aggregate operations, implementation of those operations is intentionally deferred to future Stories.

The implementation produced by this Story SHALL preserve the approved Aggregate contract while remaining extensible for those future operations.

---

# Completion Checklist

Before marking this Story complete, verify:

- Fee Obligation responsibilities implemented.
- Aggregate ownership preserved.
- Approved Aggregate state preserved.
- Supporting Value Object implemented.
- Outstanding Amount derived from Aggregate financial facts.
- Lifecycle preserved.
- Architecture preserved.
- Only approved implementation artifacts modified.
- Unit tests completed.
- No undocumented assumptions introduced.