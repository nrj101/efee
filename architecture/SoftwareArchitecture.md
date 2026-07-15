# Software Architecture

```yaml
---
document_id: SA-001
title: Software Architecture
version: 1.1.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-07-04
last_updated: 2026-07-14

related_documents:
  - architecture/adr/ADR-001-Domain Architecture Strategy.md
  - ArchitecturePatterns.md
  - AggregateDesign.md
  - ApplicationServices.md
  - ModuleDesign.md
  - CrossCuttingConcerns.md
  - ../spec/docs/SoftwareDomainModel.md
---
```

---

# Purpose

This document defines the high-level software architecture of the Student Fee Receivables Platform.

It describes how the approved Product Specification is realized through software modules, architectural layers and component collaboration.

The detailed domain design is defined in **AggregateDesign.md**, while platform-wide architectural policies are documented in **CrossCuttingConcerns.md**.

This document focuses on the organization of the software system rather than individual domain concepts or implementation details.

---

# Scope

## In Scope

- Overall architecture
- Architectural style
- Module organization
- Layer responsibilities
- Component interaction
- Dependency rules
- System boundaries

## Out of Scope

- Product behaviour
- Aggregate design
- Business rules
- Database schema
- Framework implementation
- Deployment topology
- Infrastructure configuration
- Cross-cutting architectural policies

---

# Architectural Goals

The software architecture has been designed to achieve the following goals.

- Preserve business correctness.
- Preserve financial integrity.
- Maintain clear ownership boundaries.
- Maintain separation of concerns.
- Support incremental evolution.
- Minimize coupling.
- Maximize maintainability.
- Enable deterministic AI-assisted development through explicit architectural boundaries.

---

# Architectural Style

The MVP adopts a **Modular Monolith** architecture.

The application is deployed as a single executable while being internally organized into cohesive business modules.

Each module owns one or more Aggregates responsible for a well-defined business capability and collaborates with other modules only through approved interfaces coordinated by the Application Layer.

This approach provides operational simplicity for the MVP while preserving a migration path toward distributed services should future business requirements justify such evolution.

---

# Architectural Layers

The software is organized into four logical layers.

```text
+------------------------------------------------------+
|                 Presentation Layer                   |
|          Web UI • REST APIs • Administration         |
+------------------------------------------------------+
|                 Application Layer                    |
|     Use Cases • Coordination • Transactions          |
+------------------------------------------------------+
|                    Domain Layer                      |
| Aggregates • Entities • Value Objects • Policies     |
+------------------------------------------------------+
|                Infrastructure Layer                  |
| Persistence • Messaging • External Systems           |
+------------------------------------------------------+
```

Each layer has clearly defined responsibilities and dependency rules.

![Image - Architecture Overview](/architecture/diagrams/D1-ArchitectureOverview.png)

---

# Layer Responsibilities

## Presentation Layer

Responsible for interaction with external actors.

Responsibilities include:

- User interaction
- Request validation
- Response generation
- Authentication integration (future)

The Presentation Layer SHALL NOT contain business rules.

---

## Application Layer

Coordinates business workflows.

Responsibilities include:

- Orchestrating Aggregate collaboration
- Managing transaction boundaries
- Invoking Aggregate behaviour
- Coordinating approvals
- Returning application results
- Publishing business events (future)

Business rules SHALL remain inside the Domain Layer.

---

## Domain Layer

Represents the business domain.

Responsibilities include:

- Aggregate behaviour
- Business invariants
- Aggregate invariants
- Lifecycle management
- Business policies
- Value Objects
- Domain Services (where justified)

The Domain Layer SHALL remain independent of frameworks and infrastructure.

---

## Infrastructure Layer

Provides technical capabilities required by the application.

Examples include:

- Persistence
- External integrations
- Messaging
- Logging
- File storage

Infrastructure SHALL support the Domain Layer without influencing business behaviour.

---

# Architectural Building Blocks

The architecture is composed of several complementary design views.

| Building Block | Responsibility |
|----------------|----------------|
| Aggregate Design | Defines business ownership boundaries. |
| Module Design | Organizes Aggregates into cohesive business capabilities. |
| Application Services | Coordinates cross-Aggregate business workflows. |
| Architecture Patterns | Defines reusable architectural patterns. |
| Cross Cutting Concerns | Defines platform-wide architectural policies. |
| ADRs | Capture architectural evolution and design decisions. |

Together these documents constitute the approved software architecture.

---

# Dependency Principle

Dependencies always flow inward.

Higher architectural layers depend upon lower-level abstractions, while the Domain Layer remains independent of implementation technologies.

Business correctness shall remain independent of frameworks, persistence technologies and infrastructure concerns.

---

# Cross-Cutting Architectural Policies

Several architectural policies apply uniformly across all modules, Aggregates and Application Services.

To avoid duplication and ensure consistency, these policies are documented separately in **CrossCuttingConcerns.md**.

These include:

- Aggregate identity strategy
- Business reference numbering
- Business event catalogue
- Audit and traceability
- Monetary precision
- Time handling
- Transaction boundaries
- Versioning philosophy
- Authorization philosophy

All architectural and implementation decisions SHALL comply with these policies.

---

# Architecture Governance

The architecture evolves independently of implementation.

Business evolution begins through approved RFCs.

Architectural evolution occurs through approved ADRs.

Implementation SHALL preserve the approved Product Specification and Software Architecture.

---

# Key Decisions

- The MVP adopts a Modular Monolith architecture.
- Modules are organized around business capabilities.
- Aggregates own business truth.
- Application Services coordinate business workflows.
- Business rules remain within the Domain Layer.
- Cross-cutting policies are centralized.
- Architectural evolution is governed through ADRs.

---

# Related Documents

- AggregateDesign.md
- ModuleDesign.md
- ApplicationServices.md
- ArchitecturePatterns.md
- CrossCuttingConcerns.md
- SoftwareDomainModel.md

---

# Open Questions

None.

---

# Version History

| Version | Date | Description |
|----------|------------|-------------|
| 1.0.0 | 2026-07-04 | Initial Software Architecture. |
| 1.1.0 | 2026-07-14 | Approved following Specification v1.1.0 reconciliation. Added Architecture Governance, Architectural Building Blocks, strengthened layering principles, aligned terminology with Aggregate Design v1.1.0, Module Design v1.1.0 and Application Services v1.1.0, and established the architecture as the approved MVP implementation baseline. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- CTO

## Approval Date

2026-07-14