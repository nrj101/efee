# Fee Obligation Aggregate Persistence Model

```yaml
---
document_id: TD-FEEOBLIGATION-001
title: Fee Obligation Aggregate Persistence Model
version: 1.3.0
status: Draft

owner: Product Owner
reviewer: Chief Architect

created: 2026-07-10
last_updated: 2026-07-15

related_documents:
  - ../../architecture/aggregates/FeeObligation.md
  - ../../technical-specification/aggregates/FeeObligation.md
  - ../../architecture/SoftwareArchitecture.md
  - ../../spec/docs/SoftwareDomainModel.md
  - ../../spec/docs/rfc/RFC-001-Financial-Truth-Model.md
---
```

---

# Purpose

This document defines the implementation-neutral persistence model for the **Fee Obligation Aggregate**.

It specifies the complete persistent representation required to preserve the business truth owned by the Fee Obligation Aggregate.

This document is derived from the approved:

- Software Domain Model
- Aggregate Design
- Aggregate Technical Specification
- RFC-001 Financial Truth Model

It SHALL NOT introduce new business behaviour, Aggregate responsibilities or implementation logic.

---

# Aggregate

**Fee Obligation**

---

# Aggregate Responsibility

Persist the business truth owned by the Fee Obligation Aggregate while preserving:

- Fee Obligation identity
- Student reference
- Academic Year reference
- Fee Structure reference
- Obligation Line collection
- Applied Discounts
- Payment Allocations
- Derived Outstanding Amount
- Aggregate lifecycle

Business truths owned by collaborating Aggregates remain outside the scope of this document.

---

# Persistent State

The following Aggregate state is approved for persistence.

| Field | Type | Required | Mutable | Purpose | Source |
|--------|------|----------|----------|---------|--------|
| feeObligationIdentifier | String | Yes | No | Unique Fee Obligation identifier | Fee Obligation ATS |
| studentIdentifier | String | Yes | No | References the owning Student | Fee Obligation ATS |
| academicYearIdentifier | String | Yes | No | References the governing Academic Year | Fee Obligation ATS |
| feeStructureIdentifier | String | Yes | No | References the governing Fee Structure | Fee Obligation ATS |
| obligationLines | List<ObligationLine> | Yes | Yes | Collection of owned financial obligation lines | Fee Obligation ATS |
| appliedDiscounts | List<AppliedDiscount> | Yes | Yes | Discounts applied to this obligation | Fee Obligation ATS |
| paymentAllocations | List<PaymentAllocation> | Yes | Yes | Payment allocations settling this obligation | Fee Obligation ATS |
| outstandingAmount | Monetary Amount | Yes | Yes | Persisted derived outstanding balance | Fee Obligation ATS |
| lifecycleState | Fee Obligation Lifecycle | Yes | Yes | Aggregate lifecycle state | Fee Obligation ATS |

---

# Derived State

The following Aggregate state is derived from other owned financial facts.

| Derived State | Derived From |
|---------------|--------------|
| outstandingAmount | Obligation Lines, Applied Discounts and Payment Allocations |

Outstanding Amount MAY be persisted as a rebuildable optimization provided it remains fully reproducible from its source financial facts.

Outstanding Amount SHALL NOT become the authoritative business truth.

---

# Transient State

None.

---

# Relationships

The Fee Obligation Aggregate persists references to collaborating Aggregates only through their identifiers.

| Aggregate | Persistent Reference |
|-----------|----------------------|
| Student | studentIdentifier |
| Academic Year | academicYearIdentifier |
| Fee Structure | feeStructureIdentifier |

Ownership of collaborating Aggregates SHALL NOT be transferred.

---

# Persistence Constraints

Implementation SHALL preserve:

- Fee Obligation identity
- Student reference
- Academic Year reference
- Fee Structure reference
- Obligation Line collection
- Applied Discount collection
- Payment Allocation collection
- Outstanding Amount consistency
- Aggregate lifecycle
- Aggregate ownership

Implementation SHALL NOT:

- introduce additional persistent fields;
- remove approved persistent fields;
- rename approved persistent fields;
- change approved field types;
- change approved field mutability.

Outstanding Amount SHALL:

- never become negative;
- always reconcile with the Aggregate's owned financial facts;
- always be reproducible from persisted financial facts.

Obligation Lines SHALL NOT contain duplicate identifiers.

Obligation Lines SHALL NOT contain null entries.

If additional persistent state appears necessary, implementation SHALL stop and request clarification.

---

# Persistent Representation Rules

Implementation SHALL ensure:

- `feeObligationIdentifier` remains immutable after creation.
- `studentIdentifier` remains immutable after creation.
- `academicYearIdentifier` remains immutable after creation.
- `feeStructureIdentifier` remains immutable after creation.
- `obligationLines` preserve the complete financial responsibility established by the Aggregate.
- `appliedDiscounts` preserve every approved Discount application.
- `paymentAllocations` preserve every realised Payment Allocation.
- `outstandingAmount` always reconciles with the Aggregate's owned financial facts.
- `lifecycleState` accurately represents the approved Fee Obligation lifecycle.

---

# Technology Independence

This specification intentionally excludes:

- database schema
- SQL data types
- ORM mappings
- framework annotations
- repository implementation
- indexes
- vendor-specific persistence features

These concerns belong to later Technical Design documents.

---

# Traceability

| Persistent Field | Aggregate Technical Specification |
|------------------|-----------------------------------|
| feeObligationIdentifier | Fee Obligation ATS |
| studentIdentifier | Fee Obligation ATS |
| academicYearIdentifier | Fee Obligation ATS |
| feeStructureIdentifier | Fee Obligation ATS |
| obligationLines | Fee Obligation ATS |
| appliedDiscounts | Fee Obligation ATS |
| paymentAllocations | Fee Obligation ATS |
| outstandingAmount | Fee Obligation ATS |
| lifecycleState | Fee Obligation ATS |

---

# Notes

This document represents the complete approved persistent representation of the Fee Obligation Aggregate.

Outstanding Amount is persisted as a rebuildable derived value for operational efficiency.

The authoritative financial truth remains the Aggregate's owned financial facts:

- Obligation Lines
- Applied Discounts
- Payment Allocations

Implementation SHALL faithfully realize this persistence model without:

- introducing undocumented persistent state;
- violating Aggregate ownership boundaries;
- permitting inconsistency between persisted Outstanding Amount and its source financial facts;
- introducing alternative persistent representations.

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-10 | Initial Persistence Model. |
| 1.1.0 | 2026-07-13 | Aligned with ATS v1.1.0. Standardized field names, lifecycle representation, traceability, persistence constraints and ownership rules. |
| 1.2.0 | 2026-07-14 | Aligned with RFC-001 Financial Truth Model. Added Applied Discounts and Payment Allocations, clarified Outstanding Amount as a persisted derived value, and updated persistence constraints accordingly. |
| 1.3.0 | 2026-07-15 | Aligned with ATS v1.3.0. Replaced boolean lifecycle with Fee Obligation Lifecycle, strengthened derived-state wording, expanded Persistent Representation Rules and clarified traceability. |

---

# Approval

**Status:** Draft