# Academic Year Aggregate Persistence Model

```yaml
---
document_id: TD-ACADEMICYEAR-001
title: Academic Year Aggregate Persistence Model
version: 2.0.0
status: Approved

owner: Product Owner
reviewer: Chief Architect

created: 2026-07-10
last_updated: 2026-07-17

related_documents:
  - ../../architecture/aggregates/AcademicYear.md
  - ../../technical-specification/aggregates/AcademicYear.md
  - ../../technical-design/persistence/README.md
  - ../../architecture/SoftwareArchitecture.md
  - ../../spec/docs/SoftwareDomainModel.md
---
```

---

# Purpose

This document defines the authoritative persistent representation of the Academic Year Aggregate.

It refines the approved Aggregate Technical Specification by defining the complete persistent business state required to preserve the business truth owned by the Academic Year Aggregate while remaining independent of programming language, persistence framework, database technology and infrastructure.

The Academic Year Aggregate Persistence Model defines:

- persistent business state;
- derived business state;
- transient business state;
- ownership boundaries;
- persistence constraints; and
- traceability to approved engineering specifications.

It specifies **what** business information shall be persisted without prescribing **how** persistence is implemented.

---

# Aggregate

**Academic Year**

---

# Persistence Responsibilities

The Academic Year Aggregate Persistence Model preserves the business truth owned by the Academic Year Aggregate.

It is responsible for persisting:

- Academic Year identity;
- Academic Year reference;
- Operational Period;
- Fee Structure association; and
- Academic Year lifecycle.

The Academic Year Aggregate Persistence Model intentionally does **not** persist:

- Student information;
- Fee Obligations;
- Payments;
- Receipts; or
- Discounts.

These business truths remain owned by collaborating Aggregates.

---

# Persistent Business State

The Academic Year Aggregate owns the following Persistent Business State.

| Business State | Type | Required | Mutable | Description |
|---------------|------|----------|----------|-------------|
| academicYearIdentifier | Academic Year Identifier | Yes | No | Immutable Academic Year identifier |
| academicYearCode | Academic Year Code | Yes | No | Institution-defined Academic Year reference |
| startDate | Academic Year Start Date | Yes | No | Beginning of the Academic Year |
| endDate | Academic Year End Date | Yes | No | End of the Academic Year |
| feeStructureIdentifier | Fee Structure Identifier | Yes | Yes | Approved Fee Structure reference |
| lifecycleState | Academic Year Lifecycle | Yes | Yes | Current Academic Year lifecycle |

No additional Persistent Business State is approved.

---

# Derived Business State

The Academic Year Aggregate owns no Derived Business State.

All persisted business information represents authoritative business truth owned by the Academic Year Aggregate.

No additional Derived Business State is approved.

---

# Transient Business State

The Academic Year Aggregate owns no Transient Business State.

No implementation-specific state forms part of the approved persistent representation.

No additional Transient Business State is approved.

---

# Ownership Boundaries

The Academic Year Aggregate owns only the Persistent Business State defined by this specification.

The Academic Year Aggregate SHALL NOT persist business information owned by collaborating Aggregates.

Business information owned by collaborating Aggregates includes:

- Students;
- Fee Obligations;
- Payments;
- Receipts; and
- Discounts.

The Academic Year Aggregate MAY persist references to collaborating Aggregates where ownership is preserved.

Approved Aggregate references:

| Aggregate | Business Reference |
|-----------|--------------------|
| Fee Structure | Fee Structure Identifier |

References to collaborating Aggregates SHALL preserve ownership without transferring business truth.

---

# Persistence Constraints

Implementation SHALL preserve:

- Academic Year identity;
- Academic Year reference integrity;
- Operational Period integrity;
- Fee Structure association;
- Academic Year lifecycle integrity;
- Aggregate ownership boundaries; and
- all approved Persistent Business State.

Implementation SHALL NOT:

- introduce undocumented Persistent Business State;
- remove approved Persistent Business State;
- rename approved Persistent Business State;
- change approved business types;
- violate approved mutability;
- persist business information owned by collaborating Aggregates; or
- violate Aggregate ownership boundaries.

If implementation requires additional Persistent Business State, implementation SHALL stop and clarification SHALL be requested through the appropriate engineering governance process.

---

# Persistent Representation Rules

Implementation SHALL ensure:

- Academic Year Identifier remains immutable after creation.
- Academic Year Code remains immutable after creation.
- Academic Year Start Date and Academic Year End Date preserve the approved Operational Period.
- Fee Structure Identifier references the currently approved Fee Structure.
- Academic Year Lifecycle accurately represents the approved lifecycle state.

Closed Academic Years remain permanently preserved.

Persistent representation SHALL remain consistent with the approved Aggregate Technical Specification.

---

# Traceability

The following Persistent Business State is traceable to the approved Aggregate Technical Specification.

| Persistent Business State | Source |
|---------------------------|--------|
| Academic Year Identifier | Academic Year Aggregate Technical Specification |
| Academic Year Code | Academic Year Aggregate Technical Specification |
| Academic Year Start Date | Academic Year Aggregate Technical Specification |
| Academic Year End Date | Academic Year Aggregate Technical Specification |
| Fee Structure Identifier | Academic Year Aggregate Technical Specification |
| Academic Year Lifecycle | Academic Year Aggregate Technical Specification |

All Persistent Business State SHALL remain traceable to approved engineering specifications.

---

# Consistency Requirements

Implementation SHALL preserve:

- Academic Year identity integrity;
- Academic Year reference integrity;
- Operational Period integrity;
- Fee Structure association integrity;
- lifecycle integrity;
- Aggregate ownership boundaries; and
- all approved Persistent Business State.

The persistent representation SHALL remain fully consistent with the approved Aggregate Technical Specification throughout the Aggregate lifecycle.

---

# Implementation Constraints

Implementation SHALL:

- preserve Aggregate ownership;
- preserve approved Persistent Business State;
- preserve lifecycle integrity;
- preserve traceability to approved engineering specifications;
- reject modifications that violate approved mutability; and
- remain implementation-neutral.

Implementation SHALL NOT:

- introduce implementation-specific business state;
- persist undocumented business information;
- duplicate business truth owned by collaborating Aggregates;
- modify approved ownership boundaries; or
- introduce implementation behaviour into this persistence model.

Physical persistence technology remains outside the scope of this specification.

---

# Related Documents

- SoftwareDomainModel.md
- SoftwareArchitecture.md
- Academic Year Aggregate Design
- Academic Year Aggregate Technical Specification
- Aggregate Persistence Model Standard

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-10 | Initial Persistence Model. |
| 1.1.0 | 2026-07-14 | Aligned with Academic Year ATS v1.1.0. Standardized field names, replaced boolean lifecycle with explicit lifecycle state, added Academic Year Code and Fee Structure reference, introduced Persistent Representation Rules and strengthened ownership boundaries and traceability. |
| 2.0.0 | 2026-07-17 | Aligned with TD-PERSISTENCE-STD-001 v1.0.0. Adopted the standardized Aggregate Persistence Model structure, introduced Persistent Business State, Derived Business State, Transient Business State, Ownership Boundaries, Consistency Requirements and standardized traceability without changing approved business behaviour. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- Chief Architect

## Approval Date

2026-07-17