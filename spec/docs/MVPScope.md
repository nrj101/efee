# E-Fee Product & Engineering Specification

# MVP Scope

```yaml
---
document_id: SCOPE-001
title: MVP Scope
version: 1.1.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-06-29
last_updated: 2026-07-03
next_review: Before Specification v1.0.0

related_documents:
  - ProductVision.md
  - ProblemStatement.md
  - BusinessWorkflow.md
  - BusinessRules.md
  - BusinessObjectGraph.md
---
```

---

# Purpose

This document defines the functional boundaries of the Minimum Viable Product (MVP).

Its purpose is to identify the minimum set of business capabilities required for the partner institution to operate entirely on E-Fee during the beta programme.

The MVP should solve one business problem exceptionally well rather than attempting to become a complete School ERP.

---

# Scope

This document defines:

* Business capabilities included in the MVP.
* Capabilities intentionally excluded.
* Product boundaries.
* Beta success criteria.

It intentionally does **not** define detailed workflows, implementation behaviour or technical design.

---

# MVP Goal

The MVP enables an educational institution to manage the complete lifecycle of student fee receivables while continuing to receive payments through its existing operational processes.

E-Fee becomes the institution's operational system of record for student fee receivables.

---

# Target Institution

**Initial Beta Partner**

* Single campus
* Approximately 300 active students
* Offline cash and UPI collections
* One accountant responsible for fee operations
* Principal and Manager responsible for oversight

---

# Business Capabilities Included

The MVP shall support the following business capabilities.

## Student Financial Management

* Register and maintain students.
* Associate students with Academic Years.
* Maintain student financial history.
* Activate and inactivate students while preserving historical records.

---

## Fee Policy Management

* Define Fee Structures.
* Configure Fee Components.
* Manage Academic Year fee policies.

---

## Fee Obligation Management

* Create and maintain student Fee Obligations.
* Track outstanding financial responsibilities.
* Maintain obligation lifecycle.

---

## Payment Management

* Record Payments.
* Allocate Payments across one or more Fee Obligations.
* Support partial and multi-obligation settlements.
* Preserve complete payment history.

---

## Discount Management

* Grant approved Discounts.
* Record reasons and supporting comments.
* Preserve original financial history.

---

## Receipt Management

* Record receipt acknowledgement.
* Support existing handwritten receipt processes during the MVP.
* Preserve receipt history.

---

## Financial Corrections

* Perform controlled financial corrections.
* Preserve audit history.
* Require appropriate approvals.

---

## Reporting

* Student financial position.
* Outstanding receivables.
* Daily collection summary.
* Fee defaulter reporting.

---

## Auditability

The MVP shall preserve:

* Financial history.
* Payment history.
* Receipt history.
* Discount history.
* Correction history.
* Approval history.

---

# Capabilities Excluded

The MVP intentionally excludes:

## Online Payment Gateway

Payments continue through existing institutional processes.

---

## Parent Portal

Parents are not direct users during the MVP.

---

## SMS / Email Notifications

Reminder functionality may be introduced in future releases.

---

## Mobile Application

The MVP targets desktop web usage.

---

## Multi-campus Management

The MVP targets a single institution.

---

## General Accounting

Outside the current product scope.

---

## Expense Management

Outside the current product scope.

---

## Payroll

Outside the current product scope.

---

## Attendance Management

Outside the current product scope.

---

## Examination Management

Outside the current product scope.

---

## Library Management

Outside the current product scope.

---

## Inventory Management

Outside the current product scope.

---

# Product Boundary

The MVP focuses exclusively on one business capability:

> **Managing student fee receivables from obligation creation until final settlement or closure.**

It intentionally does not attempt to manage the complete financial operations of an educational institution.

---

# Success Criteria

The MVP is considered successful when the partner institution can:

* Operate daily fee receivable management digitally.
* Explain any student's financial position within seconds.
* Track every Fee Obligation confidently.
* Reconcile daily collections with confidence.
* Identify fee defaulters immediately.
* Preserve a complete financial audit trail.
* Operate without maintaining manual fee registers for day-to-day fee operations.

---

# Future Expansion

Future product releases may introduce:

* Parent Portal
* Online Payments
* Automated Notifications
* Multi-campus Support
* Expense Management
* Payroll
* Budget Planning
* Institution-wide Accounting
* Analytics
* Mobile Applications

These capabilities remain outside the MVP unless approved through a future product revision.

---

# Key Decisions

* Solve one business problem exceptionally well.
* Prioritise operational reliability over feature breadth.
* Continue existing payment collection practices during beta.
* E-Fee becomes the operational system of record for student fee receivables.

---

# Related Documents

* ProductVision.md
* ProblemStatement.md
* BusinessWorkflow.md
* BusinessRules.md
* BusinessObjectGraph.md

---

# Open Questions

None.

---

# Version History

| Version | Date       | Description                                                                                                        |
| ------- | ---------- | ------------------------------------------------------------------------------------------------------------------ |
| 1.0.0   | 2026-06-29 | Initial approved version                                                                                           |
| 1.1.0   | 2026-07-03 | Refocused MVP scope around business capabilities and aligned terminology with the completed Gate 2 business model. |

---

# Approval

**Status:** Approved

## Approved By

* Product Owner
* CTO

## Approval Date

2026-07-03
