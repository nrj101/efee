# E-Fee Product & Engineering Specification

# User Personas

```yaml
---
document_id: PERSONA-001
title: User Personas
version: 1.1.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-06-29
last_updated: 2026-07-03
next_review: Before Specification v1.0.0

related_documents:
  - MVPScope.md
  - BusinessWorkflow.md
  - BusinessRules.md
  - BusinessObjectGraph.md
---
```

---

# Purpose

This document identifies the primary users of E-Fee, their business responsibilities, goals and interactions with the system.

Understanding the users is essential for designing intuitive workflows, assigning appropriate responsibilities and ensuring that every product capability addresses a genuine operational need.

---

# Scope

This document defines:

* Primary user groups.
* Business responsibilities.
* Business goals.
* High-level permission boundaries.

It intentionally does **not** define authentication, authorization implementation or user interface design.

---

# Persona 1 — Accountant / Receptionist

## Description

The Accountant (or Receptionist, depending on the institution) is the primary operational user of E-Fee.

This user performs the majority of day-to-day financial operations and is responsible for maintaining accurate student fee receivable records.

---

## Business Responsibilities

* Maintain student financial records.
* Manage Fee Obligations.
* Record Payments.
* Acknowledge Receipts.
* Record approved Discounts.
* Initiate financial Corrections.
* Produce operational reports.

---

## Business Goals

* Record financial activities accurately.
* Minimise reconciliation effort.
* Retrieve a student's financial position immediately.
* Produce reliable operational reports.
* Maintain complete financial history.

---

## Permission Boundaries

The Accountant cannot:

* Approve financial Corrections.
* Approve Discounts.
* Delete financial history.
* Modify approved financial records.
* Override business rules.

---

# Persona 2 — Principal

## Description

The Principal provides operational oversight and authorises exceptional financial decisions.

The Principal is not expected to perform routine operational activities.

---

## Business Responsibilities

* Approve financial Corrections.
* Approve Discounts.
* Resolve financial disputes.
* Review financial reports.
* Monitor institutional fee receivables.

---

## Business Goals

* Ensure financial integrity.
* Maintain institutional transparency.
* Reduce operational risk.
* Resolve exceptional situations efficiently.

---

# Persona 3 — School Manager

## Description

The School Manager performs responsibilities similar to the Principal and may act as an alternate approving authority according to institutional policy.

---

## Business Responsibilities

* Review financial reports.
* Approve financial Corrections.
* Approve Discounts.
* Monitor operational performance.

---

## Business Goals

* Maintain financial accountability.
* Support institutional decision making.
* Ensure compliance with institutional policies.

---

# Future Personas

The following personas remain outside the MVP but should be considered during future product evolution.

---

## Parent

Potential responsibilities:

* View outstanding financial responsibilities.
* View Payment history.
* Download Receipts.
* Receive payment reminders.
* Make online Payments.

---

## Trustee

Potential responsibilities:

* Review institutional financial reports.
* Monitor overall financial health.
* Review strategic dashboards.

---

## Auditor

Potential responsibilities:

* Review Audit History.
* Verify Approvals.
* Inspect financial records.
* Validate financial traceability.

---

# Permission Principles

The platform follows the principle of least privilege.

Users should be granted only the permissions required to perform their business responsibilities.

Approval authority should remain intentionally separated from routine operational activities.

---

# Shared Objectives

Regardless of role, every user benefits from:

* Financial transparency.
* Reliable reporting.
* Accurate financial records.
* Reduced administrative effort.
* Complete auditability.
* Explainable financial decisions.

---

# Key Decisions

* The Accountant is the primary operational user.
* Approval authority is intentionally separated from routine financial operations.
* Financial history cannot be modified without appropriate approval.
* Future personas should extend the platform without changing existing business responsibilities.

---

# Related Documents

* MVPScope.md
* BusinessWorkflow.md
* BusinessRules.md
* BusinessObjectGraph.md

---

# Open Questions

None.

---

# Version History

| Version | Date       | Description                                                                                         |
| ------- | ---------- | --------------------------------------------------------------------------------------------------- |
| 1.0.0   | 2026-06-29 | Initial approved version                                                                            |
| 1.1.0   | 2026-07-03 | Refined business responsibilities and aligned terminology with the completed Gate 2 business model. |

---

# Approval

**Status:** Approved

## Approved By

* Product Owner
* CTO

## Approval Date

2026-07-03
