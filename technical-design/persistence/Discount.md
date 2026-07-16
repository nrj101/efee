# Discount Aggregate Persistence Model

```yaml
---
document_id: TD-DISCOUNT-001
title: Discount Aggregate Persistence Model
version: 1.2.0
status: Approved

owner: Product Owner
reviewer: Chief Architect

created: 2026-07-10
last_updated: 2026-07-15

related_documents:
  - ../../architecture/aggregates/Discount.md
  - ../../technical-specification/aggregates/Discount.md
  - ../../architecture/SoftwareArchitecture.md
  - ../../spec/docs/SoftwareDomainModel.md
  - ../../../spec/docs/rfc/RFC-007-Discount-Model-Simplification.md
  - ../../spec/docs/rfc/RFC-006-Replace-Cross-Aggregate-Supporting-Entity-References-with-Stable-Identifiers.md
---
```

---

# Purpose

This document defines the implementation-neutral persistence model for the **Discount Aggregate**.

It specifies the complete persistent representation required to preserve the business truth owned by the Discount Aggregate.

This document is derived from the approved:

- Software Domain Model
- Aggregate Design
- Aggregate Technical Specification

It SHALL NOT introduce new business behaviour, Aggregate responsibilities or implementation logic.

---

# Aggregate

**Discount**

---

# Aggregate Responsibility

Persist the business truth owned by the Discount Aggregate while preserving:

- Discount identity
- Student entitlement
- Approved concession value
- Approval information
- Business justification
- Discount lifecycle

Business truths owned by collaborating Aggregates remain outside the scope of this document.

The persisted state represents only the approved entitlement to a financial concession.

The financial effect of that entitlement is intentionally excluded.

---

# Persistent State

The following Aggregate state is approved for persistence.

| Field | Type | Required | Mutable | Purpose | Source |
|--------|------|----------|----------|---------|--------|
| discountIdentifier | String | Yes | No | Unique Discount identifier | Discount ATS |
| studentIdentifier | String | Yes | No | Student receiving the Discount | Discount ATS |
| discountValue | Monetary Amount | Yes | Yes | Approved concession value | Discount ATS |
| approvalInformation | Approval Information | Yes | Yes | Approval authority and approval details | Discount ATS |
| businessJustification | Business Justification | Yes | Yes | Reason supporting the concession | Discount ATS |
| active | Boolean | Yes | Yes | Discount lifecycle state | Discount ATS |

No additional persistent state is approved.

---

# Derived State

None.

No persistent values are derived from other persisted state.

---

# Transient State

None.

---

# Relationships

The Discount Aggregate persists references to collaborating Aggregates only through approved identifiers.

| Aggregate | Relationship |
|-----------|--------------|
| Student | studentIdentifier |

The Discount Aggregate SHALL NOT persist:

- Fee Component references
- Fee Obligation references
- Obligation Line references
- Applied Discounts
- Outstanding Amount

Those business truths remain owned by collaborating Aggregates.

---

# Persistence Constraints

Implementation SHALL preserve:

- Discount identity
- Student entitlement
- Approved concession value
- Approval information
- Business justification
- Discount lifecycle
- Aggregate ownership

Implementation SHALL NOT:

- introduce additional persistent fields;
- remove approved persistent fields;
- rename approved persistent fields;
- change approved field types;
- change approved field mutability;
- persist Fee Components;
- persist Fee Obligations;
- persist Applied Discounts;
- persist Outstanding Amount;
- persist undocumented Aggregate state.

If additional persistent state appears necessary, implementation SHALL stop and request clarification.

---

# Persistent Representation Rules

Implementation SHALL ensure:

- `discountIdentifier` remains immutable after creation.
- `studentIdentifier` remains immutable after creation.
- `discountValue` is stored exactly as approved by the Aggregate.
- `approvalInformation` preserves the approved authority and approval details.
- `businessJustification` preserves the approved business justification.
- `active` accurately represents the approved Aggregate lifecycle.

The persisted state represents only the approved financial concession entitlement.

It SHALL NOT represent:

- financial application;
- settlement;
- outstanding balance; or
- applied financial effects.

---

# Technology Independence

This specification intentionally excludes:

- database schema;
- SQL data types;
- ORM mappings;
- framework annotations;
- repository implementation;
- indexes;
- vendor-specific persistence features.

These concerns belong to subsequent Technical Design documents.

---

# Traceability

| Persistent Field | Aggregate Technical Specification |
|------------------|-----------------------------------|
| discountIdentifier | Discount ATS |
| studentIdentifier | Discount ATS |
| discountValue | Discount ATS |
| approvalInformation | Discount ATS |
| businessJustification | Discount ATS |
| active | Discount ATS |

---

# Notes

This document represents the complete approved persistent representation of the Discount Aggregate.

Implementation SHALL faithfully realize this persistence model without:

- introducing undocumented persistent state;
- persisting financial effects;
- altering approved ownership boundaries;
- introducing alternative persistent representations.

The Discount Aggregate persists only the entitlement to a financial concession.

Application of that entitlement remains the responsibility of the Fee Obligation Aggregate.

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-10 | Initial Persistence Model. |
| 1.1.0 | 2026-07-13 | Aligned persistent state with Discount ATS. Added Persistent Representation Rules and clarified persistence contract. |
| 1.2.0 | 2026-07-15 | Aligned with RFC-007 and RFC-006. Clarified persistent ownership boundaries, reinforced that only concession entitlement is persisted, explicitly prohibited persistence of collaborating Aggregate state, and improved persistence contract wording. |

---

# Approval

**Status:** Approved