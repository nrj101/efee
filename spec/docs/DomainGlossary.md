# E-Fee Product & Engineering Specification

# Domain Glossary

```yaml
---
document_id: GLOSSARY-001
title: Domain Glossary
version: 1.2.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-06-29
last_updated: 2026-07-14
next_review: Before Specification v1.2.0

related_documents:
  - BusinessWorkflow.md
  - BusinessRules.md
  - BusinessObjectGraph.md
  - SoftwareDomainModel.md
  - rfc/RFC-001-Financial-Truth-Model.md
  - rfc/RFC-002-Discount-Domain-Model.md
---
```

---

# Purpose

This document establishes the common business vocabulary used throughout the E-Fee Product & Engineering Specification.

Every important business concept is defined exactly once to ensure consistent communication between business stakeholders, developers and AI-assisted engineering tools.

Unless explicitly stated otherwise, all subsequent specification documents use the definitions contained in this glossary.

---

# Scope

This glossary defines **business concepts only**.

It intentionally excludes:

- Software concepts
- Database entities
- Programming classes
- API resources
- User interface terminology

Software concepts are introduced separately in the **Software Domain Model**.

---

# Academic Year

A bounded operational period during which an institution manages student fee receivables.

An Academic Year determines the Fee Structure applicable to enrolled students and serves as the primary financial reporting boundary for the institution.

Once closed, it becomes read-only for normal business operations.

If outstanding receivables remain when an Academic Year is closed, they are consolidated into a **Final Settlement Obligation**.

---

# Student

An individual for whom the institution manages fee receivables.

A Student may participate in multiple Academic Years throughout their relationship with the institution.

A Student may become inactive, but historical financial records are never removed.

---

# Fee Structure

A reusable charging policy defining the standard fees applicable to a group of students for a particular Academic Year.

A Fee Structure is composed of one or more Fee Components.

Student-specific financial concessions are intentionally excluded and are handled separately through Discount Policies and Discount Grants.

---

# Fee Component

An individual financial category contributing to a student's overall fee obligation.

Examples include:

- Tuition Fee
- Admission Fee
- Library Fee
- Sports Fee
- Laboratory Fee

Institutions define their own Fee Components according to their policies.

Fee Components belong exclusively to a Fee Structure.

---

# Fee Obligation

A Student's financial responsibility for a particular Academic Year.

A Fee Obligation is created from the applicable Fee Structure and is itemized into one or more Fee Components.

A Fee Obligation exists regardless of whether payment has been received.

It represents the institution's account receivable from the Student.

The financial position of a Fee Obligation is explained through:

- Original obligation amount
- Applied Discounts
- Payment Allocations
- Outstanding Balance
- Operational status
- Financial history

Outstanding Balance is derived from these financial facts and represents the current amount owed by the Student.

---

# Final Settlement Obligation

A Fee Obligation created when an Academic Year closes with unsettled receivables.

It consolidates the remaining financial responsibility of a Student after the operational Academic Year has ended.

Final Settlement Obligations preserve historical traceability while allowing future settlement outside the closed Academic Year.

---

# Payment

A Payment represents a payer's intention to settle one or more Fee Obligations.

A Payment progresses through an operational lifecycle before becoming realised by the institution.

Only realised Payments may be allocated to Fee Obligations.

A Payment records:

- Amount
- Payment method
- Payer
- Transaction reference (where applicable)
- Operational lifecycle

One realised Payment may settle obligations belonging to one or more Students where institutional policy permits.

---

# Payment Allocation

The business decision describing how a realised Payment is applied across one or more Fee Obligations.

Payment Allocation explains how received money settles outstanding financial responsibilities.

The total allocated amount shall exactly equal the realised Payment amount.

---

# Receipt

The institution's official acknowledgement of an accepted Payment.

A Receipt records acknowledgement and provides an auditable reference to the corresponding Payment.

Receipt corrections preserve historical information rather than replacing previously issued acknowledgements.

---

# Discount Policy

A reusable institutional policy defining eligibility criteria and calculation rules for financial concessions.

A Discount Policy does not reduce any Student's financial responsibility by itself.

It provides the basis upon which individual Discount Grants may be approved.

---

# Discount Grant

An approved authorization granting a specific Student the entitlement to receive a financial concession under a Discount Policy.

A Discount Grant records:

- Student
- Discount Policy
- Approved value
- Reason
- Approving authority
- Effective period

A Discount Grant represents an entitlement.

It does not directly modify a Fee Obligation.

---

# Applied Discount

The financial effect created when an approved Discount Grant is applied to a specific Fee Obligation.

Applied Discounts reduce the Outstanding Balance while preserving the original financial obligation.

Historical Applied Discounts remain permanently traceable.

---

# Approval

A formal authorization required before performing controlled business activities.

Examples include:

- Granting Discounts
- Financial Corrections
- Exceptional operational decisions

Approvals preserve accountability and traceability.

---

# Correction

A business activity performed to rectify previously recorded financial information.

Corrections preserve historical information rather than replacing it.

Where practical, corrections are additive rather than destructive.

---

# Audit History

The complete chronological record of significant financial activities affecting fee receivables.

Audit History enables the institution to explain:

- What happened
- When it happened
- Who performed the action
- Who approved the action (where applicable)

---

# Business Event

A meaningful activity that changes the business facts recorded by the institution.

Examples include:

- Student Registered
- Fee Obligation Created
- Discount Granted
- Applied Discount Recorded
- Payment Realised
- Payment Allocated
- Receipt Issued
- Correction Recorded

Business Events represent immutable facts that have occurred.

---

# Business State

The current financial position derived from previously recorded Business Events.

Examples include:

- Outstanding Balance
- Total Paid
- Total Discounted
- Student Financial Status
- Academic Year Collection Status

Business State is derived from previously recorded Business Events and changes only as new Business Events are recorded.

---

# Key Decisions

- Every business concept is defined exactly once.
- Business terminology is independent of implementation technology.
- Fee Structures define charging policy.
- Fee Components belong to Fee Structures.
- Discount Policies define institutional concession rules.
- Discount Grants authorize Student-specific concessions.
- Applied Discounts record the financial effect of approved concessions.
- Fee Obligations represent Student financial responsibility.
- Payments represent settlement intent that may require realisation.
- Payment Allocations explain how realised money settles obligations.
- Business State is derived from Business Events.

---

# Related Documents

- BusinessWorkflow.md
- BusinessRules.md
- BusinessObjectGraph.md
- SoftwareDomainModel.md

---

# Open Questions

None.

---

# Version History

| Version | Date | Description |
|---------|------------|-------------|
| 1.0.0 | 2026-06-29 | Initial approved version. |
| 1.1.0 | 2026-07-03 | Updated to reflect the completed Gate 2 conceptual model and software domain terminology separation. |
| 1.2.0 | 2026-07-14 | Expanded the glossary to incorporate the Financial Truth Model, Discount domain concepts, Final Settlement Obligation and refined business terminology introduced during Specification v1.1.0 design reconciliation. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- CTO

## Approval Date

2026-07-14