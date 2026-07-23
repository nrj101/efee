# Aggregate Persistence Model Standard

```yaml
---
document_id: TD-PERSISTENCE-STD-001
title: Aggregate Persistence Model Standard
version: 1.0.0
status: Approved

owner: Product Owner
reviewer: Chief Architect

created: 2026-07-17
last_updated: 2026-07-17

related_documents:
  - ../README.md
  - ../architecture/SoftwareArchitecture.md
  - ../architecture/AggregateDesign.md
  - ../spec/docs/SoftwareDomainModel.md
  - ../technical-specification/TECH-STD-001.md
---
```

---

# Purpose

This document defines the authoritative standard for Aggregate Persistence Models.

It establishes the implementation-neutral structure, responsibilities, terminology and governance that every Aggregate Persistence Model SHALL follow.

Aggregate Persistence Models refine the approved Aggregate Technical Specifications by defining the complete persistent representation required to preserve each Aggregate's owned business truth while remaining independent of programming language, persistence framework, database technology and infrastructure.

This standard defines:

- the purpose of Aggregate Persistence Models;
- persistence responsibilities;
- approved persistence concepts;
- persistence design principles;
- traceability requirements; and
- governance requirements.

It specifies **what** an Aggregate Persistence Model shall define without prescribing **how** persistence is implemented.

---

# Scope

This standard applies to every Aggregate Persistence Model within the E-Fee platform.

Each Aggregate Persistence Model SHALL define:

- persistent business state;
- derived business state;
- transient business state;
- ownership boundaries;
- persistence constraints;
- traceability to approved engineering specifications; and
- approved persistence responsibilities.

Aggregate Persistence Models SHALL NOT define:

- business behaviour;
- Aggregate responsibilities;
- lifecycle behaviour;
- database schemas;
- SQL data types;
- ORM mappings;
- framework annotations;
- repository implementations;
- indexing strategies;
- vendor-specific persistence features; or
- implementation technology.

Business behaviour remains exclusively defined by the Aggregate Technical Specification.

---

# Relationship to the Aggregate Technical Specification

The Aggregate Persistence Model is derived exclusively from the approved Aggregate Technical Specification.

It SHALL preserve:

- Aggregate ownership;
- approved business state;
- approved business invariants;
- lifecycle integrity; and
- approved public behaviour.

An Aggregate Persistence Model SHALL NOT introduce:

- new business concepts;
- additional Aggregate state;
- new ownership responsibilities;
- new business rules; or
- implementation-specific behaviour.

Any change affecting persistent business state SHALL first be approved through the Product Specification, Software Domain Model, Software Architecture or Aggregate Technical Specification before the Persistence Model is updated.

---

# Position within the Engineering Lifecycle

Aggregate Persistence Models are produced after the Aggregate Technical Specifications have been approved and before implementation begins.

```text
Product Specification
        │
        ▼
Software Domain Model
        │
        ▼
Software Architecture
        │
        ▼
Aggregate Design
        │
        ▼
Aggregate Technical Specification
        │
        ▼
Aggregate Persistence Model
        │
        ▼
Story Package
        │
        ▼
Implementation
```

The Aggregate Persistence Model bridges the gap between business specifications and implementation by defining the authoritative persistent representation of each Aggregate.

Implementation SHALL conform to the approved Persistence Model.

---

# Persistence Responsibilities

Every Aggregate Persistence Model defines the approved persistent representation of exactly one Aggregate.

It establishes:

- what business information is persisted;
- what business information is derived;
- what business information is transient;
- which Aggregate owns each persisted business truth; and
- the persistence constraints required to preserve Aggregate integrity.

The Aggregate Persistence Model represents the authoritative definition of Aggregate state during implementation.

Developers SHALL implement only the persistent business state approved by the Aggregate Persistence Model.

If implementation requires additional persistent business state, implementation SHALL stop and clarification SHALL be requested through the appropriate engineering governance process.

---

# Persistence Design Principles

Every Aggregate Persistence Model SHALL:

- preserve Aggregate ownership;
- preserve approved business truth;
- preserve approved Aggregate invariants;
- preserve lifecycle integrity;
- preserve traceability to approved engineering specifications;
- remain implementation-neutral; and
- remain independent of persistence technology.

