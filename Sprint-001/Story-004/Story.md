# Story-004 — Discount Aggregate

```yaml
---
story_id: Story-004
title: Discount Aggregate
sprint: Sprint-001
version: 1.2.0
status: Approved

owner: Product Owner

created: 2026-07-13
last_updated: 2026-07-15

related_documents:
  - ../Sprint-001.md
  - ../../architecture/AggregateDesign.md
  - ../../architecture/aggregates/Discount.md
  - ../../technical-specification/aggregates/Discount.md
  - ../../technical-design/persistence/Discount.md
  - ../../spec/docs/SoftwareDomainModel.md
  - ../../spec/docs/BusinessRules.md
  - ../../spec/docs/rfc/RFC-007-Discount-Model-Simplification.md
  - ../../spec/docs/rfc/RFC-006-Replace-Cross-Aggregate-Supporting-Entity-References-with-Stable-Identifiers.md
---
```

---

# Purpose

Implement the Discount Aggregate defined by the approved Software Architecture.

The implementation establishes ownership of an approved financial concession entitlement while preserving the approved Aggregate boundaries.

No additional business behaviour shall be introduced.

---

# Business Objective

Introduce the Discount Aggregate responsible for preserving approved financial concession entitlements granted to Students.

The Aggregate authorises financial concessions only.

Application of those concessions to Fee Obligations is outside the scope of this Story.

---

# Aggregate Root

Discount

---

# Supporting Value Objects

Implement the following immutable Supporting Value Objects owned exclusively by the Discount Aggregate:

- ApprovalInformation
- BusinessJustification

These Supporting Value Objects form part of the Aggregate implementation and SHALL NOT be shared with other Aggregates.

---

# Collaborating Aggregates

- Student
- Fee Obligation

Collaborations SHALL preserve Aggregate ownership boundaries.

---

# Implementation Scope

Implement only:

- Discount Aggregate Root
- Supporting Value Objects
- Aggregate unit tests
- Story README

---

# Write Scope

## Source

```text
- /Sprint-001/Story-004/source/Discount.java

- /Sprint-001/Story-004/source/ApprovalInformation.java

- /Sprint-001/Story-004/source/BusinessJustification.java
```

## Tests

```text

- /Sprint-001/Story-004/tests/ApprovalInformationTest.java

- /Sprint-001/Story-004/tests/BusinessJustificationTest.java

- /Sprint-001/Story-004/tests/DiscountTest.java
```

## Documentation

```text
- /Sprint-001/Story-004/README.md
```

No additional implementation artifacts are approved.

---

# Output Locations

```text
/Sprint-001/Story-004/source/Discount.java

/Sprint-001/Story-004/source/ApprovalInformation.java

/Sprint-001/Story-004/source/BusinessJustification.java

/Sprint-001/Story-004/tests/DiscountTest.java

/Sprint-001/Story-004/tests/ApprovalInformationTest.java

/Sprint-001/Story-004/tests/BusinessJustificationTest.java

/Sprint-001/Story-004/README.md
```

---

# Dependencies

Implementation depends upon:

- Sprint-001.md
- Discount Aggregate Design
- Discount Aggregate Technical Specification
- Discount Aggregate Persistence Model

Implementation SHALL NOT depend upon implementation details of previous Stories.

---

# Acceptance Criteria

Implementation SHALL:

- preserve approved Aggregate ownership;
- preserve approved Aggregate state;
- preserve approved lifecycle;
- preserve approved business invariants;
- preserve approved public operations;
- implement the approved Supporting Value Objects;
- generate only approved output files;
- include unit tests for the Aggregate Root and all approved Supporting Value Objects.

Implementation SHALL NOT:

- calculate or apply financial effects;
- modify collaborating Aggregates;
- introduce Supporting Entities;
- introduce additional Supporting Value Objects;
- introduce repositories;
- introduce services;
- introduce persistence;
- introduce REST APIs;
- introduce framework annotations;
- introduce undocumented behaviour.

---

# Out of Scope

This Story intentionally excludes:

- Fee Obligation updates;
- Applied Discounts;
- Payment interaction;
- Receipt interaction;
- persistence;
- REST APIs;
- infrastructure;
- database mapping.

Supporting Value Objects introduced by this Story SHALL remain owned exclusively by the Discount Aggregate and SHALL NOT evolve into shared domain concepts without an approved architectural decision.