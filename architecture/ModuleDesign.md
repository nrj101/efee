# Module Design

```yaml
---
document_id: MOD-001
title: Module Design
version: 1.1.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-07-04
last_updated: 2026-07-14

related_documents:
  - AggregateDesign.md
  - SoftwareArchitecture.md
  - ApplicationServices.md
  - CrossCuttingConcerns.md
---
```

---

# Purpose

This document defines the logical software modules of the E-Fee platform.

Modules partition the software into cohesive business capabilities while preserving the Aggregate ownership boundaries established by the Software Architecture.

Modules provide the primary unit of organization within the MVP Modular Monolith.

---

# Design Principles

Modules are organized around business capabilities rather than technical layers.

Each module SHALL:

- own one primary business capability;
- own one or more closely related Aggregates;
- encapsulate its internal implementation;
- expose well-defined business interfaces;
- collaborate with other modules only through approved interfaces or Application Services; and
- minimise coupling with other modules.

The objective is to preserve high cohesion, clear ownership and long-term maintainability.

![Image - Module Dependencies](/architecture/diagrams/D2-ModuleDependencies.png)

---

# Module Catalogue

## Shared

Provides reusable technical building blocks that are common across the platform.

Examples include:

- Value Objects
- Domain Exceptions
- Common Types
- Shared Utilities

The Shared module SHALL NOT contain business behaviour or business rules.

---

## Student

### Responsibility

Owns Student identity and lifecycle.

### Primary Aggregate

- Student

### Collaborating Modules

- Academic Year
- Fee Obligation
- Discount

---

## Academic Year

### Responsibility

Owns Academic Year lifecycle and operational boundaries.

### Primary Aggregate

- Academic Year

### Collaborating Modules

- Fee Structure
- Fee Obligation
- Receipt

---

## Fee Structure

### Responsibility

Owns institutional charging policy.

### Primary Aggregate

- Fee Structure

### Collaborating Modules

- Academic Year
- Fee Obligation

---

## Discount

### Responsibility

Owns approved student discount entitlements.

### Primary Aggregate

- Discount

### Collaborating Modules

- Student
- Fee Obligation

---

## Fee Obligation

### Responsibility

Owns student financial responsibility and receivable state.

### Primary Aggregate

- Fee Obligation

### Collaborating Modules

- Student
- Academic Year
- Fee Structure
- Discount
- Payment

---

## Payment

### Responsibility

Owns realised payments received by the institution.

### Primary Aggregate

- Payment

### Collaborating Modules

- Fee Obligation
- Receipt

---

## Receipt

### Responsibility

Owns official acknowledgement of accepted Payments.

### Primary Aggregate

- Receipt

### Collaborating Modules

- Payment

---

# Module Dependencies

Logical dependencies between modules are intentionally restricted.

| Module | May Depend On |
|---------|---------------|
| Student | Shared |
| Academic Year | Shared |
| Fee Structure | Shared, Academic Year |
| Discount | Shared, Student |
| Fee Obligation | Shared, Student, Academic Year, Fee Structure, Discount |
| Payment | Shared, Fee Obligation |
| Receipt | Shared, Payment |

Dependencies SHALL remain acyclic.

---

# Collaboration Principles

Modules collaborate through Application Services.

Cross-module business workflows SHALL be coordinated by the Application Layer rather than by direct module orchestration.

Each module remains responsible only for the Aggregates and business truths it owns.

---

# Visibility Rules

Modules expose only approved business interfaces.

Internal implementation details SHALL remain encapsulated within the owning module.

Modules SHALL NOT directly modify another module's owned business state.

Cross-module communication SHALL occur only through:

- Application Services; or
- explicitly approved public interfaces.

---

# Future Evolution

The Modular Monolith establishes clear business boundaries that may later evolve into independently deployable services if justified by business requirements.

Any future decomposition SHALL preserve:

- Aggregate ownership;
- business invariants;
- module responsibilities; and
- Application Service orchestration.

---

# Key Decisions

- Modules are organized around business capabilities.
- Aggregate ownership determines module ownership.
- Cross-module workflows are coordinated by Application Services.
- Business truths remain owned by a single module.
- Modules remain implementation-independent.

---

# Related Documents

- SoftwareArchitecture.md
- AggregateDesign.md
- ApplicationServices.md
- CrossCuttingConcerns.md

---

# Open Questions

None.

---

# Version History

| Version | Date | Description |
|---------|------------|-------------|
| 1.0.0 | 2026-07-04 | Initial Module Design. |
| 1.1.0 | 2026-07-14 | Aligned module responsibilities with Aggregate Design v1.1.0. Renamed the Receivables module to Fee Obligation, simplified the Discount module following RFC-002, clarified Application Service orchestration, standardized dependency rules and visibility principles, and approved the document as the MVP modular architecture baseline. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- CTO

## Approval Date

2026-07-14