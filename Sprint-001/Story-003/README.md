# Fee Structure Aggregate

## Purpose

This Story implements the **Fee Structure Aggregate** defined by the approved Product Specification, Software Architecture and Aggregate Technical Specification.

The implementation establishes the ownership boundary responsible for maintaining the institution's charging policy through the definition and lifecycle of Fee Structures and their owned Fee Components.

---

## Responsibilities

The Fee Structure Aggregate owns:

- Fee Structure identity
- Fee Structure definition
- Fee Component composition
- Fee Structure lifecycle

The Fee Structure Aggregate does not own:

- Students
- Academic Years
- Fee Obligations
- Payments
- Receipts
- Discounts

---

## Public Operations

The Aggregate exposes the following public operations:

- Create Fee Structure
- Update Fee Structure
- Add Fee Component
- Retire Fee Structure

---

## Supporting Entity

This implementation includes the supporting entity:

- **FeeComponent**

FeeComponent represents an individual charging category owned exclusively by the Fee Structure Aggregate.

FeeComponent is intentionally immutable. All modifications to the Aggregate occur through approved Fee Structure business operations.

---

## Business Invariants

The implementation preserves the following invariants:

- Fee Structure identifier is immutable.
- Fee Structure contains at least one Fee Component.
- Fee Component identifiers are immutable.
- Fee Component names and amounts are immutable.
- Fee Component amounts must be greater than zero.
- Fee Component identifiers must be unique within a Fee Structure.
- Aggregate ownership is preserved.
- Retired Fee Structures cannot be modified.

---

## Story Scope

This implementation includes only the behaviour approved by **Story-003**.

The implementation intentionally excludes:

- Persistence
- Repositories
- REST APIs
- Framework dependencies
- Infrastructure concerns

---

## Implementation Notes

This implementation intentionally remains:

- implementation-neutral;
- framework-independent;
- focused on Aggregate behaviour;
- faithful to the approved Story Package.

Aggregate ownership is enforced by making **FeeComponent** immutable and exposing all Aggregate modifications exclusively through the **FeeStructure** Aggregate Root.

No undocumented business behaviour has been introduced.