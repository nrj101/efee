# Aggregate Persistence Model

```yaml
---
document_id: TD-PERSISTENCE-README-001
title: Aggregate Persistence Model
version: 1.1.0
status: Approved

owner: Product Owner
reviewer: Chief Architect

created: 2026-07-10
last_updated: 2026-07-14
next_review: Before Technical Specification v2.0.0

related_documents:
  - ../README.md
  - ../architecture/SoftwareArchitecture.md
  - ../architecture/AggregateDesign.md
  - ../spec/docs/SoftwareDomainModel.md
  - ../technical-specification/TECHNICAL_SPECIFICATION_STANDARDS.md
---
```

---

# Purpose

This package defines the implementation-neutral persistence model for each Aggregate of the E-Fee platform.

It bridges the gap between the approved Aggregate Technical Specifications and implementation by defining the persistent representation required to preserve each Aggregate's owned business truth.

These documents are derived exclusively from the approved:

- Product Specification
- Software Architecture
- Aggregate Design
- Aggregate Technical Specifications

They SHALL NOT introduce:

- new business behaviour;
- new architectural responsibilities;
- new Aggregate state;
- implementation technology.

---

# Scope

Each Aggregate Persistence Model defines the approved persistent representation of an Aggregate, including:

- persistent state;
- field names;
- business data types;
- requiredness;
- mutability;
- derived state;
- transient state;
- ownership boundaries;
- persistence constraints;
- traceability to approved specifications.

It intentionally excludes:

- database schema;
- SQL data types;
- ORM mappings;
- framework annotations;
- repository implementation;
- indexes;
- performance optimizations;
- vendor-specific persistence features.

---

# Position within the Engineering Lifecycle

The Aggregate Persistence Model is produced after the Aggregate Technical Specifications have been approved and before implementation begins.

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

Sprint-001 validated this lifecycle by implementing Aggregates directly from the approved Technical Specifications and Persistence Models without requiring architectural changes.

---

# Purpose of the Persistence Model

The Persistence Model eliminates implementation ambiguity by defining the approved persistent representation of an Aggregate.

It establishes exactly:

- what business information is persisted;
- what information is derived;
- what information is transient;
- which Aggregate owns each persisted business truth.

Developers SHALL implement only the approved persistent state.

If implementation requires additional persistent state, implementation SHALL stop and clarification SHALL be requested through the appropriate governance process.

---

# Design Principles

Every Aggregate Persistence Model SHALL:

- preserve Aggregate ownership;
- preserve approved business truth;
- preserve approved Aggregate invariants;
- preserve lifecycle integrity;
- preserve traceability to approved specifications;
- remain implementation-neutral;
- remain independent of database technology.

Persistence Models SHALL describe **what** is persisted, not **how** it is persisted.

---

# Relationship to Other Documents

| Document | Responsibility |
|-----------|----------------|
| Product Specification | Defines business behaviour and business rules. |
| Software Domain Model | Defines software concepts and ownership. |
| Software Architecture | Defines architectural boundaries and collaboration. |
| Aggregate Design | Defines Aggregate responsibilities and invariants. |
| Aggregate Technical Specification | Defines the complete implementation contract of each Aggregate. |
| Aggregate Persistence Model | Defines the approved persistent representation of an Aggregate. |
| Story Package | Defines the implementation work required to realize the approved specifications. |

---

# Repository Structure

Each Aggregate has exactly one Persistence Model.

```text
persistence/
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

Each document SHALL correspond to exactly one Aggregate.

---

# Traceability

Every persistent field SHALL be traceable to one or more approved engineering artifacts.

Persistent state SHALL originate from:

- Product Specification;
- Software Domain Model;
- Aggregate Design;
- Aggregate Technical Specification.

No persistent field may be introduced solely for implementation convenience.

Changes affecting persistent state SHALL originate from approved Product Specification or Architecture changes before implementation proceeds.

---

# Notes

The Aggregate Persistence Model represents the complete approved persistent representation of an Aggregate.

It serves as the authoritative source for Aggregate state during implementation while remaining independent of:

- programming language;
- persistence framework;
- database technology;
- deployment architecture.

Future Technical Design documents may define physical database schemas, repository implementations and technology-specific mappings without modifying these approved Persistence Models.

---

# Key Decisions

- Each Aggregate owns exactly one persistent representation.
- Persistent state follows Aggregate ownership boundaries.
- Derived state is explicitly identified.
- Persistence Models remain implementation-neutral.
- Physical database design is intentionally deferred.
- Every persistent field is traceable to approved engineering specifications.

---

# Version History

| Version | Date | Description |
|----------|------------|-------------|
| 1.0.0 | 2026-07-10 | Initial Persistence Model package definition. |
| 1.1.0 | 2026-07-14 | Aligned with finalized Technical Specifications and Aggregate Designs. Clarified lifecycle position, ownership boundaries, traceability, persistence responsibilities and implementation governance following Sprint-001 validation. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- Chief Architect

## Approval Date

2026-07-14