# E-Fee — Student Fee Receivables Platform

## Overview

**E-Fee** is a SaaS platform designed to help educational institutions manage the complete lifecycle of student fee receivables—from the creation of financial obligations through final settlement—while preserving complete financial auditability.

The project follows a **specification-first engineering approach** in which product understanding, business modelling, software architecture and implementation evolve through distinct engineering phases. Each phase produces independently reviewable engineering artifacts that collectively serve as the authoritative foundation for implementation.

---

# Repository Organization

The repository is organized into the following major areas.

## `/spec`

Authoritative Product Specification.

Contains the implementation-independent description of the business domain, including:

- Product Vision
- Problem Statement
- MVP Scope
- Domain Glossary
- Business Rules
- Business Workflows
- Business Object Graph
- Software Domain Model
- RFCs

These documents define **what** the platform must accomplish and remain the permanent source of truth throughout the product lifecycle.

---

## `/architecture`

Implementation-independent Software Architecture.

Contains:

- Software Architecture
- Aggregate Design
- Aggregate Specifications
- Module Design
- Architecture Patterns
- Cross-Cutting Concerns
- Architectural Decision Records (ADRs)
- Architecture diagrams

These documents define **how the software is organized** while remaining independent of programming languages, frameworks and infrastructure.

---

## `/technical-specification`

Implementation-neutral Technical Design.

Contains:

- Technical Specification Standards
- Aggregate Technical Specifications
- Aggregate Persistence Models

These documents bridge the gap between Software Architecture and implementation by defining implementation obligations while remaining technology independent.

---

## `/docs/ai`

AI Engineering Framework.

The project adopts **AI Engineering Framework v1.1.0**, providing a disciplined and repeatable approach to AI-assisted software engineering.

The framework includes:

- Engineering Constitution
- Developer Personas
- Runtime Prompts
- Story Package Template
- Canonical Engineering Examples

The framework governs **how implementation is performed** but does not define product behaviour or software architecture.

---

## `/Sprint-*`

Reference implementation Sprints.

Each Sprint contains one or more Story Packages.

A Story Package represents the complete implementation contract for an individual engineering Story and typically contains:

- Story
- Implementation Guide
- Source
- Tests
- README

Completed Sprints also include Sprint planning and Sprint retrospective artifacts, providing a complete engineering record from planning through implementation review.

---

## `/project`

Project management artifacts.

Examples include:

- Status Reports
- Next Session planning
- Release planning
- Project coordination documents

These artifacts support project execution but are not part of the approved engineering baseline.

---

## `/app`

Production application source code.

Approved implementations progressively migrate from Story Packages into the production application.

The `/app` directory represents the deployable software rather than the engineering workspaces used during implementation.

---

# Engineering Lifecycle

Development progresses through distinct engineering phases.

```text
Product Understanding
        │
        ▼
Business Specification
        │
        ▼
Software Domain Modelling
        │
        ▼
Software Architecture
        │
        ▼
Technical Specification
        │
        ▼
Persistence Model
        │
        ▼
Sprint Planning
        │
        ▼
Story Packages
        │
        ▼
AI-Assisted Implementation
        │
        ▼
Implementation Review
        │
        ▼
Sprint Retrospective
```

Each phase builds upon the previous one while preserving approved engineering artifacts.

---

# AI-Assisted Development

Implementation is performed using the approved AI Engineering Framework.

The framework enforces:

- specification-first development;
- architecture preservation;
- explicit business rule compliance;
- controlled implementation scope;
- deterministic engineering behaviour; and
- continuous engineering governance.

Implementation begins from an approved Story Package rather than directly from the Product Specification.

---

# Current Project Status

Specification **v1.1.0** establishes the approved engineering baseline for the MVP.

Sprint-001 serves as the reference implementation Sprint, validating both the engineering artifacts and the AI Engineering Framework through real implementation.

Future development builds incrementally upon this approved baseline.

The repository intentionally separates:

- Product Specification
- Software Architecture
- Technical Specification
- AI Engineering Framework
- Story Packages
- Production Implementation

This separation allows business knowledge, architecture, engineering process and implementation to evolve independently while remaining consistent.

---

# Guiding Principles

The project follows the following core principles:

- Business understanding precedes implementation.
- Product Specification is the authoritative source of business truth.
- Software Architecture preserves business correctness.
- Technical Specifications eliminate implementation ambiguity.
- Every implementation originates from an approved Story Package.
- AI engineers operate under a common Engineering Constitution.
- Architectural evolution occurs only through approved governance.
- Implementation must never contradict approved specifications or architecture.