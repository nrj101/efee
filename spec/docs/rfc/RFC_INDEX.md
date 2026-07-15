# E-Fee Product & Engineering Specification

# RFC Index

```yaml
---
document_id: RFC-INDEX-001
title: RFC Index
version: 1.1.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-07-14
last_updated: 2026-07-15

related_documents:
  - ../SPECIFICATION_STANDARDS.md
  - ../../CHANGELOG.md
---
```

---

# Purpose

This document provides an index of all approved **Requests for Change (RFCs)** within the E-Fee Product & Engineering Specification.

RFCs capture significant business, architectural and specification decisions that affect one or more specification documents.

An RFC documents **why** a change was introduced.

The specification documents define **what** the approved design is.

---

# When to Create an RFC

An RFC SHOULD be created when introducing:

- a new business concept;
- a significant architectural decision;
- a change to Aggregate ownership;
- a change to the Software Domain Model;
- a cross-cutting design principle;
- a specification governance decision.

RFCs are **not** required for:

- editorial improvements;
- formatting changes;
- clarification of existing text;
- implementation-only changes;
- document restructuring that does not change design intent.

---

# Relationship to Other Documents

The specification evolves through the following process.

```text
Business Discovery
        │
        ▼
RFC
        │
        ▼
Specification Update
        │
        ▼
Implementation
```

RFCs explain the rationale for change.

The updated specification becomes the authoritative source of truth.

---

# RFC Catalogue

| RFC | Title | Status | Summary |
|-----|-------|--------|---------|
| RFC-001 | Financial Truth Model | Proposed | Defines the authoritative financial truth model, including derived financial state and persistence of derived values. |
| RFC-002 | Discount Domain Model | Superseded | Original three-tier Discount model. Superseded by RFC-007 following implementation and architectural review. |
| RFC-003 | Fee Component Ownership | Accepted | Establishes Fee Structure as the sole owner of Fee Components and defines reference rules for collaborating Aggregates. |
| RFC-004 | Audit, Correction and Approval Model | Accepted | Defines the platform-wide model for approvals, additive corrections and financial auditability. |
| RFC-005 | Specification Evolution Process | Accepted | Defines the governance process for evolving approved specification baselines through RFC-driven change management. |
| RFC-006 | Replace Cross-Aggregate Supporting Entity References with Stable Identifiers | Approved | Prohibits direct ownership or persistence of Supporting Entities across Aggregate boundaries and mandates stable identifier references. |
| RFC-007 | Simplified Discount Aggregate | Approved | Supersedes RFC-002. Confirms the MVP Discount Aggregate owns only concession entitlement while financial application remains the responsibility of the Fee Obligation Aggregate. |

---

# RFC Lifecycle

Each RFC follows the lifecycle below.

```text
Draft
    │
    ▼
In Review
    │
    ▼
Accepted / Approved
    │
    ▼
Implemented
    │
    ▼
Superseded (Optional)
```

Accepted and Approved RFCs become part of the permanent design history.

Superseded RFCs remain preserved for historical traceability.

---

# Numbering Convention

RFC identifiers follow the format:

```text
RFC-001
RFC-002
RFC-003
...
```

RFC numbers are permanent and SHALL NOT be reused.

Superseded RFC identifiers SHALL remain reserved and continue to be referenced by later RFCs where appropriate.

---

# Cross-Referencing

Each RFC SHOULD identify:

- affected specification documents;
- architectural impact;
- implementation impact (if any);
- related RFCs and ADRs where appropriate;
- any RFC that it supersedes or amends.

Specification documents SHOULD reference the RFC that introduced significant design changes.

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-14 | Initial RFC catalogue introduced as part of Specification v1.1.0 governance improvements. |
| 1.1.0 | 2026-07-15 | Added RFC-006 and RFC-007. Marked RFC-002 as Superseded. Updated lifecycle and cross-referencing guidance to support superseded RFCs. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- CTO

## Approval Date

2026-07-15