# Student Aggregate Technical Specification

```yaml
---
document_id: ATS-STUDENT-001
title: Student Aggregate Technical Specification
version: 1.3.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-07-06
last_updated: 2026-07-17

related_documents:
  - ../../spec/docs/SoftwareDomainModel.md
  - ../../spec/docs/BusinessRules.md
  - ../../spec/docs/workflows/StudentRegistration.md
  - ../../architecture/aggregates/Student.md
---
```

---

# Purpose

This document defines the authoritative implementation contract for the Student Aggregate.

It refines the approved Software Domain Model and Software Architecture by defining the complete Aggregate contract required for implementation while remaining independent of programming language, persistence technology, implementation framework and infrastructure.

The Student Aggregate Technical Specification defines:

- Aggregate responsibilities;
- owned, referenced and derived state;
- lifecycle behaviour;
- business invariants;
- public operations;
- approved supporting types; and
- persistence traceability.

It specifies **what** the Student Aggregate must do without prescribing **how** it is implemented.

---

# Responsibilities

The Student Aggregate owns the long-term financial identity of a Student.

It is responsible for:

- preserving Student identity;
- maintaining Student information required by the financial domain;
- maintaining the Student Academic Profile; and
- managing the Student lifecycle.

The Student Aggregate intentionally does **not** own:

- Fee Obligations;
- Outstanding Balances;
- Payments;
- Receipts;
- Discounts; or
- Academic Year policies.

These business truths remain owned by collaborating Aggregates.

---

# Owned State

The Student Aggregate owns the following business state.

| State | Type | Required | Mutable | Description |
|--------|------|----------|----------|-------------|
| studentIdentifier | String | Yes | No | Immutable Student identifier |
| studentName | String | Yes | Yes | Student name |
| academicProfile | String | Yes | Yes | Student Academic Profile maintained by the institution |
| active | Boolean | Yes | Yes | Current Student lifecycle state |

No additional owned business state is approved.

---

# Referenced State

The Student Aggregate references externally owned business information but does not own it.

The Aggregate may reference:

| Aggregate | Business Purpose |
|-----------|------------------|
| Academic Year | Determine academic context |
| Fee Obligation | Associate financial obligations with the Student |
| Discount | Determine applicable financial concessions |

Referenced business information SHALL remain externally owned.

The Student Aggregate SHALL NOT modify referenced Aggregate state.

---

# Derived State

The Student Aggregate does not own any derived business state.

Lifecycle status is determined directly from owned state.

Financial information, outstanding balances and payment status are intentionally derived and managed by collaborating Aggregates.

No additional derived business state is approved.

---

# Lifecycle

The Student Aggregate supports the following lifecycle.

```text
Active
    │
    ▼
Inactive
```

Lifecycle transitions are reversible through the approved business operations.

Only one lifecycle state may exist at any point in time.

---

# Business Invariants

The implementation SHALL preserve the following Business Invariants.

- Student Identifier is immutable.
- Student identity shall never transfer.
- Every Academic Profile belongs to exactly one Student.
- Every Student has exactly one lifecycle state.
- Only the Student Aggregate may modify its owned state.
- Aggregate ownership boundaries shall always be preserved.

These invariants SHALL remain true throughout every permitted lifecycle transition and business operation.

---

# Approved Implementation Types

The following domain types participate in the approved Aggregate contract.

- Student (Aggregate Root)
- Student Identifier
- Academic Profile

No additional publicly observable domain types are approved by this specification.

---

# Public API

The Public API defines the complete externally observable behaviour of the Student Aggregate.

Every public operation SHALL preserve all documented Business Invariants.

---

## Constructor

```text
Student(
    studentIdentifier,
    studentName,
    academicProfile
)
```

Creates a valid Active Student.

The constructor SHALL:

- establish a valid Student identity;
- initialise the Academic Profile;
- establish the Active lifecycle state; and
- preserve all documented Business Invariants.

---

## Business Operations

### activate()

Transitions the Student to the Active lifecycle state.

Preconditions:

- Student is currently Inactive.

Postconditions:

- Student lifecycle becomes Active.
- Business Invariants remain preserved.

---

### deactivate()

Transitions the Student to the Inactive lifecycle state.

