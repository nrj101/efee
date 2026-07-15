# E-Fee Product & Engineering Specification

# Payment Management

```yaml
---
document_id: WF-PAYMENT-001
title: Payment Management
version: 1.1.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-07-06
last_updated: 2026-07-14
next_review: Upon approval of changes affecting Payment processing

related_documents:
  - ../BusinessWorkflow.md
  - ../BusinessRules.md
  - ../BusinessObjectGraph.md
  - ../SoftwareDomainModel.md
---
```

---

# Purpose

This document defines the business workflow governing the receipt, realisation, allocation and recording of Payments within the Student Fee Receivables Platform.

It describes how money received by the institution is recorded, validated, realised and allocated while preserving complete financial correctness and auditability.

This document is part of the Business Workflow package and SHALL be read together with **BusinessWorkflow.md**.

This document defines business sequencing only.

All governing business rules remain defined by **BusinessRules.md**.

---

# Scope

## In Scope

This workflow covers:

- Payment receipt
- Payment recording
- Payment realisation
- Payment allocation
- Partial settlement
- Multi-obligation settlement
- Payment history preservation

## Out of Scope

This workflow intentionally excludes:

- Student registration
- Fee Structure preparation
- Discount approval
- Receipt generation
- Financial corrections

---

# Business Capability

## Purpose

Record money received by the institution and allocate realised Payments to one or more outstanding Fee Obligations while preserving financial correctness and auditability.

---

## Participants

- Accountant
- Student (or Payer)

---

## Trigger

The institution receives a Payment intended to settle one or more Student Fee Obligations.

---

## Preconditions

- Student has one or more outstanding Fee Obligations.
- Payment details have been verified.
- Institutional payment acceptance procedures have been completed.

---

## Workflow

### Record Payment

1. Receive the Payment from the payer.
2. Verify the Payment details.
3. Record the Payment.
4. Preserve the Payment as permanent financial history.

### Realise Payment

1. Verify that the Payment has been successfully realised according to the payment method.
2. Mark the Payment as realised.

### Allocate Payment

1. Identify the Fee Obligations to be settled.
2. Allocate the realised Payment across one or more Fee Obligations.
3. Support both full and partial settlements where required.
4. Recalculate the Outstanding Balance of the affected Fee Obligations.
5. Preserve the Payment Allocation history for future auditability.

---

## Outcome

- Payment has been recorded.
- Realised Payment has been allocated.
- Fee Obligations reflect the updated financial position.
- Complete Payment and Payment Allocation history has been preserved.

---

## Related Business Rules

This workflow is governed by the following approved Business Rules.

- BR-013 — A Payment represents a payer's intention to settle one or more Fee Obligations.
- BR-014 — Payment Allocation shall occur only after the Payment has been realised.
- BR-015 — One realised Payment may settle multiple Fee Obligations, Fee Components or Students where permitted.
- BR-016 — The sum of all Payment Allocations shall exactly equal the realised Payment amount.
- BR-017 — No Payment Allocation may allocate more than the outstanding amount of the corresponding Fee Obligation.
- BR-018 — Allocation priority may follow parent preference or institutional policy.
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
| 1.1.0 | 2026-07-14 | Clarified Payment lifecycle, separated Payment from Payment Allocation, aligned workflow with Financial Truth Model and strengthened Business Rule traceability. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- CTO

## Approval Date

2026-07-06