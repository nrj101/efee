# Story-002 — Academic Year Aggregate

```yaml
---
story_id: Story-002
title: Academic Year Aggregate
version: 1.2.0
status: Approved

sprint: Sprint-001
priority: High

owner: Product Owner

aggregate_root: AcademicYear

created: 2026-07-13
last_updated: 2026-07-15

related_documents:
  - ../Sprint-001.md
  - ../../architecture/AggregateDesign.md
  - ../../architecture/aggregates/AcademicYear.md
  - ../../technical-specification/aggregates/AcademicYear.md
  - ../../technical-design/persistence/AcademicYear.md
  - ../../spec/docs/SoftwareDomainModel.md
  - ../../spec/docs/BusinessRules.md
---
```

---

# Purpose

Implement the Academic Year Aggregate defined by the approved Software Architecture.

The implementation establishes ownership of the Academic Year operational boundary, operational period, applicable Fee Structure reference and lifecycle while preserving the approved Aggregate boundaries.

No additional business behaviour shall be introduced.

---

# Business Objective

Introduce the Academic Year Aggregate responsible for defining the operational period within which institutional financial activity occurs.

The implementation establishes the Aggregate ownership boundary only.

---

# Aggregate Root

AcademicYear

---

# Supporting Entities

None.

---

# Supporting Domain Types

- AcademicYearLifecycle

---

# Collaborating Aggregates

- Student
- Fee Structure
- Fee Obligation

Collaboration SHALL preserve Aggregate ownership.

---

# Implementation Scope

Implement only:

- AcademicYear Aggregate Root
- Supporting Domain Types
- Aggregate unit tests
- Story README

---

# Write Scope

## Source

```
AcademicYear.java

AcademicYearLifecycle.java
```

## Tests

```
AcademicYearTest.java

AcademicYearLifecycleTest.java
```

## Documentation

```
README.md
```

No additional implementation artifacts are approved.

---

# Output Locations

```
/Sprint-001/Story-002/source/AcademicYear.java

/Sprint-001/Story-002/source/AcademicYearLifecycle.java

/Sprint-001/Story-002/tests/AcademicYearTest.java

/Sprint-001/Story-002/tests/AcademicYearLifecycleTest.java

/Sprint-001/Story-002/README.md
```

---

# Dependencies

Implementation depends upon:

- Sprint-001 implementation decisions
- Academic Year Aggregate Design
- Academic Year Aggregate Technical Specification
- Academic Year Aggregate Persistence Model

Implementation SHALL NOT depend upon implementation details of previous Stories.

---

# Approved Aggregate Model

The following Aggregate Model is approved for implementation.

| Field | Type | Required | Mutable | Purpose |
|--------|------|----------|----------|---------|
| academicYearIdentifier | String | Yes | No | Unique Academic Year identifier |
| academicYearCode | String | Yes | No | Institution-defined Academic Year reference |
| startDate | LocalDate | Yes | No | Beginning of the operational period |
| endDate | LocalDate | Yes | No | End of the operational period |
| feeStructureIdentifier | String | Yes | Yes | Applicable Fee Structure reference |
| lifecycleState | AcademicYearLifecycle | Yes | Yes | Academic Year lifecycle |

The Aggregate SHALL implement only the approved state defined above.

The Developer SHALL NOT:

- introduce additional Aggregate state;
- rename approved fields;
- change approved field types;
- change approved field mutability; or
- introduce alternative representations.

If implementation requires additional Aggregate state, STOP and request clarification.

---

# Approved Public Operations

The following public behaviour is approved.

| Operation | Purpose |
|-----------|---------|
| Create Academic Year | Create a valid Academic Year Aggregate |
| Assign Fee Structure | Associate the approved Fee Structure reference |
| Activate Academic Year | Transition Planned → Active |
| Close Academic Year | Transition Active → Closed |

Additional public behaviour requires explicit Story approval.

---

# Acceptance Criteria

Implementation SHALL:

- preserve Academic Year identity;
- preserve operational period;
- preserve Fee Structure association;
- preserve Academic Year lifecycle;
- implement only the approved Aggregate Model;
- implement only the approved public operations;
- preserve approved field names;
- preserve approved field types;
- preserve approved field mutability;
- preserve Aggregate ownership; and
- remain faithful to the approved Software Architecture and Technical Specification.

Implementation SHALL NOT:

- introduce additional Aggregate state;
- introduce additional public operations; or
- introduce undocumented business behaviour.

---

# Out of Scope

This Story intentionally excludes:

- Student management
- Fee Structure implementation
- Fee Obligation implementation
- Discount management
- Payment processing
- Receipt management
- Persistence
- REST APIs
- Infrastructure

---

# Story Dependencies

## Requires

- Story-001 — Student Aggregate

## Enables

- Story-003 — Fee Structure Aggregate
- Story-005 — Fee Obligation Aggregate

---

# Completion Checklist

Before marking this Story complete, verify:

- Academic Year Aggregate responsibilities have been implemented.
- Supporting Domain Types have been implemented.
- Approved Aggregate Model has been implemented.
- Approved public operations have been implemented.
- Academic Year Aggregate invariants are preserved.
- Aggregate ownership remains unchanged.
- Business Rules remain preserved.
- Software Architecture remains preserved.
- Only approved implementation artifacts have been modified.
- Unit tests have been completed.
- No undocumented assumptions have been introduced.

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-13 | Initial Story definition. |
| 1.1.0 | 2026-07-15 | Reconciled with the approved Aggregate Design, Technical Specification and Persistence Model. Introduced explicit lifecycle, operational period and Fee Structure reference while aligning the Story with the standardized Sprint-001 Story Package template. |
| 1.2.0 | 2026-07-15 | Authorized implementation of the `AcademicYearLifecycle` supporting domain type and its unit tests. Clarified Write Scope, Output Locations and Completion Checklist accordingly. |