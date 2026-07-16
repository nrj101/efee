# E-Fee Product & Engineering Specification

# RFC-006 — Replace Cross-Aggregate Supporting Entity References with Stable Identifiers

```yaml
---
document_id: RFC-006
title: Replace Cross-Aggregate Supporting Entity References with Stable Identifiers
version: 1.0.0
status: Accepted

owner: Product Owner
reviewer: Chief Architect

created: 2026-07-15
last_updated: 2026-07-15

supersedes: None
superseded_by: None

related_documents:
  - ../SoftwareDomainModel.md
  - ../../../architecture/AggregateDesign.md
  - ../../../architecture/SoftwareArchitecture.md
  - ../../../architecture/aggregates/Discount.md
  - ../../../technical-specification/aggregates/Discount.md
  - ../../../technical-design/persistence/Discount.md
---
```

---

# Purpose

This RFC establishes a repository-wide architectural rule prohibiting Aggregates from owning or persisting Supporting Entities that belong to other Aggregates.

Instead, cross-Aggregate relationships SHALL be represented using stable identifiers or approved Value Objects representing identity.

This change strengthens Aggregate ownership boundaries, reduces implementation coupling and improves deterministic AI-assisted implementation.

---

# Background

During the implementation review of **Sprint-001 / Story-004 (Discount Aggregate)**, it was observed that the approved Aggregate model defined the following state:

```text
applicableFeeComponents : List<FeeComponent>
```

`FeeComponent` is a Supporting Entity owned by the **Fee Structure Aggregate**.

This representation unintentionally introduced a direct dependency on another Aggregate's internal model.

Although functionally correct, this weakens Aggregate boundaries and increases implementation ambiguity.

---

# Problem Statement

Referencing another Aggregate's Supporting Entity creates several architectural issues.

## Ownership Leakage

Supporting Entities belong exclusively to their owning Aggregate.

Referencing them directly allows internal implementation details to leak across Aggregate boundaries.

---

## Implementation Coupling

Implementations become dependent upon classes that belong to another Aggregate.

This unnecessarily couples independently evolving Aggregates.

---

## AI Implementation Ambiguity

AI implementation agents cannot reliably distinguish whether the referenced Supporting Entity should be:

- copied;
- shared;
- persisted;
- modified; or
- referenced.

This ambiguity increases implementation drift.

---

## Story Independence

Story Packages are designed to be independently implementable.

Direct references to Supporting Entities from previous Stories introduce unnecessary implementation dependencies between Stories.

---

# Decision

The following architectural rule is adopted.

> **An Aggregate SHALL NOT own or persist another Aggregate's Supporting Entity.**

Cross-Aggregate references SHALL instead use:

- stable identifiers; or
- approved Value Objects representing identity.

Business ownership remains unchanged.

---

# Repository-Wide Architectural Rule

The following rule shall apply to every Aggregate within the Student Fee Receivables Platform.

## Permitted

```text
Discount
    └── List<String> feeComponentIdentifiers
```

or

```text
Discount
    └── List<FeeComponentIdentifier>
```

(where a dedicated Value Object exists)

---

## Not Permitted

```text
Discount
    └── List<FeeComponent>
```

because `FeeComponent` is owned by the Fee Structure Aggregate.

---

# Approved Change

The Discount Aggregate shall be updated as follows.

## Before

```text
applicableFeeComponents : List<FeeComponent>
```

---

## After

```text
applicableFeeComponentIdentifiers : List<String>
```

Each identifier represents an approved Fee Component within the applicable Fee Structure.

The Discount Aggregate records only the identity of applicable Fee Components.

Ownership of Fee Component business state remains with the Fee Structure Aggregate.

---

# Impact Assessment

## Product Behaviour

No change.

Business behaviour remains identical.

---

## Business Rules

No change.

---

## Business Workflow

No change.

---

## Software Domain Model

Minor terminology update only.

No conceptual changes.

---

## Aggregate Design

Ownership boundaries become clearer.

---

## Technical Specifications

The Discount Aggregate Technical Specification SHALL replace:

```text
List<FeeComponent>
```

with

```text
List<String>
```

representing Fee Component identifiers.

---

## Persistence Model

The Discount Aggregate Persistence Model SHALL persist only Fee Component identifiers.

No Supporting Entity shall be persisted.

---

## Story Packages

Story-004 SHALL be updated accordingly.

No other Story implementations are affected.

---

# Rationale

This decision aligns with the established architectural principles of the repository.

Specifically:

- Aggregate ownership remains explicit.
- Supporting Entities remain encapsulated.
- Cross-Aggregate coupling is reduced.
- Story Packages remain independently implementable.
- AI-assisted implementation becomes more deterministic.

The decision does not alter business behaviour.

It improves only the architectural representation of that behaviour.

---

# Consequences

## Positive

- Stronger Aggregate encapsulation.
- Reduced implementation coupling.
- Improved Story independence.
- Reduced AI implementation ambiguity.
- Clearer persistence ownership.
- Improved long-term maintainability.

---

## Negative

Aggregate Specifications and Story-004 require minor terminology updates.

No business functionality is affected.

---

# Alternatives Considered

## Retain Direct Supporting Entity References

Rejected.

Reason:

Supporting Entities belong exclusively to their owning Aggregate.

Direct references unnecessarily expose internal implementation details.

---

## Duplicate Supporting Entity State

Rejected.

Reason:

Duplicating Supporting Entity state would violate the principle of single ownership of business truth.

---

## Immediate Introduction of Identifier Value Objects

Deferred.

Reason:

Using `String` identifiers provides the required architectural separation while keeping Sprint-001 implementation straightforward.

Future specifications may introduce dedicated identifier Value Objects without changing Aggregate boundaries.

---

# Documents Requiring Update

The following approved documents shall be updated.

- Discount Aggregate Technical Specification
- Discount Aggregate Persistence Model
- Story-004
- Story-004 README

Minor terminology updates may also be applied where appropriate within Aggregate Design documentation.

---

# Related Architectural Principles

This RFC reinforces the principles established by:

- ADR-001 — Domain Architecture Strategy
- Aggregate Design
- Software Architecture

It does not supersede any existing architectural decision.

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-15 | Introduced repository-wide rule prohibiting cross-Aggregate Supporting Entity references. Updated the Discount Aggregate to reference Fee Component identifiers instead of Fee Component Supporting Entities. |

---

# Status

**Accepted**

This RFC forms part of Specification v1.1.0.