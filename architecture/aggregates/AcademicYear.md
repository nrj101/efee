# Academic Year Aggregate

```yaml
---
document_id: AGG-ACADEMICYEAR-001
title: Academic Year Aggregate
version: 1.0.0
status: Draft

owner: Product Owner
reviewer: CTO

created: 2026-07-06
last_updated: 2026-07-06

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

This document is part of the Aggregate Design package and SHALL be read together with **AggregateDesign.md**.

This document SHALL NOT introduce new business behaviour.

---

# Aggregate

## Responsibility

Owns the operational lifecycle of an Academic Year.

---

## Owned Business Truth

* Academic Year lifecycle
* Academic Year status

---

## Supporting Entities

None

---

## Primary Invariants

* Only one Academic Year may be active at any point in time.
* Closed Academic Years cannot accept new financial activity.
* Historical Academic Years remain immutable.

---

## Allowed Operations

* Create Academic Year
* Activate Academic Year
* Close Academic Year

---

## Collaborating Aggregates

* Student
* Fee Structure
* Fee Obligation

---

## Repository

`AcademicYearRepository`

---

# Related Documents

* AggregateDesign.md
* SoftwareArchitecture.md
* SoftwareDomainModel.md

---

# Notes

This document is a structural extraction from **AggregateDesign.md**.

No architectural decisions, responsibilities or business behaviour have been modified.

The authoritative Aggregate Design is collectively defined by **AggregateDesign.md** together with the individual Aggregate specification documents.
