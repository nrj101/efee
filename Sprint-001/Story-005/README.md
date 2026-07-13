# Student Fee Receivables Platform (eFee)

## Story Scope

This project implements the **Aggregate Root** for the `FeeObligation` domain entity. The following components are implemented as part of this story:

- `FeeObligation` (Aggregate Root)
- `ObligationLine` (Supporting Entity)
- `MonetaryAmount` (Value Object)

The following components are **not implemented** as part of this story and remain outside the current scope:

- `FeeStructure`
- `Student`
- `AcademicYear`
- `FeeDiscount`
- `FeePayment`
- `FeeReconciliation`

## Implementation Details

### FeeObligation
- Represents a fee obligation for a student in a specific academic year
- Maintains a collection of obligation lines
- Tracks the outstanding amount
- Supports lifecycle operations: `create`, `update`, `retire`

### ObligationLine
- Represents a specific fee line item
- Contains:
  - Line identifier
  - Description
  - Amount

### MonetaryAmount
- Represents a monetary value with currency
- Provides:
  - Amount
  - Currency
- Ensures immutability and defensive copying

## Domain Rules

### Lifecycle
- A `FeeObligation` can be:
  - **Active**: Can be updated
  - **Retired**: Cannot be updated

### Validation
- All constructors and update operations validate:
  - Non-null identifiers
  - Valid monetary amounts
  - No duplicate obligation lines
  - No null entries in obligation lines

### Defensiveness
- Collections are defensively copied
- Immutable value objects are used where appropriate
- No direct mutation of internal state

## Testing
- Unit tests cover:
  - Constructor validation
  - Update validation
  - Retirement behavior
  - Immutable collection behavior
  - Defensive copying