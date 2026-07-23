# Discount Aggregate Persistence Model

```yaml
---
document_id: TD-DISCOUNT-001
title: Discount Aggregate Persistence Model
version: 2.0.0
status: Approved

owner: Product Owner
reviewer: Chief Architect

created: 2026-07-10
last_updated: 2026-07-17

related_documents:
  - ../../architecture/aggregates/Discount.md
  - ../../technical-specification/aggregates/Discount.md
  - ../../technical-design/persistence/README.md
  - ../../architecture/SoftwareArchitecture.md
  - ../../spec/docs/SoftwareDomainModel.md
  - ../../spec/docs/rfc/RFC-007-Discount-Model-Simplification.md
  - ../../spec/docs/rfc/RFC-006-Replace-Cross-Aggregate-Supporting-Entity-References-with-Stable-Identifiers.md
---
```

---

# Purpose

This document defines the authoritative persistent representation of the Discount Aggregate.

It refines the approved Aggregate Technical Specification by defining the complete persistent business state required to preserve the business truth owned by the Discount Aggregate while remaining independent of programming language, persistence framework, database technology and infrastructure.

The Discount Aggregate Persistence Model defines:

- persistent business state;
- derived business state;
- transient business state;
- ownership boundaries;
- persistence constraints; and
- traceability to approved engineering specifications.

It specifies **what** business information shall be persisted without prescribing **how** persistence is implemented.

---

# Aggregate

**Discount**

---

# Persistence Responsibilities

The Discount Aggregate Persistence Model preserves the business truth owned by the Discount Aggregate.

It is responsible for persisting:

- Discount identity;
- Student entitlement;
- Approved concession value;
- Approval Information;
- Business Justification; and
- Discount lifecycle.

The persisted state represents only the approved entitlement to a financial concession.

The financial effect of that entitlement is intentionally excluded.

The Discount Aggregate Persistence Model intentionally does **not** persist:

- Fee Components;
- Fee Obligations;
- Applied Discounts;
- Outstanding Amounts; or
- Financial settlement information.

These business truths remain owned by collaborating Aggregates.

---

# Persistent Business State

The Discount Aggregate owns the following Persistent Business State.

| Business State | Type | Required | Mutable | Description |
|---------------|------|----------|----------|-------------|
| discountIdentifier | Discount Identifier | Yes | No | Immutable Discount identifier |
| studentIdentifier | Student Identifier | Yes | No | Student receiving the approved Discount |
| discountValue | Monetary Amount | Yes | Yes | Approved concession value |
| approvalInformation | Approval Information | Yes | Yes | Approved authority and approval details |
| businessJustification | Business Justification | Yes | Yes | Approved business justification |
| active | Discount Lifecycle | Yes | Yes | Current Discount lifecycle |

No additional Persistent Business State is approved.

---

# Derived Business State

The Discount Aggregate owns no Derived Business State.

All persisted business information represents authoritative business truth owned by the Discount Aggregate.

No additional Derived Business State is approved.

---

# Transient Business State

The Discount Aggregate owns no Transient Business State.

No implementation-specific state forms part of the approved persistent representation.

No additional Transient Business State is approved.

---

# Ownership Boundaries

The Discount Aggregate owns only the Persistent Business State defined by this specification.

The Discount Aggregate SHALL NOT persist business information owned by collaborating Aggregates.

Business information owned by collaborating Aggregates includes:

- Fee Components;
- Fee Obligations;
- Applied Discounts;
- Outstanding Amounts; and
- Financial settlement information.

The Discount Aggregate MAY persist references to collaborating Aggregates where ownership is preserved.

Approved Aggregate references:

| Aggregate | Business Reference |
|-----------|--------------------|
| Student | Student Identifier |

References to collaborating Aggregates SHALL preserve ownership without transferring business truth.

---

# Persistence Constraints

Implementation SHALL preserve:

