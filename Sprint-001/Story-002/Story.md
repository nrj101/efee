# Story-002 — Academic Year Aggregate

```yaml
---
story_id: Story-002
title: Academic Year Aggregate
version: 1.0.0
status: Approved

sprint: Sprint-001
priority: High

owner: Product Owner

aggregate_root: Academic Year
---
```

---

# Business Objective

Introduce the Academic Year Aggregate into the implementation of the Student Fee Receivables Platform.

The Academic Year Aggregate establishes the software ownership boundary responsible for maintaining Academic Year identity, definition and lifecycle while preserving the business invariants defined by the approved architecture.

---

# Architectural Context

This Story realizes the **Academic Year Aggregate** defined by the approved Aggregate Design.

The Aggregate Design remains the authoritative definition of:

- Aggregate responsibilities;
- owned business truth;
- supporting entities;
- invariants;
- collaboration rules;
- lifecycle ownership.

This Story SHALL faithfully realize the approved Aggregate without redefining architectural responsibilities.

---

# Architecture Traceability

## Aggregate Root

Academic Year

## Primary Business Truth

Academic Year Lifecycle

## Architecture References

- AggregateDesign.md
- SoftwareArchitecture.md

## Product Specification References

- SoftwareDomainModel.md
- BusinessRules.md
- BusinessWorkflow.md

## Technical Design References

- Academic Year Aggregate Technical Specification
- Academic Year Aggregate Persistence Model

---

# Implementation Scope

This Story implements the approved behaviour of the Academic Year Aggregate.

Included operations are limited to those defined by the approved Aggregate Design.

Included:

- Create Academic Year
- Update Academic Year
- Activate Academic Year
- Close Academic Year

Excluded:

- Student management
- Fee Structure management
- Discount management
- Fee Obligation management
- Payment processing
- Receipt management
- Persistence
- REST APIs

---

# Approved Aggregate Model

The Academic Year Aggregate SHALL implement the following persistent state exactly.

| Field | Type | Required | Mutable | Purpose |
|--------|------|----------|----------|---------|
| academicYearId | String | Yes | No | Unique Academic Year identifier. |
| name | String | Yes | Yes | Academic Year name. |
| startDate | LocalDate | Yes | Yes | Beginning of the Academic Year. |
| endDate | LocalDate | Yes | Yes | End of the Academic Year. |
| active | Boolean | Yes | Yes | Academic Year lifecycle state. |

The Developer SHALL NOT:

- introduce additional Aggregate fields;
- rename approved fields;
- change approved field types;
- change approved mutability.

If additional Aggregate state appears necessary, STOP implementation and request clarification.

---

# Approved Aggregate Operations

The following Aggregate operations are approved.

| Operation | Purpose |
|-----------|---------|
| Create Academic Year | Create a new Academic Year while preserving approved invariants. |
| Update Academic Year | Update approved Academic Year information. |
| Activate Academic Year | Transition the Academic Year to the Active lifecycle state. |
| Close Academic Year | Transition the Academic Year to the Closed lifecycle state. |

The Developer SHALL expose only these business operations.

---

# Acceptance Criteria

The implementation shall:

- preserve Academic Year identity;
- preserve Academic Year lifecycle;
- preserve approved Aggregate state exactly as defined by the Persistence Model;
- implement only the approved Aggregate operations;
- preserve all approved invariants;
- remain faithful to the approved architecture.

No behaviour outside the approved implementation scope shall be introduced.

---

# Story Dependencies

## Requires

- Story-001 — Student Aggregate

## Enables

- Story-003 — Fee Structure Aggregate
- Story-005 — Fee Obligation Aggregate

---

# Implementation Contract

## Write Scope

Only the following implementation artifacts may be created or modified.

### Source

- /Sprint-001/Story-002/source/AcademicYear.java

### Tests

- /Sprint-001/Story-002/tests/AcademicYearTest.java

### Documentation

- /Sprint-001/Story-002/README.md

No additional implementation artifacts may be modified without explicit approval.

---

## Output Locations

| Artifact | Output Location |
|----------|-----------------|
| AcademicYear.java | /Sprint-001/Story-002/source/AcademicYear.java |
| AcademicYearTest.java | /Sprint-001/Story-002/tests/AcademicYearTest.java |
| README.md | /Sprint-001/Story-002/README.md |

The Developer SHALL:

- create or modify artifacts only at the approved Output Locations;
- preserve the Story Package directory structure;
- avoid introducing additional folders;
- avoid inferring package hierarchies unless explicitly approved.

---

# Completion Checklist

Before marking this Story complete, verify:

- Academic Year responsibilities implemented.
- Aggregate Model preserved exactly.
- Aggregate invariants preserved.
- Aggregate ownership unchanged.
- Business Rules preserved.
- Software Architecture preserved.
- Only approved implementation artifacts modified.
- Unit tests completed.
- No undocumented assumptions introduced.