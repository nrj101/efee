# Discount Aggregate

```yaml
---
document_id: AGG-DISCOUNT-001
title: Discount Aggregate
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
  - ../../../spec/docs/rfc/RFC-002-Discount-Domain-Model.md
  - ../../spec/docs/rfc/RFC-006-Replace-Cross-Aggregate-Supporting-Entity-References-with-Stable-Identifiers.md
---
```

---

# Purpose

This document defines the architectural design of the **Discount Aggregate**.

It specifies the business ownership, responsibilities, business invariants, lifecycle ownership and collaboration boundaries of the Discount Aggregate.

This document forms part of the Aggregate Design package and SHALL be read together with **AggregateDesign.md**.

This document SHALL NOT introduce new business behaviour.

---

# Aggregate

## Responsibility

The Discount Aggregate owns the authorised financial concession entitlement granted to a Student.

It preserves the business entitlement to a financial concession while maintaining complete historical auditability.

The Discount Aggregate does not own the financial application of that entitlement.

Application of a Discount is realised only through the Fee Obligation Aggregate.

---

## Owned Business Truth

The Discount Aggregate owns:

- authorised Student Discount;
- approved concession value;
- approval information;
- business justification;
- Discount lifecycle.

Business truths owned by collaborating Aggregates remain outside the Aggregate boundary.

---

## Supporting Entities

None.

The Discount Aggregate intentionally contains no Supporting Entities in the MVP.

---

## Primary Invariants

- Every Discount belongs to exactly one Student.
- Every Discount preserves its approved concession value.
- Every Discount preserves its approval information.
- Every Discount preserves its business justification.
- Historical Discounts remain permanently preserved.
- Discount ownership never transfers to another Aggregate.

---

## Allowed Operations

- Grant Discount
- Update Discount
- Retire Discount

---

## Collaborating Aggregates

- Student
- Fee Obligation

The Student Aggregate owns Student identity.

The Fee Obligation Aggregate owns financial responsibility and determines the financial effect of an approved Discount.

The Discount Aggregate authorises financial concessions without assuming ownership of financial responsibility.

Collaborations occur only through Aggregate references.

---

## Repository

`DiscountRepository`

---

# Related Documents

- AggregateDesign.md
- SoftwareArchitecture.md
- SoftwareDomainModel.md
- RFC-007-Discount-Model-Simplification
- RFC-006-Replace-Cross-Aggregate-Supporting-Entity-References-with-Stable-Identifiers

---

# Notes

This document is a structural refinement of **AggregateDesign.md**.

No new business behaviour is introduced.

The Discount Aggregate preserves only the business entitlement to an authorised financial concession.

It intentionally excludes the financial application of that entitlement.

Applied Discounts remain part of the Fee Obligation Aggregate because they represent realised financial responsibility rather than concession entitlement.

The authoritative Aggregate Design is collectively defined by **AggregateDesign.md** together with the individual Aggregate specification documents.

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-06 | Initial Aggregate definition. |
| 1.1.0 | 2026-07-15 | Aligned with RFC-003 and RFC-006. Clarified Aggregate ownership, owned business truth, collaboration boundaries and distinction between concession entitlement and financial application. |

---

# Approval

**Status:** Approved