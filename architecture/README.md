# Software Architecture

This directory contains the software architecture of the Student Fee Receivables Platform.

The architecture defines **how the approved Product Specification is realized in software** while remaining independent of implementation technologies.

Business behaviour continues to be defined exclusively within the Product Specification (`/spec`).

---

## Purpose

The architecture documents establish:

* software organization;
* ownership boundaries;
* architectural principles;
* module structure;
* application orchestration; and
* long-term design rationale.

Implementation details are intentionally excluded.

---

## Document Guide

| Document                    | Purpose                                                         |
| --------------------------- | --------------------------------------------------------------- |
| `ARCHITECTURE_STANDARDS.md` | Standards governing all architecture documentation.             |
| `adr/`                      | Architecture Decision Records (ADRs).                           |
| `ArchitecturePatterns.md`   | Recurring architectural principles and modelling patterns.      |
| `AggregateDesign.md`        | Aggregate ownership, business boundaries and interaction rules. |
| `SoftwareArchitecture.md`   | High-level software organization and architectural layers.      |
| `ModuleDesign.md`           | Logical module decomposition and dependency rules.              |
| `ApplicationServices.md`    | Application-layer orchestration of business capabilities.       |

---

## Recommended Reading Order

1. `ARCHITECTURE_STANDARDS.md`
2. `adr/ADR-001-Domain Architecture Strategy.md`
3. `ArchitecturePatterns.md`
4. `AggregateDesign.md`
5. `SoftwareArchitecture.md`
6. `ModuleDesign.md`
7. `ApplicationServices.md`

---

## Architecture Diagrams

Architecture diagrams are maintained under `/architecture/diagrams`.

Each diagram has one canonical home within the architecture documentation, where it is introduced and explained.

The diagram files themselves should remain implementation-independent and evolve alongside the architecture through ADRs where applicable.

---

## Governance

Architecture evolves independently from the Product Specification.

* Business changes are governed through **RFCs**.
* Architectural changes are governed through **ADRs**.
* Implementation changes are governed through the engineering process and code review.

---

## Guiding Principle

The software architecture exists to faithfully realize the approved Product Specification while preserving business correctness, maintainability and long-term evolvability.
