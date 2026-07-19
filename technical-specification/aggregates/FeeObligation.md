# Fee Obligation Aggregate Technical Specification

```yaml
---
document_id: ATS-FEEOBLIGATION-001
title: Fee Obligation Aggregate Technical Specification
version: 1.4.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-07-06
last_updated: 2026-07-17

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

This document defines the authoritative implementation contract for the Fee Obligation Aggregate.

It refines the approved Software Domain Model and Software Architecture by defining the complete Aggregate contract required for implementation while remaining independent of programming language, persistence technology, implementation framework and infrastructure.

The Fee Obligation Aggregate Technical Specification defines:

- Aggregate responsibilities;
- owned, referenced and derived state;
- lifecycle behaviour;
- business invariants;
- public operations;
- approved supporting types; and
- persistence traceability.

It specifies **what** the Fee Obligation Aggregate must do without prescribing **how** it is implemented.

---

# Responsibilities

The Fee Obligation Aggregate owns the complete financial responsibility of a Student for an Academic Year.

It is responsible for:

- preserving Fee Obligation identity;
- maintaining Student, Academic Year and Fee Structure references;
- managing the owned Obligation Line collection;
- managing Applied Discounts;
- managing Payment Allocations;
- maintaining the derived Outstanding Amount; and
- managing the Fee Obligation lifecycle.

The Fee Obligation Aggregate intentionally does **not** own:

- Student identity;
- Academic Year definition;
- Fee Structure policy;
- Discount approval;
- Payment lifecycle; or
- Receipt lifecycle.

The Fee Obligation Aggregate is the authoritative owner of the Student's financial responsibility.

These business truths remain owned by collaborating Aggregates.

---

# Owned State

The Fee Obligation Aggregate owns the following business state.

| State | Type | Required | Mutable | Description |
|--------|------|----------|----------|-------------|
| feeObligationIdentifier | Fee Obligation Identifier | Yes | No | Immutable Fee Obligation identifier |
| studentIdentifier | Student Identifier | Yes | No | Student responsible for the obligation |
| academicYearIdentifier | Academic Year Identifier | Yes | No | Governing Academic Year |
| feeStructureIdentifier | Fee Structure Identifier | Yes | No | Governing Fee Structure |
| obligationLines | Collection<ObligationLine> | Yes | Yes | Owned financial obligations |
| appliedDiscounts | Collection<AppliedDiscount> | Yes | Yes | Discounts applied to the obligation |
| paymentAllocations | Collection<PaymentAllocation> | Yes | Yes | Payments allocated to the obligation |
| outstandingAmount | Monetary Amount | Yes | Yes | Derived outstanding balance maintained by the Aggregate |
| lifecycleState | Fee Obligation Lifecycle | Yes | Yes | Current Fee Obligation lifecycle |

No additional owned business state is approved.

---

# Referenced State

The Fee Obligation Aggregate references externally owned business information but does not own it.

The Aggregate may reference:

| Aggregate | Business Purpose |
|-----------|------------------|
| Student | Identify the financial owner |
| Academic Year | Establish the governing academic period |
| Fee Structure | Establish the governing charging policy |
| Discount | Validate approved concessions |
| Payment | Validate realised payments |

Referenced business information SHALL remain externally owned.

The Fee Obligation Aggregate SHALL NOT modify referenced Aggregate state.

---

# Derived State

The Fee Obligation Aggregate owns one approved derived business state.

| Derived State | Derived From |
|---------------|--------------|
| Outstanding Amount | Obligation Lines, Applied Discounts and Payment Allocations |

Outstanding Amount is a derived Aggregate state.

The authoritative financial facts remain:

- Obligation Lines;
- Applied Discounts; and
- Payment Allocations.

Outstanding Amount SHALL always be reproducible from these owned financial facts.

Outstanding Amount MAY be persisted as an implementation optimisation provided it always remains consistent with its owned financial facts.

No additional derived business state is approved.

---

# Lifecycle

The Fee Obligation Aggregate supports the following lifecycle.

```text
Active
    │
    ▼
