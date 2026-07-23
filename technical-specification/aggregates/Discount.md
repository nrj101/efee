# Discount Aggregate Technical Specification

```yaml
---
document_id: ATS-DISCOUNT-001
title: Discount Aggregate Technical Specification
version: 1.3.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-07-06
last_updated: 2026-07-17

related_documents:
  - ../../spec/docs/SoftwareDomainModel.md
  - ../../spec/docs/BusinessRules.md
  - ../../spec/docs/workflows/DiscountManagement.md
  - ../../architecture/aggregates/Discount.md
  - ../../../spec/docs/rfc/RFC-007-Discount-Model-Simplification.md
  - ../../spec/docs/rfc/RFC-006-Replace-Cross-Aggregate-Supporting-Entity-References-with-Stable-Identifiers.md
---
```

---

# Purpose

This document defines the authoritative implementation contract for the Discount Aggregate.

It refines the approved Software Domain Model and Software Architecture by defining the complete Aggregate contract required for implementation while remaining independent of programming language, persistence technology, implementation framework and infrastructure.

The Discount Aggregate Technical Specification defines:

- Aggregate responsibilities;
- owned, referenced and derived state;
- lifecycle behaviour;
- business invariants;
- public operations;
- approved supporting types; and
- persistence traceability.

It specifies **what** the Discount Aggregate must do without prescribing **how** it is implemented.

---

# Responsibilities

The Discount Aggregate owns the entitlement to an approved financial concession granted to a Student.

It is responsible for:

- preserving Discount identity;
- maintaining the Student reference;
- preserving the approved concession value;
- maintaining approval information;
- preserving the business justification; and
- managing the Discount lifecycle.

The Discount Aggregate intentionally does **not** own:

- Student financial responsibility;
- Fee Obligations;
- Applied Discounts;
- Payments; or
- Receipts.

The financial effect of a Discount is realised exclusively through the Fee Obligation Aggregate.

These business truths remain owned by collaborating Aggregates.

---

# Owned State

The Discount Aggregate owns the following business state.

| State | Type | Required | Mutable | Description |
|--------|------|----------|----------|-------------|
| discountIdentifier | Discount Identifier | Yes | No | Immutable Discount identifier |
| studentIdentifier | Student Identifier | Yes | No | Student receiving the Discount |
| discountValue | Monetary Amount | Yes | Yes | Approved concession value |
| approvalInformation | Approval Information | Yes | Yes | Approval authority and approval details |
| businessJustification | Business Justification | Yes | Yes | Approved reason for the concession |
| lifecycleState | Discount Lifecycle | Yes | Yes | Current Discount lifecycle |

No additional owned business state is approved.

---

# Referenced State

The Discount Aggregate references externally owned business information but does not own it.

The Aggregate may reference:

| Aggregate | Business Purpose |
|-----------|------------------|
| Student | Identify the recipient of the concession |
| Fee Obligation | Enable application of the approved Discount |

Referenced business information SHALL remain externally owned.

The Discount Aggregate SHALL NOT modify referenced Aggregate state.

---

# Derived State

The Discount Aggregate does not own any derived business state.

Applied Discount values, Outstanding Amounts and financial effects are intentionally derived and recorded by the Fee Obligation Aggregate.

No additional derived business state is approved.

---

# Lifecycle

The Discount Aggregate supports the following lifecycle.

```text
Active
    │
    ▼
Retired
```

Lifecycle transitions are irreversible.

Retired Discounts remain permanently preserved.

Only one lifecycle state may exist at any point in time.

---

# Business Invariants

The implementation SHALL preserve the following Business Invariants.

- Discount Identifier is immutable.
- Student Identifier is immutable.
- Every Discount belongs to exactly one Student.
- Discount Value shall be greater than zero.
- Every Discount preserves its approval information.
- Every Discount preserves its business justification.
- Retired Discounts remain immutable.
- Only the Discount Aggregate may modify its owned state.
- Aggregate ownership boundaries shall always be preserved.

These invariants SHALL remain true throughout every permitted lifecycle transition and business operation.

---

# Approved Implementation Types

The following domain types participate in the approved Aggregate contract.

- Discount Identifier
- Discount Lifecycle
- Approval Information
- Business Justification

No additional publicly observable domain types are approved by this specification.

---

# Public API

The Public API defines the complete externally observable behaviour of the Discount Aggregate.

Every public operation SHALL preserve all documented Business Invariants.

---

## Constructor

```text
Discount(
    discountIdentifier,
    studentIdentifier,
    discountValue,
    approvalInformation,
    businessJustification
)
```

Creates a valid Discount.

The constructor SHALL:

- establish a valid Discount identity;
- associate the Student reference;
- establish the approved concession value;
- establish the approval information;
- establish the business justification;
- establish the Active lifecycle state; and
- preserve all documented Business Invariants.

---

## Business Operations

### update(
    discountValue,
    approvalInformation,
    businessJustification
)

Updates the approved financial concession.

Preconditions:

- Discount is Active.
- Discount Value is greater than zero.
- Approval Information is valid.
- Business Justification is provided.

Postconditions:

- Approved mutable state is updated.
- Aggregate identity remains unchanged.
- Business Invariants remain preserved.

---

### retire()

