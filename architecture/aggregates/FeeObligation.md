# Fee Obligation Aggregate

```yaml
---
document_id: AGG-FEEOBLIGATION-001
title: Fee Obligation Aggregate
version: 1.1.0
status: Draft

owner: Product Owner
reviewer: CTO

created: 2026-07-06
last_updated: 2026-07-14

related_documents:
  - ../AggregateDesign.md
  - ../SoftwareArchitecture.md
  - ../../spec/docs/SoftwareDomainModel.md
  - ../../spec/docs/rfc/RFC-001-Financial-Truth-Model.md
---
```

---

# Purpose

This document defines the architectural design of the **Fee Obligation Aggregate**.

It specifies the business ownership, responsibilities, financial derivation model, business invariants, lifecycle ownership and collaboration boundaries of the Fee Obligation Aggregate.

This document forms part of the Aggregate Design package and SHALL be read together with **AggregateDesign.md**.

This document SHALL NOT introduce new business behaviour.

---

# Aggregate

## Responsibility

The Fee Obligation Aggregate owns the financial responsibility of a Student for a specific Academic Year.

It preserves the financial facts required to determine the Student's current financial position while maintaining complete historical auditability.

---

## Owned Business Truth

The Fee Obligation Aggregate owns:

- Student financial responsibility;
- Fee Obligation lifecycle;
- financial facts associated with the obligation.

Business truths owned by collaborating Aggregates remain outside the Aggregate boundary.

---

## Financial Position

The Fee Obligation Aggregate preserves the financial facts required to determine a Student's current financial responsibility.

Current financial position is derived from:

- Original Obligation Lines;
- Applied Discounts;
- Applied Payment Allocations.

The Aggregate may persist derived financial state for operational efficiency provided the persisted value remains fully reproducible from the preserved financial facts.

Derived financial state SHALL NOT become the authoritative business truth.

---

## Supporting Entities

- Obligation Line
- Applied Discount

---

## Primary Invariants

- Every Fee Obligation belongs to exactly one Student.
- Every Fee Obligation belongs to exactly one Academic Year.
- Every Fee Obligation is governed by exactly one Fee Structure.
- Current financial position shall always be derivable from preserved financial facts.
- Outstanding position shall never become negative.
- Financial history shall remain auditable.
- Historical financial facts shall never be silently modified.

---

## Allowed Operations

- Create Fee Obligation
- Apply Authorised Discount
- Record Payment Allocation
- Close Fee Obligation

---

## Collaborating Aggregates

- Student
- Academic Year
- Fee Structure
- Discount
- Payment

Each collaborating Aggregate preserves its own business truth.

The Fee Obligation Aggregate remains solely responsible for preserving the Student's financial responsibility.

---

## Repository

`FeeObligationRepository`

---

# Related Documents

- AggregateDesign.md
- SoftwareArchitecture.md
- SoftwareDomainModel.md
- RFC-001-Financial-Truth-Model.md

---

# Notes

This document is a structural refinement of **AggregateDesign.md**.

No new business behaviour is introduced.

The Aggregate derives its current financial position from preserved financial facts in accordance with **RFC-001 – Financial Truth Model**.

The authoritative Aggregate Design is collectively defined by **AggregateDesign.md** together with the individual Aggregate specification documents.

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-06 | Initial Aggregate definition. |
| 1.1.0 | 2026-07-14 | Aligned with RFC-001 Financial Truth Model. Clarified financial ownership, derived financial position, supporting entities and collaboration boundaries. |

---

# Approval

**Status:** Draft