Preconditions:

- Student is currently Active.

Postconditions:

- Student lifecycle becomes Inactive.
- Business Invariants remain preserved.

---

### update(
    studentName,
    academicProfile
)

Updates approved Student information.

Preconditions:

- Updated values satisfy all applicable business validation rules.

Postconditions:

- Approved Student information is updated.
- Student identity remains unchanged.
- Business Invariants remain preserved.

---

## Accessors

```text
getStudentIdentifier()

getStudentName()

getAcademicProfile()

isActive()
```

Accessors expose approved Student information only.

Accessors SHALL NOT modify Aggregate state.

No additional public operations are approved by this specification.

---

# Supporting Types

The following Supporting Types participate in the approved Aggregate contract.

## Student Identifier

Defines the immutable business identity of a Student.

Responsibilities:

- uniquely identify a Student;
- remain immutable throughout the Student lifecycle.

Business Invariants:

- Identifier shall never change.
- Identifier shall uniquely identify exactly one Student.

---

## Academic Profile

Defines the approved academic information associated with a Student.

Responsibilities:

- represent the Student's academic profile;
- support approved Student lifecycle operations.

Business Invariants:

- Every Academic Profile belongs to exactly one Student.
- Academic Profile remains owned by the Student Aggregate.

---

# Persistence Traceability

The following business concepts are represented by the Student Aggregate.

| Business Concept | Classification |
|------------------|----------------|
| Student | Aggregate Root |
| Student Identifier | Owned State |
| Student Name | Owned State |
| Academic Profile | Owned State |
| Student Lifecycle | Owned State |

The Student Aggregate does not persist:

- Fee Obligations;
- Payments;
- Receipts;
- Discounts; or
- Outstanding Balances.

Persistent representation SHALL remain consistent with this Aggregate Technical Specification and the Aggregate Persistence Model.

---

# Consistency Requirements

Implementation SHALL preserve:

- Student identity integrity;
- Academic Profile integrity;
- lifecycle integrity;
- Aggregate ownership boundaries; and
- all documented Business Invariants.

Financial information SHALL remain outside the responsibility of the Student Aggregate.

---

# Collaboration Contract

The Student Aggregate collaborates with the following Aggregates.

| Aggregate | Collaboration Purpose |
|-----------|-----------------------|
| Academic Year | Determine academic context |
| Fee Obligation | Associate financial obligations |
| Discount | Determine applicable financial concessions |

Collaborations SHALL occur exclusively through approved Aggregate references.

Ownership of business truth SHALL NOT transfer between collaborating Aggregates.

---

# Implementation Constraints

Implementation SHALL:

- validate constructor inputs;
- validate business operation inputs;
- preserve Aggregate ownership;
- preserve lifecycle integrity;
- preserve Student identity; and
- preserve all documented Business Invariants.

Implementation SHALL NOT:

- expose public setters;
- expose undocumented public operations;
- perform financial calculations;
- modify collaborating Aggregates;
- introduce undocumented Aggregate state; or
- violate Aggregate ownership boundaries.

Implementation technology remains outside the scope of this specification.

---

# Story Traceability

Initially implemented through:

- Sprint-001 / Story-001

Future Stories MAY extend implementation while preserving this Aggregate Technical Specification.

---

# Related Documents

- SoftwareDomainModel.md
- BusinessRules.md
- StudentRegistration.md
- Student Aggregate Design

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-06 | Initial Aggregate Technical Specification. |
| 1.1.0 | 2026-07-14 | Expanded into the standard Aggregate Technical Specification template. |
| 1.2.0 | 2026-07-15 | Reconciled with the approved Software Domain Model and Aggregate Design. Removed unapproved Admission Number and Registered lifecycle, restored Academic Profile, simplified lifecycle to Active/Inactive, and aligned terminology with the implementation baseline. |
| 1.3.0 | 2026-07-17 | Aligned with TECH-STD-001 v1.2.0. Adopted the standardized Aggregate Technical Specification structure, introduced Referenced State, Derived State, Approved Implementation Types, Supporting Types and Persistence Traceability sections, and aligned the Public API with the standardized contract format without changing approved business behaviour. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- CTO

## Approval Date

2026-07-17