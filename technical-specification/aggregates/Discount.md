# Discount Aggregate Technical Specification

```yaml
---
document_id: ATS-DISCOUNT-001
title: Discount Aggregate Technical Specification
version: 1.1.0
status: Draft

owner: Product Owner
reviewer: CTO

created: 2026-07-06
last_updated: 2026-07-13

related_documents:
  - ../../spec/docs/SoftwareDomainModel.md
  - ../../spec/docs/BusinessRules.md
  - ../../spec/docs/workflows/DiscountManagement.md
  - ../../architecture/aggregates/Discount.md
---
```

---

# Purpose

This document defines the implementation-neutral technical specification for the Discount Aggregate.

It refines the approved Software Domain Model and Aggregate Design by defining the technical obligations required to preserve authorised financial reductions granted to Students.

This specification intentionally defines the approved implementation contract while remaining independent of programming language, persistence technology and framework.

---

# Aggregate Responsibility

The Discount Aggregate owns an authorised financial reduction granted to a Student.

It preserves:

- Discount identity
- Eligibility
- Reduction rules
- Applicable Fee Components
- Discount lifecycle

The Discount Aggregate owns entitlement only.

It intentionally does not own:

- Student financial responsibility
- Fee Obligations
- Payments
- Receipts

---

# Owned State

The Aggregate owns:

- Discount identity
- Eligibility
- Reduction rules
- Applicable Fee Components
- Lifecycle state

The Aggregate does not own:

- Student financial responsibility
- Payment information
- Receipt information
- Fee Obligation financial state

---

# Ownership Boundaries

The Discount Aggregate owns only the entitlement to an authorised financial reduction.

Business truths owned by collaborating Aggregates shall never be modified by this Aggregate.

---

# Lifecycle Model

The Aggregate preserves the lifecycle of an authorised Discount.

Historical Discounts remain preserved.

Lifecycle transitions shall preserve historical business truth.

---

# Consistency Requirements

The Aggregate preserves:

- Discount identity integrity
- Eligibility integrity
- Reduction rule integrity
- Lifecycle integrity

Consistency requirements remain traceable to the approved Business Rules.

---

# Approved Aggregate Model

The following Aggregate state is approved.

| Field | Type | Required | Mutable | Purpose |
|--------|------|----------|----------|---------|
| discountIdentifier | String | Yes | No | Unique Discount identifier |
| studentIdentifier | String | Yes | No | Student receiving the Discount |
| applicableFeeComponents | List<FeeComponent> | Yes | Yes | Fee Components eligible for Discount |
| discountValue | Monetary Amount | Yes | Yes | Approved reduction value |
| active | Boolean | Yes | Yes | Indicates whether the Discount remains active |

No additional Aggregate state is approved.

---

# Supporting Entities

The Discount Aggregate collaborates with:

- FeeComponent

No additional supporting entities are approved.

---

# Approved Business Operations

The Aggregate is approved to expose only the following business operations.

## Constructor

Discount(...)

## Business Operations

update(...)

retire()

## Accessors

getDiscountIdentifier()

getStudentIdentifier()

getApplicableFeeComponents()

getDiscountValue()

isActive()

No additional business operations are approved.

---

# Approved Lifecycle

Approved lifecycle states:

- Active
- Retired

No additional lifecycle states are approved.

---

# Approved Business Invariants

Implementation shall preserve the following business invariants.

- Every Discount has a unique Discount identifier.
- Every Discount belongs to exactly one Student.
- A Discount applies only to approved Fee Components.
- Retired Discounts remain historically preserved.
- Discount ownership never transfers to another Aggregate.

---

# Implementation Obligations

| Obligation | Type | Source |
|------------|------|--------|
| Preserve Discount identity | State | Software Domain Model |
| Preserve Student entitlement | State | Software Domain Model |
| Preserve applicable Fee Components | State | Software Domain Model |
| Preserve reduction value | State | Software Domain Model |
| Preserve lifecycle | Lifecycle | Software Domain Model |
| Preserve Aggregate ownership | Ownership | Aggregate Design |
| Preserve Business Invariants | Consistency | Business Rules |

---

# Collaboration Contract

The Discount Aggregate collaborates with:

- Student
- Fee Obligation

Collaborations preserve Aggregate ownership boundaries.

The Discount Aggregate authorises reductions without assuming ownership of financial responsibility.

---

# Implementation Clarifications

Implementation SHALL:

- preserve the approved Aggregate state;
- preserve the approved business operations;
- preserve Aggregate ownership;
- preserve lifecycle integrity;
- preserve historical business truth.

Implementation SHALL NOT:

- invent additional Aggregate state;
- invent additional business operations;
- invent additional lifecycle states;
- invent additional supporting entities;
- rename approved Aggregate members;
- change approved ownership boundaries;
- introduce undocumented business behaviour.

If implementation requires additional behaviour, state or operations, implementation SHALL stop and request clarification.

---

# Implementation Constraints

Implementation shall preserve:

- ownership boundaries;
- lifecycle integrity;
- reduction rule integrity;
- historical Discount information.

Implementation technology remains outside the scope of this specification.

---

# Story Traceability

Initially implemented through:

- Sprint-001 / Story-004

Future Stories may extend implementation while preserving this specification.

---

# Related Documents

- SoftwareDomainModel.md
- DiscountManagement.md
- BusinessRules.md
- Discount Aggregate Design

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-06 | Initial version |
| 1.1.0 | 2026-07-13 | Added approved aggregate model, approved business operations, lifecycle contract, implementation clarifications and implementation contract to reduce implementation ambiguity for AI-assisted development. |

---

# Approval

**Status:** Draft