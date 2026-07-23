# Academic Year Aggregate Technical Specification

```yaml
---
document_id: ATS-ACADEMICYEAR-001
title: Academic Year Aggregate Technical Specification
version: 1.2.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-07-06
last_updated: 2026-07-17

related_documents:
  - ../../spec/docs/SoftwareDomainModel.md
  - ../../spec/docs/BusinessRules.md
  - ../../spec/docs/workflows/FeePolicyManagement.md
  - ../../architecture/aggregates/AcademicYear.md
---
```

---

# Purpose

This document defines the authoritative implementation contract for the Academic Year Aggregate.

It refines the approved Software Domain Model and Software Architecture by defining the complete Aggregate contract required for implementation while remaining independent of programming language, persistence technology, implementation framework and infrastructure.

The Academic Year Aggregate Technical Specification defines:

- Aggregate responsibilities;
- owned, referenced and derived state;
- lifecycle behaviour;
- business invariants;
- public operations;
- approved supporting types; and
- persistence traceability.

It specifies **what** the Academic Year Aggregate must do without prescribing **how** it is implemented.

---

# Responsibilities

The Academic Year Aggregate owns the operational boundary within which institutional financial activities occur.

It is responsible for:

- preserving Academic Year identity;
- maintaining the Academic Year code;
- preserving the operational period;
- maintaining the applicable Fee Structure reference; and
- managing the Academic Year lifecycle.

The Academic Year Aggregate intentionally does **not** own:

- Students;
- Fee Structures;
- Fee Obligations;
- Payments;
- Receipts; or
- Discounts.

These business truths remain owned by collaborating Aggregates.

---

# Owned State

The Academic Year Aggregate owns the following business state.

| State | Type | Required | Mutable | Description |
|--------|------|----------|----------|-------------|
| academicYearIdentifier | String | Yes | No | Immutable Academic Year identifier |
| academicYearCode | String | Yes | No | Institution-defined Academic Year reference |
| startDate | LocalDate | Yes | No | Beginning of the Academic Year |
| endDate | LocalDate | Yes | No | End of the Academic Year |
| feeStructureIdentifier | String | Yes | Yes | Associated Fee Structure reference |
| lifecycleState | Academic Year Lifecycle | Yes | Yes | Current Academic Year lifecycle |

No additional owned business state is approved.

---

# Referenced State

The Academic Year Aggregate references externally owned business information but does not own it.

The Aggregate may reference:

| Aggregate | Business Purpose |
|-----------|------------------|
| Fee Structure | Associate the applicable Fee Structure |
| Student | Establish the operational academic context |
| Fee Obligation | Define the operational boundary for fee obligations |

Referenced business information SHALL remain externally owned.

The Academic Year Aggregate SHALL NOT modify referenced Aggregate state.

---

# Derived State

The Academic Year Aggregate does not own any derived business state.

Operational reporting, financial summaries and institutional metrics are intentionally derived outside this Aggregate.

No additional derived business state is approved.

---

# Lifecycle

The Academic Year Aggregate supports the following lifecycle.

```text
Planned
     │
     ▼
Active
     │
     ▼
Closed
```

Lifecycle transitions are irreversible.

Closed Academic Years remain permanently preserved.

Only one lifecycle state may exist at any point in time.

---

# Business Invariants

The implementation SHALL preserve the following Business Invariants.

- Academic Year Identifier is immutable.
- Academic Year Code is immutable.
- Operational period is immutable after creation.
- Every Academic Year references at most one approved Fee Structure at any point in time.
- Closed Academic Years are immutable.
- Only the Academic Year Aggregate may modify its owned state.
- Aggregate ownership boundaries shall always be preserved.

These invariants SHALL remain true throughout every permitted lifecycle transition and business operation.

---

# Approved Implementation Types

The following domain types participate in the approved Aggregate contract.

- Academic Year Identifier
- Academic Year Lifecycle

No additional publicly observable domain types are approved by this specification.

---

# Public API

The Public API defines the complete externally observable behaviour of the Academic Year Aggregate.

Every public operation SHALL preserve all documented Business Invariants.

---

## Constructor

```text
AcademicYear(
    academicYearIdentifier,
    academicYearCode,
    startDate,
    endDate,
    feeStructureIdentifier
)
```

Creates a valid Academic Year.

The constructor SHALL:

- establish a valid Academic Year identity;
- establish the operational period;
- associate the initial Fee Structure reference;
- establish the Planned lifecycle state; and
- preserve all documented Business Invariants.

---

## Business Operations

### activate()

Transitions the Academic Year to the Active lifecycle state.

Preconditions:

- Academic Year is currently Planned.

Postconditions:

- Academic Year lifecycle becomes Active.
- Business Invariants remain preserved.

