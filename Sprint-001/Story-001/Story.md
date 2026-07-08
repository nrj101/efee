# Story-001 — Student Aggregate

```yaml
---
story_id: Story-001
title: Student Aggregate
version: 1.0.0
status: Approved

sprint: Sprint-001
priority: High

owner: Product Owner

aggregate_root: Student
---
```

---

# Business Objective

Introduce the Student Aggregate into the implementation of the Student Fee Receivables Platform.

The Student Aggregate establishes the software ownership boundary responsible for maintaining Student identity, academic profile and lifecycle while preserving the business invariants defined by the approved architecture.

---

# Architectural Context

This Story realizes the **Student Aggregate** defined by the approved Aggregate Design.

The Aggregate Design remains the authoritative definition of:

* Aggregate responsibilities;
* owned business truth;
* supporting entities;
* invariants;
* collaboration rules;
* lifecycle ownership.

This Story SHALL faithfully realize the approved Aggregate without redefining architectural responsibilities.

---

# Architecture Traceability

## Aggregate Root

Student

## Primary Business Truth

Student Identity

## Architecture References

* AggregateDesign.md
* SoftwareArchitecture.md

## Product Specification References

* SoftwareDomainModel.md
* BusinessRules.md
* BusinessWorkflow.md

---

# Implementation Scope

This Story implements the approved behaviour of the Student Aggregate.

Included operations are limited to those defined by the approved Aggregate Design.

Included:

* Register Student
* Update Student Information
* Activate Student
* Deactivate Student

Excluded:

* Fee Obligations
* Payments
* Receipts
* Discounts
* Academic Year lifecycle
* Reporting
* Persistence
* REST APIs

---

# Acceptance Criteria

The implementation shall:

* preserve Student identity;
* preserve Student lifecycle;
* enforce all approved Student Aggregate invariants;
* implement only approved Student Aggregate operations;
* remain faithful to the approved architecture.

No behaviour outside the approved implementation scope shall be introduced.

---

# Story Dependencies

## Requires

None

## Enables

* Story-002 — Academic Year Aggregate
* Story-005 — Fee Obligation Aggregate

---

# Implementation Contract

## Write Scope

Only the following implementation artifacts may be created or modified.

### Source

* /Sprint-001/Story-001/source/Student.java

### Tests

* /Sprint-001/Story-001/tests/StudentTest.java

### Documentation

* /Sprint-001/Story-001/README.md

No additional implementation artifacts may be modified without explicit approval.

---

## Output Locations

The following Output Locations are authoritative.

| Artifact         | Output Location                              |
| ---------------- | -------------------------------------------- |
| Student.java     | /Sprint-001/Story-001/source/Student.java    |
| StudentTest.java | /Sprint-001/Story-001/tests/StudentTest.java |
| README.md        | /Sprint-001/Story-001/README.md              |

The Developer SHALL:

* create or modify artifacts only at the approved Output Locations;
* preserve the Story Package structure;
* avoid introducing additional folders;
* avoid inferring Maven or Gradle project layouts;
* avoid introducing package hierarchies unless explicitly approved by the project.

---

# Completion Checklist

Before marking this Story complete, verify:

* Student Aggregate responsibilities have been implemented.
* Student Aggregate invariants are preserved.
* Aggregate ownership remains unchanged.
* Business Rules remain preserved.
* Software Architecture remains preserved.
* Only approved implementation artifacts have been modified.
* Unit tests have been completed.
* No undocumented assumptions have been introduced.
