# E-Fee Product & Engineering Specification

# Fee Policy Management

```yaml
---
document_id: WF-FEEPOLICY-001
title: Fee Policy Management
version: 1.0.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-07-06
last_updated: 2026-07-06
next_review: Upon approval of changes affecting Academic Years or Fee Policies

related_documents:
  - ../BusinessWorkflow.md
  - ../BusinessRules.md
  - ../BusinessObjectGraph.md
  - ../SoftwareDomainModel.md
---
```

---

# Purpose

This document defines the business workflow governing the preparation of an Academic Year and the establishment of institutional Fee Policies.

It describes how the institution prepares the operational environment before any Student financial activity occurs.

This document is part of the Business Workflow package and SHALL be read together with **BusinessWorkflow.md**.

---

# Scope

## In Scope

This workflow covers:

- Academic Year preparation
- Academic Year activation
- Fee Structure preparation
- Fee Component definition
- Fee Policy approval

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

Preparation for a new Academic Year.

---

## Preconditions

- The upcoming Academic Year has been approved.
- Institutional Fee Policies are available for review.
- Fee Components have been identified.

---

## Workflow

### Academic Year Preparation

1. Create the new Academic Year.
2. Verify the Academic Year details.
3. Approve the Academic Year for operational use.
4. Activate the Academic Year.

### Fee Policy Preparation

1. Define the Fee Structure for the Academic Year.
2. Configure the applicable Fee Components.
3. Review the proposed Fee Policy.
4. Approve the Fee Policy.
5. Publish the approved Fee Structure for operational use.

---

## Outcome

- Academic Year is operational.
- Approved Fee Structure is available.
- Fee Components are available for creating Student Fee Obligations.

---

## Related Business Rules

- Only one Academic Year may be active at any point in time.
- Approved Fee Policies govern Student Fee Obligations.
- Historical Fee Policies remain preserved for auditability.

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
|----------|------|-------------|
| 1.0.0 | 2026-07-06 | Initial extraction from BusinessWorkflow.md. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- CTO

## Approval Date

2026-07-06