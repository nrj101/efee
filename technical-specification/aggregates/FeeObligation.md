# Fee Obligation Aggregate Technical Specification

```yaml
---
document_id: ATS-FEEOBLIGATION-001
title: Fee Obligation Aggregate Technical Specification
version: 1.3.0
status: Draft

owner: Product Owner
reviewer: CTO

created: 2026-07-06
last_updated: 2026-07-15

related_documents:
  - ../../spec/docs/SoftwareDomainModel.md
  - ../../spec/docs/BusinessRules.md
  - ../../spec/docs/workflows/FeeObligationManagement.md
  - ../../spec/docs/rfc/RFC-001-Financial-Truth-Model.md
  - ../../architecture/aggregates/FeeObligation.md
---
```

---

# Purpose

This document defines the implementation-neutral technical specification for the Fee Obligation Aggregate.

It refines the approved Software Domain Model and Aggregate Design by defining the complete Aggregate contract required for implementation while remaining independent of programming language, persistence technology and implementation framework.

---

# Aggregate Responsibility

The Fee Obligation Aggregate owns the financial responsibility of a Student.

It preserves:

- Student reference
- Academic Year reference
- Fee Structure reference
- Obligation Line collection
- Applied Discounts
- Payment Allocations
- Derived Outstanding Amount
- Aggregate lifecycle

The Fee Obligation Aggregate is the sole owner of the Student's financial responsibility.

---

# Owned State

The Aggregate owns the following state.

| Field | Type | Required | Mutable | Description |
|--------|------|----------|----------|-------------|
| feeObligationIdentifier | String | Yes | No | Unique Fee Obligation identifier |
| studentIdentifier | String | Yes | No | Owning Student reference |
| academicYearIdentifier | String | Yes | No | Governing Academic Year |
| feeStructureIdentifier | String | Yes | No | Governing Fee Structure |
| obligationLines | List<ObligationLine> | Yes | Yes | Collection of owned obligation lines |
| appliedDiscounts | List<AppliedDiscount> | Yes | Yes | Discounts applied to this obligation |
| paymentAllocations | List<PaymentAllocation> | Yes | Yes | Payment allocations settling this obligation |
| outstandingAmount | Monetary Amount | Yes | Yes | Derived outstanding balance maintained by the Aggregate |
| lifecycleState | Fee Obligation Lifecycle | Yes | Yes | Aggregate lifecycle state |

---

# Supporting Entities

The Fee Obligation Aggregate owns the following Supporting Entities.

| Supporting Entity | Purpose |
|-------------------|---------|
| ObligationLine | Represents a single financial obligation preserved by the Aggregate. |
| AppliedDiscount | Represents the application of an approved Discount to an Obligation Line. |

Supporting Entities SHALL NOT exist independently of the owning Aggregate.

---

# Aggregate Does Not Own

The Aggregate SHALL NOT own:

- Student identity
- Academic Year definition
- Fee Structure policy
- Discount approval
- Payment lifecycle
- Receipt lifecycle

These business truths remain owned by collaborating Aggregates.

---

# Financial Truth

The Fee Obligation Aggregate owns the complete financial position of the Student for the governed Academic Year.

Outstanding Amount is a **derived Aggregate state**.

The authoritative business facts are:

- Obligation Lines
- Applied Discounts
- Payment Allocations

Outstanding Amount SHALL always be reproducible from these owned financial facts.

Outstanding Amount SHALL NOT be treated as an independently managed business fact.

The Aggregate MAY persist Outstanding Amount as an implementation optimization provided it always remains consistent with its owned financial facts.

---

# Public API

## Constructor

```text
FeeObligation(
    feeObligationIdentifier,
    studentIdentifier,
    academicYearIdentifier,
    feeStructureIdentifier,
    obligationLines
)
```

Creates a new Active Fee Obligation.

The initial Outstanding Amount SHALL be derived from the Aggregate's owned financial facts.

---

## Business Operations

```
update(
    obligationLines
)
```

Updates the owned financial facts while preserving Aggregate invariants.

---

```
applyDiscount(
    appliedDiscount
)
```

Applies an approved Discount to this Fee Obligation.

---

```
allocatePayment(
    paymentAllocation
)
```

Records a realised Payment Allocation against this Fee Obligation.

---

```
retire()
```

Transitions the Aggregate into the Retired lifecycle state.

Historical Fee Obligations remain permanently preserved.

---

## Accessors

```
getFeeObligationIdentifier()

getStudentIdentifier()

getAcademicYearIdentifier()

getFeeStructureIdentifier()

getObligationLines()

getAppliedDiscounts()

getPaymentAllocations()

getOutstandingAmount()

getLifecycleState()
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
- Outstanding Amount SHALL remain consistent with the Aggregate's owned financial facts.
- Outstanding Amount SHALL always be reproducible from the Aggregate's owned financial facts.
- A Fee Obligation SHALL contain one or more Obligation Lines.
- Obligation Lines SHALL NOT contain duplicate identifiers.
- Obligation Lines SHALL NOT contain null entries.
- Applied Discounts SHALL reference approved Discounts.
- Payment Allocations SHALL reconcile to realised Payments.
- Retired Fee Obligations SHALL remain immutable.
- Aggregate ownership SHALL always be preserved.

---

# Ownership Boundaries

Only the Fee Obligation Aggregate may modify:

- Obligation Lines
- Applied Discounts
- Payment Allocations
- Outstanding Amount
- Aggregate lifecycle

Collaborating Aggregates SHALL NOT directly modify this Aggregate's owned state.

---

# Lifecycle

The Aggregate supports the following lifecycle.

```text
Active
   │
   ▼
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
- Applied Discount consistency
- Payment Allocation consistency
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
| Preserve Applied Discounts | State | RFC-001 |
| Preserve Payment Allocations | State | RFC-001 |
| Maintain derived Outstanding Amount consistency | Financial Truth | RFC-001 |
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
- maintain Outstanding Amount consistency;
- reject invalid lifecycle transitions;
- reject duplicate Obligation Lines;
- reject null Obligation Lines;
- prevent external mutation of owned collections.

Implementation SHALL NOT:

- expose mutable internal collections;
- expose public setters;
- permit arbitrary modification of Outstanding Amount;
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
- Discount
- Payment

Collaborations occur only through Aggregate references.

Ownership of business truth SHALL NOT transfer between Aggregates.

---

# Story Traceability

Initially implemented through:

- Sprint-001 / Story-005

Future Stories may incrementally implement additional approved operations while preserving this specification.

---

# Related Documents

- SoftwareDomainModel.md
- BusinessRules.md
- FeeObligationManagement.md
- RFC-001 – Financial Truth Model
- Fee Obligation Aggregate Design

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-06 | Initial version. |
| 1.1.0 | 2026-07-13 | Added complete Aggregate contract, Public API, Aggregate State, Business Invariants, Lifecycle, Ownership rules and Implementation Constraints. |
| 1.2.0 | 2026-07-14 | Aligned with RFC-001. Clarified Financial Truth Model, introduced Applied Discounts and Payment Allocations as owned financial facts, and defined Outstanding Amount as a derived Aggregate state. |
| 1.3.0 | 2026-07-15 | Standardized lifecycle representation using Fee Obligation Lifecycle, explicitly documented Supporting Entities, strengthened Financial Truth wording and clarified that Outstanding Amount is a derived Aggregate state reconstructed from preserved financial facts. |

---

# Approval

**Status:** Draft