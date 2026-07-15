# Receipt Aggregate

```yaml
---
document_id: AGG-RECEIPT-001
title: Receipt Aggregate
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

This document defines the architectural design of the **Receipt Aggregate**.

It specifies the business ownership, responsibilities, invariants, lifecycle ownership and collaboration boundaries of the Receipt Aggregate.

This document is part of the Aggregate Design package and SHALL be read together with **AggregateDesign.md**.

This document SHALL NOT introduce new business behaviour.

---

# Aggregate

## Responsibility

Owns the official acknowledgement of accepted Payments.

---

## Owned Business Truth

* Receipt lifecycle
* Receipt identity
* Financial acknowledgement

---

## Supporting Entities

None

---

## Primary Invariants

* Every Receipt acknowledges exactly one accepted Payment.
* Receipt history shall remain immutable.
* Receipt identifiers shall remain unique.

---

## Allowed Operations

* Generate Receipt
* Reissue Receipt (where permitted)
* Void Receipt (where permitted by business policy)

---

## Collaborating Aggregates

* Payment

---

## Repository

`ReceiptRepository`

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