# Aggregate Persistence Model

```yaml
---
document_id: TD-PERSISTENCE-README-001
title: Aggregate Persistence Model
version: 1.0.0
status: Draft

owner: Product Owner
reviewer: Chief Architect

created: 2026-07-10
last_updated: 2026-07-10

related_documents:
  - ../README.md
  - ../../architecture/SoftwareArchitecture.md
  - ../../architecture/AggregateDesign.md
  - ../../spec/docs/SoftwareDomainModel.md
---
```

---

# Purpose

This package defines the implementation-neutral persistence model for each Aggregate of the Student Fee Receivables Platform.

It bridges the gap between the approved Software Architecture and software implementation by defining the information that must be persisted in order to preserve each Aggregate's business truth.

These documents are derived exclusively from the approved Product Specification, Software Architecture and Aggregate Technical Specifications.

They SHALL NOT introduce new business behaviour, architectural responsibilities or implementation technology.

---

# Scope

The Aggregate Persistence Model defines:

- persistent Aggregate state;
- field names;
- field types;
- mutability;
- requiredness;
- derived state;
- transient state;
- persistence constraints.

It intentionally excludes:

- database vendors;
- SQL data types;
- ORM mappings;
- framework annotations;
- indexing;
- performance optimizations;
- implementation details.

---

# Position within the Engineering Lifecycle

The Aggregate Persistence Model is produced after completion of the Software Architecture and before implementation begins.

```text
Business Specification
        │
        ▼
Software Domain Model
        │
        ▼
Software Architecture
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

---

# Purpose of the Persistence Model

The purpose of the Persistence Model is to eliminate implementation ambiguity.

It provides the approved structural representation of each Aggregate before implementation begins.

Developers SHALL implement only the state defined by the approved Persistence Model.

If implementation requires additional persistent state, implementation SHALL stop and clarification SHALL be requested.

---

# Design Principles

Every Aggregate Persistence Model SHALL:

- preserve Aggregate ownership;
- preserve business truth;
- preserve approved invariants;
- preserve lifecycle integrity;
- remain implementation-neutral;
- remain independent of database technology.

---

# Relationship to Other Documents

| Document | Responsibility |
|-----------|----------------|
| Product Specification | Defines business behaviour. |
| Software Domain Model | Defines software concepts and relationships. |
| Software Architecture | Defines ownership boundaries and responsibilities. |
| Aggregate Technical Specification | Defines implementation obligations for each Aggregate. |
| Aggregate Persistence Model | Defines the approved persistent representation of an Aggregate. |
| Story Package | Defines the implementation work to be performed. |

---

# Repository Structure

Each Aggregate has exactly one Persistence Model document.

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

---

# Traceability

Every persistent field SHALL be traceable to one or more approved architectural artifacts.

No field may be introduced solely as an implementation convenience.

---

# Notes

The Aggregate Persistence Model represents the approved implementation model for an Aggregate.

It serves as the authoritative source for Aggregate state during implementation while remaining independent of programming language, persistence framework and database technology.

Future technical design documents may define physical database schemas and technology-specific mappings without modifying these documents.