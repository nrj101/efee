# Story-003 — Fee Structure Aggregate

```yaml
---
story_id: Story-003
title: Fee Structure Aggregate
version: 1.0.0
status: Approved

sprint: Sprint-001
priority: High

owner: Product Owner

aggregate_root: Fee Structure
---
```

---

# Business Objective

Introduce the Fee Structure Aggregate into the implementation of the Student Fee Receivables Platform.

The Fee Structure Aggregate establishes the software ownership boundary responsible for maintaining institutional charging policies while preserving the approved business invariants defined by the Software Architecture.

---

# Architectural Context

This Story realizes the **Fee Structure Aggregate** defined by the approved Aggregate Design.

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

Fee Structure

## Primary Business Truth

Institutional Charging Policy

## Architecture References

- AggregateDesign.md
- SoftwareArchitecture.md

## Product Specification References

- SoftwareDomainModel.md
- BusinessRules.md
- BusinessWorkflow.md

## Technical Design References

- Fee Structure Aggregate Technical Specification
- Fee Structure Aggregate Persistence Model

---

# Implementation Scope

This Story implements the approved behaviour of the Fee Structure Aggregate.

Included:

- Create Fee Structure
- Update Fee Structure
- Activate Fee Structure
- Deactivate Fee Structure

Excluded:

- Student management
- Academic Year management
- Discount management
- Fee Obligation management
- Payment processing
- Receipt generation
- Persistence
- REST APIs

---

# Approved Aggregate Model

The Aggregate SHALL implement the persistent state defined by the approved Persistence Model.

The Developer SHALL:

- implement every approved persistent field;
- preserve approved field names;
- preserve approved field types;
- preserve approved mutability.

The Developer SHALL NOT:

- introduce additional Aggregate state;
- rename approved fields;
- change approved field types.

If additional state appears necessary, STOP and request clarification.

---

# Approved Aggregate Operations

The following Aggregate operations are approved.

| Operation | Purpose |
|-----------|---------|
| Create Fee Structure | Create a new Fee Structure. |
| Update Fee Structure | Update approved Fee Structure information. |
| Activate Fee Structure | Activate the Fee Structure. |
| Deactivate Fee Structure | Deactivate the Fee Structure. |

No additional public operations shall be introduced.

---

# Acceptance Criteria

The implementation shall:

- preserve Fee Structure identity;
- preserve approved charging policy information;
- preserve Aggregate lifecycle;
- preserve approved Aggregate state;
- implement only approved Aggregate operations;
- remain faithful to the approved architecture.

No behaviour outside the approved implementation scope shall be introduced.

---

# Story Dependencies

## Requires

- Story-001 — Student Aggregate
- Story-002 — Academic Year Aggregate

## Enables

- Story-004 — Discount Policy Aggregate
- Story-005 — Fee Obligation Aggregate

---

# Implementation Contract

## Write Scope

### Aggregate Root and Supporting entities

- /Sprint-001/Story-003/source/FeeComponent.java
- /Sprint-001/Story-003/source/FeeStructure.java

### Tests

- /Sprint-001/Story-003/tests/FeeStructureTest.java
- /Sprint-001/Story-003/tests/FeeComponentTest.java

### Documentation

- /Sprint-001/Story-003/README.md

README.md shall document only the behavior implemented in this Story. It shall not claim enforcement of business rules or invariants that are specified in the documentation, but are not implemented in the code.

---

## Output Locations

| Artifact | Output Location |
|----------|-----------------|
| FeeComponent.java | /Sprint-001/Story-003/source/FeeComponent.java |
| FeeStructure.java | /Sprint-001/Story-003/source/FeeStructure.java |
| FeeComponentTest.java | /Sprint-001/Story-003/tests/FeeComponentTest.java |
| FeeStructureTest.java | /Sprint-001/Story-003/tests/FeeStructureTest.java |
| README.md | /Sprint-001/Story-003/README.md |

---

# Completion Checklist

Before marking this Story complete, verify:

- Aggregate responsibilities implemented.
- Aggregate state preserved.
- Aggregate invariants preserved.
- Aggregate ownership preserved.
- Business Rules preserved.
- Architecture preserved.
- Only approved artifacts modified.
- Unit tests completed.
- No undocumented assumptions introduced.