# E-Fee — Student Fee Receivables Platform

## Overview

**E-Fee** is a SaaS platform designed to help educational institutions manage the complete lifecycle of student fee receivables—from the creation of financial obligations through final settlement—while preserving complete financial integrity and auditability.

The project follows a **Specification-First Engineering** approach in which business understanding, software architecture, technical specification and implementation evolve through well-defined engineering phases.

Each phase produces independently reviewable engineering artifacts that collectively provide complete traceability from business requirements to executable software.

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
- Requests for Change (RFCs)
- Project Roadmap

These documents define **what** the platform must accomplish and remain the permanent source of business truth throughout the product lifecycle.

---

## `/architecture`

Implementation-independent Software Architecture.

Contains:

- Software Architecture
- Aggregate Design
- Architecture Patterns
- Application Services
- Module Design
- Cross-Cutting Concerns
- Architecture Standards
- Architecture Decision Records (ADRs)
- Architecture diagrams

These documents define **how the software is organized** while remaining independent of programming languages, frameworks and infrastructure.

---

## `/technical-specification`

Implementation-neutral Technical Specifications.

Contains:

- Technical Specification Standards
- Aggregate Technical Specifications

These documents translate the approved Software Architecture into precise implementation contracts while remaining technology independent.

---

## `/technical-design`

Technical design supporting implementation.

Currently contains:

- Aggregate Persistence Models

These documents describe implementation-oriented technical concerns that complement the Technical Specifications while remaining independent of any specific persistence technology.

---

## `/Sprint-*`

Reference Implementation Sprints.

Each Sprint contains one or more Story Packages.

A Story Package represents the complete implementation contract for an individual engineering Story and typically contains:

- Story
- Implementation Guide
- Reference Source Code
- Reference Unit Tests
- Story README

Completed Sprints also include Sprint planning and Sprint retrospective artifacts, providing a complete engineering record from planning through implementation review.

Reference implementations remain immutable once approved.

---

## `/app`

Production Application.

The `app` module contains the executable production implementation of the Student Fee Receivables Platform.

Approved reference implementations are integrated into this module after implementation review and architectural validation.

The module includes:

- Gradle build configuration
- Production source code
- Production unit tests
- Standard Java package structure
- Application resources

This module represents the deployable software that will ultimately be promoted through Development, QA, UAT and Production environments.

---

## `/docs/ai`

AI Engineering Framework.

The project adopts a disciplined AI-assisted engineering workflow providing repeatable implementation through approved Story Packages.

The framework includes:

- Engineering Constitution
- Developer Personas
- Runtime Prompts
- Story Package Template
- Canonical Engineering Examples
- AI Engineering Workflows

The framework governs **how implementation is performed** but does not define business behaviour or software architecture.

---

## `/project`

Project management artifacts.

Examples include:

- Status Reports
- Next Session planning
- Engineering feedback
- AI Framework evaluation
- Project coordination documents

These artifacts support project execution but are not part of the approved engineering baseline.

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
Story Planning
        │
        ▼
Story Packages
        │
        ▼
AI-Assisted Reference Implementation
        │
        ▼
Implementation Review
        │
        ▼
Production Integration
        │
        ▼
Build & Test Validation
        │
        ▼
Executable Application
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
- deterministic engineering behaviour;
- implementation traceability; and
- continuous engineering governance.

Implementation always begins from an approved Story Package rather than directly from the Product Specification.

Approved Story implementations become immutable reference implementations before being integrated into the production application.

---

# Current Project Status

The repository has established the first complete engineering baseline for the Student Fee Receivables Platform.

Current baseline includes:

- Product Specification
- Software Architecture
- Technical Specification
- Reference Implementation (Sprint-001)
- Production Application
- AI Engineering Framework

Sprint-001 successfully validated:

- Specification-First Engineering
- Story Package workflow
- AI-assisted implementation
- Production integration
- Automated build and testing
- Engineering governance through RFCs and ADRs

Future implementation builds incrementally upon this approved engineering baseline.

---

# Guiding Principles

The project follows the following core principles:

- Business understanding precedes implementation.
- Product Specification is the authoritative source of business truth.
- Software Architecture preserves business correctness.
- Technical Specifications eliminate implementation ambiguity.
- Every implementation originates from an approved Story Package.
- Reference implementations remain immutable after approval.
- Production code is integrated only from approved reference implementations.
- AI engineers operate under a common Engineering Constitution.
- Architectural evolution occurs only through approved governance.
- Implementation must never contradict approved specifications or architecture.

---

# Repository Philosophy

The repository intentionally separates:

- Product Specification
- Software Architecture
- Technical Specification
- Reference Implementations
- Production Application
- AI Engineering Framework
- Project Management

This separation enables business knowledge, architecture, engineering process and executable software to evolve independently while preserving complete traceability between every engineering artifact.