# Academic Year Aggregate

```yaml
---
document_id: AGG-ACADEMICYEAR-001
title: Academic Year Aggregate
version: 1.1.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-07-06
last_updated: 2026-07-15

related_documents:
  - ../AggregateDesign.md
  - ../SoftwareArchitecture.md
  - ../../spec/docs/SoftwareDomainModel.md
---
```

---

# Purpose

This document defines the architectural design of the **Academic Year Aggregate**.

It specifies the business ownership, responsibilities, invariants, lifecycle ownership and collaboration boundaries of the Academic Year Aggregate.

This document forms part of the Aggregate Design package and SHALL be read together with **AggregateDesign.md**.

This document SHALL NOT introduce new business behaviour.

---

# Aggregate

## Responsibility

The Academic Year Aggregate owns the operational boundary within which institutional financial activity occurs.

It preserves the Academic Year lifecycle, operational period and the approved Fee Structure applicable to that Academic Year.

---

## Owned Business Truth

The Academic Year Aggregate owns:

- Academic Year identity
- Academic Year operational period
- Applicable Fee Structure reference
- Academic Year lifecycle

Business truths owned by collaborating Aggregates remain outside the Aggregate boundary.

---

## Supporting Entities

None.

The Academic Year Aggregate intentionally contains no supporting Entities in the MVP.

---

## Primary Invariants

- Only one Academic Year may be Active at any point in time.
- Every Academic Year defines a single operational period.
- Every Academic Year references at most one applicable Fee Structure at a time.
- Closed Academic Years cannot accept new financial activity.
- Historical Academic Years remain immutable.

---

## Lifecycle

The Academic Year Aggregate supports the following lifecycle.

```text
Planned
    │
    ▼
Active
    │
    ▼
Closed
```

Lifecycle transitions are irreversible.

Closed Academic Years remain permanently preserved.

---

## Allowed Operations

- Create Academic Year
- Assign Fee Structure
- Activate Academic Year
- Close Academic Year

---

## Collaborating Aggregates

- Student
- Fee Structure
- Fee Obligation

The Academic Year Aggregate owns only the reference to the applicable Fee Structure.

The Fee Structure Aggregate remains the owner of the Fee Structure definition.

---

## Repository

`AcademicYearRepository`

---

# Related Documents

- AggregateDesign.md
- SoftwareArchitecture.md
- SoftwareDomainModel.md

---

# Notes

This document is a structural refinement of **AggregateDesign.md**.

No new business behaviour is introduced.

The Academic Year Aggregate defines the operational boundary within which institutional financial activity occurs.

The authoritative Aggregate Design is collectively defined by **AggregateDesign.md** together with the individual Aggregate specification documents.

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-06 | Initial Aggregate definition. |
| 1.1.0 | 2026-07-15 | Clarified owned business truth, explicitly defined the Planned → Active → Closed lifecycle, introduced ownership of the applicable Fee Structure reference, and aligned the Aggregate Design with the approved Software Domain Model and Technical Specification. |

---

# Approval

**Status:** Approved