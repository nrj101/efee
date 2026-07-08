# Payment Aggregate

```yaml
---
document_id: AGG-PAYMENT-001
title: Payment Aggregate
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

This document defines the architectural design of the **Payment Aggregate**.

It specifies the business ownership, responsibilities, invariants, lifecycle ownership and collaboration boundaries of the Payment Aggregate.

This document is part of the Aggregate Design package and SHALL be read together with **AggregateDesign.md**.

This document SHALL NOT introduce new business behaviour.

---

# Aggregate

## Responsibility

Owns the recording of money received by the institution.

---

## Owned Business Truth

* Payment lifecycle
* Payment evidence

---

## Supporting Entities

None

---

## Primary Invariants

* A Payment represents money actually received.
* Payment history shall remain immutable.
* Payment allocations shall preserve financial integrity.

---

## Allowed Operations

* Record Payment
* Allocate Payment
* Reverse Payment (where permitted by business policy)

---

## Collaborating Aggregates

* Student
* Fee Obligation
* Receipt

---

## Repository

`PaymentRepository`

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
