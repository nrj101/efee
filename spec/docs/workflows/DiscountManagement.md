# E-Fee Product & Engineering Specification

# Discount Management

```yaml
---
document_id: WF-DISCOUNT-001
title: Discount Management
version: 1.0.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-07-06
last_updated: 2026-07-06
next_review: Upon approval of changes affecting Discount management

related_documents:
  - ../BusinessWorkflow.md
  - ../BusinessRules.md
  - ../BusinessObjectGraph.md
  - ../SoftwareDomainModel.md
---
```

---

# Purpose

This document defines the business workflow governing the approval, application and management of Discounts within the Student Fee Receivables Platform.

It describes how discounts, waivers, scholarships etc. are granted while preserving institutional policy, financial correctness and complete auditability.

This document is part of the Business Workflow package and SHALL be read together with **BusinessWorkflow.md**.

---

# Scope

## In Scope

This workflow covers:

- Discount approval
- Discount application
- Discount recording
- Discount history preservation

## Out of Scope

This workflow intentionally excludes:

- Student registration
- Fee policy preparation
- Payment processing
- Receipt generation
- Financial corrections

---

# Business Capability

## Purpose

Apply granted discounts to Student's Fee Obligations while preserving institutional policy and historical auditability.

---

## Participants

- Accountant
- Principal
- Manager

---

## Trigger

An authorised request for financial concession (discount) is received.

---

## Preconditions

- Student Fee Obligation exists.
- Discount request has been reviewed.
- Institutional approval requirements have been satisfied.

---

## Workflow

1. Receive the Discount request.
2. Review the justification.
3. Obtain the required approvals.
4. Apply the approved Discount.
5. Update the affected Fee Obligation.
6. Preserve the Discount as permanent financial history.

---

## Outcome

- Approved Discount applied.
- Outstanding financial responsibility updated.
- Complete Discount history preserved.

---

## Related Business Rules

- Discounts require institutional approval.
- Discounts reduce approved Fee Obligations only.
- Discount history shall remain immutable.
- Financial auditability shall always be preserved.

---

# Related Documents

- BusinessRules.md
- BusinessObjectGraph.md
- SoftwareDomainModel.md
- BusinessWorkflow.md

---

# Notes

This document is a structural extraction from **BusinessWorkflow.md**.

No business behaviour, workflow, business rules or operational intent have been modified.

The authoritative Business Workflow specification is collectively defined by **BusinessWorkflow.md** together with the individual Business Capability workflow documents.

---

# Version History

| Version | Date | Description |
|---------|------|-------------|
| 1.0.0 | 2026-07-06 | Initial extraction from BusinessWorkflow.md. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- CTO

## Approval Date

2026-07-06