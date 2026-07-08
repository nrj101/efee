# Fee Obligation Aggregate

```yaml
---
document_id: AGG-FEEOBLIGATION-001
title: Fee Obligation Aggregate
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

This document defines the architectural design of the **Fee Obligation Aggregate**.

It specifies the business ownership, responsibilities, invariants, lifecycle ownership and collaboration boundaries of the Fee Obligation Aggregate.

This document is part of the Aggregate Design package and SHALL be read together with **AggregateDesign.md**.

This document SHALL NOT introduce new business behaviour.

---

# Aggregate

## Responsibility

Owns a student's financial responsibility for an Academic Year.

---

## Owned Business Truth

* Fee Obligation lifecycle
* Outstanding financial responsibility
* Financial settlement state

---

## Supporting Entities

* Fee Obligation Line Item

---

## Primary Invariants

* Every Fee Obligation belongs to exactly one Student.
* Every Fee Obligation belongs to exactly one Academic Year.
* Outstanding balance shall never become negative.
* Financial history shall remain auditable.

---

## Allowed Operations

* Create Fee Obligation
* Apply Discount
* Allocate Payment
* Close Fee Obligation

---

## Collaborating Aggregates

* Student
* Academic Year
* Fee Structure
* Discount Policy
* Payment

---

## Repository

`FeeObligationRepository`

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
