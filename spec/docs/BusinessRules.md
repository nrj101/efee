# E-Fee Product & Engineering Specification

## Business Rules

```yaml
---
document_id: RULES-001
title: Business Rules
version: 1.0.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-06-29
last_updated: 2026-06-29
next_review: Before Gate 2

related_documents:
  - BusinessWorkflow.md
  - DomainGlossary.md
  - BusinessObjectGraph.md
---
```

---

## Purpose

This document defines the fundamental business rules governing fee receivables within E-Fee.

These rules express the operational constraints that must remain true regardless of implementation technology.

They represent business invariants rather than programming validations.

---

## Scope

This document defines rules governing:

* Academic Years
* Students
* Fee Obligations
* Payments
* Payment Allocation
* Discounts
* Corrections
* Approvals
* Reporting

It does not define technical validation or user interface behaviour.

---

# Academic Year

### BR-001

An Academic Year owns all fee obligations created during that academic session.

---

### BR-002

A closed Academic Year becomes read-only.

No operational modifications are permitted after closure.

---

### BR-003

Any remaining receivables at Academic Year closure shall be consolidated into a Final Settlement Obligation for each student.

---

# Student

### BR-004

Students shall never be physically deleted.

Historical financial information must remain permanently available.

---

### BR-005

Inactive students shall not participate in future operational activities or reporting unless explicitly requested.

Historical records remain accessible.

---

# Fee Obligations

### BR-006

A Fee Obligation exists independently of payment.

Receiving payment does not create the obligation.

---

### BR-007

Every Fee Obligation belongs to exactly one Academic Year.

---

### BR-008

Outstanding Balance is derived from:

* Original Amount
* Approved Discounts
* Allocated Payments

It shall not be treated as an independently managed business fact.

---

### BR-009

Outstanding Balance shall never become negative.

---

### BR-010

Future Fee Obligations may reflect revised fee structures.

Existing Fee Obligations should remain unchanged except through approved business activities.

---

# Payments

### BR-011

A Payment represents money actually received by the institution.

No Payment shall exist without corresponding financial inflow.

---

### BR-012

One Payment shall be associated with exactly one Receipt.

---

### BR-013

One Payment may satisfy:

* Multiple Fee Obligations
* Multiple Fee Components
* Multiple Students

provided all allocations reconcile to the Payment amount.

---

# Payment Allocation

### BR-014

The sum of all Payment Allocations shall exactly equal the associated Payment amount.

---

### BR-015

No Payment Allocation may allocate more than the outstanding amount of the corresponding Fee Obligation.

---

### BR-016

Payment Allocation priority may follow:

* Parent preference, or
* Institution default policy

---

# Discounts

### BR-017

Discounts reduce the amount owed without removing historical financial information.

---

### BR-018

Every Discount shall record:

* Reason
* Approving Authority
* Supporting comments (where applicable)

---

# Corrections

### BR-019

Historical financial information should not be silently modified.

Corrections should preserve the original business history whenever practical.

---

### BR-020

Corrections affecting financial information require prior approval.

---

### BR-021

Corrections should be additive rather than destructive wherever practical.

---

# Approvals

### BR-022

Approval authority shall remain separate from routine data entry.

---

### BR-023

Approval activities shall preserve:

* Approver
* Date
* Reason
* Associated business activity

---

# Receipts

### BR-024

Receipts acknowledge the receipt of actual money.

Receipts shall not be generated without an associated financial transaction.

---

### BR-025

Receipt references shall remain traceable throughout the lifecycle of associated Fee Obligations.

---

# Reporting

### BR-026

Reports shall represent the current business state while remaining explainable through historical business events.

---

### BR-027

Historical reports shall remain reproducible from preserved financial history.

---

# Auditability

### BR-028

Every significant financial activity shall remain traceable.

---

### BR-029

Every significant financial change shall identify:

* What changed
* When it changed
* Who performed it
* Who approved it (where applicable)

---

# General Principles

### BR-030

Business Events record facts.

Business State is derived from those facts.

---

### BR-031

Financial integrity takes precedence over operational convenience.

---

### BR-032

The system should preserve explainability before optimization.

---

## Key Decisions

* Business rules are implementation-independent.
* Outstanding Balance is derived.
* Payments record money received.
* Allocations explain how money is applied.
* Financial history is preserved.
* Corrections are additive wherever practical.
* Closed Academic Years are immutable.

---

## Related Documents

* BusinessWorkflow.md
* DomainGlossary.md
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
