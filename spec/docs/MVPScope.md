# E-Fee Product & Engineering Specification

## MVP Scope

```yaml
---
document_id: SCOPE-001
title: MVP Scope
version: 1.0.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-06-29
last_updated: 2026-06-29
next_review: Before MVP Implementation

related_documents:
  - ProductVision.md
  - ProblemStatement.md
  - BusinessWorkflow.md
  - BusinessRules.md
---
```

---

## Purpose

This document defines the functional boundaries of the Minimum Viable Product (MVP).

Its purpose is to clearly identify the minimum set of capabilities required for the partner school to operate entirely on E-Fee during the beta program.

The MVP should solve one business problem exceptionally well rather than attempting to become a complete School ERP.

---

## Scope

This document defines:

* Features included in the MVP
* Features intentionally excluded
* Beta success criteria
* Product boundaries

It does **not** define detailed workflows or implementation behaviour.

---

## MVP Goal

The MVP enables a school to manage the complete lifecycle of student fee receivables using E-Fee while continuing to collect payments through existing offline methods.

The application becomes the institution's operational system of record for fee receivables.

---

## Target Institution

Initial Beta Partner

* Single campus
* Approximately 300 students
* Low monthly tuition fee
* Offline cash and UPI collection
* One accountant responsible for fee entry
* Principal and Manager responsible for oversight

---

## Capabilities Included

The MVP shall support the following capabilities.

### Student Management

* Student registration
* Student profile maintenance
* Student activation and inactivation
* Academic year association

---

### Fee Configuration

* Fee structures
* Fee components
* Fee obligations
* Monthly fee generation

---

### Fee Collection

* Record payments
* Manual receipt number capture
* Payment allocation
* Partial payments
* Multi-month payments
* Multiple fee categories

---

### Discounts

* Partial waiver
* Full waiver
* Discount reason
* Supporting comments

---

### Approvals

* Approval workflow for corrections
* Principal or Manager authorization
* Immutable approval history

---

### Reporting

* Outstanding fees
* Student ledger
* Daily collection report
* Defaulter report

---

### Auditability

* Financial history
* Payment history
* Allocation history
* Approval history
* Correction history

---

## Capabilities Excluded

The MVP intentionally excludes:

### Online Payment Gateway

Payments continue through existing school processes.

---

### Parent Portal

Parents are not direct users during the MVP.

---

### SMS / Email Notifications

Reminder functionality may be introduced after successful beta validation.

---

### Mobile Application

The MVP targets desktop web usage.

---

### Expense Management

Outside current product scope.

---

### Payroll

Outside current product scope.

---

### Attendance

Outside current product scope.

---

### Examination Management

Outside current product scope.

---

### Library

Outside current product scope.

---

### Inventory

Outside current product scope.

---

## Product Boundaries

The MVP focuses exclusively on:

> **Managing fee receivables.**

It does not attempt to manage the complete financial operations of an institution.

---

## Success Criteria

The MVP is considered successful when the partner school can:

* Record all fee transactions digitally.
* Track every fee obligation.
* Reconcile daily collections confidently.
* Explain any student's fee history.
* Identify fee defaulters immediately.
* Preserve a complete audit trail.
* Operate without maintaining manual fee registers for day-to-day activities.

---

## Future Expansion

Future releases may introduce:

* Parent Portal
* Online Payments
* Automated Notifications
* Multi-campus Support
* Expense Management
* Payroll
* Budgeting
* Institution-wide Accounting
* Analytics
* Mobile Applications

These capabilities remain outside the MVP unless approved through a future product revision.

---

## Key Decisions

* Solve one business problem exceptionally well.
* Prioritize operational reliability over feature breadth.
* Continue existing payment collection practices during beta.
* The application becomes the system of record for fee receivables.

---

## Related Documents

* ProductVision.md
* ProblemStatement.md
* BusinessWorkflow.md
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
