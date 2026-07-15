# Fee Obligation Aggregate

## Purpose

This Story implements the **Fee Obligation Aggregate** defined by the approved Product Specification, Software Architecture and Aggregate Technical Specification.

The implementation establishes the ownership boundary responsible for maintaining a Student's financial responsibility for an Academic Year.

This implementation intentionally realizes only the subset of Aggregate behavior approved by **Story-005**.

---

## Responsibilities

The Fee Obligation Aggregate owns:

- Fee Obligation identity
- Student reference
- Academic Year reference
- Fee Structure reference
- Obligation Lines
- Derived Outstanding Amount
- Aggregate lifecycle

The Fee Obligation Aggregate does not own:

- Student identity
- Academic Year definition
- Fee Structure policy
- Discount entitlements
- Payment allocations
- Receipts

---

## Public Operations

The Aggregate exposes the following public operations:

- Create Fee Obligation
- Update Obligation Lines
- Retire Fee Obligation

---

## Supporting Value Object

The implementation includes the Supporting Value Object:

- ObligationLine

ObligationLine represents an individual financial responsibility owned exclusively by the Fee Obligation Aggregate.

---

## Business Invariants

The implementation preserves the following invariants:

- Fee Obligation identifier is immutable.
- Student identifier is immutable.
- Academic Year identifier is immutable.
- Fee Structure identifier is immutable.
- A Fee Obligation contains at least one Obligation Line.
- Obligation Line identifiers are unique.
- Obligation Lines cannot contain null values.
- Outstanding Amount is derived from the owned Obligation Lines.
- Outstanding Amount shall never become negative.
- Aggregate ownership is preserved.

---

## Story Scope

This implementation includes only the behavior approved by **Story-005**.

The following approved operations remain intentionally unimplemented in this Story:

- Apply Discount
- Allocate Payment

No persistence, repositories, REST APIs, framework dependencies or infrastructure concerns are included.

---

## Implementation Notes

This implementation intentionally remains:

- implementation-neutral;
- framework-independent;
- focused on Aggregate behavior;
- faithful to the approved Story Package.

Additional implementation characteristics include:

- ObligationLine is implemented as an immutable Supporting Value Object.
- Cross-Aggregate collaboration occurs only through stable identifiers.
- Monetary values are represented using `BigDecimal`.
- Outstanding Amount is derived from the owned Obligation Lines.
- Defensive copying protects owned collections.
- Public collection accessors expose immutable views.
- Aggregate equality is based solely on `feeObligationIdentifier`.
- Lifecycle transitions are managed exclusively through the approved `retire()` operation.

No undocumented business behavior has been introduced.