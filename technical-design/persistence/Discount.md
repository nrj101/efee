# Discount Aggregate Persistence Model

```yaml
---
document_id: TD-DISCOUNT-001
title: Discount Aggregate Persistence Model
version: 1.0.0
status: Draft

owner: Product Owner
reviewer: Chief Architect

created: 2026-07-10
last_updated: 2026-07-10

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
- Discount eligibility;
- Reduction rules;
- Applicable Fee Components;
- Discount lifecycle.

Business truths owned by other Aggregates remain outside the scope of this document.

---

# Persistent State

The following Aggregate state is approved for persistence.

| Field | Type | Required | Mutable | Purpose | Source |
|--------|------|----------|----------|---------|--------|
| discountId | String | Yes | No | Unique Discount identifier. | Discount ATS |
| eligibility | String | Yes | Yes | Defines who is eligible for the Discount. | Discount ATS |
| reductionRule | String | Yes | Yes | Defines the approved financial reduction. | Discount ATS |
| applicableFeeComponents | List<String> | Yes | Yes | Fee Components to which the Discount applies. | Discount ATS |
| status | String | Yes | Yes | Discount lifecycle state. | Discount ATS |

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

---

# Persistence Constraints

The implementation SHALL preserve:

- Discount identity;
- Discount eligibility;
- Reduction rules;
- Applicable Fee Components;
- Discount lifecycle;
- Aggregate ownership.

The implementation SHALL NOT:

- introduce additional persistent fields;
- remove approved persistent fields;
- rename approved persistent fields;
- change approved field types;
- change approved field mutability.

If additional persistent state appears necessary, implementation SHALL stop and request clarification.

---

# Technology Independence

This document intentionally excludes:

- database schema;
- SQL data types;
- ORM mappings;
- framework annotations;
- indexes;
- constraints specific to any persistence technology.

These concerns belong to subsequent Technical Design documents.

---

# Traceability

| Persistent Field | Traceability |
|------------------|--------------|
| discountId | Discount Aggregate Technical Specification |
| eligibility | Discount Aggregate Technical Specification |
| reductionRule | Discount Aggregate Technical Specification |
| applicableFeeComponents | Discount Aggregate Technical Specification |
| status | Discount Aggregate Technical Specification |

---

# Notes

This document represents the approved persistent representation of the Discount Aggregate.

Implementation SHALL faithfully realize this persistence model without introducing undocumented state or alternative representations.