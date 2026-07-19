# Fee Obligation Aggregate Persistence Model

```yaml
---
document_id: TD-FEEOBLIGATION-001
title: Fee Obligation Aggregate Persistence Model
version: 2.0.0
status: Approved

owner: Product Owner
reviewer: Chief Architect

created: 2026-07-10
last_updated: 2026-07-17

related_documents:
  - ../../architecture/aggregates/FeeObligation.md
  - ../../technical-specification/aggregates/FeeObligation.md
  - ../../technical-design/persistence/README.md
  - ../../architecture/SoftwareArchitecture.md
  - ../../spec/docs/SoftwareDomainModel.md
  - ../../spec/docs/rfc/RFC-001-Financial-Truth-Model.md
---
```

---

# Purpose

This document defines the authoritative persistent representation of the Fee Obligation Aggregate.

It refines the approved Aggregate Technical Specification by defining the complete persistent business state required to preserve the business truth owned by the Fee Obligation Aggregate while remaining independent of programming language, persistence framework, database technology and infrastructure.

The Fee Obligation Aggregate Persistence Model defines:

- persistent business state;
- derived business state;
- transient business state;
- ownership boundaries;
- persistence constraints; and
- traceability to approved engineering specifications.

It specifies **what** business information shall be persisted without prescribing **how** persistence is implemented.

---

# Aggregate

**Fee Obligation**

---

# Persistence Responsibilities

The Fee Obligation Aggregate Persistence Model preserves the business truth owned by the Fee Obligation Aggregate.

It is responsible for persisting:

- Fee Obligation identity;
- Student reference;
- Academic Year reference;
- Fee Structure reference;
- Obligation Line collection;
- Applied Discount collection;
- Payment Allocation collection;
- Derived Outstanding Amount; and
- Fee Obligation lifecycle.

The Fee Obligation Aggregate Persistence Model intentionally does **not** persist:

- Student information;
- Academic Year information;
- Fee Structure definitions;
- Payment transactions; or
- Discount entitlements.

These business truths remain owned by collaborating Aggregates.

---

# Persistent Business State

The Fee Obligation Aggregate owns the following Persistent Business State.

| Business State | Type | Required | Mutable | Description |
|---------------|------|----------|----------|-------------|
| feeObligationIdentifier | Fee Obligation Identifier | Yes | No | Immutable Fee Obligation identifier |
| studentIdentifier | Student Identifier | Yes | No | Reference to the owning Student |
| academicYearIdentifier | Academic Year Identifier | Yes | No | Reference to the governing Academic Year |
| feeStructureIdentifier | Fee Structure Identifier | Yes | No | Reference to the governing Fee Structure |
| obligationLines | Obligation Line Collection | Yes | Yes | Collection of owned financial obligation lines |
| appliedDiscounts | Applied Discount Collection | Yes | Yes | Collection of applied Discounts |
| paymentAllocations | Payment Allocation Collection | Yes | Yes | Collection of realised Payment Allocations |
| outstandingAmount | Monetary Amount | Yes | Yes | Persisted derived outstanding balance |
| lifecycleState | Fee Obligation Lifecycle | Yes | Yes | Current Fee Obligation lifecycle |

No additional Persistent Business State is approved.

---

# Persistent Supporting Entity State

## Obligation Line

The Obligation Line Supporting Entity owns the following Persistent Business State.

| Business State | Type | Required | Mutable | Description |
|---------------|------|----------|----------|-------------|
| obligationLineIdentifier | Obligation Line Identifier | Yes | No | Immutable Obligation Line identifier |
| feeComponentIdentifier | Fee Component Identifier | Yes | No | Associated Fee Component |
| obligationAmount | Monetary Amount | Yes | Yes | Financial obligation amount |

No additional Persistent Business State is approved.

---

## Applied Discount

The Applied Discount Supporting Entity owns the following Persistent Business State.

| Business State | Type | Required | Mutable | Description |
|---------------|------|----------|----------|-------------|
| discountIdentifier | Discount Identifier | Yes | No | Applied Discount reference |
| discountAmount | Monetary Amount | Yes | Yes | Approved Discount amount applied to the Obligation |

No additional Persistent Business State is approved.

---

## Payment Allocation

The Payment Allocation Supporting Entity owns the following Persistent Business State.

| Business State | Type | Required | Mutable | Description |
|---------------|------|----------|----------|-------------|
| paymentIdentifier | Payment Identifier | Yes | No | Associated Payment reference |
| allocatedAmount | Monetary Amount | Yes | Yes | Allocated Payment amount |

No additional Persistent Business State is approved.

---

# Derived Business State

The Fee Obligation Aggregate owns the following Derived Business State.

| Derived Business State | Derived From |
|------------------------|--------------|
| Outstanding Amount | Obligation Lines, Applied Discounts and Payment Allocations |

Outstanding Amount MAY be persisted as a rebuildable optimization provided it remains fully reproducible from its source financial facts.

Outstanding Amount SHALL NOT become the authoritative business truth.

No additional Derived Business State is approved.

---

# Transient Business State

The Fee Obligation Aggregate owns no Transient Business State.

No implementation-specific state forms part of the approved persistent representation.

No additional Transient Business State is approved.

---

# Ownership Boundaries

The Fee Obligation Aggregate owns only the Persistent Business State defined by this specification.

The Fee Obligation Aggregate owns:

- Obligation Line Supporting Entity;
- Applied Discount Supporting Entity; and
- Payment Allocation Supporting Entity.

