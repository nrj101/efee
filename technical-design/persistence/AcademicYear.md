# Academic Year Aggregate Persistence Model

```yaml
---
document_id: TD-ACADEMICYEAR-001
title: Academic Year Aggregate Persistence Model
version: 1.0.0
status: Draft

owner: Product Owner
reviewer: Chief Architect

created: 2026-07-10
last_updated: 2026-07-10

related_documents:
  - ../../architecture/aggregates/AcademicYear.md
  - ../../architecture/technical-specification/aggregates/AcademicYear.md
  - ../../architecture/SoftwareArchitecture.md
  - ../../spec/docs/SoftwareDomainModel.md
---
```

---

# Purpose

This document defines the implementation-neutral persistence model for the **Academic Year Aggregate**.

It specifies the complete persistent state required to preserve the business truth owned by the Academic Year Aggregate.

This document is derived from the approved Software Domain Model, Software Architecture and Aggregate Technical Specification.

It SHALL NOT introduce new business behaviour or architectural responsibilities.

---

# Aggregate

**Academic Year**

---

# Aggregate Responsibility

Persist the information owned by the Academic Year Aggregate while preserving:

- Academic Year identity;
- Academic Year definition;
- Academic Year lifecycle.

Business truths owned by other Aggregates remain outside the scope of this document.

---

# Persistent State

The following Aggregate state is approved for persistence.

| Field | Type | Required | Mutable | Purpose | Source |
|--------|------|----------|----------|---------|--------|
| academicYearId | String | Yes | No | Unique Academic Year identifier. | Academic Year ATS |
| name | String | Yes | Yes | Academic Year name. | Academic Year ATS |
| startDate | LocalDate | Yes | Yes | Beginning of the Academic Year. | Academic Year ATS |
| endDate | LocalDate | Yes | Yes | End of the Academic Year. | Academic Year ATS |
| active | Boolean | Yes | Yes | Academic Year lifecycle state. | Academic Year ATS |

---

# Derived State

None.

---

# Transient State

None.

---

# Relationships

The Academic Year Aggregate maintains no persistent references to collaborating Aggregates.

Relationships are established by collaborating Aggregates that own those business truths.

---

# Persistence Constraints

The implementation SHALL preserve:

- Academic Year identity;
- Academic Year definition;
- Academic Year lifecycle;
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
| academicYearId | Academic Year Aggregate Technical Specification |
| name | Academic Year Aggregate Technical Specification |
| startDate | Academic Year Aggregate Technical Specification |
| endDate | Academic Year Aggregate Technical Specification |
| active | Academic Year Aggregate Technical Specification |

---

# Notes

This document represents the approved persistent representation of the Academic Year Aggregate.

Implementation SHALL faithfully realize this persistence model without introducing undocumented state or alternative representations.