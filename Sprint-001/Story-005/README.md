# Fee Obligation Implementation

This Story implements the **Fee Obligation Aggregate** as defined by the approved Software Domain Model, Aggregate Technical Specification and Persistence Model.

---

## Overview

The implementation includes:

- `FeeObligation.java` — Fee Obligation Aggregate Root
- `FeeObligationTest.java` — Unit tests for the Aggregate

The implementation assumes the existence of collaborating domain types such as:

- `ObligationLine`
- `BigDecimal`

These collaborators are referenced by the Aggregate but are not implemented as part of this Story.

---

## Aggregate Responsibility

The Fee Obligation Aggregate owns a Student's financial responsibility for a specific Academic Year.

The Aggregate preserves:

- Fee Obligation identity
- Student reference
- Academic Year reference
- Fee Structure reference
- Obligation Line collection
- Outstanding Amount
- Aggregate lifecycle

The Aggregate intentionally does **not** own:

- Student identity
- Academic Year definition
- Fee Structure policy
- Payment information
- Discount information

---

## Implementation Details

### Fee Obligation Aggregate

The Aggregate Root provides the following business operations:

- Create a Fee Obligation
- Update Obligation Lines
- Update Outstanding Amount
- Retire a Fee Obligation

### Aggregate State

The Aggregate preserves:

- Immutable identifiers
- Mutable Obligation Line collection
- Mutable Outstanding Amount
- Lifecycle state (Active / Retired)

---

## Business Rules

The implementation enforces the following business invariants.

### Validation

A Fee Obligation:

- must have a Fee Obligation Identifier
- must reference a Student
- must reference an Academic Year
- must reference a Fee Structure
- must contain at least one Obligation Line
- cannot contain null Obligation Lines
- cannot contain duplicate Obligation Line Identifiers
- cannot have a negative Outstanding Amount

### Lifecycle

A retired Fee Obligation:

- cannot be updated
- cannot be retired again

Historical information is preserved.

---

## Defensive Programming

The implementation preserves Aggregate ownership through defensive programming.

Specifically:

- constructor performs defensive copying
- update performs defensive copying
- internal collections are never exposed directly
- callers receive immutable collection views

---

## Testing

Unit tests verify:

- Aggregate creation
- Constructor validation
- Successful update
- Update validation
- Duplicate Obligation Line detection
- Null Obligation Line validation
- Outstanding Amount validation
- Retirement
- Double retirement prevention
- Update after retirement
- Immutable collection behaviour
- Defensive copying

---

## Supported Operations

The Aggregate exposes the following operations.

```text
FeeObligation(...)
update(...)
retire()

getFeeObligationIdentifier()
getStudentIdentifier()
getAcademicYearIdentifier()
getFeeStructureIdentifier()
getObligationLines()
getOutstandingAmount()
isActive()
```

---

## Notes

The implementation intentionally remains technology independent.

It does **not** introduce:

- persistence annotations
- framework dependencies
- database mappings
- REST endpoints
- messaging infrastructure

Implementation follows the approved Story Package, Aggregate Technical Specification, Persistence Model and Engineering Constitution.