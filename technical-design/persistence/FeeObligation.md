# Fee Obligation Aggregate Persistence Model

```yaml
---
document_id: TD-FEEOBLIGATION-001
title: Fee Obligation Aggregate Persistence Model
version: 1.1.0
status: Draft

owner: Product Owner
reviewer: Chief Architect

created: 2026-07-10
last_updated: 2026-07-13

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

It specifies the complete persistent representation required to preserve the business truth owned by the Fee Obligation Aggregate.

This document is derived from the approved:

- Software Domain Model
- Aggregate Design
- Aggregate Technical Specification

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
- Outstanding Amount
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
| outstandingAmount | Monetary Amount | Yes | Yes | Remaining financial responsibility | Fee Obligation ATS |
| active | Boolean | Yes | Yes | Aggregate lifecycle state | Fee Obligation ATS |

---

# Derived State

None.

No persistent values are derived from other persisted state.

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

No persistent ownership of collaborating Aggregates is introduced.

---

# Persistence Constraints

Implementation SHALL preserve:

- Fee Obligation identity
- Student reference
- Academic Year reference
- Fee Structure reference
- Obligation Line collection
- Outstanding Amount
- lifecycle integrity
- Aggregate ownership

Implementation SHALL NOT:

- introduce additional persistent fields;
- remove approved persistent fields;
- rename approved persistent fields;
- change approved field types;
- change approved field mutability;
- persist derived state.

Outstanding Amount SHALL never become negative.

Obligation Lines SHALL NOT contain duplicate identifiers.

Obligation Lines SHALL NOT contain null entries.

If additional persistent state appears necessary, implementation SHALL stop and request clarification.

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
| outstandingAmount | Fee Obligation ATS |
| active | Fee Obligation ATS |

---

# Notes

This document represents the complete approved persistent representation of the Fee Obligation Aggregate.

Implementation SHALL faithfully realize this persistence model without:

- introducing undocumented persistent state;
- persisting derived information;
- altering approved ownership boundaries;
- introducing alternative persistent representations.

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-10 | Initial Persistence Model |
| 1.1.0 | 2026-07-13 | Aligned with ATS v1.1.0. Standardized field names, lifecycle representation, traceability, persistence constraints and ownership rules. |

# Approval

**Status:** Draft