# E-Fee Product & Engineering Specification

# Fee Obligation Management

```yaml
---
document_id: WF-FEEOBLIGATION-001
title: Fee Obligation Management
version: 1.1.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-07-06
last_updated: 2026-07-14
next_review: Upon approval of changes affecting Fee Obligations

related_documents:
  - ../BusinessWorkflow.md
  - ../BusinessRules.md
  - ../BusinessObjectGraph.md
  - ../SoftwareDomainModel.md
---
```

---

# Purpose

This document defines the business workflow governing the creation, maintenance and closure of Student Fee Obligations within the Student Fee Receivables Platform.

It describes how a Student's financial responsibility is established, maintained and ultimately settled while preserving complete financial auditability and explainability.

This document is part of the Business Workflow package and SHALL be read together with **BusinessWorkflow.md**.

This document defines business sequencing only.

All governing business rules remain defined by **BusinessRules.md**.

---

# Scope

## In Scope

This workflow covers:

- Fee Obligation creation
- Obligation Line creation
- Fee Obligation maintenance
- Financial event application
- Fee Obligation closure

## Out of Scope

This workflow intentionally excludes:

- Student registration
- Fee Structure preparation
- Payment collection
- Receipt generation
- Discount approval
- Financial corrections

---

# Business Capability

## Purpose

Create and maintain the financial responsibilities of Students throughout an Academic Year until final settlement or closure.

---

## Participants

- Accountant

---

## Trigger

A Student becomes financially responsible for one or more institutional charges.

---

## Preconditions

- Student has been registered.
- Academic Year is active.
- Applicable Fee Structure has been published.
- Applicable Fee Components have been identified.

---

## Workflow

1. Identify the applicable Fee Structure.
2. Create the Student Fee Obligation.
3. Create one or more Obligation Lines using the approved Fee Components.
4. Preserve the original financial responsibility.
5. Apply approved financial events such as Discounts and realised Payment Allocations throughout the lifecycle of the Fee Obligation.
6. Recalculate the Outstanding Balance from the current financial facts.
7. Close the Fee Obligation once all financial responsibilities have been settled or otherwise completed according to institutional policy.

---

## Outcome

- Student Fee Obligation established.
- Obligation Lines preserve the Student's financial responsibility.
- Outstanding Balance accurately reflects the current financial position.
- Complete financial history is preserved.
- Fee Obligation progresses through its approved lifecycle.

---

## Related Business Rules

This workflow is governed by the following approved Business Rules.

- BR-008 — Fee Obligations exist independently of Payments.
- BR-009 — Every Fee Obligation belongs to exactly one Student and one Academic Year.
- BR-010 — A Fee Obligation shall be itemized by one or more Fee Components.
- BR-011 — Outstanding Balance is derived from Original Amount, Approved Discounts and Settled Payments.
- BR-012 — Outstanding Balance shall never become negative.
- BR-031 — Every significant financial activity shall remain traceable.

---

# Related Documents

- BusinessRules.md
- BusinessObjectGraph.md
- SoftwareDomainModel.md
- BusinessWorkflow.md

---

# Notes

This document is a structural extraction from **BusinessWorkflow.md**.

No business behaviour, workflow intent or operational sequencing has been modified.

The authoritative Business Workflow specification is collectively defined by **BusinessWorkflow.md** together with the individual Business Capability workflow documents.

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-06 | Initial extraction from BusinessWorkflow.md. |
| 1.1.0 | 2026-07-14 | Aligned workflow with RFC-001 Financial Truth Model, clarified that Outstanding Balance is derived from financial facts, strengthened traceability to Business Rules, and updated terminology. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- CTO

## Approval Date

2026-07-06