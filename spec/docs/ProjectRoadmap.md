# E-Fee Product & Engineering Specification

# Project Roadmap

```yaml
---
document_id: ROADMAP-001
title: Project Roadmap
version: 1.1.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-06-29
last_updated: 2026-07-03
next_review: At the completion of every Gate

related_documents:
  - ProductVision.md
  - ProblemStatement.md
  - MVPScope.md
---
```

---

# Purpose

This document provides a high-level view of the E-Fee project roadmap.

It answers three fundamental questions:

* Where are we?
* What have we completed?
* What comes next?

Unlike the Product Vision or Business Rules, this document evolves throughout the lifetime of the project and reflects the current state of product development.

---

# Scope

This document describes:

* Project progression.
* Engineering gates.
* Major milestones.
* Current project status.

It does **not** define product requirements or implementation details.

---

# Product Overview

## Engineering Name

**Student Fee Receivables Platform**

---

## Commercial Brand

**E-Fee**

---

## Mission

Build an affordable, secure and audit-friendly SaaS platform that enables educational institutions to confidently manage every fee obligation from creation to final settlement.

---

# Current Status

## Current Gate

🟡 **Gate 3 — Software Architecture**

---

## Current Milestone

Architecture Design

---

## Specification Baseline

**Specification v1.0.0**

Business and software modelling are complete and frozen.

Architecture will build upon this baseline.

---

# Engineering Roadmap

## ✅ Gate 1 — Product Foundation

### Objective

Understand the business problem and establish a clear product direction.

### Deliverables

* Problem Statement
* Product Vision
* MVP Scope
* User Personas

### Exit Criteria

A shared understanding of the business problem, product vision and MVP boundaries.

### Status

✅ Completed

---

## ✅ Gate 2 — Business & Software Domain Modelling

### Objective

Develop a complete, implementation-independent specification of the business and its software representation.

### Deliverables

* Domain Glossary
* Business Rules
* Business Workflow
* Business Object Graph
* Software Domain Model
* Modelling Decision Log

### Exit Criteria

A stable specification that completely describes the business domain and software domain without depending on implementation technology.

### Status

✅ Completed

---

## 🟡 Gate 3 — Software Architecture

### Objective

Design the software architecture that faithfully implements the Software Domain Model.

### Deliverables

* Aggregate Boundaries
* Aggregate Roots
* Domain Operations
* Domain Services
* Domain Events
* Architectural Views
* Initial ADRs

### Exit Criteria

A complete implementation-independent architecture suitable for realization in any modern technology stack.

### Status

🟡 In Progress

---

## ⬜ Gate 4 — Technical Design

### Objective

Translate the software architecture into detailed implementation guidance.

### Deliverables

* API Design
* Persistence Model
* Integration Design
* Security Design
* Non-Functional Requirements
* Deployment Strategy

### Exit Criteria

A complete technical design capable of guiding implementation.

### Status

⬜ Not Started

---

## ⬜ Gate 5 — MVP Implementation

### Objective

Build the first production-ready implementation of E-Fee.

### Deliverables

* Backend
* Frontend
* Database
* Automated Tests
* CI/CD Pipeline

### Exit Criteria

Feature-complete MVP ready for deployment to the partner school.

### Status

⬜ Not Started

---

## ⬜ Gate 6 — Beta Validation

### Objective

Deploy E-Fee to the partner school and validate business assumptions.

### Deliverables

* Beta Deployment
* User Feedback
* Bug Fixes
* Product Improvements

### Exit Criteria

The partner school successfully manages day-to-day fee receivables using E-Fee.

### Status

⬜ Not Started

---

## ⬜ Gate 7 — Commercial Readiness

### Objective

Prepare E-Fee for adoption by additional educational institutions.

### Deliverables

* Product Hardening
* Documentation
* Customer Onboarding
* Pricing Strategy
* Licensing
* Operational Support

### Exit Criteria

The platform is ready for commercial rollout.

### Status

⬜ Not Started

---

# Current Progress

| Area                     | Status |
| ------------------------ | ------ |
| Product Foundation       | ✅      |
| Business Specification   | ✅      |
| Software Domain Model    | ✅      |
| Repository Consolidation | ✅      |
| Software Architecture    | 🟡     |
| Technical Design         | ⬜      |
| MVP Implementation       | ⬜      |
| Beta Validation          | ⬜      |
| Commercial Readiness     | ⬜      |

---

# Current Focus

The immediate objective is to complete **Gate 3 — Software Architecture**.

The architecture should emerge naturally from the Software Domain Model while preserving the business truths established in **Specification v1.0.0**.

No implementation technology should influence architectural decisions prematurely.

---

# Success Criteria

Gate 3 will be considered complete when:

* Aggregate boundaries are clearly defined.
* Aggregate Roots have been identified.
* Domain responsibilities are well established.
* Architectural decisions are documented through ADRs.
* The architecture remains faithful to the Software Domain Model.

---

# Key Decisions

* Business understanding precedes software modelling.
* Software modelling precedes architecture.
* Architecture precedes implementation.
* Every gate has explicit deliverables and exit criteria.
* The specification serves as the permanent source of truth throughout the project lifecycle.

---

# Related Documents

* ProductVision.md
* ProblemStatement.md
* MVPScope.md
* SoftwareDomainModel.md

---

# Open Questions

None.

---

# Version History

| Version | Date       | Description                                                                                                                        |
| ------- | ---------- | ---------------------------------------------------------------------------------------------------------------------------------- |
| 1.0.0   | 2026-06-29 | Initial roadmap                                                                                                                    |
| 1.1.0   | 2026-07-03 | Updated to reflect completed Gate 2, introduction of Software Domain Modelling as a distinct gate and revised engineering roadmap. |

---

# Approval

**Status:** Approved

## Approved By

* Product Owner
* CTO

## Approval Date

2026-07-03
