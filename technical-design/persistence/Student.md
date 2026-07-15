# Student Aggregate Persistence Model

```yaml
---
document_id: TD-STUDENT-001
title: Student Aggregate Persistence Model
version: 1.2.0
status: Draft

owner: Product Owner
reviewer: Chief Architect

created: 2026-07-10
last_updated: 2026-07-15

related_documents:
  - ../../architecture/aggregates/Student.md
  - ../../technical-specification/aggregates/Student.md
  - ../../architecture/SoftwareArchitecture.md
  - ../../spec/docs/SoftwareDomainModel.md
---
```

---

# Purpose

This document defines the implementation-neutral persistence model for the **Student Aggregate**.

It specifies the complete persistent representation required to preserve the business truth owned by the Student Aggregate.

This document is derived from the approved:

- Software Domain Model
- Aggregate Design
- Aggregate Technical Specification

It SHALL NOT introduce new business behaviour, Aggregate responsibilities or implementation logic.

---

# Aggregate

**Student**

---

# Aggregate Responsibility

Persist the business truth owned by the Student Aggregate while preserving:

- Student identity
- Student information required by the financial domain
- Academic profile
- Student lifecycle

Business truths owned by collaborating Aggregates remain outside the scope of this document.

---

# Persistent State

The following Aggregate state is approved for persistence.

| Field | Type | Required | Mutable | Purpose | Source |
|--------|------|----------|----------|---------|--------|
| studentIdentifier | String | Yes | No | Internal immutable Student identifier | Student ATS |
| studentName | String | Yes | Yes | Student name | Student ATS |
| academicProfile | String | Yes | Yes | Academic profile maintained by the institution | Student ATS |
| active | Boolean | Yes | Yes | Student lifecycle state | Student ATS |

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

The Student Aggregate maintains no persistent references to collaborating Aggregates.

Relationships with:

- Academic Year
- Fee Obligation
- Discount
- Payment
- Receipt

are established by collaborating Aggregates while preserving Aggregate ownership boundaries.

---

# Persistence Constraints

Implementation SHALL preserve:

- Student identity
- Student information
- Academic profile
- Student lifecycle
- Aggregate ownership

Implementation SHALL NOT:

- introduce additional persistent fields;
- remove approved persistent fields;
- rename approved persistent fields;
- change approved field types;
- change approved field mutability;
- persist Fee Obligations;
- persist Payment information;
- persist Receipt information;
- persist Discount information;
- persist undocumented Aggregate state.

If additional persistent state appears necessary, implementation SHALL stop and request clarification.

---

# Persistent Representation Rules

Implementation SHALL ensure:

- `studentIdentifier` remains immutable after creation.
- `studentName` accurately reflects approved updates.
- `academicProfile` accurately reflects approved updates.
- `active` accurately represents the approved Student lifecycle.

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
| studentIdentifier | Student ATS |
| studentName | Student ATS |
| academicProfile | Student ATS |
| active | Student ATS |

---

# Notes

This document represents the complete approved persistent representation of the Student Aggregate.

Implementation SHALL faithfully realize this persistence model without:

- introducing undocumented persistent state;
- altering approved ownership boundaries;
- persisting business truths owned by collaborating Aggregates; or
- introducing alternative persistent representations.

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-10 | Initial Persistence Model. |
| 1.1.0 | 2026-07-14 | Expanded to align with the standardized Aggregate Persistence Model template. |
| 1.2.0 | 2026-07-15 | Reconciled with the approved Software Domain Model and Student Aggregate Technical Specification. Removed unapproved Admission Number and explicit lifecycle enumeration, restored Academic Profile, simplified lifecycle to Active/Inactive, and aligned the persistent representation with the Sprint-001 implementation baseline. |

---

# Approval

**Status:** Draft