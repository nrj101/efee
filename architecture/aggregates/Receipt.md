# Receipt Aggregate

```yaml
---
document_id: AGG-RECEIPT-001
title: Receipt Aggregate
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
  - ../../spec/docs/rfc/RFC-001-Financial-Truth-Model.md
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

Owns the official acknowledgement and lifecycle of accepted Payments.

---

## Owned Business Truth

* Receipt identity
* Receipt lifecycle
* Receipt evidence
* Payment acknowledgement

---

## Supporting Entities

None.

---

## Primary Invariants

* Every Receipt acknowledges exactly one accepted Payment.
* Receipt identity remains immutable.
* Receipt history shall remain permanently preserved.
* Receipt identifiers shall remain unique.

---

## Allowed Operations

* Issue Receipt
* Correct Receipt (where permitted by business policy)

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
* RFC-001 — Financial Truth Model

---

# Notes

This document is a structural extraction from **AggregateDesign.md**.

No architectural decisions, responsibilities or business behaviour have been modified.

The authoritative Aggregate Design is collectively defined by **AggregateDesign.md** together with the individual Aggregate specification documents.

The Receipt Aggregate owns the institution's official acknowledgement of an accepted Payment.

Receipt ownership is intentionally separated from Payment ownership. The Payment Aggregate preserves the financial evidence of money received, while the Receipt Aggregate preserves the institution's acknowledgement of that Payment. This separation maintains clear Aggregate ownership and supports complete financial auditability.

---

# Version History

| Version | Date | Description |
|----------|------------|-------------|
| 1.0.0 | 2026-07-06 | Initial Aggregate Design. |
| 1.1.0 | 2026-07-15 | Aligned with RFC-001 Financial Truth Model. Clarified Aggregate ownership, strengthened lifecycle and acknowledgement responsibilities, aligned operations with the approved Receipt Aggregate Technical Specification, and documented the separation between Payment evidence and Receipt acknowledgement. |

---

# Approval

**Status:** Approved

## Approved By

* Product Owner
* CTO

## Approval Date

2026-07-15