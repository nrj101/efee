# Story-003 — Fee Structure Aggregate

```yaml
---
story_id: Story-003
title: Fee Structure Aggregate
version: 1.1.0
status: Approved

sprint: Sprint-001
priority: High

owner: Product Owner

aggregate_root: FeeStructure
---
```

---

# Business Objective

Introduce the Fee Structure Aggregate into the implementation of the Student Fee Receivables Platform.

The Fee Structure Aggregate establishes the software ownership boundary responsible for maintaining institutional charging policies while preserving the approved business invariants defined by the Software Architecture.

---

# Architectural Context

This Story realizes the approved **Fee Structure Aggregate** defined by the Software Architecture.

Aggregate responsibilities, ownership, supporting entities, invariants, lifecycle and collaboration boundaries remain authoritatively defined by the Architecture documentation.

This Story SHALL faithfully implement the approved Aggregate without redefining architectural responsibilities.

---

# Architecture Traceability

## Aggregate Root

FeeStructure

## Primary Business Truth

Institutional Charging Policy

## Architecture References

- AggregateDesign.md
- SoftwareArchitecture.md
- Fee Structure Aggregate Design

## Product Specification References

- SoftwareDomainModel.md
- BusinessRules.md
- FeePolicyManagement.md

## Technical Design References

- Fee Structure Aggregate Technical Specification
- Fee Structure Aggregate Persistence Model

---

# Implementation Scope

This Story implements the approved behaviour of the Fee Structure Aggregate.

### Included

- Create Fee Structure
- Update Fee Structure
- Add Fee Component
- Retire Fee Structure

### Excluded

- Student management
- Academic Year management
- Discount management
- Fee Obligation management
- Payment processing
- Receipt generation
- Persistence
- REST APIs

---

# Approved Aggregate Model

The Aggregate SHALL implement the approved Aggregate state defined by the Aggregate Technical Specification and Persistence Model.

The Developer SHALL:

- implement every approved Aggregate field;
- preserve approved field names;
- preserve approved field types;
- preserve approved field mutability;
- preserve Supporting Entity ownership.

The Developer SHALL NOT:

- introduce additional Aggregate state;
- rename approved fields;
- change approved field types;
- expose mutable Aggregate internals.

If additional Aggregate state appears necessary, STOP and request clarification.

---

# Supporting Entity Contract

FeeComponent is a Supporting Entity owned exclusively by the FeeStructure Aggregate.

Supporting Entities SHALL NOT be shared across Aggregates.

Only the Aggregate Root may manage the lifecycle and composition of its Supporting Entities.

---

# Approved Aggregate Operations

The following Aggregate operations are approved.

| Operation | Purpose |
|-----------|---------|
| Create Fee Structure | Create a new Fee Structure. |
| Update Fee Structure | Update approved Fee Structure information. |
| Add Fee Component | Add a new Fee Component to the Fee Structure. |
| Retire Fee Structure | Retire the Fee Structure while preserving historical integrity. |

No additional public Aggregate operations shall be introduced.

---

# Acceptance Criteria

The implementation SHALL:

- preserve Fee Structure identity;
- preserve institutional charging policy;
- preserve Fee Component ownership;
- preserve Aggregate lifecycle;
- preserve approved Aggregate state;
- implement only the approved Aggregate operations;
- remain faithful to the approved Software Architecture.

The implementation SHALL NOT:

- expose mutable internal collections;
- expose mutable Aggregate state;
- introduce undocumented behaviour.

---

# Story Dependencies

## Requires

- Story-001 — Student Aggregate
- Story-002 — Academic Year Aggregate

## Enables

- Story-004 — Discount Aggregate
- Story-005 — Fee Obligation Aggregate

---

# Implementation Contract

## Write Scope

### Aggregate Root and Supporting Entity

#### Source

- /Sprint-001/Story-003/source/FeeStructure.java
- /Sprint-001/Story-003/source/FeeComponent.java

#### Tests

- /Sprint-001/Story-003/tests/FeeStructureTest.java
- /Sprint-001/Story-003/tests/FeeComponentTest.java

#### Documentation

- /Sprint-001/Story-003/README.md

The Story README shall document only the behaviour implemented by this Story.

It SHALL NOT claim implementation of business rules or invariants that are defined in the specifications but intentionally deferred to future Stories.

---

## Output Locations

| Artifact | Output Location |
|----------|-----------------|
| FeeStructure.java | /Sprint-001/Story-003/source/FeeStructure.java |
| FeeComponent.java | /Sprint-001/Story-003/source/FeeComponent.java |
| FeeStructureTest.java | /Sprint-001/Story-003/tests/FeeStructureTest.java |
| FeeComponentTest.java | /Sprint-001/Story-003/tests/FeeComponentTest.java |
| README.md | /Sprint-001/Story-003/README.md |

The Developer SHALL:

- create or modify artifacts only at the approved Output Locations;
- preserve the approved Story Package structure;
- avoid introducing additional folders;
- avoid inferring repository layouts beyond this Story.

---

# Completion Checklist

Before marking this Story complete, verify:

- Fee Structure responsibilities implemented.
- Approved Aggregate state preserved.
- Supporting Entity ownership preserved.
- Aggregate invariants preserved.
- Aggregate ownership preserved.
- Business Rules preserved.
- Software Architecture preserved.
- Only approved implementation artifacts modified.
- Unit tests completed.
- No undocumented assumptions introduced.

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-06 | Initial Story Package. |
| 1.1.0 | 2026-07-15 | Reconciled with Fee Structure ATS v3.1.0. Updated Aggregate operations, clarified Supporting Entity ownership, aligned terminology with Aggregate Design and strengthened the implementation contract regarding encapsulation and Aggregate boundaries. |