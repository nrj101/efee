# E-Fee Product & Engineering Specification

# Discount Management

```yaml
---
document_id: WF-DISCOUNT-001
title: Discount Management
version: 1.1.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-07-06
last_updated: 2026-07-14
next_review: Upon approval of changes affecting Discount Management

related_documents:
  - ../BusinessWorkflow.md
  - ../BusinessRules.md
  - ../BusinessObjectGraph.md
  - ../SoftwareDomainModel.md
---
```

---

# Purpose

This document defines the business workflow governing the approval, application and lifecycle management of Discounts within the Student Fee Receivables Platform.

It describes how authorised financial concessions are granted to students while preserving financial integrity, institutional approval requirements and complete auditability.

This document is part of the Business Workflow package and SHALL be read together with **BusinessWorkflow.md**.

This document defines business sequencing only.

All governing business rules remain defined by **BusinessRules.md**.

---

# Scope

## In Scope

This workflow covers:

- Discount request
- Discount review
- Discount approval
- Discount application
- Discount lifecycle management
- Discount history preservation

## Out of Scope

This workflow intentionally excludes:

- Student registration
- Fee Structure preparation
- Payment processing
- Receipt generation
- Financial corrections

---

# Business Capability

## Purpose

Grant authorised financial concessions to Students while preserving institutional approval requirements, financial correctness and historical auditability.

---

## Participants

- Accountant
- Principal
- Manager

---

## Trigger

An authorised request for a financial concession is received.

---

## Preconditions

- Student Fee Obligation exists.
- Discount request has been reviewed.
- Institutional approval requirements have been satisfied.

---

## Workflow

1. Receive the Discount request.
2. Review the supporting justification.
3. Verify student eligibility where applicable.
4. Obtain the required approvals.
5. Create the approved Discount.
6. Apply the Discount to the applicable Fee Obligation.
7. Recalculate the outstanding financial responsibility.
8. Preserve the Discount as permanent financial history.

---

## Outcome

- Discount has been approved and recorded.
- Applicable Fee Obligation reflects the approved financial concession.
- Outstanding financial responsibility has been updated.
- Complete Discount history has been preserved for audit purposes.

---

## Related Business Rules

This workflow is governed by the following approved Business Rules.

- BR-022 — Discounts are granted to eligible Students.
- BR-023 — Every Discount records its reason, approving authority and supporting comments.
- BR-024 — Historical financial information shall never be silently modified.
- BR-031 — Every significant financial activity shall remain traceable.
- BR-032 — Every significant financial change shall identify what changed, when, who performed it and who approved it where applicable.

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
| 1.1.0 | 2026-07-14 | Simplified workflow to align with the MVP Discount model, strengthened Business Rule traceability, clarified workflow sequencing and removed obsolete policy terminology. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- CTO

## Approval Date

2026-07-06