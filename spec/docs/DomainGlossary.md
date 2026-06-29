# E-Fee Product & Engineering Specification

## Domain Glossary

```yaml
---
document_id: GLOSSARY-001
title: Domain Glossary
version: 1.0.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-06-29
last_updated: 2026-06-29
next_review: Before Gate 2

related_documents:
  - BusinessWorkflow.md
  - BusinessRules.md
  - BusinessObjectGraph.md
---
```

---

## Purpose

This document establishes the common business vocabulary used throughout the E-Fee specification.

Every important business concept is defined exactly once to ensure consistent communication between business stakeholders, developers and AI-assisted engineering tools.

Unless explicitly stated otherwise, all subsequent documents use the definitions contained in this glossary.

---

## Scope

This glossary defines business concepts only.

It intentionally excludes:

* Database entities
* Programming classes
* API resources
* User interface terminology

Those are implementation concerns and are defined in later documents where appropriate.

---

# Academic Year

A bounded operational period during which an institution manages student fee receivables.

An Academic Year owns the fee obligations created for its enrolled students and serves as the primary reporting boundary.

Once closed, it becomes read-only.

---

# Student

An individual enrolled within an Academic Year for whom the institution manages fee receivables.

A Student may become inactive, but historical financial records are never removed.

---

# Fee Structure

A reusable definition describing how fees are calculated for a group of students.

A Fee Structure is composed of one or more Fee Components.

---

# Fee Component

An individual charge that contributes to a student's overall fee obligation.

Examples include:

* Tuition Fee
* Admission Fee
* Library Fee
* Sports Fee
* Laboratory Fee

The platform does not prescribe the available components; institutions define them according to their own policies.

---

# Fee Obligation

A financial obligation representing money owed by a student to the institution for a specific fee component within an Academic Year.

A Fee Obligation exists regardless of whether payment has been received.

It represents an account receivable.

Throughout its lifecycle, a Fee Obligation records:

* Original amount
* Discounts
* Amount paid
* Outstanding balance (derived)
* Operational status
* Receipt references
* Comments
* Historical changes

---

# Payment

A financial event representing money received by the institution.

A Payment records:

* Amount received
* Payment method
* Receipt reference
* Transaction reference (where applicable)

A single Payment may contribute towards one or more Fee Obligations.

---

# Payment Allocation

The distribution of a Payment across one or more Fee Obligations.

The total allocated amount must always equal the Payment amount.

Payment Allocation explains **how** money was applied after it was received.

---

# Receipt

The institution's acknowledgement that money has been received.

For the MVP, receipts continue to be handwritten according to existing operational practice.

E-Fee records the corresponding receipt reference for traceability.

One Payment is associated with one Receipt.

---

# Discount

A reduction applied to a Fee Obligation with appropriate institutional approval.

Discounts reduce the amount owed while preserving the original financial history.

Examples include:

* Fee Waiver
* Scholarship
* Financial Assistance

---

# Approval

A formal authorization required before performing specific controlled business activities.

Examples include:

* Financial corrections
* Discounts
* Exceptional operational decisions

Approvals preserve accountability and traceability.

---

# Correction

A business activity performed to rectify previously recorded information.

Corrections preserve historical information rather than replacing it.

Where practical, corrections should be additive rather than destructive.

---

# Final Settlement Obligation

A special Fee Obligation created when an Academic Year concludes or when a student exits the institution.

It consolidates any remaining unsettled receivables into a single final obligation, providing a complete and auditable summary of the student's financial position for that Academic Year.

---

# Audit History

The complete chronological record of significant financial activities affecting the lifecycle of fee receivables.

Audit History enables the institution to explain:

* What happened
* When it happened
* Who performed the action
* Who approved the action (where applicable)

---

# Business Event

A meaningful activity that changes the business state of the institution.

Examples include:

* Payment received
* Discount approved
* Fee obligation created
* Correction recorded
* Student inactivated

Business Events represent facts that have occurred.

---

# Business State

The current financial position derived from previously recorded Business Events.

Examples include:

* Outstanding balance
* Total paid
* Total discounted
* Student status

Business State may change over time as new Business Events occur.

---

## Key Decisions

* Every business concept is defined exactly once.
* Business terminology is independent of implementation technology.
* Fee Obligations represent receivables, regardless of payment.
* Payments record money received.
* Payment Allocation records how money is applied.
* Business State is derived from Business Events.

---

## Related Documents

* BusinessWorkflow.md
* BusinessRules.md
* BusinessObjectGraph.md

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
