# E-Fee Product & Engineering Specification

# RFC-003 — Fee Component Ownership

```yaml
---
document_id: RFC-003
title: Fee Component Ownership
version: 1.0.0
status: Accepted

owner: Product Owner
reviewer: CTO

created: 2026-07-14
last_updated: 2026-07-14

related_documents:
  - ../SoftwareDomainModel.md
  - ../../../architecture/AggregateDesign.md
  - ../../../architecture/ArchitecturePatterns.md
  - ../../../technical-specification/aggregates/FeeStructure.md
  - ../../../technical-specification/aggregates/FeeObligation.md
---
```

---

# Purpose

This RFC establishes ownership rules for **Fee Components** within the E-Fee domain model.

It resolves inconsistencies identified during the v1.0.0 design review regarding how Fee Components are referenced by collaborating Aggregates.

This RFC introduces no new business capability. It clarifies Aggregate ownership and preserves architectural consistency.

---

# Background

The v1.0.0 specification allowed multiple interpretations of Fee Component ownership.

Some technical specifications embedded complete Fee Component objects inside other Aggregates, while the Aggregate Design identified Fee Components as entities owned exclusively by the Fee Structure Aggregate.

This ambiguity violated the principle that a business concept shall have exactly one owning Aggregate.

---

# Decision

The Fee Structure Aggregate SHALL remain the sole owner of Fee Components.

Fee Components SHALL NOT be shared between Aggregates.

Collaborating Aggregates SHALL reference Fee Components using stable identifiers or immutable snapshots where historical preservation is required.

---

# Ownership Model

```
Fee Structure
      │
      ▼
Fee Component
```

Fee Components exist only within the boundary of their owning Fee Structure.

No other Aggregate owns or modifies Fee Components.

---

# Collaboration Model

Other Aggregates MAY reference Fee Components for business purposes.

Examples include:

- Fee Obligation Line
- Applied Discount
- Payment Allocation

These references SHALL use:

- Fee Component identifiers; or
- immutable snapshots where historical reconstruction is required.

No collaborating Aggregate SHALL directly modify a Fee Component.

---

# Rationale

This ownership model:

- preserves Aggregate boundaries;
- prevents shared mutable state;
- simplifies lifecycle management;
- supports versioned Fee Structures;
- preserves historical financial correctness.

---

# Consequences

The following implementation principles apply.

- Fee Components remain owned exclusively by Fee Structure.
- Fee Obligations reference Fee Components rather than embedding them.
- Applied Discounts reference Fee Components rather than owning them.
- Payment Allocations operate against Obligation Lines rather than Fee Components directly.
- Historical financial records remain reproducible even after future Fee Structure revisions.

---

# Impacted Documents

This RFC affects:

- Software Domain Model
- Aggregate Design
- Architecture Patterns
- Fee Structure Aggregate
- Fee Obligation Aggregate
- Discount Aggregate
- Fee Structure ATS
- Fee Obligation ATS
- Discount ATS
- Associated Persistence Models

No new business capability is introduced.

---

# Alternatives Considered

## Shared Fee Component Entity

Rejected.

Allowing multiple Aggregates to own or modify Fee Components introduces shared mutable state, weakens Aggregate boundaries and complicates historical reconstruction.

---

# Status

**Accepted**

This RFC forms part of Specification v1.1.0.