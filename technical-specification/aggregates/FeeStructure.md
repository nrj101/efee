# Fee Structure Aggregate Technical Specification

```yaml
---
document_id: ATS-FEESTRUCTURE-001
title: Fee Structure Aggregate Technical Specification
version: 3.2.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-07-06
last_updated: 2026-07-17

related_documents:
  - ../../architecture/aggregates/FeeStructure.md
  - ../../spec/docs/BusinessRules.md
  - ../../spec/docs/workflows/FeePolicyManagement.md
  - ../../technical-design/persistence/FeeStructure.md
---
```

---

# Purpose

This document defines the authoritative implementation contract for the Fee Structure Aggregate.

It refines the approved Software Domain Model and Software Architecture by defining the complete Aggregate contract required for implementation while remaining independent of programming language, persistence technology, implementation framework and infrastructure.

The Fee Structure Aggregate Technical Specification defines:

- Aggregate responsibilities;
- owned, referenced and derived state;
- lifecycle behaviour;
- business invariants;
- public operations;
- approved supporting types; and
- persistence traceability.

It specifies **what** the Fee Structure Aggregate must do without prescribing **how** it is implemented.

---

# Responsibilities

The Fee Structure Aggregate owns the institutional charging policy.

It is responsible for:

- preserving Fee Structure identity;
- maintaining Fee Structure information;
- managing Fee Component composition; and
- managing the Fee Structure lifecycle.

The Fee Structure Aggregate intentionally does **not** own:

- Students;
- Fee Obligations;
- Payments;
- Receipts; or
- Discounts.

These business truths remain owned by collaborating Aggregates.

---

# Owned State

The Fee Structure Aggregate owns the following business state.

| State | Type | Required | Mutable | Description |
|--------|------|----------|----------|-------------|
| feeStructureIdentifier | Fee Structure Identifier | Yes | No | Immutable Fee Structure identifier |
| feeStructureName | Fee Structure Name | Yes | Yes | Institution-defined Fee Structure name |
| feeComponents | Collection&lt;FeeComponent&gt; | Yes | Yes | Fee Components owned by the Aggregate |
| lifecycleState | Fee Structure Lifecycle | Yes | Yes | Current Fee Structure lifecycle |

No additional owned business state is approved.

---

# Referenced State

The Fee Structure Aggregate references externally owned business information but does not own it.

The Aggregate may reference:

| Aggregate | Business Purpose |
|-----------|------------------|
| Academic Year | Determine where the Fee Structure is applied |
| Fee Obligation | Associate obligations generated from the Fee Structure |

Referenced business information SHALL remain externally owned.

The Fee Structure Aggregate SHALL NOT modify referenced Aggregate state.

---

# Derived State

The Fee Structure Aggregate does not own any derived business state.

Financial reporting, institutional summaries and obligation calculations are intentionally derived outside this Aggregate.

No additional derived business state is approved.

---

# Lifecycle

The Fee Structure Aggregate supports the following lifecycle.

```text
Active
    │
    ▼
Retired
```

Lifecycle transitions are irreversible.

Retired Fee Structures remain permanently preserved.

Only one lifecycle state may exist at any point in time.

---

# Business Invariants

The implementation SHALL preserve the following Business Invariants.

- Fee Structure identity is immutable.
- Every Fee Structure contains one or more Fee Components.
- Fee Component identifiers are unique within a Fee Structure.
- Every Fee Component belongs to exactly one Fee Structure.
- Historical Fee Structures remain immutable once used.
- Only the Fee Structure Aggregate may modify its owned state.
- Aggregate ownership boundaries shall always be preserved.

These invariants SHALL remain true throughout every permitted lifecycle transition and business operation.

---

# Approved Implementation Types

The following domain types participate in the approved Aggregate contract.

- Fee Structure Identifier
- Fee Structure Lifecycle
- Fee Component
- Fee Component Identifier

No additional publicly observable domain types are approved by this specification.

---

# Public API

The Public API defines the complete externally observable behaviour of the Fee Structure Aggregate.

Every public operation SHALL preserve all documented Business Invariants.

---

## Constructor

```text
FeeStructure(
    feeStructureIdentifier,
    feeStructureName,
    feeComponents
)
```

Creates a valid Fee Structure.

The constructor SHALL:

- establish a valid Fee Structure identity;
- initialise the Fee Structure information;
- establish the initial Fee Component composition;
- establish the Active lifecycle state; and
- preserve all documented Business Invariants.

---

## Business Operations

### update(
    feeStructureName,
    feeComponents
)

Updates approved Fee Structure information.

Preconditions:

- Fee Structure is Active.
- Fee Structure name is valid.
- One or more Fee Components are provided.

Postconditions:

- Approved mutable state is updated.
- Aggregate identity remains unchanged.
- Business Invariants remain preserved.

---

### addFeeComponent(
    feeComponent
)

