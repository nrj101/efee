# E-Fee Product & Engineering Specification

## User Personas

```yaml
---
document_id: PERSONA-001
title: User Personas
version: 1.0.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-06-29
last_updated: 2026-06-29
next_review: Before MVP Implementation

related_documents:
  - MVPScope.md
  - BusinessWorkflow.md
  - BusinessRules.md
---
```

---

## Purpose

This document identifies the primary users of E-Fee, their responsibilities, goals and interactions with the system.

Understanding the users is essential for designing intuitive workflows, enforcing appropriate permissions and ensuring that every feature addresses a genuine operational need.

---

## Scope

This document defines:

* Primary user groups
* Business responsibilities
* System responsibilities
* High-level permissions

It does **not** define authentication, authorization implementation or user interface design.

---

# Persona 1 — Accountant / Receptionist

## Description

The Accountant (or Receptionist, depending on the institution) is the primary operational user of E-Fee.

This user performs the majority of day-to-day activities related to fee collection and serves as the primary operator of the system.

---

## Responsibilities

* Register students
* Maintain student information
* Record payments
* Capture manual receipt numbers
* Allocate payments to fee obligations
* Record discounts approved by management
* Submit correction requests
* Generate operational reports

---

## Goals

* Record transactions quickly and accurately.
* Minimize reconciliation effort.
* Retrieve student fee history instantly.
* Produce reliable reports.
* Maintain accurate financial records.

---

## Constraints

The Accountant cannot:

* Approve corrections.
* Delete financial history.
* Modify approved financial records.
* Override business rules.

---

# Persona 2 — Principal

## Description

The Principal is responsible for operational oversight and approval of exceptional financial decisions.

The Principal is not expected to perform routine data entry.

---

## Responsibilities

* Approve corrections.
* Approve discounts.
* Review reports.
* Monitor fee collection.
* Resolve financial disputes.

---

## Goals

* Ensure financial accuracy.
* Maintain institutional transparency.
* Reduce operational risk.
* Resolve exceptional situations efficiently.

---

# Persona 3 — School Manager

## Description

The School Manager performs responsibilities similar to the Principal and may act as an alternate approving authority depending on institutional policy.

---

## Responsibilities

* Review financial reports.
* Approve corrections.
* Approve discounts.
* Monitor operational performance.

---

## Goals

* Maintain financial accountability.
* Support institutional decision making.
* Ensure compliance with internal policies.

---

# Future Personas

The following personas are outside the MVP but should be considered during future product evolution.

---

## Parent

Potential responsibilities:

* View outstanding fees.
* Download receipts.
* View payment history.
* Receive reminders.
* Make online payments.

---

## Trustee

Potential responsibilities:

* Review institutional reports.
* Monitor overall financial health.
* Review strategic dashboards.

---

## Auditor

Potential responsibilities:

* Review audit history.
* Verify approvals.
* Inspect financial records.

---

# Permission Principles

The system should follow the principle of least privilege.

Users should only be granted the permissions necessary to perform their responsibilities.

Approval authority should remain separate from routine operational activities.

---

# Shared Objectives

Regardless of role, every user benefits from:

* Financial transparency
* Reliable reporting
* Accurate records
* Reduced manual effort
* Complete auditability

---

## Key Decisions

* The Accountant is the primary operational user.
* Approval authority is intentionally separated from data entry.
* Financial history cannot be modified without appropriate approval.
* Future personas should extend the platform without changing existing responsibilities.

---

## Related Documents

* MVPScope.md
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
