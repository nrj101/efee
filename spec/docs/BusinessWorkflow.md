# E-Fee Product & Engineering Specification

## Business Workflow

```yaml
---
document_id: WORKFLOW-001
title: Business Workflow
version: 1.0.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-06-29
last_updated: 2026-06-29
next_review: Before MVP Implementation

related_documents:
  - UserPersonas.md
  - DomainGlossary.md
  - BusinessRules.md
---
```

---

## Purpose

This document describes how educational institutions manage student fee receivables using E-Fee.

It focuses on business activities performed by users rather than software implementation.

The objective is to establish a shared understanding of the operational workflow before defining business objects, architecture or implementation.

---

## Scope

This document describes the operational lifecycle of fee receivables from the beginning of an academic year until final settlement.

It does **not** define detailed business rules, data structures or implementation behaviour.

---

# Workflow Overview

The institution manages fee receivables through a sequence of business activities.

Each activity represents a meaningful business event that contributes to the complete financial history of a student's academic year.

---

# Academic Year Setup

Before fee collection begins, the institution prepares the academic session.

Activities include:

* Create the academic year.
* Define fee structures.
* Register students.
* Associate students with the academic year.
* Generate the expected fee obligations for each student.

At this point, no money has been collected.

Only financial obligations exist.

---

# Fee Collection

When a parent visits the institution, the accountant records the payment.

The institution may receive payment through:

* Cash
* UPI
* Other approved offline methods

A handwritten receipt is issued according to the institution's existing operational practice.

The receipt number is recorded within E-Fee.

One payment may settle:

* One fee obligation
* Multiple fee obligations
* Multiple fee categories
* Multiple students (for example, siblings)

---

# Payment Allocation

After recording a payment, the institution determines how the received amount should be applied.

Allocation follows either:

* The parent's requested priority, or
* The institution's default priority when no preference is provided.

Every allocated amount contributes towards reducing one or more outstanding fee obligations.

No allocated amount may exceed the outstanding balance of the corresponding obligation.

---

# Discounts and Waivers

Exceptional situations may require fee concessions.

The institution may:

* Waive part of a fee.
* Waive an entire fee.
* Record supporting comments.
* Capture the approving authority.

Discounts reduce the outstanding amount owed by the student while preserving a complete financial history.

---

# Corrections

Mistakes occasionally occur.

Instead of modifying historical financial information, corrections should preserve the original business events whenever practical.

Corrections require appropriate approval before taking effect.

The institution should always be able to explain:

* What changed.
* Why it changed.
* Who approved the change.
* When the change occurred.

---

# Reporting

Throughout the academic year, the institution monitors fee receivables.

Typical reporting activities include:

* Outstanding balances
* Student fee history
* Daily collections
* Defaulters
* Discounts granted
* Pending approvals

Reports should always reflect the current financial position while remaining traceable to historical business events.

---

# Student Exit

A student may leave the institution before the academic year ends.

The student's historical financial information remains permanently available.

The student becomes inactive for operational purposes.

No historical financial information is removed.

---

# Academic Year Closure

At the end of the academic year, active fee collection for that year concludes.

Remaining unsettled obligations are consolidated into a final settlement obligation for each student.

This provides a complete and auditable summary of the student's financial position for the completed academic year.

Closed academic years become read-only.

No further operational changes are permitted.

---

# Business Workflow Principles

The workflow should always preserve the following principles.

* Financial history is preserved.
* Business events remain traceable.
* Corrections are transparent.
* Financial reporting remains reliable.
* Business operations remain understandable.

---

## Key Decisions

* Business activities are documented before software behaviour.
* Historical financial information is never removed.
* Corrections preserve history rather than replacing it.
* Closed academic years become immutable.
* The workflow represents business operations independent of technology.

---

## Related Documents

* UserPersonas.md
* DomainGlossary.md
* BusinessRules.md

---

## Open Questions

None.

---

## Version History

| Version | Date       | Description              |
| ------- | ---------- | ------------------------ |
| 1.0.0   | 2026-06-29 | Initial approved version |

---

## Approval

**Status:** Approved

**Approved By**

* Product Owner
* CTO

**Approval Date**

2026-06-29
