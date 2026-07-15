# Student Aggregate

```yaml
---
document_id: AGG-STUDENT-001
title: Student Aggregate
version: 1.0.0
status: Approved

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

This document defines the architectural design of the **Student Aggregate**.

It specifies the business ownership, responsibilities, invariants, lifecycle ownership and collaboration boundaries of the Student Aggregate.

This document is part of the Aggregate Design package and SHALL be read together with **AggregateDesign.md**.

This document SHALL NOT introduce new business behaviour.

---

# Aggregate

## Responsibility

Owns the identity and academic enrollment of a student.

---

## Owned Business Truth

* Student identity
* Academic profile
* Student lifecycle

---

## Supporting Entities

None

---

## Primary Invariants

* Student identity is unique.
* Student lifecycle remains valid.
* Student identity cannot be duplicated.

---

## Allowed Operations

* Register Student
* Update Student Information
* Activate Student
* Deactivate Student

---

## Collaborating Aggregates

* Academic Year
* Fee Obligation
* Discount Policy

---

## Repository

`StudentRepository`

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

# Approval

**Status:** Approved