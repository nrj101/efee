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

This repository contains the complete business, software and engineering specification for **E-Fee**, a SaaS platform that enables educational institutions to confidently manage student fee receivables.

The specification is the **single source of truth** for the product.

Implementation follows the specification.

---

# Repository Structure

```text
# Repository Structure

```text
/
│
├── README.md                          ⭐ Repository entry point
├── LICENSE
├── .gitignore
│
├── app/                               # Production source code
│
├── architecture/                      # Software architecture
│   │
│   ├── ArchitecturePatterns.md
│   ├── SoftwareArchitecture.md
│   │
│   └── adr/
│       └── ADR-001-Domain Architecture Strategy.md
│
├── project/                           # Engineering governance & planning
│   │
│   ├── AI_COLLABORATION_CHARTER.md
│   ├── NextSession.md
│   └── StatusReport.md
│
└── spec/                              # Product specification
    │
    ├── CHANGELOG.md
    ├── SPECIFICATION_STANDARDS.md
    ├── BusinessObjectGraph.png
    │
    └── docs/
        │
        ├── ProblemStatement.md
        ├── ProductVision.md
        ....
        ....
        │
        └── rfc/
            └── RFC-001.md
```

---

# Repository Organization

The repository is organized into independent layers, each with a single responsibility. This separation ensures that product requirements, software architecture, engineering processes, and implementation evolve independently while remaining traceable. 

| Folder          | Purpose                                                                   | Primary Question                             | Governed By                   |
| --------------- | ------------------------------------------------------------------------- | -------------------------------------------- | ----------------------------- |
| `/spec`         | Product specifications and business knowledge                             | **What** should the product do?              | RFC                           |
| `/architecture` | Software architecture and design decisions                                | **How** should software realize the product? | ADR                           |
| `/project`      | Project governance, planning, AI collaboration, and engineering processes | **How** is the project executed?             | Project Process               |
| `/app`          | Production source code and implementation                                 | **How** is the architecture implemented?     | Code Review & AI Constitution |

## Relationship Between Layers

The repository follows a layered evolution model.

```text
Product Specification
        │
        ▼
Software Architecture
        │
        ▼
Engineering Process
        │
        ▼
Implementation
```

Each layer builds upon the one above it while remaining independently governable.

* **Product Specification** defines the business domain and product behaviour without prescribing implementation.
* **Software Architecture** translates the approved specification into a software design while preserving business intent.
* **Engineering Process** defines how contributors (human and AI) collaborate to build the software consistently.
* **Implementation** contains the executable realization of the approved architecture.

## Folder Overview

### `/spec`

Contains the permanent product specification and business knowledge for the E-Fee platform.

These documents describe **what the product is**, independent of any specific software architecture or technology. The Specification serves as the long-term source of truth for product behaviour and evolves through the RFC process.

---

### `/architecture`

Contains the software architecture that realizes the approved product specification.

These documents define **how the software is designed** while remaining faithful to the business domain. Architecture evolves independently from the product specification and is governed through Architecture Decision Records (ADRs).

---

### `/project`

Contains engineering governance and project management artifacts used during development.

This includes AI collaboration guidance, planning documents, session notes, status reports, sprint planning, and other engineering processes that support implementation but do not define the product itself.

---

### `/app`

Contains the production source code.

The implementation is expected to conform to both the approved Product Specification and the Software Architecture. Source code evolves through normal development practices, including code reviews and the AI Constitution.


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

## Modifications

| Artifact                  | Purpose                       | Can change via        |
| ------------------------- | ----------------------------- | --------------------- |
| Product Vision            | Why the product exists        | Human                 |
| MVP Scope                 | What is in/out                | RFC                   |
| Business Rules            | Business truth                | RFC                   |
| Domain Model              | Business concepts             | RFC                   |
| **Software Architecture** | How business maps to software | ADR                   |
| AI Constitution           | How AI works                  | Constitution version  |
| Implementation            | Code                          | Pull Request + Review |


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
