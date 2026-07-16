# Fee Structure Aggregate

```yaml
---
document_id: AGG-FEESTRUCTURE-001
title: Fee Structure Aggregate
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

This document defines the architectural design of the **Fee Structure Aggregate**.

It specifies the business ownership, responsibilities, invariants, lifecycle ownership and collaboration boundaries of the Fee Structure Aggregate.

This document is part of the Aggregate Design package and SHALL be read together with **AggregateDesign.md**.

This document SHALL NOT introduce new business behaviour.

---

# Aggregate

## Responsibility

Owns the institutional charging policy for an Academic Year.

---

## Owned Business Truth

* Fee Structure definition
* Fee Component composition

---

## Supporting Entities

* Fee Component

---

## Primary Invariants

* A Fee Structure consists of one or more Fee Components.
* Fee Components belong to exactly one Fee Structure.
* Historical Fee Structures remain immutable once used.

---

## Allowed Operations

* Create Fee Structure
* Add Fee Component
* Update Fee Structure
* Retire Fee Structure

---

## Collaborating Aggregates

* Academic Year
* Fee Obligation

---

## Repository

`FeeStructureRepository`

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