# E-Fee Product & Engineering Specification

# Domain Glossary

```yaml
---
document_id: GLOSSARY-001
title: Domain Glossary
version: 1.1.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-06-29
last_updated: 2026-07-03
next_review: Before Specification v1.0.0

related_documents:
  - BusinessWorkflow.md
  - BusinessRules.md
  - BusinessObjectGraph.md
  - SoftwareDomainModel.md
---
```

---

# Purpose

This document establishes the common business vocabulary used throughout the E-Fee specification.

Every important business concept is defined exactly once to ensure consistent communication between business stakeholders, developers and AI-assisted engineering tools.

Unless explicitly stated otherwise, all subsequent specification documents use the definitions contained in this glossary.

---

# Scope

This glossary defines **business concepts only**.

It intentionally excludes:

* Software concepts
* Database entities
* Programming classes
* API resources
* User interface terminology

Software concepts are introduced separately in the **Software Domain Model**.

---

# Academic Year

A bounded operational period during which an institution manages student fee receivables.

An Academic Year determines the Fee Structure applicable to enrolled students and serves as the primary financial reporting boundary for the institution.

Once closed, it becomes read-only for normal business operations.

---

# Student

An individual for whom the institution manages fee receivables.

A Student may participate in multiple Academic Years throughout their relationship with the institution.

A Student may become inactive, but historical financial records are never removed.

---

# Fee Structure

A reusable charging policy that defines the standard fees applicable to a group of students for a particular Academic Year.

A Fee Structure is composed of one or more Fee Components.

Student-specific reductions are intentionally excluded and are handled separately through Discounts.

---

# Fee Component

An individual financial category that contributes to a student's overall fee obligation.

Examples include:

* Tuition Fee
* Admission Fee
* Library Fee
* Sports Fee
* Laboratory Fee

The platform does not prescribe the available Fee Components; institutions define them according to their own policies.

---

# Fee Obligation

A student's financial responsibility for a particular Academic Year.

A Fee Obligation is determined by the applicable Fee Structure and is itemized by one or more Fee Components.

A Fee Obligation exists regardless of whether payment has been received.

It represents the institution's account receivable from the student.

Throughout its lifecycle, a Fee Obligation records:

* Original amount
* Applied discounts
* Settlements
* Outstanding balance
* Operational status
* Financial history

---

# Payment

A financial event representing money received by the institution.

A Payment records:

* Amount received
* Payment method
* Payer
* Transaction reference (where applicable)
* Payment lifecycle

A single Payment may settle obligations belonging to one or more students.

---

# Payment Allocation

The business decision describing how a Payment is applied across one or more Fee Obligations.

Payment Allocation explains how received money settles outstanding financial responsibilities.

The total allocated amount must never exceed the realised Payment amount.

---

# Receipt

The institution's official acknowledgement of an accepted Payment.

A Receipt records acknowledgement and provides an auditable reference for the corresponding Payment.

Receipt corrections preserve audit history rather than replacing previously issued information.

---

# Discount

A reduction granted to an eligible Student with appropriate institutional approval.

A Discount reduces the student's financial responsibility while preserving the original financial history.

Examples include:

* Scholarship
* Fee Waiver
* Financial Assistance
* Staff Concession
* Sibling Concession
* Government-sponsored concession

---

# Approval

A formal authorization required before performing controlled business activities.

Examples include:

* Granting discounts
* Performing financial corrections
* Exceptional operational decisions

Approvals preserve accountability and traceability.

---

# Correction

A business activity performed to rectify previously recorded financial information.

Corrections preserve historical information rather than replacing it.

Where practical, corrections should be additive rather than destructive.

---

# Audit History

The complete chronological record of significant financial activities affecting fee receivables.

Audit History enables the institution to explain:

* What happened
* When it happened
* Who performed the action
* Who approved the action (where applicable)

---

# Business Event

A meaningful activity that changes the business state of the institution.

Examples include:

* Student enrolled
* Fee Obligation created
* Discount granted
* Payment realised
* Receipt acknowledged
* Correction recorded

Business Events represent facts that have occurred.

---

# Business State

The current financial position derived from previously recorded Business Events.

Examples include:

* Outstanding balance
* Total paid
* Total discounted
* Student financial status
* Academic Year collection status

Business State evolves as new Business Events occur.

---

# Key Decisions

* Every business concept is defined exactly once.
* Business terminology is independent of implementation technology.
* Fee Structures define charging policy.
* Discounts personalise charging policy for eligible students.
* Fee Obligations represent student financial responsibility.
* Payments record money received.
* Payment Allocations explain how money settles obligations.
* Business State is derived from Business Events.

---

# Related Documents

* BusinessWorkflow.md
* BusinessRules.md
* BusinessObjectGraph.md
* SoftwareDomainModel.md

---

# Open Questions

None.

---

# Version History

| Version | Date       | Description                                                                                         |
| ------- | ---------- | --------------------------------------------------------------------------------------------------- |
| 1.0.0   | 2026-06-29 | Initial approved version                                                                            |
| 1.1.0   | 2026-07-03 | Updated to reflect the completed Gate 2 conceptual model and software domain terminology separation |

---

# Approval

**Status:** Approved

## Approved By

* Product Owner
* CTO

## Approval Date

2026-07-03