Retired
```

Lifecycle transitions are irreversible.

Retired Fee Obligations remain permanently preserved.

Only one lifecycle state may exist at any point in time.

---

# Business Invariants

The implementation SHALL preserve the following Business Invariants.

- Fee Obligation Identifier is immutable.
- Student Identifier is immutable.
- Academic Year Identifier is immutable.
- Fee Structure Identifier is immutable.
- Every Fee Obligation contains one or more Obligation Lines.
- Obligation Line identifiers are unique within the Aggregate.
- Obligation Lines shall not contain null entries.
- Applied Discounts reference approved Discounts.
- Payment Allocations reconcile to realised Payments.
- Outstanding Amount shall never become negative.
- Outstanding Amount shall always remain consistent with the Aggregate's owned financial facts.
- Outstanding Amount shall always be reproducible from the Aggregate's owned financial facts.
- Retired Fee Obligations remain immutable.
- Only the Fee Obligation Aggregate may modify its owned state.
- Aggregate ownership boundaries shall always be preserved.

These invariants SHALL remain true throughout every permitted lifecycle transition and business operation.

---

# Approved Implementation Types

The following domain types participate in the approved Aggregate contract.

- Fee Obligation Identifier
- Fee Obligation Lifecycle
- Obligation Line
- Applied Discount
- Payment Allocation

No additional publicly observable domain types are approved by this specification.

---

# Public API

The Public API defines the complete externally observable behaviour of the Fee Obligation Aggregate.

Every public operation SHALL preserve all documented Business Invariants.

---

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

Creates a valid Fee Obligation.

The constructor SHALL:

- establish a valid Fee Obligation identity;
- associate the governing Student;
- associate the governing Academic Year;
- associate the governing Fee Structure;
- establish the initial Obligation Line collection;
- derive the initial Outstanding Amount;
- establish the Active lifecycle state; and
- preserve all documented Business Invariants.

---

## Business Operations

### update(
    obligationLines
)

Updates the owned financial obligations.

Preconditions:

- Fee Obligation is Active.
- One or more valid Obligation Lines are provided.

Postconditions:

- Approved mutable state is updated.
- Outstanding Amount is recalculated.
- Business Invariants remain preserved.

---

### applyDiscount(
    appliedDiscount
)

Applies an approved Discount to the Fee Obligation.

Preconditions:

- Fee Obligation is Active.
- Discount is approved.
- Applied Discount is valid.

Postconditions:

- Applied Discount becomes owned by the Aggregate.
- Outstanding Amount is recalculated.
- Business Invariants remain preserved.

---

### allocatePayment(
    paymentAllocation
)

Records a realised Payment Allocation.

Preconditions:

- Fee Obligation is Active.
- Payment Allocation is valid.

Postconditions:

- Payment Allocation becomes owned by the Aggregate.
- Outstanding Amount is recalculated.
- Business Invariants remain preserved.

---

### retire()

Transitions the Fee Obligation to the Retired lifecycle state.

Preconditions:

- Fee Obligation is currently Active.

Postconditions:

- Lifecycle becomes Retired.
- Historical integrity is preserved.
- Business Invariants remain preserved.

---

## Accessors

```text
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

Accessors expose approved Fee Obligation information only.

Accessors SHALL NOT modify Aggregate state.

No additional public operations are approved by this specification.

---

# Supporting Types

The following Supporting Types participate in the approved Aggregate contract.

## Fee Obligation Identifier

Defines the immutable business identity of a Fee Obligation.

Responsibilities:

- uniquely identify a Fee Obligation;
- remain immutable throughout the Fee Obligation lifecycle.

Business Invariants:

- Identifier shall never change.
- Identifier shall uniquely identify exactly one Fee Obligation.

---

## Obligation Line

Defines a single financial obligation owned by the Fee Obligation Aggregate.

Responsibilities:

- represent an individual financial obligation;
- preserve the charge amount;
- remain owned exclusively by the Fee Obligation Aggregate.

Business Invariants:

- Every Obligation Line belongs to exactly one Fee Obligation.
- Obligation Line identifiers are unique within a Fee Obligation.
- Null Obligation Lines are not permitted.

