# E-Fee Product & Engineering Specification

# RFC-002 — Discount Domain Model

```yaml
---
document_id: RFC-002
title: Discount Domain Model
version: 1.0.0

status: Superseded
superseded_by: RFC-007

owner: Product Owner
reviewer: CTO

created: 2026-07-14
last_updated: 2026-07-14

related_documents:
  - ../BusinessRules.md
  - ../SoftwareDomainModel.md
  - ../../../architecture/AggregateDesign.md
  - ../../../architecture/ArchitecturePatterns.md
---
```

Superseded: This RFC has been superseded by RFC-007-Discount-Model-Simplification. It is retained for historical traceability and no longer defines the current architectural baseline.

---

# Purpose

This RFC establishes the canonical software model for Discounts within the E-Fee platform.

It resolves inconsistencies identified during the v1.0.0 design review regarding ownership, lifecycle and financial application of Discounts.

This RFC introduces no new business capability. It standardizes the software realization of already approved business rules.

---

# Background

The v1.0.0 specification contained two competing designs.

The Aggregate Design described:

```
Discount Policy
        │
        ▼
Discount Grant
        │
        ▼
Applied Discount
```

while the Aggregate Technical Specification described a single Discount Aggregate directly attached to a Student.

Both models could not simultaneously represent:

- institutional policy;
- approval;
- entitlement;
- financial effect; and
- complete auditability.

---

# Decision

The platform SHALL adopt the following canonical model.

```
Discount Policy
        │
        ▼
Discount Grant
        │
        ▼
Applied Discount
```

Each concept owns a distinct business truth.

---

# Responsibilities

## Discount Policy

Owns institutional discount rules.

Examples include:

- sibling concession
- scholarship
- employee concession

Policies define eligibility only.

Policies SHALL NOT modify financial state.

---

## Discount Grant

Represents an approved entitlement for a specific Student.

A Discount Grant SHALL preserve:

- Student
- Policy
- Approver
- Reason
- Approval timestamp
- Supporting comments

A Discount Grant authorizes a future financial reduction.

It SHALL NOT directly modify Fee Obligations.

---

## Applied Discount

Represents the financial application of a Discount Grant to one or more Obligation Lines.

Applied Discounts become part of permanent financial history.

Applied Discounts SHALL remain immutable.

---

# Ownership

| Business Truth | Owner |
|---------------|-------|
| Discount Policy | Discount Policy |
| Approved entitlement | Discount Grant |
| Financial reduction | Applied Discount |

Ownership SHALL NOT overlap.

---

# Consequences

The model provides:

- complete auditability;
- separation of entitlement from financial effect;
- immutable financial history;
- support for future policy evolution;
- clear Aggregate ownership.

---

# Impacted Documents

This RFC affects:

- Software Domain Model
- Aggregate Design
- Architecture Patterns
- Discount Aggregate
- Discount ATS
- Discount Persistence Model
- Discount Workflow
- Business Rules

No implementation changes are introduced directly by this RFC.

---

# Alternatives Considered

## Single Discount Aggregate

Rejected.

It combines policy, approval and financial effect into a single concept, making ownership ambiguous and limiting future extensibility.

---

# Status

**Superseded**

This RFC has been superseded by RFC-007 as part of Specification v1.1.0.