---

### close()

Transitions the Academic Year to the Closed lifecycle state.

Preconditions:

- Academic Year is currently Active.
- Institutional closure requirements have been satisfied.

Postconditions:

- Academic Year lifecycle becomes Closed.
- Academic Year becomes immutable.
- Business Invariants remain preserved.

---

### assignFeeStructure(
    feeStructureIdentifier
)

Associates the Academic Year with the approved Fee Structure reference.

Preconditions:

- Referenced Fee Structure is valid.
- Academic Year is not Closed.

Postconditions:

- Fee Structure reference is updated.
- Ownership of the Fee Structure remains external.
- Business Invariants remain preserved.

---

## Accessors

```text
getAcademicYearIdentifier()

getAcademicYearCode()

getStartDate()

getEndDate()

getFeeStructureIdentifier()

getLifecycleState()
```

Accessors expose approved Academic Year information only.

Accessors SHALL NOT modify Aggregate state.

No additional public operations are approved by this specification.


---

# Supporting Types

The following Supporting Types participate in the approved Aggregate contract.

## Academic Year Identifier

Defines the immutable business identity of an Academic Year.

Responsibilities:

- uniquely identify an Academic Year;
- remain immutable throughout the Academic Year lifecycle.

Business Invariants:

- Identifier shall never change.
- Identifier shall uniquely identify exactly one Academic Year.

---

## Academic Year Lifecycle

Defines the approved lifecycle states of an Academic Year.

Responsibilities:

- represent the current operational state;
- govern permitted lifecycle transitions.

Business Invariants:

- Only one lifecycle state may exist at any point in time.
- Lifecycle transitions shall follow the approved lifecycle.
- Closed Academic Years are immutable.

---

# Persistence Traceability

The following business concepts are represented by the Academic Year Aggregate.

| Business Concept | Classification |
|------------------|----------------|
| Academic Year | Aggregate Root |
| Academic Year Identifier | Owned State |
| Academic Year Code | Owned State |
| Operational Period | Owned State |
| Fee Structure Reference | Owned State |
| Academic Year Lifecycle | Owned State |

The Academic Year Aggregate does not persist:

- Students;
- Fee Structures;
- Fee Obligations;
- Payments;
- Receipts; or
- Discounts.

Persistent representation SHALL remain consistent with this Aggregate Technical Specification and the Aggregate Persistence Model.

---

# Consistency Requirements

Implementation SHALL preserve:

- Academic Year identity integrity;
- operational period integrity;
- Fee Structure association integrity;
- lifecycle integrity;
- Aggregate ownership boundaries; and
- all documented Business Invariants.

The Academic Year Aggregate SHALL define the operational boundary for institutional financial activities without assuming ownership of financial information.

---

# Collaboration Contract

The Academic Year Aggregate collaborates with the following Aggregates.

| Aggregate | Collaboration Purpose |
|-----------|-----------------------|
| Student | Establish operational academic context |
| Fee Structure | Associate the applicable Fee Structure |
| Fee Obligation | Define the operational boundary for fee obligations |

Collaborations SHALL occur exclusively through approved Aggregate references.

Ownership of business truth SHALL NOT transfer between collaborating Aggregates.

---

# Implementation Constraints

Implementation SHALL:

- validate constructor inputs;
- validate business operation inputs;
- preserve Aggregate ownership;
- preserve lifecycle integrity;
- reject invalid lifecycle transitions; and
- preserve all documented Business Invariants.

Implementation SHALL NOT:

- expose public setters;
- expose undocumented public operations;
- modify collaborating Aggregates;
- introduce undocumented Aggregate state; or
- violate Aggregate ownership boundaries.

Implementation technology remains outside the scope of this specification.

---

# Story Traceability

Initially implemented through:

- Sprint-001 / Story-002

Future Stories MAY extend implementation while preserving this Aggregate Technical Specification.

---

# Related Documents

- SoftwareDomainModel.md
- BusinessRules.md
- FeePolicyManagement.md
- Academic Year Aggregate Design

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-06 | Initial Aggregate Technical Specification. |
| 1.1.0 | 2026-07-14 | Expanded into the standard Aggregate Technical Specification template. Added approved Aggregate state, Public API, Business Invariants, Lifecycle, Ownership Boundaries, Collaboration Contract and Implementation Constraints while preserving existing business responsibilities. |
| 1.2.0 | 2026-07-17 | Aligned with TECH-STD-001 v1.2.0. Adopted the standardized Aggregate Technical Specification structure, introduced Referenced State, Derived State, Approved Implementation Types, Supporting Types and Persistence Traceability sections, and aligned the Public API with the standardized contract format without changing approved business behaviour. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- CTO

## Approval Date

2026-07-17