The Fee Obligation Aggregate SHALL NOT persist business information owned by collaborating Aggregates.

Business information owned by collaborating Aggregates includes:

- Student information;
- Academic Year information;
- Fee Structure definitions;
- Payment transactions; and
- Discount entitlements.

The Fee Obligation Aggregate MAY persist references to collaborating Aggregates where ownership is preserved.

Approved Aggregate references:

| Aggregate | Business Reference |
|-----------|--------------------|
| Student | Student Identifier |
| Academic Year | Academic Year Identifier |
| Fee Structure | Fee Structure Identifier |

References to collaborating Aggregates SHALL preserve ownership without transferring business truth.

---

# Persistence Constraints

Implementation SHALL preserve:

- Fee Obligation identity;
- Student reference integrity;
- Academic Year reference integrity;
- Fee Structure reference integrity;
- Obligation Line collection integrity;
- Applied Discount collection integrity;
- Payment Allocation collection integrity;
- Outstanding Amount consistency;
- Fee Obligation lifecycle integrity;
- Supporting Entity ownership;
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

Outstanding Amount SHALL:

- never become negative;
- always reconcile with the Aggregate's owned financial facts; and
- always be reproducible from persisted financial facts.

If implementation requires additional Persistent Business State, implementation SHALL stop and clarification SHALL be requested through the appropriate engineering governance process.

---

# Persistent Representation Rules

Implementation SHALL ensure:

- Fee Obligation Identifier remains immutable after creation.
- Student Identifier remains immutable after creation.
- Academic Year Identifier remains immutable after creation.
- Fee Structure Identifier remains immutable after creation.
- Obligation Line collection preserves the complete financial responsibility established by the Aggregate.
- Applied Discount collection preserves every approved Discount application.
- Payment Allocation collection preserves every realised Payment Allocation.
- Outstanding Amount always reconciles with the Aggregate's owned financial facts.
- Fee Obligation Lifecycle accurately represents the approved lifecycle state.

Persistent representation SHALL remain consistent with the approved Aggregate Technical Specification.

---

# Traceability

The following Persistent Business State is traceable to the approved Aggregate Technical Specification.

## Aggregate Root

| Persistent Business State | Source |
|---------------------------|--------|
| Fee Obligation Identifier | Fee Obligation Aggregate Technical Specification |
| Student Identifier | Fee Obligation Aggregate Technical Specification |
| Academic Year Identifier | Fee Obligation Aggregate Technical Specification |
| Fee Structure Identifier | Fee Obligation Aggregate Technical Specification |
| Obligation Line Collection | Fee Obligation Aggregate Technical Specification |
| Applied Discount Collection | Fee Obligation Aggregate Technical Specification |
| Payment Allocation Collection | Fee Obligation Aggregate Technical Specification |
| Outstanding Amount | Fee Obligation Aggregate Technical Specification |
| Fee Obligation Lifecycle | Fee Obligation Aggregate Technical Specification |

## Supporting Entities

| Persistent Business State | Source |
|---------------------------|--------|
| Obligation Line Identifier | Fee Obligation Aggregate Technical Specification |
| Fee Component Identifier | Fee Obligation Aggregate Technical Specification |
| Obligation Amount | Fee Obligation Aggregate Technical Specification |
| Discount Identifier | Fee Obligation Aggregate Technical Specification |
| Discount Amount | Fee Obligation Aggregate Technical Specification |
| Payment Identifier | Fee Obligation Aggregate Technical Specification |
| Allocated Amount | Fee Obligation Aggregate Technical Specification |

All Persistent Business State SHALL remain traceable to approved engineering specifications.

---

# Consistency Requirements

Implementation SHALL preserve:

- Fee Obligation identity integrity;
- Student reference integrity;
- Academic Year reference integrity;
- Fee Structure reference integrity;
- financial fact integrity;
- Outstanding Amount consistency;
- Supporting Entity ownership;
- Fee Obligation lifecycle integrity;
- Aggregate ownership boundaries; and
- all approved Persistent Business State.

The persistent representation SHALL remain fully consistent with the approved Aggregate Technical Specification throughout the Aggregate lifecycle.

---

# Implementation Constraints

Implementation SHALL:

- preserve Aggregate ownership;
- preserve Supporting Entity ownership;
- preserve approved Persistent Business State;
- preserve Derived Business State consistency;
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
- Fee Obligation Aggregate Design
- Fee Obligation Aggregate Technical Specification
- Aggregate Persistence Model Standard
- RFC-001 – Financial Truth Model

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-10 | Initial Persistence Model. |
| 1.1.0 | 2026-07-13 | Aligned with ATS v1.1.0. Standardized field names, lifecycle representation, traceability, persistence constraints and ownership rules. |
| 1.2.0 | 2026-07-14 | Aligned with RFC-001 Financial Truth Model. Added Applied Discounts and Payment Allocations, clarified Outstanding Amount as a persisted derived value, and updated persistence constraints accordingly. |
| 1.3.0 | 2026-07-15 | Aligned with ATS v1.3.0. Replaced boolean lifecycle with Fee Obligation Lifecycle, strengthened derived-state wording, expanded Persistent Representation Rules and clarified traceability. |
| 2.0.0 | 2026-07-17 | Aligned with TD-PERSISTENCE-STD-001 v1.0.0. Adopted the standardized Aggregate Persistence Model structure, introduced Persistent Business State, Derived Business State, Transient Business State, Ownership Boundaries, Consistency Requirements and standardized traceability without changing approved business behaviour. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- Chief Architect

## Approval Date

2026-07-17