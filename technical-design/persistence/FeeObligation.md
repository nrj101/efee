# Fee Obligation Aggregate Persistence Model

```yaml
---
document_id: TD-FEEOBLIGATION-001
title: Fee Obligation Aggregate Persistence Model
version: 1.0.0
status: Draft

owner: Product Owner
reviewer: Chief Architect

created: 2026-07-10
last_updated: 2026-07-10

related_documents:
  - ../../architecture/aggregates/FeeObligation.md
  - ../../architecture/technical-specification/aggregates/FeeObligation.md
  - ../../architecture/SoftwareArchitecture.md
  - ../../spec/docs/SoftwareDomainModel.md
---
```

---

# Purpose

This document defines the implementation-neutral persistence model for the **Fee Obligation Aggregate**.

It specifies the complete persistent state required to preserve the business truth owned by the Fee Obligation Aggregate.

This document is derived from the approved Software Domain Model, Software Architecture and Aggregate Technical Specification.

It SHALL NOT introduce new business behaviour or architectural responsibilities.

---

# Aggregate

**Fee Obligation**

---

# Aggregate Responsibility

Persist the information owned by the Fee Obligation Aggregate while preserving:

- Student financial responsibility;
- governing Academic Year;
- governing Fee Structure;
- Obligation Line collection;
- Outstanding Amount;
- Fee Obligation lifecycle.

Business truths owned by other Aggregates remain outside the scope of this document.

---

# Persistent State

| Field | Type | Required | Mutable | Purpose | Source |
|--------|------|----------|----------|---------|--------|
| feeObligationId | String | Yes | No | Unique Fee Obligation identifier. | Fee Obligation ATS |
| studentId | String | Yes | No | References the owning Student. | Fee Obligation ATS |
| academicYearId | String | Yes | No | References the governing Academic Year. | Fee Obligation ATS |
| feeStructureId | String | Yes | No | References the governing Fee Structure. | Fee Obligation ATS |
| obligationLines | List<ObligationLine> | Yes | Yes | Collection of financial obligations. | Fee Obligation ATS |
| outstandingAmount | BigDecimal | Yes | Yes | Current outstanding financial responsibility. | Fee Obligation ATS |
| status | String | Yes | Yes | Fee Obligation lifecycle state. | Fee Obligation ATS |

---

# Derived State

None.

---

# Transient State

None.

---

# Relationships

The Fee Obligation Aggregate persists references to collaborating Aggregates through their identifiers.

| Aggregate | Reference |
|-----------|-----------|
| Student | studentId |
| Academic Year | academicYearId |
| Fee Structure | feeStructureId |

These references preserve Aggregate ownership boundaries.

---

# Persistence Constraints

The implementation SHALL preserve:

- Fee Obligation identity;
- Student ownership;
- Academic Year ownership;
- Fee Structure ownership;
- Outstanding Amount;
- Obligation Line collection;
- lifecycle integrity;
- Aggregate ownership.

The implementation SHALL NOT:

- introduce additional persistent fields;
- remove approved persistent fields;
- rename approved persistent fields;
- change approved field types;
- change approved field mutability.

Outstanding Amount SHALL never become negative.

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
| feeObligationId | Fee Obligation Aggregate Technical Specification |
| studentId | Fee Obligation Aggregate Technical Specification |
| academicYearId | Fee Obligation Aggregate Technical Specification |
| feeStructureId | Fee Obligation Aggregate Technical Specification |
| obligationLines | Fee Obligation Aggregate Technical Specification |
| outstandingAmount | Fee Obligation Aggregate Technical Specification |
| status | Fee Obligation Aggregate Technical Specification |

---

# Notes

This document represents the approved persistent representation of the Fee Obligation Aggregate.

Implementation SHALL faithfully realize this persistence model without introducing undocumented state or alternative representations.