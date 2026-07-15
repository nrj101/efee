# Academic Year Aggregate Technical Specification

```yaml
---
document_id: ATS-ACADEMICYEAR-001
title: Academic Year Aggregate Technical Specification
version: 1.1.0
status: Draft

owner: Product Owner
reviewer: CTO

created: 2026-07-06
last_updated: 2026-07-14

related_documents:
  - ../../spec/docs/SoftwareDomainModel.md
  - ../../spec/docs/BusinessRules.md
  - ../../spec/docs/workflows/FeePolicyManagement.md
  - ../../architecture/aggregates/AcademicYear.md
---
```

---

# Purpose

This document defines the implementation-neutral technical specification for the Academic Year Aggregate.

It refines the approved Software Domain Model and Aggregate Design by defining the complete Aggregate contract required for implementation while remaining independent of programming language, persistence technology and implementation framework.

---

# Aggregate Responsibility

The Academic Year Aggregate owns the operational boundary within which institutional financial activities occur.

It preserves:

- Academic Year identity
- Academic Year code
- Operational period
- Applicable Fee Structure reference
- Academic Year lifecycle

The Academic Year Aggregate intentionally does **not** own:

- Students
- Fee Structures
- Fee Obligations
- Payments
- Receipts
- Discounts

These business truths remain owned by collaborating Aggregates.

---

# Owned State

The Aggregate owns the following state.

| Field | Type | Required | Mutable | Description |
|--------|------|----------|----------|-------------|
| academicYearIdentifier | String | Yes | No | Internal immutable Academic Year identifier |
| academicYearCode | String | Yes | No | Institution-defined Academic Year reference |
| startDate | LocalDate | Yes | No | Beginning of the Academic Year |
| endDate | LocalDate | Yes | No | End of the Academic Year |
| feeStructureIdentifier | String | Yes | Yes | Applicable Fee Structure reference |
| lifecycleState | Academic Year Lifecycle | Yes | Yes | Current Academic Year lifecycle |

---

# Aggregate Does Not Own

The Aggregate SHALL NOT own:

- Fee Structure definition
- Student information
- Fee Obligations
- Payment information
- Receipt information
- Discount information

These business truths remain owned by collaborating Aggregates.

---

# Public API

## Constructor

```
AcademicYear(
    academicYearIdentifier,
    academicYearCode,
    startDate,
    endDate,
    feeStructureIdentifier
)
```

Creates a new Academic Year.

A newly created Academic Year enters the Planned lifecycle state.

---

## Business Operations

```
activate()
```

Transitions the Academic Year into Active.

---

```
close()
```

Transitions the Academic Year into Closed.

Closure shall occur only after all required business activities have been completed according to institutional policy.

---

```
assignFeeStructure(
    feeStructureIdentifier
)
```

Associates the Academic Year with the approved Fee Structure reference.

Ownership of the Fee Structure remains with the Fee Structure Aggregate.

---

## Accessors

```
getAcademicYearIdentifier()

getAcademicYearCode()

getStartDate()

getEndDate()

getFeeStructureIdentifier()

getLifecycleState()
```

No additional public operations are approved by this specification.

---

# Business Invariants

Implementation SHALL preserve the following invariants.

- Academic Year Identifier is immutable.
- Academic Year Code is immutable.
- Operational period is immutable after creation.
- Every Academic Year references at most one approved Fee Structure at a time.
- Closed Academic Years are immutable.
- Aggregate ownership shall always be preserved.

---

# Ownership Boundaries

Only the Academic Year Aggregate may modify:

- Academic Year lifecycle
- Fee Structure association

Collaborating Aggregates SHALL NOT directly modify this Aggregate's owned state.

---

# Lifecycle

The Aggregate supports the following lifecycle.

```
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

---

# Consistency Requirements

Implementation SHALL preserve:

- Academic Year identity integrity
- Operational period integrity
- Fee Structure association integrity
- Lifecycle integrity
- Aggregate ownership

The Academic Year SHALL define the operational boundary for financial activities without assuming ownership of financial information.

---

# Implementation Obligations

| Obligation | Type | Source |
|------------|------|--------|
| Preserve Academic Year identity | State | Software Domain Model |
| Preserve operational period | State | Software Domain Model |
| Preserve Fee Structure reference | State | Software Domain Model |
| Preserve lifecycle | Lifecycle | Aggregate Design |
| Preserve Aggregate ownership | Architecture | Aggregate Design |
| Preserve operational boundary | Business Rule | Business Rules |

---

# Collaboration Contract

The Academic Year Aggregate collaborates with:

- Student
- Fee Structure
- Fee Obligation

Collaborations occur only through Aggregate references.

Ownership of business truth SHALL NOT transfer between Aggregates.

---

# Implementation Constraints

Implementation SHALL:

- validate constructor inputs;
- validate business operation inputs;
- preserve Aggregate ownership;
- preserve lifecycle integrity;
- reject invalid lifecycle transitions.

Implementation SHALL NOT:

- expose public setters;
- expose undocumented public operations;
- modify collaborating Aggregates;
- introduce undocumented Aggregate state.

Implementation technology remains outside the scope of this specification.

---

# Story Traceability

Initially implemented through:

- Sprint-001 / Story-002

Future Stories may extend implementation while preserving this specification.

---

# Related Documents

- SoftwareDomainModel.md
- FeePolicyManagement.md
- BusinessRules.md
- Academic Year Aggregate Design

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-06 | Initial Aggregate Technical Specification. |
| 1.1.0 | 2026-07-14 | Expanded into the standard Aggregate Technical Specification template. Added approved Aggregate state, Public API, Business Invariants, Lifecycle, Ownership Boundaries, Collaboration Contract and Implementation Constraints while preserving existing business responsibilities. |

---

# Approval

**Status:** Draft