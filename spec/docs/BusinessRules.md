# E-Fee Product & Engineering Specification

# Business Rules

```yaml
---
document_id: RULES-001
title: Business Rules
version: 1.1.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-06-29
last_updated: 2026-07-03
next_review: Before Specification v1.0.0

related_documents:
  - BusinessWorkflow.md
  - DomainGlossary.md
  - BusinessObjectGraph.md
  - SoftwareDomainModel.md
---
```

---

# Purpose

This document defines the fundamental business rules governing student fee receivables within E-Fee.

These rules express business constraints that must remain true regardless of implementation technology.

They represent **business invariants**, not programming validations.

---

# Scope

This document defines rules governing:

* Academic Years
* Students
* Fee Structures
* Fee Obligations
* Payments
* Payment Allocation
* Receipts
* Discounts
* Corrections
* Approvals
* Reporting

It intentionally does **not** define technical validation or user interface behaviour.

---

# Academic Year

### BR-001

An Academic Year governs all Fee Obligations created for that academic session.

---

### BR-002

A closed Academic Year becomes read-only.

Normal operational activities are no longer permitted after closure.

---

### BR-003

Any remaining receivables at Academic Year closure shall be consolidated into a Final Settlement Obligation for each student.

---

# Student

### BR-004

Students shall never be physically deleted.

Historical financial information shall remain permanently available.

---

### BR-005

Inactive students shall not participate in future operational activities unless explicitly permitted.

Historical financial records remain accessible.

---

# Fee Structure

### BR-006

A Fee Structure defines the standard charging policy for a group of students.

---

### BR-007

Changes to a Fee Structure shall not retroactively modify existing Fee Obligations.

Only future obligations may use revised Fee Structures.

---

# Fee Obligations

### BR-008

A Fee Obligation exists independently of payment.

Receiving payment does not create the obligation.

---

### BR-009

Every Fee Obligation belongs to exactly one Student and one Academic Year.

---

### BR-010

A Fee Obligation shall be itemized by one or more Fee Components.

---

### BR-011

Outstanding Balance represents the Student's current financial position.

It is derived from the Fee Obligation's authoritative financial facts, including:

* Original Obligation Amount
* Approved Discounts
* Realised Payment Allocations
* Approved Financial Corrections

The system shall persist the current Outstanding Balance after every successful financial adjustment.

The persisted Outstanding Balance shall always be reproducible from the underlying financial facts.

Outstanding Balance shall not be treated as an independently managed business fact.

> **Traceability:** Refined by RFC-001 — Financial Truth Model.

#### BR-011A

Financial facts constitute the authoritative record of a Student's financial responsibility.

These facts include:

* Obligation Lines
* Applied Discounts
* Payment Allocations
* Financial Corrections

Outstanding Balance represents the current financial position derived from those financial facts.

Financial facts shall remain authoritative throughout the lifecycle of the Fee Obligation.

> **Traceability:** Introduced by RFC-001 — Financial Truth Model.

---

### BR-012

Outstanding Balance shall never become negative.

---

# Payments

### BR-013

A Payment represents a payer's intention to settle one or more Fee Obligations.

A Payment may require confirmation before it is considered realised by the institution.

---

### BR-014

Payment Allocation shall occur only after the Payment has been realised.

---

### BR-015

One realised Payment may settle:

* Multiple Fee Obligations
* Multiple Fee Components
* Multiple students (where institution policy permits)

provided all allocations reconcile to the realised Payment amount.

---

# Payment Allocation

### BR-016

The sum of all realised Payment Allocations shall exactly equal the realised Payment amount.

---

### BR-017

No Payment Allocation may allocate more than the outstanding amount of the corresponding Fee Obligation.

---

### BR-018

Allocation priority may follow:

* Parent preference, or
* Institution default policy.

---

# Receipts

### BR-019

A Receipt acknowledges an accepted Payment.

---

### BR-020

Receipts shall preserve their complete lifecycle and correction history.

---

### BR-021

Receipt references shall remain traceable throughout the lifecycle of associated Fee Obligations.

---

# Discounts

### BR-022

Discounts are granted to eligible Students.

They reduce the student's financial responsibility while preserving the original financial history.

---

### BR-023

Every Discount shall record:

* Reason
* Approving authority
* Supporting comments (where applicable)

---

# Corrections

### BR-024

Historical financial information shall never be silently modified.

Corrections shall preserve the original financial facts and business history whenever practical.

---

### BR-025

Corrections affecting financial information require prior approval.

---

### BR-026

Corrections should be additive rather than destructive wherever practical.

---

# Approvals

### BR-027

Approval authority shall remain separate from routine operational activities.

---

### BR-028

Approval activities shall preserve:

* Approver
* Date
* Reason
* Associated business activity

---

# Reporting

### BR-029

Reports shall represent the current Business State while remaining explainable through historical Business Events.

---

### BR-030

Historical reports shall remain reproducible from preserved financial history.

---

# Auditability

### BR-031

Every significant financial activity shall remain traceable.

---

### BR-032

Every significant financial change shall identify:

* What changed
* When it changed
* Who performed it
* Who approved it (where applicable)

---

# General Principles

### BR-033

Business Events record immutable business facts.

Current Business State represents the financial position derived from those facts.

Derived Business State may be persisted for operational efficiency, provided it remains reproducible from the underlying business facts.

> **Traceability:** Refined by RFC-001 — Financial Truth Model.

---

### BR-034

Financial integrity takes precedence over operational convenience.

---

### BR-035

Software shall preserve business truths rather than redefine them.

---

### BR-036

The system should preserve explainability before optimisation.

---

# Key Decisions

* Business rules are implementation-independent.
* Fee Structures define charging policy.
* Fee Obligations represent student financial responsibility.
* Outstanding Balance represents the persisted financial position derived from authoritative financial facts.
* Payments represent settlement attempts that may require realisation.
* Payment Allocations explain how realised money settles obligations.
* Receipts acknowledge accepted Payments.
* Discounts are granted to Students.
* Financial history is preserved.
* Corrections are additive wherever practical.
* Closed Academic Years are immutable.

---

# Related Documents

* DomainGlossary.md
* BusinessWorkflow.md
* BusinessObjectGraph.md
* SoftwareDomainModel.md

---

# Open Questions

None.

---

# Version History

| Version | Date       | Description                                                                                               |
| ------- | ---------- | --------------------------------------------------------------------------------------------------------- |
| 1.0.0   | 2026-06-29 | Initial approved version                                                                                  |
| 1.1.0   | 2026-07-03 | Updated to reflect the completed Gate 2 business model, payment lifecycle and refined business invariants |
| 1.2.0   | 2026-07-14 | Refined Financial Truth Model through RFC-001. Clarified authoritative financial facts, persisted financial position and reconciliation principles. |


---

# Approval

**Status:** Approved

## Approved By

* Product Owner
* CTO

## Approval Date

2026-07-03
