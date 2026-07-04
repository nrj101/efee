# Architecture Patterns

```yaml
---
document_id: AP-001
title: Architecture Patterns
version: 1.0.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-07-04
last_updated: 2026-07-04
next_review: Before first implementation sprint

related_documents:
  - ADR-001.md
  - SoftwareDomainModel.md
  - BusinessRules.md
  - BusinessWorkflow.md
---
```

---

# Purpose

This document captures recurring architectural patterns adopted by the Student Fee Receivables Platform.

These patterns are derived from the approved business specifications and the Software Domain Model. They provide consistent architectural guidance for implementation without introducing new business behaviour.

Patterns documented here are expected to be reused throughout the software architecture.

---

# Scope

## In Scope

* Domain architecture patterns
* Ownership patterns
* Consistency patterns
* Lifecycle patterns
* Collaboration patterns

## Out of Scope

* Design patterns (Factory, Strategy, etc.)
* Framework-specific implementation
* Infrastructure patterns
* Deployment architecture

---

# AP-001 — Stable Policy and Operational State

## Intent

Separate long-lived institutional policy from runtime operational state.

## Motivation

Institutional policies change infrequently, whereas operational financial state changes continuously throughout an Academic Year.

Separating these responsibilities reduces coupling while preserving business correctness.

## Examples

| Stable Policy       | Operational State                                 |
| ------------------- | ------------------------------------------------- |
| Fee Component       | Obligation Line                                   |
| Discount Policy     | Discount Grant *(software realization candidate)* |
| Academic Year Rules | Financial Activity                                |

## Consequences

* Policies remain stable.
* Operational state evolves independently.
* Historical financial activity remains unaffected by future policy changes.

---

# AP-002 — Single Ownership of Business Truth

## Intent

Every business truth shall have exactly one owning Software Domain Concept.

## Motivation

Shared ownership introduces ambiguity, duplicated state and inconsistent business behaviour.

## Examples

| Business Truth           | Owner           |
| ------------------------ | --------------- |
| Student Identity         | Student         |
| Charging Policy          | Fee Structure   |
| Student Receivable       | Fee Obligation  |
| Money Received           | Payment         |
| Official Acknowledgement | Receipt         |
| Discount Entitlement     | Discount Policy |

## Consequences

* Clear ownership boundaries.
* Reduced coupling.
* Simplified aggregate design.

---

# AP-003 — Immutable Financial Facts

## Intent

Historical financial facts are preserved once they occur.

Corrections introduce new business facts rather than rewriting existing ones.

## Examples

* Payments remain immutable after successful receipt.
* Receipt corrections preserve acknowledgement history.
* Allocation corrections preserve settlement history.

## Consequences

* Complete auditability.
* Financial traceability.
* Simplified reconciliation.

---

# AP-004 — Lifecycle-Driven Operations

## Intent

Lifecycle state determines which business operations are permitted.

## Motivation

Business operations are governed by the current state of the owning business concept rather than by user interface behaviour.

## Examples

* Closed Academic Years reject new financial activity.
* Settled Fee Obligations reject retrospective policy changes.
* Receipt Corrections follow an approval-driven lifecycle.

## Consequences

* Business invariants remain protected.
* Invalid state transitions are prevented.
* Domain behaviour remains predictable.

---

# AP-005 — Collaboration over Shared Ownership

## Intent

Business processes emerge through collaboration between Software Domain Concepts.

No Software Domain Concept directly owns another concept's business truth.

## Examples

* Payments settle Fee Obligations through Payment Allocations.
* Receipts acknowledge accepted Payments.
* Discount Policies authorise reductions applied to Fee Obligations.

## Consequences

* Low coupling.
* High cohesion.
* Clear responsibility boundaries.

---

# AP-006 — Approval-Governed State Transitions

## Intent

Business operations requiring organizational authorization shall transition through an explicit approval state before modifying domain state.

## Motivation

Certain operations require human approval as part of the business process rather than as an infrastructure or security concern.

Approval governs **when** a state transition may occur, but does not own the business truth itself.

## Current Applications

* Discount Grant
* Receipt Correction
* Modification of active Fee Obligations

## Future Evolution

Future versions may introduce a generalized Approval Workflow without requiring changes to the core domain model.

---

# AP-007 — Entitlement vs Financial Effect

## Intent

Separate business entitlement from its financial application.

## Motivation

A business entitlement may exist independently of whether it produces an immediate financial impact.

Examples

Entitlement	Financial Effect
Discount Grant	Applied Discount

## Consequences

Historical financial effects remain immutable.
Future policy changes affect only future financial activity.
Business entitlements remain independently traceable.

---

# Pattern Relationships

These patterns are complementary and should be applied together.

For example:

* Stable Policies produce Operational State.
* Aggregates own Business Truth.
* Lifecycle governs permitted operations.
* Financial facts remain immutable.
* Cross-aggregate business behaviour emerges through collaboration.

---

# Key Decisions

* Patterns documented here are derived from the approved business specifications.
* Patterns guide software implementation but do not redefine business behaviour.
* New architectural patterns require an ADR.
* Existing patterns may evolve only through an approved ADR.

---

# Approval

**Status:** Approved

## Approved By

* Product Owner
* CTO

## Approval Date

2026-07-04
