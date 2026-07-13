# Story-004 — Discount Aggregate

```yaml
---
story_id: Story-004
title: Discount Aggregate
sprint: Sprint-001
version: 1.0.0
status: Draft

owner: Product Owner

created: 2026-07-13
last_updated: 2026-07-13

related_documents:
  - ../../Sprint-001.md
  - ../../../architecture/AggregateDesign.md
  - ../../../architecture/aggregates/Discount.md
  - ../../../architecture/technical-specification/aggregates/Discount.md
  - ../../../architecture/persistence-model/aggregates/Discount.md
  - ../../../spec/docs/SoftwareDomainModel.md
  - ../../../spec/docs/BusinessRules.md
---
```

---

# Purpose

Implement the Discount Aggregate defined by the approved Software Architecture.

The implementation establishes ownership of institutional discount eligibility and discount lifecycle while preserving the approved Aggregate boundaries.

No additional business behaviour shall be introduced.

---

# Business Objective

Introduce the Discount Aggregate responsible for preserving approved institutional discounts that may later be applied to Student Fee Obligations.

The implementation establishes the Aggregate ownership boundary only.

Application of Discounts to Fee Obligations is outside the scope of this Story.

---

# Aggregate Root

Discount

---

# Supporting Entities

None

---

# Collaborating Aggregates

- Student
- Academic Year
- Fee Structure
- Fee Obligation

Collaboration SHALL preserve Aggregate ownership.

---

# Implementation Scope

Implement only:

- Discount Aggregate Root
- Aggregate unit tests
- Story README

---

# Write Scope

## Source

```
Discount.java
```

## Tests

```
DiscountTest.java
```

## Documentation

```
README.md
```

No additional implementation artifacts are approved.

---

# Output Locations

```
/Sprint-001/Story-004/source/Discount.java

/Sprint-001/Story-004/tests/DiscountTest.java

/Sprint-001/Story-004/README.md
```

---

# Dependencies

Implementation depends upon:

- Sprint-001 implementation decisions
- Discount Aggregate Design
- Discount ATS
- Discount Persistence Model

Implementation SHALL NOT depend upon implementation details of previous Stories.

---

# Acceptance Criteria

Implementation SHALL:

- preserve Aggregate ownership
- preserve approved Aggregate state
- preserve approved lifecycle
- preserve approved invariants
- preserve approved public operations
- generate only approved output files
- include unit tests
- include Story README

Implementation SHALL NOT:

- introduce repositories
- introduce services
- introduce persistence
- introduce REST APIs
- introduce framework annotations
- introduce additional Aggregate collaborators
- introduce undocumented behaviour

---

# Out of Scope

This Story intentionally excludes:

- Fee Obligation updates
- Payment interaction
- Receipt interaction
- persistence
- REST APIs
- database mapping
- infrastructure