---

## Applied Discount

Defines the application of an approved Discount to a Fee Obligation.

Responsibilities:

- record the application of an approved Discount;
- preserve the financial concession applied to the obligation.

Business Invariants:

- Every Applied Discount references an approved Discount.
- Every Applied Discount belongs to exactly one Fee Obligation.

---

## Payment Allocation

Defines the allocation of a realised Payment to a Fee Obligation.

Responsibilities:

- record settlement of financial responsibility;
- preserve payment allocation information.

Business Invariants:

- Every Payment Allocation belongs to exactly one Fee Obligation.
- Payment Allocations reconcile to realised Payments.

---

## Fee Obligation Lifecycle

Defines the approved lifecycle states of a Fee Obligation.

Responsibilities:

- represent the current operational state;
- govern permitted lifecycle transitions.

Business Invariants:

- Only one lifecycle state may exist at any point in time.
- Lifecycle transitions shall follow the approved lifecycle.
- Retired Fee Obligations are immutable.

---

# Persistence Traceability

The following business concepts are represented by the Fee Obligation Aggregate.

| Business Concept | Classification |
|------------------|----------------|
| Fee Obligation | Aggregate Root |
| Fee Obligation Identifier | Owned State |
| Student Identifier | Owned State |
| Academic Year Identifier | Owned State |
| Fee Structure Identifier | Owned State |
| Obligation Lines | Owned State |
| Applied Discounts | Owned State |
| Payment Allocations | Owned State |
| Outstanding Amount | Derived Owned State |
| Fee Obligation Lifecycle | Owned State |

The Fee Obligation Aggregate does not persist:

- Students;
- Academic Years;
- Fee Structures;
- Discount approvals;
- Payments; or
- Receipts.

Persistent representation SHALL remain consistent with this Aggregate Technical Specification and the Aggregate Persistence Model.

---

# Consistency Requirements

Implementation SHALL preserve:

- Fee Obligation identity integrity;
- governing reference integrity;
- financial fact integrity;
- Outstanding Amount consistency;
- lifecycle integrity;
- Aggregate ownership boundaries; and
- all documented Business Invariants.

Financial correctness SHALL remain valid after every successful business operation.

---

# Collaboration Contract

The Fee Obligation Aggregate collaborates with the following Aggregates.

| Aggregate | Collaboration Purpose |
|-----------|-----------------------|
| Student | Establish financial ownership |
| Academic Year | Define the governing academic period |
| Fee Structure | Define the governing charging policy |
| Discount | Validate and apply approved concessions |
| Payment | Validate realised payment allocations |

Collaborations SHALL occur exclusively through approved Aggregate references.

The Fee Obligation Aggregate owns the complete financial responsibility of the Student.

Ownership of business truth SHALL NOT transfer between collaborating Aggregates.

---

# Implementation Constraints

Implementation SHALL:

- validate constructor inputs;
- validate business operation inputs;
- preserve Aggregate ownership;
- preserve lifecycle integrity;
- preserve financial consistency;
- maintain Outstanding Amount consistency;
- reject duplicate Obligation Lines;
- reject null Obligation Lines;
- preserve all documented Business Invariants; and
- prevent external modification of owned collections.

Implementation SHALL NOT:

- expose mutable internal collections;
- expose public setters;
- permit arbitrary modification of Outstanding Amount;
- allow modification after retirement;
- expose undocumented public operations;
- introduce undocumented Aggregate state; or
- violate Aggregate ownership boundaries.

Implementation technology remains outside the scope of this specification.

---

# Story Traceability

Initially implemented through:

- Sprint-001 / Story-005

Future Stories MAY extend implementation while preserving this Aggregate Technical Specification.

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
| 1.4.0 | 2026-07-17 | Aligned with TECH-STD-001 v1.2.0. Adopted the standardized Aggregate Technical Specification structure, introduced Referenced State, Derived State, Approved Implementation Types, Supporting Types and Persistence Traceability sections, and aligned the Public API with the standardized contract format without changing approved business behaviour. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- CTO

## Approval Date

2026-07-17
```