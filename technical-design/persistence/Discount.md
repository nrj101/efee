# Discount Aggregate Persistence Model

```yaml
---
document_id: TD-DISCOUNT-001
title: Discount Aggregate Persistence Model
version: 1.1.0
status: Draft

owner: Product Owner
reviewer: Chief Architect

created: 2026-07-10
last_updated: 2026-07-13

related_documents:
  - ../../architecture/aggregates/Discount.md
  - ../../architecture/technical-specification/aggregates/Discount.md
  - ../../architecture/SoftwareArchitecture.md
  - ../../spec/docs/SoftwareDomainModel.md
---
```

---

# Purpose

This document defines the implementation-neutral persistence model for the **Discount Aggregate**.

It specifies the complete persistent state required to preserve the business truth owned by the Discount Aggregate.

This document is derived from the approved Software Domain Model, Software Architecture and Aggregate Technical Specification.

It SHALL NOT introduce new business behaviour or architectural responsibilities.

---

# Aggregate

**Discount**

---

# Aggregate Responsibility

Persist the information owned by the Discount Aggregate while preserving:

- Discount identity;
- Student entitlement;
- Applicable Fee Components;
- Discount value;
- Discount lifecycle.

Business truths owned by other Aggregates remain outside the scope of this document.

---

# Persistent State

The following Aggregate state is approved for persistence.

| Field | Type | Required | Mutable | Purpose | Source |
|--------|------|----------|----------|---------|--------|
| discountIdentifier | String | Yes | No | Unique Discount identifier. | Discount ATS |
| studentIdentifier | String | Yes | No | Student receiving the Discount. | Discount ATS |
| applicableFeeComponents | List<FeeComponent> | Yes | Yes | Fee Components eligible for the Discount. | Discount ATS |
| discountValue | Monetary Amount | Yes | Yes | Approved Discount value. | Discount ATS |
| active | Boolean | Yes | Yes | Discount lifecycle state. | Discount ATS |

No additional persistent state is approved.

---

# Derived State

None.

---

# Transient State

None.

---

# Relationships

The Discount Aggregate maintains no persistent references to collaborating Aggregates.

Relationships are established by collaborating Aggregates that own those business truths.

The Discount Aggregate owns only its own persistent state.

---

# Persistence Constraints

Implementation SHALL preserve:

- Discount identity;
- Student entitlement;
- Applicable Fee Components;
- Discount value;
- Discount lifecycle;
- Aggregate ownership.

Implementation SHALL NOT:

- introduce additional persistent fields;
- remove approved persistent fields;
- rename approved persistent fields;
- change approved field types;
- change approved field mutability;
- persist undocumented Aggregate state.

If additional persistent state appears necessary, implementation SHALL stop and request clarification.

---

# Persistent Representation Rules

Implementation SHALL ensure:

- `discountIdentifier` remains immutable after creation.
- `studentIdentifier` remains immutable after creation.
- `applicableFeeComponents` contains only approved Fee Components.
- `discountValue` is stored exactly as approved by the Aggregate.
- `active` represents the approved lifecycle state.

No additional persistence rules are approved.

---

# Technology Independence

This document intentionally excludes:

- database schema;
- SQL data types;
- ORM mappings;
- framework annotations;
- indexes;
- vendor-specific persistence features.

These concerns belong to subsequent Technical Design documents.

---

# Traceability

| Persistent Field | Traceability |
|------------------|--------------|
| discountIdentifier | Discount Aggregate Technical Specification |
| studentIdentifier | Discount Aggregate Technical Specification |
| applicableFeeComponents | Discount Aggregate Technical Specification |
| discountValue | Discount Aggregate Technical Specification |
| active | Discount Aggregate Technical Specification |

---

# Notes

This document represents the approved persistent representation of the Discount Aggregate.

Implementation SHALL faithfully realize this persistence model without introducing undocumented state, undocumented persistence fields or alternative representations.

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-10 | Initial Persistence Model. |
| 1.1.0 | 2026-07-13 | Aligned persistent state with Discount ATS. Added Persistent Representation Rules, clarified persistence contract, and prohibited undocumented persistent state. |

---

# Approval

**Status:** Draft