Aggregate Persistence Models SHALL describe **what** business information is persisted, not **how** it is persisted.

Implementation decisions such as database schemas, persistence frameworks and storage technologies remain outside the scope of this standard.

---

# Approved Persistence Concepts

Every Aggregate Persistence Model SHALL classify business information using the following persistence concepts.

## Persistent Business State

Persistent Business State represents business information owned by the Aggregate that SHALL be permanently stored.

Persistent Business State:

- represents authoritative business truth;
- is owned exclusively by the Aggregate;
- is preserved throughout the Aggregate lifecycle; and
- is traceable to the approved Aggregate Technical Specification.

---

## Derived Business State

Derived Business State represents business information computed from authoritative business truth.

Derived Business State:

- SHALL NOT become an independent source of business truth;
- SHALL remain reproducible from approved persistent business information; and
- SHALL identify the authoritative Aggregate that owns the underlying business truth.

---

## Transient Business State

Transient Business State represents implementation information that is not part of the Aggregate's persistent business truth.

Transient Business State:

- SHALL NOT be persisted as business information;
- SHALL NOT introduce new business concepts;
- SHALL remain outside the approved Aggregate contract; and
- SHALL NOT affect business behaviour.

---

## Ownership Boundaries

Every persisted business concept SHALL have exactly one owning Aggregate.

Aggregate Persistence Models SHALL preserve the ownership boundaries established by:

- the Software Domain Model;
- the Software Architecture;
- the Aggregate Design; and
- the Aggregate Technical Specification.

Business information owned by collaborating Aggregates SHALL NOT be persisted as owned state.

References to collaborating Aggregates SHALL preserve ownership without transferring business truth.

---

# Relationship to Other Documents

| Document | Responsibility |
|-----------|----------------|
| Product Specification | Defines business behaviour and business rules. |
| Software Domain Model | Defines software concepts, ownership and business truth. |
| Software Architecture | Defines architectural boundaries and Aggregate collaboration. |
| Aggregate Design | Defines Aggregate responsibilities, ownership and invariants. |
| Aggregate Technical Specification | Defines the complete implementation contract for an Aggregate. |
| Aggregate Persistence Model | Defines the approved persistent representation of an Aggregate. |
| Story Package | Defines the implementation work required to realize the approved specifications. |

The Aggregate Persistence Model SHALL remain fully traceable to the approved engineering specifications.

---

# Repository Structure

Each Aggregate SHALL have exactly one Aggregate Persistence Model.

```text
technical-design/
└── persistence/
    │
    ├── README.md
    ├── Student.md
    ├── AcademicYear.md
    ├── FeeStructure.md
    ├── Discount.md
    ├── FeeObligation.md
    ├── Payment.md
    └── Receipt.md
```

Each Aggregate Persistence Model SHALL correspond to exactly one approved Aggregate Technical Specification.

---

# Traceability

Every persisted business concept SHALL be traceable to one or more approved engineering artifacts.

Persistent Business State SHALL originate exclusively from:

- Product Specification;
- Software Domain Model;
- Software Architecture;
- Aggregate Design; or
- Aggregate Technical Specification.

Aggregate Persistence Models SHALL NOT introduce persistent business information solely for implementation convenience.

Changes affecting persistent business state SHALL originate from approved engineering specifications before implementation proceeds.

---

# Governance

Aggregate Persistence Models are controlled engineering specifications.

Every Aggregate Persistence Model SHALL:

- conform to this Aggregate Persistence Model Standard;
- preserve consistency with the approved Aggregate Technical Specification;
- preserve Aggregate ownership boundaries;
- remain implementation-neutral; and
- undergo architectural review before approval.

Any proposed change affecting business ownership, persistent business state or persistence responsibilities SHALL first be approved through the appropriate engineering governance process.

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-17 | Initial Aggregate Persistence Model Standard. Established the standardized structure, responsibilities, approved persistence concepts, traceability requirements and governance for all Aggregate Persistence Models. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- Chief Architect

## Approval Date

2026-07-17