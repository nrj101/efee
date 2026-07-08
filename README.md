# E-Fee — Student Fee Receivables Platform

## Overview

**E-Fee** is a SaaS platform designed to help educational institutions manage the complete lifecycle of student fee receivables—from the creation of financial obligations through final settlement—while preserving complete financial auditability.

The project follows a specification-first engineering approach. Product understanding, business modelling, software architecture and implementation are developed as distinct engineering phases, allowing each stage to remain independently reviewable and reusable.

---

# Repository Organization

The repository is organized into several major areas.

## `/spec`

Authoritative product specification.

Contains the implementation-independent description of the business domain, including:

* Product Vision
* Problem Statement
* MVP Scope
* Business Rules
* Business Workflow
* Domain Glossary
* Software Domain Model
* Business Object Graph

These documents define **what** the system must accomplish.

They remain the permanent source of truth throughout the project lifecycle.

---

## `/architecture`

Implementation-independent software architecture.

Contains:

* Software Architecture
* Aggregate Design
* Aggregate-specific Architecture
* Architecture Patterns
* Module Design
* Architectural Decision Records (ADRs)
* Architecture diagrams

These documents define **how the software should be organized** while remaining independent of any programming language or framework.

---

## `/technical-specification`

Implementation-neutral technical specifications.

Contains one Technical Specification for each Aggregate.

Each document defines:

* Aggregate responsibilities
* Owned state
* Lifecycle model
* Consistency requirements
* Collaboration contracts
* Implementation obligations
* Story traceability

These documents bridge the gap between Software Architecture and implementation while remaining independent of programming languages and frameworks.

--- 

## `/docs/ai`

AI Engineering Framework adopted by this project.

This repository adopts **AI Engineering Framework v1.0**, which provides a disciplined and repeatable methodology for AI-assisted software development.

The framework includes:

* Engineering Constitution
* AI Personas
* Runtime Prompts
* Story Package Templates
* Canonical Engineering Examples

The framework governs **how AI engineers perform implementation**, but does not define product behaviour or software architecture.

---

## `/Sprint-*`

Implementation workspaces.

Each Sprint contains one or more Story Packages.

A Story Package represents the complete implementation contract for a single engineering story and typically contains:

* Story
* Implementation Guide
* README
* Source artifacts
* Test artifacts

Story Packages are intentionally self-contained to support repeatable AI-assisted implementation.

---

## `/project`

Project management artifacts.

Examples include:

* Status Reports
* Next Session planning
* Implementation planning
* Other project coordination documents

These artifacts support project execution but are not part of the product specification.

---

## `/app`

Application source code.

Production implementation will gradually emerge here as approved Story Packages are implemented.

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
Sprint Planning
        │
        ▼
Story Packages
        │
        ▼
AI-Assisted Implementation
        │
        ▼
Verification & Review
```

Each phase builds upon the previous one while preserving the approved engineering artifacts.

---

# AI-Assisted Development

Implementation is performed using the adopted AI Engineering Framework.

The framework enforces:

* specification-first development;
* architecture preservation;
* explicit business rule compliance;
* controlled implementation scope;
* repeatable engineering behaviour.

Implementation always begins from an approved Story Package rather than directly from the product specification.

---

# Current Project Status

The Product Specification, Software Architecture and Technical Specification together constitute the approved engineering baseline for MVP implementation.

Current development focuses on incrementally implementing Story Packages while validating the AI Engineering Framework through real engineering work.

The repository intentionally separates:

* Product Specification
* Software Architecture
* Technical Specification
* AI Engineering Framework
* Story Packages
* Implementation artifacts

This separation allows the product, architecture, implementation guidance and engineering process to evolve independently while remaining consistent.

---

# Guiding Principles

The project follows several core principles:

* Business understanding precedes implementation.
* Software architecture preserves business correctness.
* Every implementation originates from an approved Story Package.
* AI engineers operate under a common Engineering Constitution.
* Implementation must never contradict approved specifications or architecture.
* Product documentation remains the authoritative source of truth throughout the project lifecycle.
