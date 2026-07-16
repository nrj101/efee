# Payment Aggregate

```yaml
---
document_id: AGG-PAYMENT-001
title: Payment Aggregate
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

This document defines the architectural design of the **Payment Aggregate**.

It specifies the business ownership, responsibilities, invariants, lifecycle ownership and collaboration boundaries of the Payment Aggregate.

This document is part of the Aggregate Design package and SHALL be read together with **AggregateDesign.md**.

This document SHALL NOT introduce new business behaviour.

---

# Aggregate

## Responsibility

Owns the institutional record and lifecycle of Payments received by the institution.

---

## Owned Business Truth

* Payment identity
* Payment amount
* Payment lifecycle
* Payment evidence

---

## Supporting Entities

None.

---

## Primary Invariants

* Payment identity remains immutable.
* Payment amount remains immutable.
* Payment history shall remain permanently preserved.
* Only realised Payments may contribute to financial settlement.

---

## Allowed Operations

* Record Payment
* Realise Payment
* Cancel Payment (where permitted by business policy)

---

## Collaborating Aggregates

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
* RFC-001 — Financial Truth Model

---

# Notes

This document is a structural extraction from **AggregateDesign.md**.

No architectural decisions, responsibilities or business behaviour have been modified.

The authoritative Aggregate Design is collectively defined by **AggregateDesign.md** together with the individual Aggregate specification documents.

The Payment Aggregate owns only the institutional record of money received.

The financial effect of a Payment is realised by the **Fee Obligation Aggregate** through Payment Allocations. This preserves a single owner for the Student's financial responsibility while maintaining complete financial traceability.

---

# Version History

| Version | Date | Description |
|----------|------------|-------------|
| 1.0.0 | 2026-07-06 | Initial Aggregate Design. |
| 1.1.0 | 2026-07-15 | Aligned with RFC-001 Financial Truth Model. Clarified Aggregate ownership, removed Payment Allocation ownership, aligned lifecycle responsibilities with the approved Payment Aggregate Technical Specification, documented collaboration with the Fee Obligation Aggregate, and strengthened ownership of Payment identity, lifecycle and financial evidence. |

---

# Approval

**Status:** Approved

## Approved By

* Product Owner
* CTO

## Approval Date

2026-07-15