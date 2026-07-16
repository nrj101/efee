# Discount Aggregate Technical Specification

```yaml
---
document_id: ATS-DISCOUNT-001
title: Discount Aggregate Technical Specification
version: 1.2.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-07-06
last_updated: 2026-07-15

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

This document defines the implementation-neutral technical specification for the Discount Aggregate.

It refines the approved Software Domain Model and Aggregate Design by defining the technical obligations required to preserve authorised financial concessions granted to Students.

This specification defines the complete Aggregate contract while remaining independent of programming language, persistence technology and implementation framework.

---

# Aggregate Responsibility

The Discount Aggregate owns an approved financial concession entitlement granted to a Student.

It preserves:

- Discount identity
- Student reference
- Approved concession value
- Approval information
- Business justification
- Discount lifecycle

The Discount Aggregate owns the entitlement to a financial concession.

It intentionally does **not** own:

- Student financial responsibility
- Fee Obligations
- Obligation Lines
- Applied Discounts
- Payments
- Receipts

The financial effect of a Discount is realised only through the Fee Obligation Aggregate.

The Discount Aggregate never calculates or records the financial effect of a concession.

---

# Owned State

The Aggregate owns the following state.

| Field | Type | Required | Mutable | Description |
|--------|------|----------|----------|-------------|
| discountIdentifier | String | Yes | No | Unique Discount identifier |
| studentIdentifier | String | Yes | No | Student receiving the Discount |
| discountValue | Monetary Amount | Yes | Yes | Approved concession value |
| approvalInformation | Approval Information | Yes | Yes | Approval authority and approval details |
| businessJustification | Business Justification | Yes | Yes | Reason supporting the concession |
| active | Boolean | Yes | Yes | Aggregate lifecycle |

---

# Aggregate Does Not Own

The Aggregate SHALL NOT own:

- Fee Components
- Fee Obligations
- Outstanding Amount
- Applied Discounts
- Payment information
- Receipt information
- Student financial responsibility

These business truths remain owned by collaborating Aggregates.

---

# Ownership Boundaries

The Discount Aggregate owns only the entitlement to an approved financial concession.

Business truths owned by collaborating Aggregates SHALL NOT be modified by this Aggregate.

Application of a Discount shall always occur through the Fee Obligation Aggregate.

---

# Public API

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

Creates a new Active Discount.

---

## Business Operations

```text
update(
    discountValue,
    approvalInformation,
    businessJustification
)
```

Updates the approved concession while preserving Aggregate ownership and business invariants.

---

```text
retire()
```

Transitions the Aggregate into the Retired lifecycle state.

Historical Discounts remain permanently preserved.

---

## Accessors

```text
getDiscountIdentifier()

getStudentIdentifier()

getDiscountValue()

getApprovalInformation()

getBusinessJustification()

isActive()
```

No additional public operations are approved by this specification.

---

# Business Invariants

Implementation SHALL preserve the following invariants.

- Discount Identifier is immutable.
- Student Identifier is immutable.
- Every Discount belongs to exactly one Student.
- Discount Value shall be greater than zero.
- Every Discount preserves its approval information.
- Every Discount preserves its business justification.
- Historical Discounts remain permanently preserved.
- Discount ownership never transfers to another Aggregate.

---

# Lifecycle

The Aggregate supports a single lifecycle transition.

```text
Active
   ↓
Retired
```

No further lifecycle transitions are permitted.

Historical Discounts remain permanently preserved.

---

# Consistency Requirements

Implementation SHALL preserve:

- Discount identity integrity
- Student entitlement integrity
- Approval integrity
- Business justification integrity
- Lifecycle integrity
- Aggregate ownership

The Aggregate shall never directly modify another Aggregate's financial state.

---

# Implementation Obligations

| Obligation | Type | Source |
|------------|------|--------|
| Preserve Discount identity | State | Software Domain Model |
| Preserve Student entitlement | State | Software Domain Model |
| Preserve approved concession value | State | Software Domain Model |
| Preserve approval information | State | Discount Aggregate Technical Specification |
| Preserve business justification | State | Discount Aggregate Technical Specification |
| Preserve lifecycle integrity | Lifecycle | Aggregate Design |
| Preserve Aggregate ownership | Architecture | Aggregate Design |
| Preserve Business Invariants | Consistency | Business Rules |

---

# Collaboration Contract

The Discount Aggregate collaborates with:

- Student
- Fee Obligation

Collaborations occur only through Aggregate references.

The Discount Aggregate authorises financial concessions.

The Fee Obligation Aggregate determines and records the financial effect of those concessions through Applied Discounts.

Ownership of financial responsibility SHALL NOT transfer between Aggregates.

---

# Implementation Constraints

Implementation SHALL:

- validate constructor inputs;
- validate business operation inputs;
- preserve Aggregate ownership;
- preserve lifecycle integrity;
- preserve approval information;
- preserve business justification;
- reject unsupported lifecycle transitions.

Implementation SHALL NOT:

- expose public setters;
- expose undocumented public operations;
- introduce additional Aggregate state;
- introduce Fee Component ownership;
- calculate Outstanding Amount;
- apply financial effects directly;
- modify collaborating Aggregates.

Implementation technology remains outside the scope of this specification.

---

# Story Traceability

Initially implemented through:

- Sprint-001 / Story-004

Future Stories may extend implementation while preserving this specification.

---

# Related Documents

- Software Domain Model
- Business Rules
- Discount Management
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

---

# Approval

**Status:** Approved