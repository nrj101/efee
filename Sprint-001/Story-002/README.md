# Academic Year Aggregate

## Purpose

This Story implements the **Academic Year Aggregate** defined by the approved Product Specification, Software Architecture, Aggregate Technical Specification and Story-002.

The implementation establishes the Aggregate ownership boundary responsible for maintaining Academic Year identity, operational period, applicable Fee Structure reference and lifecycle.

---

## Responsibilities

The Academic Year Aggregate owns:

- Academic Year identity
- Operational period
- Applicable Fee Structure reference
- Academic Year lifecycle

The Academic Year Aggregate does not own:

- Students
- Fee Structure definition
- Fee Obligations
- Payments
- Receipts
- Discounts

---

## Implemented State

The Aggregate implements the following approved state:

- Academic Year Identifier
- Academic Year Code
- Operational Period
- Applicable Fee Structure Identifier
- Academic Year Lifecycle

---

## Public Operations

The Aggregate exposes the following public operations:

- Create Academic Year
- Assign Fee Structure
- Activate Academic Year
- Close Academic Year

---

## Business Invariants

The implementation preserves the following invariants:

- Academic Year Identifier is immutable.
- Academic Year Code is immutable.
- Operational Period is immutable after creation.
- Only one Fee Structure reference is associated at a time.
- Lifecycle transitions preserve Aggregate consistency.
- Aggregate ownership is preserved.

---

## Story Scope

This implementation includes only the behaviour approved by **Story-002**.

No persistence, repositories, REST APIs, framework dependencies or infrastructure concerns are included.

---

## Implementation Notes

This implementation intentionally remains:

- implementation-neutral;
- framework-independent;
- focused on Aggregate behaviour; and
- faithful to the approved Story Package.

The implementation reflects the reconciled Specification v1.1 baseline established during Sprint-001 engineering validation.

No undocumented business behaviour has been introduced.