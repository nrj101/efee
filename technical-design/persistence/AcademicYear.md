# Academic Year Aggregate Persistence Model

```yaml
---
document_id: TD-ACADEMICYEAR-001
title: Academic Year Aggregate Persistence Model
version: 1.1.0
status: Approved

owner: Product Owner
reviewer: Chief Architect

created: 2026-07-10
last_updated: 2026-07-14

related_documents:
  - ../../architecture/aggregates/AcademicYear.md
  - ../../technical-specification/aggregates/AcademicYear.md
  - ../../architecture/SoftwareArchitecture.md
  - ../../spec/docs/SoftwareDomainModel.md
---
```

---

# Purpose

This document defines the implementation-neutral persistence model for the **Academic Year Aggregate**.

It specifies the complete persistent representation required to preserve the business truth owned by the Academic Year Aggregate.

This document is derived from the approved:

- Software Domain Model
- Aggregate Design
- Aggregate Technical Specification

It SHALL NOT introduce new business behaviour, Aggregate responsibilities or implementation logic.

---

# Aggregate

**Academic Year**

---

# Aggregate Responsibility

Persist the business truth owned by the Academic Year Aggregate while preserving:

- Academic Year identity
- Academic Year reference
- Operational period
- Applicable Fee Structure reference
- Academic Year lifecycle

Business truths owned by collaborating Aggregates remain outside the scope of this document.

---

# Persistent State

The following Aggregate state is approved for persistence.

| Field | Type | Required | Mutable | Purpose | Source |
|--------|------|----------|----------|---------|--------|
| academicYearIdentifier | String | Yes | No | Internal immutable Academic Year identifier | Academic Year ATS |
| academicYearCode | String | Yes | No | Institution-defined Academic Year reference | Academic Year ATS |
| startDate | LocalDate | Yes | No | Beginning of the Academic Year | Academic Year ATS |
| endDate | LocalDate | Yes | No | End of the Academic Year | Academic Year ATS |
| feeStructureIdentifier | String | Yes | Yes | Applicable Fee Structure reference | Academic Year ATS |
| lifecycleState | Academic Year Lifecycle | Yes | Yes | Current Academic Year lifecycle | Academic Year ATS |

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

The Academic Year Aggregate persists references to collaborating Aggregates only where required.

| Aggregate | Persistent Reference |
|-----------|----------------------|
| Fee Structure | feeStructureIdentifier |

The Academic Year Aggregate SHALL NOT persist:

- Student information
- Fee Obligations
- Payments
- Receipts
- Discounts

These business truths remain owned by collaborating Aggregates.

---

# Persistence Constraints

Implementation SHALL preserve:

- Academic Year identity
- Academic Year reference
- Operational period
- Fee Structure association
- Academic Year lifecycle
- Aggregate ownership

Implementation SHALL NOT:

- introduce additional persistent fields;
- remove approved persistent fields;
- rename approved persistent fields;
- change approved field types;
- change approved field mutability;
- persist Student information;
- persist Fee Obligations;
- persist Payment information;
- persist Receipt information;
- persist Discount information;
- persist undocumented Aggregate state.

If additional persistent state appears necessary, implementation SHALL stop and request clarification.

---

# Persistent Representation Rules

Implementation SHALL ensure:

- `academicYearIdentifier` remains immutable after creation.
- `academicYearCode` remains immutable after creation.
- `startDate` and `endDate` preserve the approved operational period.
- `feeStructureIdentifier` references the currently approved Fee Structure for the Academic Year.
- `lifecycleState` accurately represents the approved Academic Year lifecycle.

Closed Academic Years remain permanently preserved.

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
| academicYearIdentifier | Academic Year ATS |
| academicYearCode | Academic Year ATS |
| startDate | Academic Year ATS |
| endDate | Academic Year ATS |
| feeStructureIdentifier | Academic Year ATS |
| lifecycleState | Academic Year ATS |

---

# Notes

This document represents the complete approved persistent representation of the Academic Year Aggregate.

Implementation SHALL faithfully realize this persistence model without:

- introducing undocumented persistent state;
- altering approved ownership boundaries;
- persisting business truths owned by collaborating Aggregates;
- introducing alternative persistent representations.

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-10 | Initial Persistence Model. |
| 1.1.0 | 2026-07-14 | Aligned with Academic Year ATS v1.1.0. Standardized field names, replaced boolean lifecycle with explicit lifecycle state, added Academic Year code and Fee Structure reference, introduced Persistent Representation Rules and strengthened ownership boundaries and traceability. |

---

# Approval

**Status:** Approved