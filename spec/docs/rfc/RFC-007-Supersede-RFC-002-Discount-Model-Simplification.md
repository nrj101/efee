# E-Fee Product & Engineering Specification

# RFC-007 — Discount Model Simplification for MVP

```yaml
---
document_id: RFC-007
title: Discount Model Simplification for MVP
version: 1.0.0
status: Accepted

owner: Product Owner
reviewer: CTO

created: 2026-07-15
last_updated: 2026-07-15

supersedes: RFC-002
superseded_by: None

related_documents:
  - ../SoftwareDomainModel.md
  - ../../architecture/AggregateDesign.md
  - ../../architecture/aggregates/Discount.md
  - ../../architecture/technical-specification/aggregates/Discount.md
  - ../../architecture/persistence-model/aggregates/Discount.md
  - ../../Sprint-001/Story-004.md
---
```

---

# Status

**Approved**

---

# Purpose

This RFC simplifies the Discount domain model for the MVP implementation.

It supersedes RFC-002 by replacing the previously approved three-tier Discount model with a single Discount Aggregate representing an approved financial concession entitlement.

The objective is to reduce implementation complexity while preserving clear Aggregate ownership boundaries and maintaining compatibility with future evolution.

---

# Background

RFC-002 introduced the following canonical model.

```text
Discount Policy
        │
        ▼
Discount Grant
        │
        ▼
Applied Discount
```

The model provides strong separation between policy definition, entitlement approval and financial application.

During Sprint-001 implementation, it became clear that this level of decomposition exceeded the needs of the MVP.

The MVP does not currently require:

- reusable institutional discount policies;
- policy evaluation engines;
- multiple grant workflows;
- policy versioning.

Maintaining these concepts would significantly increase implementation complexity without delivering proportional business value.

---

# Decision

The MVP SHALL adopt a simplified Discount model.

```text
Discount
        │
        ▼
Applied Discount
```

The Discount Aggregate owns the approved concession entitlement granted to a Student.

Application of that entitlement remains the responsibility of the Fee Obligation Aggregate.

No separate Discount Policy or Discount Grant Aggregate shall be introduced during the MVP.

---

# Aggregate Responsibilities

The Discount Aggregate owns:

- Discount identity;
- Student reference;
- approved concession value;
- approval information;
- business justification;
- lifecycle.

The Aggregate authorises a financial concession.

It SHALL NOT calculate or record the financial effect of that concession.

---

# Financial Application

Application of a Discount remains the responsibility of the Fee Obligation Aggregate.

Applied Discounts continue to represent realised financial history.

The Discount Aggregate records only the approved entitlement.

---

# Architectural Rationale

This simplified model:

- preserves Aggregate ownership;
- preserves financial auditability;
- reduces implementation complexity;
- reduces Story dependencies;
- improves AI-assisted implementation;
- remains sufficient for MVP business requirements.

---

# Future Evolution

Future releases MAY introduce:

- Discount Policy;
- Policy versioning;
- Eligibility engines;
- Discount Grant;
- Policy evaluation services.

Such enhancements SHALL evolve from the simplified Discount Aggregate through future RFCs.

No future enhancement shall invalidate the ownership boundaries established by this RFC.

---

# Impact Assessment

The following documents SHALL adopt the simplified Discount model.

- Software Domain Model
- Discount Aggregate Design
- Discount Aggregate Technical Specification
- Discount Aggregate Persistence Model
- Story-004
- Discount Workflow

No changes are required to:

- Fee Structure
- Student
- Academic Year
- Fee Obligation ownership

---

# Consequences

## Positive

- Simpler Aggregate model.
- Reduced implementation complexity.
- Smaller Story Packages.
- Improved architectural consistency.
- Clearer AI implementation guidance.

## Negative

Institutional discount policy management is deferred until a future release.

---

# Alternatives Considered

## Retain RFC-002 three-tier model

Rejected.

The model introduces additional Aggregates and workflows that are not required for the MVP.

The additional complexity outweighs the immediate business benefit.

---

# Compatibility

This RFC supersedes RFC-002.

Repositories implementing the simplified Discount Aggregate remain architecturally correct for the MVP.

Future specification versions may extend the model without invalidating existing implementations.

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-15 | Superseded RFC-002 by adopting a simplified Discount Aggregate for the MVP while preserving future extensibility. |

---

# Status

**Accepted**

This RFC forms part of Specification v1.1.0.