# Discount Policy Aggregate

```yaml
---
document_id: AGG-DISCOUNT-001
title: Discount Aggregate
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

This document defines the architectural design of the **Discount Aggregate**.

It specifies the business ownership, responsibilities, invariants, lifecycle ownership and collaboration boundaries of the Discount Aggregate.

This document is part of the Aggregate Design package and SHALL be read together with **AggregateDesign.md**.

This document SHALL NOT introduce new business behaviour.

---

# Aggregate

## Responsibility

Owns the lifecycle of approved financial concessions granted to students.

---

## Owned Business Truth

* Discount eligibility
* Granted Discount lifecycle

---

## Supporting Entities

None

---

## Primary Invariants

* Discounts require approval according to institutional policy.
* Granted Discounts preserve financial auditability.
* Historical Discounts remain immutable.

---

## Allowed Operations

* Grant Discount
* Update Discount
* Cancel Discount

---

## Collaborating Aggregates

* Student
* Fee Obligation

---

## Repository

`DiscountRepository`

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