Transitions the Discount to the Retired lifecycle state.

Preconditions:

- Discount is currently Active.

Postconditions:

- Lifecycle becomes Retired.
- Historical integrity is preserved.
- Business Invariants remain preserved.

---

## Accessors

```text
getDiscountIdentifier()

getStudentIdentifier()

getDiscountValue()

getApprovalInformation()

getBusinessJustification()

getLifecycleState()

isActive()
```

Accessors expose approved Discount information only.

Accessors SHALL NOT modify Aggregate state.

No additional public operations are approved by this specification.

---

# Supporting Types

The following Supporting Types participate in the approved Aggregate contract.

## Discount Identifier

Defines the immutable business identity of a Discount.

Responsibilities:

- uniquely identify a Discount;
- remain immutable throughout the Discount lifecycle.

Business Invariants:

- Identifier shall never change.
- Identifier shall uniquely identify exactly one Discount.

---

## Approval Information

Defines the approved authority and supporting approval details for a Discount.

Responsibilities:

- record the approval authority;
- preserve approval details supporting the concession.

Business Invariants:

- Approval Information shall always exist.
- Approval Information shall remain internally consistent.

---

## Business Justification

Defines the approved reason supporting a financial concession.

Responsibilities:

- capture the business reason for the Discount;
- preserve the approved justification throughout the Discount lifecycle.

Business Invariants:

- Business Justification shall always exist.
- Business Justification shall remain associated with exactly one Discount.

---

## Discount Lifecycle

Defines the approved lifecycle states of a Discount.

Responsibilities:

- represent the current operational state;
- govern permitted lifecycle transitions.

Business Invariants:

- Only one lifecycle state may exist at any point in time.
- Lifecycle transitions shall follow the approved lifecycle.
- Retired Discounts are immutable.

---

# Persistence Traceability

The following business concepts are represented by the Discount Aggregate.

| Business Concept | Classification |
|------------------|----------------|
| Discount | Aggregate Root |
| Discount Identifier | Owned State |
| Student Identifier | Owned State |
| Discount Value | Owned State |
| Approval Information | Owned State |
| Business Justification | Owned State |
| Discount Lifecycle | Owned State |

The Discount Aggregate does not persist:

- Students;
- Fee Obligations;
- Applied Discounts;
- Outstanding Amounts;
- Payments; or
- Receipts.

Persistent representation SHALL remain consistent with this Aggregate Technical Specification and the Aggregate Persistence Model.

---

# Consistency Requirements

Implementation SHALL preserve:

- Discount identity integrity;
- Student entitlement integrity;
- approval information integrity;
- business justification integrity;
- lifecycle integrity;
- Aggregate ownership boundaries; and
- all documented Business Invariants.

The Discount Aggregate SHALL authorise financial concessions without directly modifying another Aggregate's financial state.

---

# Collaboration Contract

The Discount Aggregate collaborates with the following Aggregates.

| Aggregate | Collaboration Purpose |
|-----------|-----------------------|
| Student | Identify the concession recipient |
| Fee Obligation | Apply the approved Discount during obligation processing |

Collaborations SHALL occur exclusively through approved Aggregate references.

The Discount Aggregate authorises financial concessions.

The Fee Obligation Aggregate determines and records the financial effect of those concessions.

Ownership of business truth SHALL NOT transfer between collaborating Aggregates.

---

# Implementation Constraints

Implementation SHALL:

- validate constructor inputs;
- validate business operation inputs;
- preserve Aggregate ownership;
- preserve lifecycle integrity;
- preserve approval information;
- preserve business justification; and
- preserve all documented Business Invariants.

Implementation SHALL NOT:

- expose public setters;
- expose undocumented public operations;
- introduce undocumented Aggregate state;
- calculate Outstanding Amounts;
- apply financial effects directly;
- modify collaborating Aggregates; or
- violate Aggregate ownership boundaries.

Implementation technology remains outside the scope of this specification.

---

# Story Traceability

Initially implemented through:

- Sprint-001 / Story-004

Future Stories MAY extend implementation while preserving this Aggregate Technical Specification.

---

# Related Documents

- SoftwareDomainModel.md
- BusinessRules.md
- DiscountManagement.md
- Discount Aggregate Design
- RFC-007-Discount-Model-Simplification
- RFC-006-Replace-Cross-Aggregate-Supporting-Entity-References-with-Stable-Identifiers

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-06 | Initial version. |
| 1.1.0 | 2026-07-13 | Added complete Aggregate contract, approved state, lifecycle, implementation obligations and implementation constraints. |
| 1.2.0 | 2026-07-15 | Aligned with RFC-007 and RFC-006. Simplified the Discount Aggregate to own concession entitlement only, clarified ownership boundaries, strengthened lifecycle contract, refined implementation obligations and reinforced Aggregate collaboration through the Fee Obligation Aggregate. |
| 1.3.0 | 2026-07-17 | Aligned with TECH-STD-001 v1.2.0. Adopted the standardized Aggregate Technical Specification structure, introduced Referenced State, Derived State, Approved Implementation Types, Supporting Types and Persistence Traceability sections, and aligned the Public API with the standardized contract format without changing approved business behaviour. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- CTO

## Approval Date

2026-07-17