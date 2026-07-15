# Story-004: Discount Aggregate

## Purpose

This Story implements the Discount Aggregate defined by the approved Software Architecture.

The implementation establishes ownership of an approved financial concession entitlement granted to a Student while preserving the approved Aggregate boundaries.

The financial application of a Discount is intentionally outside the scope of this Story.

---

## Aggregate Responsibility

The Discount Aggregate owns:

- Discount identity
- Student reference
- Approved concession value
- Approval information
- Business justification
- Discount lifecycle

The Aggregate authorises financial concessions only.

It does not own Fee Obligations, Applied Discounts, Payments or Receipts.

---

## Implemented Files

### Source

- `Discount.java` – Aggregate Root
- `ApprovalInformation.java` – Supporting Value Object representing approval authority and approval reference
- `BusinessJustification.java` – Supporting Value Object representing the approved business rationale

### Tests

- `DiscountTest.java`
- `ApprovalInformationTest.java`
- `BusinessJustificationTest.java`

### Documentation

- `README.md`

---

## Supported Operations

### Discount

- `Discount(...)`
- `update(...)`
- `retire()`

### ApprovalInformation

- `ApprovalInformation(...)`

### BusinessJustification

- `BusinessJustification(...)`

---

## Implementation Notes

- The implementation follows the approved Aggregate Design, Aggregate Technical Specification and Aggregate Persistence Model.
- The Discount Aggregate preserves only the business entitlement to an approved financial concession.
- Financial application of a Discount is intentionally excluded and remains the responsibility of the Fee Obligation Aggregate.
- Approval Information and Business Justification are implemented as immutable Supporting Value Objects owned exclusively by the Discount Aggregate.
- Monetary values are represented using `BigDecimal`.
- Aggregate identity is immutable.
- Aggregate equality is based solely on `discountIdentifier`.
- Lifecycle transitions are managed exclusively through the `retire()` operation.
- No framework dependencies, persistence concerns or infrastructure code have been introduced.

---

## Architectural Compliance

This implementation:

- preserves Aggregate ownership boundaries;
- preserves the approved Aggregate state;
- preserves the approved lifecycle;
- preserves the approved business invariants;
- introduces no undocumented business behaviour;
- introduces no cross-Aggregate Supporting Entity references;
- remains implementation-independent and framework-neutral.

---

## Story Outcome

Story-004 successfully establishes the Discount Aggregate as the owner of authorised financial concession entitlements.

The financial application of those concessions will be implemented by the Fee Obligation Aggregate in a subsequent Story while preserving the approved Aggregate ownership boundaries.