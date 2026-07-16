# E-Fee Product & Engineering Specification

# Fee Policy Management

```yaml
---
document_id: WF-FEEPOLICY-001
title: Fee Policy Management
version: 1.1.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-07-06
last_updated: 2026-07-14
next_review: Upon approval of changes affecting Academic Years or Fee Structures

related_documents:
  - ../BusinessWorkflow.md
  - ../BusinessRules.md
  - ../BusinessObjectGraph.md
  - ../SoftwareDomainModel.md
---
```

---

# Purpose

This document defines the business workflow governing the preparation of an Academic Year and the establishment of institutional Fee Structures.

It describes how the institution prepares the operational and financial environment before any Student financial activity occurs.

This document is part of the Business Workflow package and SHALL be read together with **BusinessWorkflow.md**.

This document defines business sequencing only.

All governing business rules remain defined by **BusinessRules.md**.

---

# Scope

## In Scope

This workflow covers:

- Academic Year preparation
- Academic Year activation
- Fee Structure preparation
- Fee Component definition
- Fee Structure approval and publication

## Out of Scope

This workflow intentionally excludes:

- Student registration
- Fee Obligation creation
- Payment processing
- Discount management
- Financial corrections

---

# Business Capability

## Purpose

Prepare the institution's operational and financial policies before student financial activities begin.

---

## Participants

- Principal
- Manager
- Accountant

---

## Trigger

Preparation of an Academic Year before operational activities begin.

---

## Preconditions

- The upcoming Academic Year has been approved.
- Proposed Fee Structures have been prepared for review.
- Fee Components have been identified.

---

## Workflow

### Academic Year Preparation

1. Create the new Academic Year.
2. Verify the Academic Year details.
3. Approve the Academic Year for operational use.
4. Activate the Academic Year.

### Fee Structure Preparation

1. Define the Fee Structure for the Academic Year.
2. Configure the applicable Fee Components.
3. Review the proposed Fee Structure.
4. Approve the Fee Structure.
5. Publish the approved Fee Structure for operational use.

---

## Outcome

- Academic Year is operational.
- Approved Fee Structure is published and available for future Fee Obligation creation.
- Fee Components are available for creating Student Fee Obligations.

---

## Related Business Rules

This workflow is governed by the following approved Business Rules.

- BR-001 — An Academic Year governs all Fee Obligations created for that academic session.
- BR-006 — A Fee Structure defines the standard charging policy for a group of students.
- BR-007 — Changes to a Fee Structure shall not retroactively modify existing Fee Obligations.

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
| 1.1.0 | 2026-07-14 | Aligned terminology with Fee Structure, removed undocumented business rules, strengthened traceability to Business Rules, and clarified workflow scope. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- CTO

## Approval Date

2026-07-06