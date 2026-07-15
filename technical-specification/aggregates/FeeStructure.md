# Fee Structure Aggregate Technical Specification

```yaml
---
document_id: ATS-FEESTRUCTURE-001
title: Fee Structure Aggregate Technical Specification
version: 3.0.0
status: Approved

owner: Product Owner
reviewer: CTO

created: 2026-07-06
last_updated: 2026-07-13

related_documents:
  - ../../architecture/aggregates/FeeStructure.md
  - ../../spec/docs/BusinessRules.md
  - ../../spec/docs/workflows/FeePolicyManagement.md
  - ../../persistence/FeeStructure.md
---
```

---

# Purpose

This document defines the implementation contract for the Fee Structure Aggregate.

It specifies the approved Aggregate interface, Aggregate state, Supporting Entity interface, lifecycle, invariants and implementation obligations required to faithfully realize the approved Software Architecture.

This specification intentionally remains programming-language independent.

---

# Aggregate Responsibility

The Fee Structure Aggregate owns:

- Fee Structure identity
- Institutional charging policy
- Fee Component composition
- Fee Structure lifecycle

The Aggregate does not own:

- Student information
- Fee Obligations
- Payments
- Receipts
- Discounts

---

# Approved Aggregate State

Only the following Aggregate state is approved.

| Aggregate State | Domain Type | Mutable |
|-----------------|-------------|----------|
| Fee Structure Identifier | Fee Structure Identifier | No |
| Fee Structure Name | Fee Structure Name | Yes |
| Fee Components | Collection of Fee Components | Yes |
| Lifecycle Status | Fee Structure Lifecycle | Yes |

No additional Aggregate state shall be introduced.

---

# Approved Supporting Entity State

## Fee Component

Only the following Supporting Entity state is approved.

| State | Domain Type | Mutable |
|--------|-------------|----------|
| Fee Component Identifier | Fee Component Identifier | No |
| Fee Component Name | Fee Component Name | Yes |
| Fee Amount | Monetary Value | Yes |

Fee Components are Supporting Entities owned exclusively by the Fee Structure Aggregate.

Supporting Entities SHALL NOT be shared across Aggregates.

No additional Supporting Entity state shall be introduced.

---

# Approved Aggregate Interface

## Construction

```
FeeStructure(
    feeStructureIdentifier,
    feeStructureName,
    feeComponents
)
```

The Aggregate shall be constructed only from approved Aggregate state.

---

## Approved Business Operations

### update

```
update(
    feeStructureName,
    feeComponents
)
```

### addFeeComponent

```
addFeeComponent(
    feeComponent
)
```

### retire

```
retire()
```

No additional public Aggregate operations are approved.

---

## Approved State Access

```
getFeeStructureIdentifier()

getFeeStructureName()

getFeeComponents()

isActive()
```

No additional Aggregate accessors are approved.

---

# Approved Supporting Entity Interface

## Construction

```
FeeComponent(
    feeComponentIdentifier,
    feeComponentName,
    feeAmount
)
```

---

## Approved State Access

```
getFeeComponentIdentifier()

getFeeComponentName()

getFeeAmount()
```

No additional Supporting Entity operations are approved.

---

# Aggregate Relationships

```text
FeeStructure

    owns

        Collection<FeeComponent>

AcademicYear

    references

        FeeStructure

FeeObligation

    references

        FeeStructure
```

---

# Aggregate Invariants

The implementation shall preserve:

- Fee Structure identity remains immutable.
- A Fee Structure contains one or more Fee Components.
- Fee Component identifiers are unique within a Fee Structure.
- Every Fee Component belongs to exactly one Fee Structure.
- Historical Fee Structures remain immutable once used.
- Aggregate ownership remains preserved.

---

# Lifecycle Model

Approved lifecycle states:

Active
    │
    ▼
Retired

---

# Implementation Obligations

## FeeStructure(...)

### Preconditions

- feeStructureIdentifier shall be provided.
- feeStructureName shall be provided.
- feeComponents shall contain one or more Fee Components.

### Postconditions

- Aggregate identity established.
- Aggregate invariants satisfied.
- Lifecycle initialized.

---

## update(...)

### Preconditions

- feeStructureName shall be provided.
- feeComponents shall contain one or more Fee Components.

### Postconditions

- Only approved mutable Aggregate state may change.
- Aggregate identity remains unchanged.
- Lifecycle state remains unchanged.
- Aggregate invariants remain preserved.

---

## addFeeComponent(...)

### Preconditions

- feeComponent shall be provided.

### Postconditions

- Fee Component becomes owned by this Aggregate.
- Aggregate invariants remain preserved.

---

## retire()

### Preconditions

None.

### Postconditions

- Aggregate transitions to Retired lifecycle state.
- Aggregate identity remains unchanged.
- Historical integrity remains preserved.

---

## State Access

State accessors shall not modify Aggregate state.

---

# Collaboration Contract

Collaborates with:

- Academic Year
- Fee Obligation

Business truth ownership shall never be transferred.

---

# Implementation Constraints

Implementation shall not introduce:

- persistence logic
- repositories
- REST APIs
- dependency injection
- messaging
- framework annotations
- infrastructure concerns

Implementation SHALL NOT expose mutable internal collections.

---

# Story Traceability

Initially implemented through:

- Sprint-001 / Story-003

---

# Related Documents

- Fee Structure Aggregate Design
- Fee Structure Persistence Model
- BusinessRules.md
- FeePolicyManagement.md

---

# Version History

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | 2026-07-06 | Initial specification. |
| 2.0.0 | 2026-07-13 | Introduced implementation contract. |
| 3.1.0 | 2026-07-13 | Added explicit Aggregate interface, Supporting Entity interface, constructor contract, operation contracts, preconditions and postconditions. |

---

# Approval

**Status:** Approved