Adds a Fee Component to the Fee Structure.

Preconditions:

- Fee Structure is Active.
- Fee Component is valid.
- Fee Component identifier is unique within the Aggregate.

Postconditions:

- Fee Component becomes owned by this Aggregate.
- Business Invariants remain preserved.

---

### retire()

Transitions the Fee Structure to the Retired lifecycle state.

Preconditions:

- Fee Structure is currently Active.

Postconditions:

- Lifecycle becomes Retired.
- Historical integrity is preserved.
- Business Invariants remain preserved.

---

## Accessors

```text
getFeeStructureIdentifier()

getFeeStructureName()

getFeeComponents()

getLifecycleState()

isActive()
```

Accessors expose approved Fee Structure information only.

Accessors SHALL NOT modify Aggregate state.

No additional public operations are approved by this specification.

---

# Supporting Types

The following Supporting Types participate in the approved Aggregate contract.

## Fee Structure Identifier

Defines the immutable business identity of a Fee Structure.

Responsibilities:

- uniquely identify a Fee Structure;
- remain immutable throughout the Fee Structure lifecycle.

Business Invariants:

- Identifier shall never change.
- Identifier shall uniquely identify exactly one Fee Structure.

---

## Fee Component

Defines a chargeable component within a Fee Structure.

Responsibilities:

- represent an approved fee component;
- maintain the approved fee amount;
- remain owned exclusively by the Fee Structure Aggregate.

Business Invariants:

- Every Fee Component belongs to exactly one Fee Structure.
- Fee Component identifiers are unique within a Fee Structure.

---

## Fee Structure Lifecycle

Defines the approved lifecycle states of a Fee Structure.

Responsibilities:

- represent the current operational state;
- govern permitted lifecycle transitions.

Business Invariants:

- Only one lifecycle state may exist at any point in time.
- Lifecycle transitions shall follow the approved lifecycle.
- Retired Fee Structures are immutable.

---

# Persistence Traceability

The following business concepts are represented by the Fee Structure Aggregate.

| Business Concept | Classification |
|------------------|----------------|
| Fee Structure | Aggregate Root |
| Fee Structure Identifier | Owned State |
| Fee Structure Name | Owned State |
| Fee Components | Owned State |
| Fee Structure Lifecycle | Owned State |

The Fee Structure Aggregate does not persist:

- Students;
- Academic Years;
- Fee Obligations;
- Payments;
- Receipts; or
- Discounts.

Persistent representation SHALL remain consistent with this Aggregate Technical Specification and the Aggregate Persistence Model.

---

# Consistency Requirements

Implementation SHALL preserve:

- Fee Structure identity integrity;
- Fee Component composition integrity;
- lifecycle integrity;
- Aggregate ownership boundaries; and
- all documented Business Invariants.

The Fee Structure Aggregate SHALL define institutional charging policy without assuming ownership of financial transactions or obligations.

---

# Collaboration Contract

The Fee Structure Aggregate collaborates with the following Aggregates.

| Aggregate | Collaboration Purpose |
|-----------|-----------------------|
| Academic Year | Associate the applicable Fee Structure |
| Fee Obligation | Provide the approved charging policy |

Collaborations SHALL occur exclusively through approved Aggregate references.

Ownership of business truth SHALL NOT transfer between collaborating Aggregates.

---

# Implementation Constraints

Implementation SHALL:

- validate constructor inputs;
- validate business operation inputs;
- preserve Aggregate ownership;
- preserve lifecycle integrity;
- preserve all documented Business Invariants; and
- prevent external modification of owned Fee Components.

Implementation SHALL NOT:

- expose public setters;
- expose undocumented public operations;
- modify collaborating Aggregates;
- introduce undocumented Aggregate state;
- expose mutable internal collections; or
- violate Aggregate ownership boundaries.

Implementation technology remains outside the scope of this specification.

---

# Story Traceability

Initially implemented through:

- Sprint-001 / Story-003

Future Stories MAY extend implementation while preserving this Aggregate Technical Specification.

---

# Related Documents

- BusinessRules.md
- FeePolicyManagement.md
- Fee Structure Aggregate Design
- Fee Structure Persistence Model

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-06 | Initial specification. |
| 2.0.0 | 2026-07-13 | Introduced implementation contract. |
| 3.1.0 | 2026-07-13 | Added explicit Aggregate interface, Supporting Entity interface, constructor contract, operation contracts, preconditions and postconditions. |
| 3.2.0 | 2026-07-17 | Aligned with TECH-STD-001 v1.2.0. Adopted the standardized Aggregate Technical Specification structure, introduced Referenced State, Derived State, Approved Implementation Types, Supporting Types and Persistence Traceability sections, and aligned the Public API with the standardized contract format without changing approved business behaviour. |

---

# Approval

**Status:** Approved

## Approved By

- Product Owner
- CTO

## Approval Date

2026-07-17