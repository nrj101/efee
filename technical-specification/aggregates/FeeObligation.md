# Fee Obligation Aggregate Technical Specification

```yaml
---
document_id: ATS-FEEOBLIGATION-001
title: Fee Obligation Aggregate Technical Specification
version: 1.1.0
status: Draft

owner: Product Owner
reviewer: CTO

created: 2026-07-06
last_updated: 2026-07-13

related_documents:
  - ../../spec/docs/SoftwareDomainModel.md
  - ../../spec/docs/BusinessRules.md
  - ../../spec/docs/workflows/FeeObligationManagement.md
  - ../../architecture/aggregates/FeeObligation.md
---
```

---

# Purpose

This document defines the implementation-neutral technical specification for the Fee Obligation Aggregate.

It refines the approved Software Domain Model and Aggregate Design by defining the technical obligations required to preserve a Student's financial responsibility.

This specification SHALL define the complete Aggregate contract required for implementation while remaining independent of programming language, persistence technology and framework.

---

# Aggregate Responsibility

The Fee Obligation Aggregate owns the financial responsibility of a Student.

It preserves:

- Student reference
- Academic Year reference
- Fee Structure reference
- Obligation Line collection
- Outstanding Amount
- lifecycle state

The Fee Obligation Aggregate is the single owner of the Student's financial responsibility.

---

# Owned State

The Aggregate owns the following state.

| Field | Type | Required | Mutable | Description |
|--------|------|----------|----------|-------------|
| feeObligationIdentifier | String | Yes | No | Unique Fee Obligation identifier |
| studentIdentifier | String | Yes | No | Owning Student reference |
| academicYearIdentifier | String | Yes | No | Governing Academic Year |
| feeStructureIdentifier | String | Yes | No | Governing Fee Structure |
| obligationLines | List<ObligationLine> | Yes | Yes | Collection of obligation lines |
| outstandingAmount | Monetary Amount | Yes | Yes | Remaining financial responsibility |
| active | Boolean | Yes | Yes | Aggregate lifecycle |

---

# Aggregate Does Not Own

The Aggregate SHALL NOT own:

- Student identity
- Academic Year definition
- Fee Structure policy
- Payments
- Receipts
- Discount policy

These business truths remain owned by collaborating Aggregates.

---

# Public API

## Constructor

```
FeeObligation(
    feeObligationIdentifier,
    studentIdentifier,
    academicYearIdentifier,
    feeStructureIdentifier,
    obligationLines,
    outstandingAmount
)
```

The constructor SHALL create an Active Fee Obligation.

---

## Business Operations

The Aggregate exposes only the following business operations.

```
update(
    obligationLines,
    outstandingAmount
)
```

Updates the owned financial state while preserving Aggregate invariants.

---

```
retire()
```

Transitions the Aggregate into the Retired lifecycle state.

Once retired, further modification SHALL NOT be permitted.

---

## Accessors

The Aggregate exposes read-only access to its owned state.

```
getFeeObligationIdentifier()

getStudentIdentifier()

getAcademicYearIdentifier()

getFeeStructureIdentifier()

getObligationLines()

getOutstandingAmount()

isActive()
```

No additional public operations are approved by this specification.

---

# Business Invariants

Implementation SHALL preserve the following invariants.

- Fee Obligation Identifier is immutable.
- Student Identifier is immutable.
- Academic Year Identifier is immutable.
- Fee Structure Identifier is immutable.
- Outstanding Amount SHALL never become negative.
- A Fee Obligation SHALL contain one or more Obligation Lines.
- Obligation Lines SHALL not contain duplicate identifiers.
- Obligation Lines SHALL not contain null entries.
- Retired Fee Obligations SHALL remain immutable.
- Aggregate ownership SHALL always be preserved.

---

# Ownership Boundaries

Only the Fee Obligation Aggregate may modify:

- Outstanding Amount
- Obligation Lines
- lifecycle state

Collaborating Aggregates SHALL NOT directly modify this Aggregate's owned state.

---

# Lifecycle

The Aggregate supports the following lifecycle.

```
Active
    ↓
Retired
```

Lifecycle transitions are irreversible.

Historical Fee Obligations remain permanently preserved.

---

# Consistency Requirements

Implementation SHALL preserve:

- Aggregate ownership
- Financial consistency
- Outstanding Amount consistency
- Obligation Line consistency
- Lifecycle integrity

Financial correctness SHALL remain valid after every successful business operation.

---

# Implementation Obligations

| Obligation | Type | Source |
|------------|------|--------|
| Preserve Student financial responsibility | Ownership | Aggregate Design |
| Preserve governing Fee Structure reference | State | Software Domain Model |
| Preserve governing Academic Year reference | State | Software Domain Model |
| Preserve Obligation Line collection | State | Software Domain Model |
| Preserve Outstanding Amount | State | Software Domain Model |
| Preserve lifecycle integrity | Lifecycle | Aggregate Design |
| Preserve Aggregate ownership | Architecture | Aggregate Design |
| Preserve financial consistency | Business Rule | Business Rules |

---

# Implementation Constraints

Implementation SHALL:

- validate constructor inputs;
- validate business operation inputs;
- preserve Aggregate ownership;
- preserve lifecycle integrity;
- preserve financial consistency;
- reject invalid state transitions;
- reject duplicate Obligation Lines;
- reject null Obligation Lines;
- prevent external mutation of owned collections.

Implementation SHALL NOT:

- expose mutable internal collections;
- expose public setters;
- allow modification after retirement;
- introduce undocumented public operations;
- introduce undocumented Aggregate state.

Implementation technology remains outside the scope of this specification.

---

# Collaboration Contract

The Fee Obligation Aggregate collaborates with:

- Student
- Academic Year
- Fee Structure
- Payment
- Discount

Collaborations occur only through Aggregate references.

Ownership of business truth SHALL NOT transfer between Aggregates.

---

# Story Traceability

Initially implemented through:

- Sprint-001 / Story-005

Future Stories may extend implementation while preserving this specification.

---

# Related Documents

- SoftwareDomainModel.md
- BusinessRules.md
- FeeObligationManagement.md
- Fee Obligation Aggregate Design

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-06 | Initial version |
| 1.1.0 | 2026-07-13 | Added complete Aggregate contract, Public API, Aggregate State, Business Invariants, Lifecycle, Ownership rules and Implementation Constraints to eliminate implementation ambiguity. |

---

# Approval

**Status:** Draft