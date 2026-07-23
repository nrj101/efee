# E-Fee Product & Engineering Specification

# Project Roadmap

```yaml
---
document_id: ROADMAP-001
title: Project Roadmap
version: 1.5.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-06-29
last_updated: 2026-07-23
next_review: At the completion of every Engineering Gate

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

- Where are we?
- What have we completed?
- What comes next?

Unlike the Product Vision or Business Rules, this document evolves throughout the lifetime of the project and reflects the current state of product development.

---

# Scope

This document describes:

- Project progression
- Engineering Gates
- Major milestones
- Current engineering status
- Future development direction

It does **not** define business requirements, software architecture or implementation details.

---

# Product Overview

## Engineering Name

**Student Fee Receivables Platform**

---

## Commercial Brand

**E-Fee**

---

## Mission

Build an affordable, secure and audit-friendly SaaS platform that enables educational institutions to confidently manage every fee obligation from creation through final settlement while preserving complete financial integrity and auditability.

---

# Current Status

## Current Gate

🟡 **Gate 5 — MVP Engineering**

---

## Current Milestone

**Sprint-002 Reference Implementation Established**

---

# Engineering Baseline

The following engineering artifacts now form the approved implementation baseline for continued MVP development.

- Product Specification v1.2.0
- Software Architecture v1.2.0
- Technical Specification v1.2.0
- Technical Design (initial)
- Sprint-001 Reference Implementation
- Sprint-002 Reference Implementation
- Production Application (`app/`)
- AI Engineering Framework v1.0

Sprint-001 and Sprint-002 have collectively validated:

- Story Package driven implementation;
- AI-assisted software development workflow;
- Production integration process;
- Gradle build validation;
- automated unit testing;
- engineering governance through RFCs and ADRs;
- repeatable implementation across multiple architectural layers.

The current engineering baseline has been validated through successful execution of **154 automated unit tests with zero failures**.

Future implementation SHALL extend this engineering baseline rather than redefine it.

---

# Engineering Roadmap

## ✅ Gate 1 — Product Foundation

### Objective

Understand the business problem and establish a clear product direction.

### Deliverables

- Problem Statement
- Product Vision
- MVP Scope
- User Personas

### Exit Criteria

A shared understanding of the business problem, product vision and MVP boundaries.

### Status

✅ Completed

---

## ✅ Gate 2 — Business & Software Domain Modelling

### Objective

Develop a complete, implementation-independent specification of the business and its software representation.

### Deliverables

- Domain Glossary
- Business Rules
- Business Workflow
- Business Object Graph
- Software Domain Model
- Modelling Decision Log

### Exit Criteria

A stable specification describing the complete business and software domain independent of implementation technology.

### Status

✅ Completed

---

## ✅ Gate 3 — Software Architecture

### Objective

Design the software architecture that faithfully realizes the approved Software Domain Model.

### Deliverables

- Aggregate Design
- Architecture Patterns
- Application Services
- Cross Cutting Concerns
- Architecture Standards
- Architecture Decision Records

### Exit Criteria

A complete implementation-independent software architecture suitable for realization in any modern technology stack.

### Status

✅ Completed

---

## ✅ Gate 4 — Technical Specification

### Objective

Translate the approved Software Architecture into implementation-neutral technical specifications.

### Deliverables

- Technical Specification Standards
- Aggregate Technical Specifications
- Persistence Models
- Collaboration Contracts
- Story Traceability

### Exit Criteria

Complete implementation-neutral technical specifications exist for every Aggregate while preserving the approved Product Specification and Software Architecture.

### Status

✅ Completed

---

## 🟡 Gate 5 — MVP Engineering

### Objective

Incrementally implement the approved engineering specification while validating the AI Engineering Framework through real software development.

### Deliverables

- Story Package implementations
- Reference Sprint implementations
- Production application
- Automated unit tests
- Engineering validation
- Continuous implementation verification

### Exit Criteria

- MVP business capabilities implemented.
- Every Sprint preserves the approved engineering baseline.
- Story Packages consistently produce deterministic implementations.
- Production integration remains reproducible.
- Automated testing validates all implemented business invariants.
- AI Engineering Framework consistently produces reviewable implementations.

### Current Progress

✅ Sprint-001 Complete

✅ Sprint-002 Complete

Sprint-002 establishes the first fully integrated and validated reference implementation of the E-Fee platform.

Subsequent Sprint Packages continue under the approved engineering baseline.

### Status

🟡 In Progress

---

## ⬜ Gate 6 — Beta Validation

### Objective

Deploy E-Fee to the partner institution and validate business assumptions under real operational conditions.

### Deliverables

- Beta deployment
- User validation
- Bug fixes
- Product improvements
- Operational feedback

### Exit Criteria

The partner institution successfully manages day-to-day fee receivables using E-Fee.

### Status

⬜ Not Started

---

## ⬜ Gate 7 — Commercial Readiness

### Objective

Prepare E-Fee for adoption by additional educational institutions.

### Deliverables

- Product hardening
- Documentation
- Customer onboarding
- Pricing strategy
- Licensing
- Operational support

### Exit Criteria

The platform is operationally and commercially ready for broader rollout.

### Status

⬜ Not Started

---

# Current Progress

| Area | Status |
|------|--------|
| Product Foundation | ✅ |
| Business Specification | ✅ |
| Software Domain Model | ✅ |
| Software Architecture | ✅ |
| Technical Specification | ✅ |
| Sprint-001 Reference Implementation | ✅ |
| Sprint-002 Reference Implementation | ✅ |
| Production Application | ✅ |
| Gradle Build Validation | ✅ |
| Automated Unit Testing | ✅ |
| AI Engineering Framework Validation | ✅ |
| MVP Engineering | 🟡 |
| Beta Validation | ⬜ |
| Commercial Readiness | ⬜ |

---

# Current Focus

Sprint-001 and Sprint-002 have established the project's validated engineering baseline through successful reference implementations, production integration and automated validation.

The immediate focus is to continue incremental MVP implementation through subsequent Sprint Packages while preserving:

- the approved Product Specification;
- the approved Software Architecture;
- the approved Technical Specification;
- the approved Technical Design;
- the validated AI Engineering Framework;
- the production integration workflow;
- automated build and testing;
- architectural consistency across implementation layers.

Future implementation SHALL extend the approved engineering baseline rather than redefine it.

---

# Success Criteria

Gate 5 will be considered successful when:

- all MVP business capabilities have been implemented;
- every Sprint preserves the approved engineering specification;
- Story Packages consistently produce deterministic, reviewable implementations;
- production integration remains repeatable;
- automated testing validates all implemented business invariants;
- the AI Engineering Framework consistently demonstrates repeatable engineering quality across multiple implementation Sprints.
- integrated reference implementations remain buildable, testable and architecturally consistent.

---

# Key Decisions

- Business understanding precedes software modelling.
- Software modelling precedes architecture.
- Architecture precedes technical specification.
- Technical specification precedes implementation.
- Every Engineering Gate has explicit deliverables and exit criteria.
- The Product Specification remains the permanent source of business truth.
- Sprint Packages produce immutable reference implementations.
- Production code is integrated from approved Story Packages.
- Sprint-001 establishes the initial engineering baseline.
- Sprint-002 establishes the first validated reference implementation baseline.
- Future implementation SHALL extend rather than redefine the approved engineering baseline.

---

# Related Documents

- ProductVision.md
- ProblemStatement.md
- MVPScope.md
- SoftwareDomainModel.md

---

# Open Questions

None.

---

# Version History

| Version | Date | Description |
|---------|------------|-------------|
| 1.0.0 | 2026-06-29 | Initial roadmap. |
| 1.1.0 | 2026-07-03 | Updated to reflect completion of Gate 2, introduction of Software Domain Modelling as a distinct Engineering Gate and revised project roadmap. |
| 1.2.0 | 2026-07-08 | Updated to reflect completion of Software Architecture and Technical Specification and transition to MVP Engineering. |
| 1.3.0 | 2026-07-14 | Updated following the freeze of Specification v1.1.0. Sprint-001 established as the reference implementation and AI Engineering Framework validation baseline for continued MVP development. |
| 1.4.0 | 2026-07-16 | Updated following completion of Sprint-001 reference implementation, production integration, Gradle build validation and establishment of the Golden engineering baseline for continued MVP development. |
| 1.5.0 | 2026-07-23 | Updated following completion of Sprint-002, establishment of the first validated reference implementation, successful production integration, Gradle build validation and execution of 154 automated unit tests with zero failures. |


---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- CTO

## Approval Date

2026-07-16