- Discount identity;
- Student entitlement;
- Approved concession value;
- Approval Information integrity;
- Business Justification integrity;
- Discount lifecycle integrity;
- Aggregate ownership boundaries; and
- all approved Persistent Business State.

Implementation SHALL NOT:

- introduce undocumented Persistent Business State;
- remove approved Persistent Business State;
- rename approved Persistent Business State;
- change approved business types;
- violate approved mutability;
- persist business information owned by collaborating Aggregates; or
- violate Aggregate ownership boundaries.

If implementation requires additional Persistent Business State, implementation SHALL stop and clarification SHALL be requested through the appropriate engineering governance process.

---

# Persistent Representation Rules

Implementation SHALL ensure:

- Discount Identifier remains immutable after creation.
- Student Identifier remains immutable after creation.
- Monetary Amount accurately represents the approved concession value.
- Approval Information preserves the approved authority and approval details.
- Business Justification preserves the approved business rationale.
- Discount Lifecycle accurately represents the approved lifecycle state.

The persisted representation SHALL preserve only the approved financial concession entitlement.

It SHALL NOT represent:

- financial application;
- settlement;
- outstanding balance; or
- applied financial effects.

Persistent representation SHALL remain consistent with the approved Aggregate Technical Specification.

---

# Traceability

The following Persistent Business State is traceable to the approved Aggregate Technical Specification.

| Persistent Business State | Source |
|---------------------------|--------|
| Discount Identifier | Discount Aggregate Technical Specification |
| Student Identifier | Discount Aggregate Technical Specification |
| Monetary Amount | Discount Aggregate Technical Specification |
| Approval Information | Discount Aggregate Technical Specification |
| Business Justification | Discount Aggregate Technical Specification |
| Discount Lifecycle | Discount Aggregate Technical Specification |

All Persistent Business State SHALL remain traceable to approved engineering specifications.

---

# Consistency Requirements

Implementation SHALL preserve:

- Discount identity integrity;
- Student entitlement integrity;
- Approved concession integrity;
- Approval Information integrity;
- Business Justification integrity;
- Discount lifecycle integrity;
- Aggregate ownership boundaries; and
- all approved Persistent Business State.

The persistent representation SHALL remain fully consistent with the approved Aggregate Technical Specification throughout the Aggregate lifecycle.

---

# Implementation Constraints

Implementation SHALL:

- preserve Aggregate ownership;
- preserve approved Persistent Business State;
- preserve lifecycle integrity;
- preserve traceability to approved engineering specifications;
- reject modifications that violate approved mutability; and
- remain implementation-neutral.

Implementation SHALL NOT:

- introduce implementation-specific business state;
- persist undocumented business information;
- duplicate business truth owned by collaborating Aggregates;
- modify approved ownership boundaries; or
- introduce implementation behaviour into this persistence model.

Physical persistence technology remains outside the scope of this specification.

---

# Related Documents

- SoftwareDomainModel.md
- SoftwareArchitecture.md
- Discount Aggregate Design
- Discount Aggregate Technical Specification
- Aggregate Persistence Model Standard
- RFC-007 – Discount Model Simplification
- RFC-006 – Replace Cross-Aggregate Supporting Entity References with Stable Identifiers

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-10 | Initial Persistence Model. |
| 1.1.0 | 2026-07-13 | Aligned persistent state with Discount ATS. Added Persistent Representation Rules and clarified persistence contract. |
| 1.2.0 | 2026-07-15 | Aligned with RFC-007 and RFC-006. Clarified persistent ownership boundaries, reinforced that only concession entitlement is persisted, explicitly prohibited persistence of collaborating Aggregate state, and improved persistence contract wording. |
| 2.0.0 | 2026-07-17 | Aligned with TD-PERSISTENCE-STD-001 v1.0.0. Adopted the standardized Aggregate Persistence Model structure, introduced Persistent Business State, Derived Business State, Transient Business State, Ownership Boundaries, Consistency Requirements and standardized traceability without changing approved business behaviour. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- Chief Architect

## Approval Date

2026-07-17