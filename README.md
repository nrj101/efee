# E-Fee Product & Engineering Specification

# README

```yaml id="e7y2pk"
---
document_id: README-001
title: Repository Overview
version: 1.1.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-06-29
last_updated: 2026-07-03
next_review: After Specification v1.0.0

related_documents:
  - SPECIFICATION_STANDARDS.md
  - CHANGELOG.md
  - ProjectRoadmap.md
---
```

---

# Welcome

Welcome to the **E-Fee repository**.

This repository is organized into three major areas:

app/
Implementation

project/
Working project documents

spec/
Permanent product specification

This repository contains the complete business, software and engineering specification for **E-Fee**, a SaaS platform that enables educational institutions to confidently manage student fee receivables.

The specification is the **single source of truth** for the product.

Implementation follows the specification.

---

# Repository Structure

```text
/
│
├── README.md                ⭐
├── LICENSE
├── .gitignore
│
├── app/
│
├── project/
│     AI_COLLABORATION_CHARTER.md
│     ArchitectureNotes.md
│     NextSession.md
│     StatusReport.md
│
└── spec/
      CHANGELOG.md
      SPECIFICATION_STANDARDS.md
      BusinessObjectGraph.png
      │
      docs/
          ProblemStatement.md
          ProductVision.md
          ....
          ....
          adr/
          rfc/
```

---

# Repository Organization

The repository is intentionally divided into three independent areas.

## app/

Contains the software implementation.

---

## project/

Contains living project documentation used during development, planning and collaboration.

These documents describe **how the product is being built**, not the product itself.

---

## spec/

Contains the permanent product specification.

These documents describe **what E-Fee is** and serve as the long-term knowledge base for the product.

---

# Reading Order

New contributors should read the specification in the following order.

## Product Foundation

1. ProblemStatement.md
2. ProductVision.md
3. MVPScope.md
4. UserPersonas.md

---

## Business Specification

5. DomainGlossary.md
6. BusinessRules.md
7. BusinessWorkflow.md
8. BusinessObjectGraph.md

---

## Software Specification

9. SoftwareDomainModel.md
10. DecisionLog.md

---

## Supporting Documents

11. ProjectRoadmap.md

Architecture Decision Records (ADRs) and Requests for Change (RFCs) should be consulted as required.

---

# Specification Structure

The specification progresses through a series of increasingly concrete models.

```text
Problem Statement
        │
        ▼
Product Vision
        │
        ▼
Business Rules
        │
        ▼
Business Workflow
        │
        ▼
Business Object Graph
        │
        ▼
Software Domain Model
        │
        ▼
Software Architecture
        │
        ▼
Implementation
```

Each layer builds upon the previous one while preserving a single responsibility.

---

# Current Status

## Specification Version

**Specification v1.0.0**

---

## Current Milestone

**Gate 2 — Business & Software Domain Modelling**

**Status:** Complete

---

## Next Milestone

**Gate 3 — Software Architecture**

---

# Guiding Principles

The product follows these principles.

* Business First
* Simplicity Before Complexity
* Software Preserves Business Truth
* Every Financial Decision Must Be Explainable
* Financial History Is Immutable
* Architecture Drives Implementation
* AI Assists, Humans Decide

---

# Repository Rules

* The specification is the permanent memory of the product.
* Every significant decision should be documented.
* Approved documents should evolve through controlled versioning.
* Modelling decisions belong in the Modelling Decision Log.
* Architecture decisions belong in ADRs.
* Product evolution should begin with an RFC whenever appropriate.
* Avoid duplicating knowledge across documents.

---

# Versioning

Each specification document is versioned independently using Semantic Versioning.

The repository `CHANGELOG.md` records major specification milestones and repository evolution.

Individual document version histories record document-specific changes.

---

# Contribution Workflow

Every significant change should follow this progression.

```text
Idea
   │
   ▼
Discussion
   │
   ▼
Specification Update
   │
   ▼
Review
   │
   ▼
Approval
   │
   ▼
Implementation
```

Implementation should never precede an approved specification.

---

# AI Usage

AI is an engineering assistant.

AI may assist with:

* Analysis
* Documentation
* Design
* Architecture discussions
* Code generation
* Test generation
* Reviews

Business ownership, modelling decisions and architectural decisions remain human responsibilities.

---

# Repository Goals

The specification aims to produce software that is:

* Business-driven
* Maintainable
* Auditable
* Secure
* Extensible
* Explainable
* Understandable

The specification should remain implementation-independent wherever practical.

---

# Related Documents

* SPECIFICATION_STANDARDS.md
* CHANGELOG.md
* ProjectRoadmap.md

---

# Open Questions

None.

---

# Version History

| Version | Date       | Description                                                                                |
| ------- | ---------- | ------------------------------------------------------------------------------------------ |
| 1.0.0   | 2026-06-29 | Initial repository overview                                                                |
| 1.1.0   | 2026-07-03 | Updated for completed Gate 2, repository reorganization and Specification v1.0.0 baseline. |

---

# Approval

**Status:** Approved

## Approved By

* Product Owner
* CTO

## Approval Date

2026-07-03
