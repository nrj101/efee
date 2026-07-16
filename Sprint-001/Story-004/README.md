# Discount Aggregate

## Purpose

This Story implements the **Discount Aggregate** defined by the approved Product Specification, Software Architecture and Aggregate Technical Specification.

The implementation establishes the ownership boundary responsible for preserving approved financial concession entitlements granted to Students.

This implementation intentionally realizes only the subset of Aggregate behavior approved by **Story-004**.

---

## Responsibilities

The Discount Aggregate owns:

- Discount identity
- Student reference
- Approved concession value
- Approval Information
- Business Justification
- Aggregate lifecycle

The Discount Aggregate does not own:

- Discount Policies
- Fee Obligations
- Applied Discounts
- Payments
- Receipts

The Aggregate preserves only the approved entitlement to a financial concession.

The financial application of that entitlement is intentionally outside the scope of this Story.

---

## Public Operations

The Aggregate exposes the following public operations:

- Create Discount
- Update Discount
- Retire Discount

---

## Supporting Value Objects

The implementation includes the following Supporting Value Objects:

- ApprovalInformation
- BusinessJustification

Both Supporting Value Objects are immutable and owned exclusively by the Discount Aggregate.

---

## Business Invariants

The implementation preserves the following invariants:

- Discount identifier is immutable.
- Student identifier is immutable.
- Discount value must be greater than zero.
- Approval Information cannot be null.
- Business Justification cannot be null.
- Historical Discounts remain permanently preserved.
- Retired Discounts cannot be modified.
- Aggregate ownership is preserved.

---

## Story Scope

This implementation includes only the behavior approved by **Story-004**.

The following responsibilities remain intentionally outside the scope of this Story:

- Discount Policy management
- Financial application of Discounts
- Fee Obligation updates
- Payment interaction
- Receipt interaction

No persistence, repositories, REST APIs, framework dependencies or infrastructure concerns are included.

---

## Implementation Notes

This implementation intentionally remains:

- implementation-neutral;
- framework-independent;
- focused on Aggregate behavior;
- faithful to the approved Story Package.

Additional implementation characteristics include:

- ApprovalInformation is implemented as an immutable Supporting Value Object.
- BusinessJustification is implemented as an immutable Supporting Value Object.
- Cross-Aggregate collaboration occurs only through stable identifiers.
- Monetary values are represented using `BigDecimal`.
- Aggregate identity is immutable.
- Aggregate equality is based solely on `discountIdentifier`.
- Lifecycle transitions are managed exclusively through the approved `retire()` operation.

No undocumented business behavior has been introduced.